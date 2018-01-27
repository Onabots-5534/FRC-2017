package org.usfirst.frc.team5534.robot;

public class Autonomous {

	public static void Init() {

//		Climber.Stop();
		
		Drivetrain.Stop();

//		Lift.Grab();
//		Lift.Pull();
//		Lift.Height( 0 );

		Navigation.Reset();

		Stage.Init();

		Telemetry.Open();

	}
	
	
	public static void Periodic() {
		Stage.Reset();
		switch ( Chooser.autonSelected ) {
		
			case Chooser.autonCrossBaseline: Station.Baseline();      break;
			
			case Chooser.autonLeftStation:   Station.LeftStation();   break;
			
			case Chooser.autonCenterStation: Station.CenterStation(); break;
			
			case Chooser.autonRightStation:  Station.RightStation();  break;
			
			case Chooser.autonDoNothing:     Station.DoNothing();     break;
			
			case Chooser.autonTesting:       Station.Testing();       break;
			
			default: break;
		}
		Stage.Next();
	}
	
}
