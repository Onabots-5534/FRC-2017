package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chooser {
	
	public static DigitBoard DB = DigitBoard.getInstance(); 

	public static final String autonDoNothing     = "Pout";
	public static final String autonLeftStation   = "Left Station";
	public static final String autonCenterStation = "Center Station";
	public static final String autonRightStation  = "Right Station";
	public static final String autonCrossBaseline = "Baseline";
	public static final String autonTesting       = "Testing";

	public static String autonSelected = autonTesting;


	public static void Dashboard() {

		DB.writeDigits( Chooser.autonSelected );	

		SmartDashboard.putBoolean("Button A",     DB.getA()             );
		SmartDashboard.putBoolean("Button B",     DB.getB()             );
		SmartDashboard.putNumber("Potentiometer", DB.getPotentiometer() );
		SmartDashboard.putString( "Auton Mode",   autonSelected         );
	}

	
    public static void AutonChooser() {
    	
    	double voltage = 6 * DB.getPotentiometer();
    	
    	if      ( voltage < 1 ) { autonSelected = autonDoNothing;     }
    	
    	else if ( voltage < 2 ) { autonSelected = autonLeftStation;   }
    	
    	else if ( voltage < 3 ) { autonSelected = autonCenterStation; }
    	
    	else if ( voltage < 4 ) { autonSelected = autonRightStation;  }
    	
    	else if ( voltage < 5 ) { autonSelected = autonCrossBaseline; }
    	
    	else                    { autonSelected = autonTesting;       }
    	
    }
    
}
