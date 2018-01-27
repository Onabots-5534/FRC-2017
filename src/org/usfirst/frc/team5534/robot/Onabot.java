package org.usfirst.frc.team5534.robot;

public class Onabot {

	public static void Init() {

		Claw.Init();
		
		Climber.Init();
		
		Dashboard.Init();
		
		Drivetrain.Init();
		
//		Lift.Init();

		Navigation.Init();
		
		Telemetry.Init();
		
		Vision.Init();

	}


	public static void Periodic() {
		
		Claw.Periodic();

		Climber.Periodic();
		
		Dashboard.Periodic();

		Drivetrain.Periodic();

//		Lift.Periodic();
		
		Navigation.Periodic();
	
		Telemetry.Periodic();
		
		Vision.Periodic();
		
	}
	
}
