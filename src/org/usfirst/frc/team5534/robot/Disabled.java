package org.usfirst.frc.team5534.robot;

public class Disabled {

	public static void Init() {

		Telemetry.Close();
	}

	
	public static void Periodic() {

		Chooser.AutonChooser();
		
		Field.Periodic();
	}
	
}
