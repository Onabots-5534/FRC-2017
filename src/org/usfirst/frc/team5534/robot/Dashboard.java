package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {

	public static void Init() { }
	

	public static void Periodic() {

		SmartDashboard.putNumber( "Time", System.currentTimeMillis() );
		
		Chooser.Dashboard();

//		Climber.Dashboard();

		Drivetrain.Dashboard();

//		Field.Dashboard();

//		Lift.Dashboard();

		Navigation.Dashboard();
		
		Stage.Dashboard();
	}

}
