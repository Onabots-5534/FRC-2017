package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Pilot {

	public static void Galvez() {
		Joystick DriveStick = Operator.DriveStickL;
		double PowerD = -DriveStick.getY();
		double PowerT = +DriveStick.getTwist();
		Drivetrain.DriveArcade( PowerD,  PowerT );
	} // END GALVEZ

	
	public static void Steensma() {
		Joystick DriveStick = Operator.DriveStickL;
		double PowerD = -DriveStick.getY();
		double PowerT = +DriveStick.getTwist() / 3;
		Drivetrain.DriveArcade( PowerD,  PowerT );

		if ( DriveStick.getRawButton(2) ) {
			Autopilot.LastHeading = 0;
			Navigation.Reset();
			Stage.Init();
		}

		if ( DriveStick.getRawButton(3) ) {
			Stage.Reset();
			Track.CrossBaseLine();
			Stage.Next();
		}

		if ( DriveStick.getRawButton(4) ) { Autopilot.DriveStraight( 24 ); }
		
		
		if      ( DriveStick.getRawButton(5) ) { Claw.Pull(); }
		else if ( DriveStick.getRawButton(6) ) { Claw.Push(); }
		else                                   { Claw.Stop(); }
		
	} // END STEENSMA
	
		

}
