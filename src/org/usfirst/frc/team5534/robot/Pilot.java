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
		double PowerT = +DriveStick.getX()/3;
		Drivetrain.DriveArcade( PowerD,  PowerT );

		if ( DriveStick.getRawButton(2) ) {
			Autopilot.LastHeading = 0;
			Autopilot.LastPowerD = 0;
			Autopilot.LastPowerT = 0;
			Navigation.Reset();
			Stage.Init();
		}

		if ( DriveStick.getRawButton(3) ) {
			Stage.Reset();
			Track.Testing();
			Stage.Next();
		}

		if ( DriveStick.getRawButton(4) ) { Autopilot.DriveStraight( 24 ); }
		
		
		if      ( DriveStick.getRawButton(5) ) { Claw.Grab(); }
		else if ( DriveStick.getRawButton(6) ) { Claw.Drop(); }
		else                                   { Claw.Stop(); }
		
	} // END STEENSMA
	
		

}
