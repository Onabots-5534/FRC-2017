package org.usfirst.frc.team5534.robot;

public class Track {

	
	// TESTING. This path is just for testing purposes. Currently it is
	// tied to a button on the joystick so that we can test different
	// autonomous routines.
	public static void Testing() {
		switch ( Stage.Number ) {
			case 0:
				Autopilot.DriveStraight( 12 );
				Stage.StopBeyondForwardDistance( 30 * 12 );
				break;
				
			default:
				Stage.Last();
				break;
		}
	}
	

	// CROSS BASELINE. Just cross the baseline. This is a fall-back mode
	// in case of something unexpected such as not receiving data from the
	// field management system.
	public static void CrossBaseLine() {
		switch ( Stage.Number ) {
		
			// SECURE CUBE
			case 0:
//				Lift.Grab();
//				Lift.Height( 24 );
				break;
				
			// DRIVE NORTH
			case 1:
				Autopilot.DriveStraight( 24 );
				Stage.StopBeyondForwardDistance( 144 );
				break;
					
			// DONE
			default:
				Stage.Last();
				break;
		}

	}
	

	// RIGHT SWITCH SOUTH. This is one of the easiest autonomous modes.
	// Drive forward to the surface and drop the cube. Try to line up the
	// robot so that the cube drops near the outer edge.
	public static void RightSwitchSouth() {
		switch ( Stage.Number ) {
		
			// SECURE CUBE
			case 0:
//				Lift.Grab();
//				Lift.Height( 24 );
				break;
				
			// DRIVE NORTH
			case 1:
				Autopilot.DriveToSurface( 10 );
				Stage.StopNearFrontSurface( 10, 2 );
				break;

			case 2:
//				Lift.Drop();
				break;
				
			// DONE
			default:
				Stage.Last();
				break;
		}
	}
	
	
	// LEFT SWITCH SOUTH. This is another easy autonomous mode that could
	// use vision tracking. This drops the cube on the left side from the
	// center starting position.
	public static void LeftSwitchSouth() {
		switch ( Stage.Number ) {
		
			// SECURE CUBE
			case 0:
//				Lift.Grab();
//				Lift.Height( 24 );
				break;
				
			// DRIVE NORTH
			case 1:
				Autopilot.DriveStraight( 24 );
				Stage.StopBeyondForwardDistance( 48 );
				break;
				
			// TURN WEST
			case 2:
				Autopilot.TurnToHeading( 270 );
				Stage.StopNearHeading( 270,  10 );
				break;
				
			// DRIVE WEST
			case 3:
				Autopilot.DriveStraight( 24 );
				Stage.StopBeyondForwardDistance( 72 );
				break;
				
			// TURN NORTH
			case 4:
				Autopilot.TurnToHeading( 0 );
				Stage.StopNearHeading( 0, 10 );
				break;
				
			// DRIVE TO SWITCH
			case 5:
				Autopilot.DriveToSurface( 10 );
				Stage.StopNearFrontSurface( 10, 2 );
				break;
				
			// STOP AND DROP
			case 6:
//				Lift.Drop();
				break;
				
			// RESET
			default:
				Stage.Last();
				break;
		}
	}


	// LEFT SWITCH WEST. Placing cubes on the outside edge of the switch.
	// This requires the robot to drive forward a certain distance, turn
	// right, drive to the surface, and drop the cube.
	public static void LeftSwitchWest() {
		switch ( Stage.Number ) {
		
			// SECURE CUBE
			case 0:
//				Lift.Grab();
//				Lift.Height( 24 );
				break;
				
			// DRIVE NORTH
			case 1:
				Autopilot.DriveStraight( 24 );
				Stage.StopBeyondForwardDistance( 15*12 );
				break;

			// TURN EAST
			case 2:
				Autopilot.TurnToHeading( 90 );
				Stage.StopNearHeading( 90, 10 );
				break;
				
			// DRIVE EAST
			case 3:
				Autopilot.DriveToSurface( 10 );
				Stage.StopNearFrontSurface( 10, 2 );
				break;
				
			// DROP CUBE
			case 4:
//				Lift.Drop();
				break;
				
			// RESET
			default:
				Stage.Last();
				break;
		}
	}
	
	
	// RIGHT SWITCH EAST. Placing cubes on the outside edge of the switch.
	// This requires the robot to drive forward a certain distance, turn
	// left, drive to the surface, and drop the cube.
	public static void RightSwitchEast() {
		switch ( Stage.Number ) {
		
			// SECURE CUBE
			case 0:
//				Lift.Grab();
//				Lift.Height( 24 );
				break;
				
			// DRIVE NORTH
			case 1:
				Autopilot.DriveStraight( 24 );
				Stage.StopBeyondForwardDistance( 15*12 );
				break;

			// TURN WEST
			case 2:
				Autopilot.TurnToHeading( 270 );
				Stage.StopNearHeading( 270, 10 );
				break;
				
			// DRIVE WEST
			case 3:
				Autopilot.DriveToSurface( 10 );
				Stage.StopNearFrontSurface( 10, 2 );
				break;
				
			// DROP CUBE
			case 4:
//				Lift.Drop();
				break;
				
			// RESET
			default:
				Stage.Last();
				break;
		}
	}
	
	
	// RIGHT SCALE EAST. This is the near version of placing a cube
	// on the scale in autonomous mode. This will need to be tested
	// extensively and requires the use of a sonic ranger on the back
	// of the robot or something similar.
	public static void RightScaleEast() {
		switch ( Stage.Number ) {
		
			// SECURE CUBE
			case 0:
//				Lift.Grab();
//				Lift.Height( 73 );
				break;
				
			// DRIVE NORTH
			case 1:
				Autopilot.DriveStraight( 36 );
				Stage.StopBeyondForwardDistance( 240 );
				break;
				
			// TURN WEST
			case 2:
				Autopilot.TurnToHeading( 270 );
				Stage.StopNearHeading( 270, 10 );
				break;
		
			// DRIVE WEST
			case 3:
				Autopilot.DriveStraight( 12 );
				Stage.StopNearBackSurface( 50, 2 );
				break;
			
			// DROP CUBE
			case 4:
//				Lift.Drop();
				break;
				
			// RESET
			default:
				Stage.Last();
				break;
		}
	}

	
	// LEFT SCALE WEST. This is the near version of placing a cube
	// on the scale in autonomous mode. This will need to be tested
	// extensively and requires the use of a sonic ranger on the back
	// of the robot or something similar.
	public static void LeftScaleWest() {
		switch ( Stage.Number ) {
		
			// SECURE CUBE
			case 0:
//				Lift.Grab();
//				Lift.Height( 73 );
				break;
				
			// DRIVE NORTH
			case 1:
				Autopilot.DriveStraight( 36 );
				Stage.StopBeyondForwardDistance( 240 );
				break;
				
			// TURN EAST
			case 2:
				Autopilot.TurnToHeading( 90 );
				Stage.StopNearHeading( 90, 10 );
				break;
		
			// DRIVE EAST
			case 3:
				Autopilot.DriveStraight( 12 );
				Stage.StopNearBackSurface( 50, 2 );
				break;
			
			// DROP CUBE
			case 4:
//				Lift.Drop();
				break;
				
			// RESET
			default:
				Stage.Last();
				break;
		}
	}

	
}
