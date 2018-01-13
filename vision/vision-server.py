#!/usr/bin/python3
import numpy as np
import cv2
import math
from networktables import NetworkTables
from optparse import OptionParser

## OTHER NOTES
## On the raspberry pi, include a cron job that automatically starts
## the vision server on reboot using this line for the pi user. By 
## default, the script does not output any data either over the 
## network or the terminal.
##
##	@reboot /home/pi/vision-server.py -p
##
## Note that no ampersand is needed after the cron line since cron
## jobs are run in the background by default.
## 
##	The -p flag indicates that results should be published to the 
##	network table on the driver station.
##
## The other flags, -c and -d respectively show coordinates of the
## target in the terminal and display the image with overlay.

## COMMAND LINE OPTIONS
parser = OptionParser()
parser.add_option("-d", "--display", action="store_true", dest="DISPLAY", default=False )
parser.add_option("-c", "--coord",   action="store_true", dest="COORD",   default=False )
parser.add_option("-p", "--publish", action="store_true", dest="PUBLISH", default=True  )
(options,args) = parser.parse_args()


## REPORTING. The DriverStation has a static address of
## 10.55.34.2 and acts as the server for the vision table.
if options.PUBLISH == True:
	NetworkTables.initialize(server='10.55.34.2')
	visionTable = NetworkTables.getTable('Vision')

## CONNECT TO THE CAMERA
capture = cv2.VideoCapture( 0 )

## THRESHOLD ARRAYS. These arrays identify the range of HSV
## values that are used to identify regions of interest.
lower = np.array([  40,   0, 230 ])
upper = np.array([ 100, 210, 255 ])


def gs(value):
	"A strange way to document functions"
	score = 100.0-(100.0*abs(1.0-value))
	return score;


def onmouse( k, x, y, s, p ):
	global hsv
	if k == 1:
		print( hsv[y,x] )
				

## CONTINUE RUNNING SERVER
while True:

	## CAPTURE A FRAME
	result, frame = capture.read()

	## ROTATE FRAME
	## These are needed on the 2017 robot since the camera is
	## mounted upside-down. This is not the case on the test robot.
	flop = cv2.flip( frame, 0 )
	flip = cv2.flip( flop,  1 )

	## BLUR IMAGE. Blurring the image reduces the graininess.
	## Contours are thus more smooth and less fragmented.
	blur = cv2.blur( flip, (3,3) )

	## CONVERT TO HSV. Change the colorspace from HSV to RGB. It is
	## easier to identify the ranges of green this way.
	hsv = cv2.cvtColor( blur, cv2.COLOR_BGR2HSV )

	## MASK IMAGE. We are left with a black and white image where
	## regions of interest are white.
	mask = cv2.inRange( hsv, lower, upper )

	## GET CONTOURS OF BLOBS. This may need to be changed to read
	## as _, contours, _ according to previous testing.
	_, contours, _ = cv2.findContours( mask, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE )

	## INITIALIZE BEST VALUES. Return values of -1 indicate that
	## a reasonable target was not found.
	bestContour1 = -1
	bestContour2 = -1

	bestScore = 0
	
	bestX = 0
	bestY = 0

	## Uppercase variables represent lists while lowercase variables
	## represent scalars for the current or best result. Not pythonic
	## but it works for me.
	Contours = []
	X = []
	Y = []
	H = []
	W = []
	BoxCx = []
	BoxCy = []

	##
	## LOOP THROUGH CONTOURS
	##
	for contour in list(contours):

		### DIMENSIONS AND COORDINATES OF EACH BLOB
		x, y, w, h = cv2.boundingRect( contour )

		## SKIP IF BOX IS TOO SMALL
		if h < 10: continue

		if w < 10:  continue
		if w > 200: continue

		if h/w > 4.0: continue
		if h/w < 1.0: continue

		## EXPECTED VERTICAL POSITION
		#if y <  10: continue
		if y > 300: continue

		## STORE INDIVIDUAL COMPONENTS
		Contours.append( contour )
		X.append( x * 1.0 )
		Y.append( y * 1.0 )
		H.append( h * 1.0 )
		W.append( w * 1.0 )

		BoxCx.append( x + w/2 )
		BoxCy.append( y + h/2 )

		## DEBUGGING
		if options.DISPLAY == True:

			## DRAW CONTOURS
			#cv2.drawContours( flip, contour, -1, (0,0,0), 2 )

			## DRAW A GREEN CIRCLE at the contour center.
			cv2.circle( flip, (int(x+w/2),int(y+h/2)), 7, (0,255,0), -1 )
			
			#cv2.putText( flip, str(w), (int(x+w/2-10),int(y+h/2+15)), cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0,0,0), 2 )


	###
	### LOOP THROUGH PAIRS
	###
	for i in range( len(Contours) ):

		for j in range( i+1, len(Contours) ):

			## BOUNDING BOX OF BOTH BOXES
			boundingBoxW = abs( BoxCx[i]-BoxCx[j] ) + (W[i] + W[j])/2
			boundingBoxH = (H[i] + H[j])/2

			## 1. OVERALL BOUNDING BOX RATIO. The ratio of the overall
			## bounding box should be nearly 10.75 : 5.00.
			boxScore = 1.0 * (boundingBoxW/10.75) / (boundingBoxH/5.00)

			## 2. TOP EDGES. The difference of top edge positions should
			## be small compared to the average box height.
			topScore = 1.0 + abs( BoxCy[i]-BoxCy[j] ) / boundingBoxH

			## 3. WIDTH RATIOS. How well do the widths of both boxes
			## compare to one another? They should be roughly equal.
			widthScore = 1.0 * W[i] / W[j]

			## 4. HEIGHT RATIOS. How well do the heights of both boxes
			## compare to one another? They should be roughly equal.
			heightScore = 1.0 * H[i] / H[j]

			## CALCULATE A SCORE FOR A PAIR OF BOXES
			newScore = gs(boxScore) + gs(topScore) + gs(widthScore) + gs(heightScore)

			## DEBUGGING
			#if options.DISPLAY == True:

				### POTENTIAL CENTER POINTS.
				#cv2.circle( flip, (int(bestX),int(bestY)), 3, (0,255,0), 2 )

				#cv2.putText( flip, str(round(gs(boxScore),2)), (int(bestX)+10,int(bestY)), cv2.FONT_HERSHEY_SIMPLEX, 0.4, (0,0,0), 2 )
				#cv2.putText( flip, str(round(gs(topScore),2)), (int(bestX)+10,int(bestY+20)), cv2.FONT_HERSHEY_SIMPLEX, 0.4, (0,0,0), 2 )
				#cv2.putText( flip, str(int(newScore)), (int(bestX)+10,int(bestY+40)), cv2.FONT_HERSHEY_SIMPLEX, .5, (0,0,0), 2 )

			## CHECK FOR NEW BEST SCORE
			if newScore > bestScore and newScore > 200:

				## REMEMBER CONTOURS
				bestContour1 = i
				bestContour2 = j

				## COMPUTE NEW SPRING CENTER
				bestX = int( BoxCx[i]/2 + BoxCx[j]/2 )
				bestY = int( BoxCy[i]/2 + BoxCy[j]/2 )

				## BEST SCORE
				bestScore = int( newScore )

				## CONSIDER. 
				## If the score is sufficiently high we can probably leave
				## the loop early and just return the current result. This
				## might be useful if processing is not fast enough.
				#if bestScore > 350: break

	## SHOW COORDINATES IN TERMINAL
	if options.COORD == True:
		print( str(int(bestScore)) + ' ' + str(bestX) + ' ' + str(bestY) )

	##
	## DEBUG
	##
	if options.DISPLAY == True:

		## PUT RED, FILLED IN CIRCLE AT BEST CENTER
		if bestX > 0:
			cv2.circle( flip, (bestX,bestY), 7, (0,0,255), -1 )

		## DRAW BEST CONTOURS
		#if bestContour1 > -1 and bestContour2 > -1:
			#cv2.drawContours( flip, Contours[bestContour1], -1, (0,0,255), 3 )
			#cv2.drawContours( flip, Contours[bestContour2], -1, (0,0,255), 3 )
			#cv2.rectangle(flip, (int(X[bestContour1]),int(Y[bestContour1])), (int(X[bestContour1]+W[bestContour1]),int(Y[bestContour1]+H[bestContour1])),(255,255,0),2)
			#cv2.rectangle(flip, (int(X[bestContour2]),int(Y[bestContour2])), (int(X[bestContour2]+W[bestContour2]),int(Y[bestContour2]+H[bestContour2])),(255,255,0),2)

		## SHOW HSV ON CLICK
		cv2.namedWindow("ORIG")
		cv2.setMouseCallback("ORIG", onmouse )
		
		## DISPLAY IMAGE
		cv2.imshow("ORIG", flip )
#		cv2.imshow("BLUR", blur )
		ch = cv2.waitKey( 1 )




	##
	## PUBLISH VALUES TO NETWORK TABLE
	## Return values of -1 indicate that no reasonable target
	## was found.
	## 
	if options.PUBLISH == True:
		visionTable.putNumber( "X", bestX )
		visionTable.putNumber( "Y", bestY )
		visionTable.putNumber( "Score", bestScore )
