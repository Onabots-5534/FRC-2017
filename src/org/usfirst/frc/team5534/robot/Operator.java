package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class Operator {

	public static Joystick DriveStickL = new Joystick( Ports.USB_DriveStickL );
//	public static Joystick DriveStickR = new Joystick( Ports.USB_DriveStickR );
	public static XboxController XBox = new XboxController( Ports.USB_XBoxStick );
	
	public static void Init() {

		Climber.Stop();

		Drivetrain.Stop();

		Claw.Grab();

//		Lift.Height( 0 );

		Navigation.Reset();

		Telemetry.Open();

	}


	public static void Periodic() {

		Pilot.Steensma();

	}

}
