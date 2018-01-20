package org.usfirst.frc.team5534.robot;

public class Onabot {

	public static void Init() {

		Climber.Init();
		
		Claw.Init();
		
		Drivetrain.Init();
		
		Lift.Init();

		Navigation.Init();
		
	}


	public static void Periodic() {
		
		Claw.Periodic();

		Climber.Periodic();
		
		Dashboard.Periodic();

		Drivetrain.Periodic();

		Lift.Periodic();
		
		Navigation.Periodic();
	
		Telemetry.Periodic();
		
	}
	
}
