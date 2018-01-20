package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber {

	public static Spark ClimbMotor = new Spark( Ports.PWM_ClimbMotor );
	
	public static double ClimbPower = 0;
	
	
	public static void Init() {
		ClimbMotor.setInverted( false );
		Stop();
	}
	
	
	public static void Periodic() {
		ClimbMotor.set( ClimbPower );
	}
	
	
	public static void Dashboard() {
		SmartDashboard.putNumber( "Power C", ClimbPower );
	}


	public static String TelemetryHead() {
		String result = "";
		result += "ClimbPower ";
		return result;
	}
	
	
	public static String TelemetryData() {
		String result = "";
		result += ClimbPower + " ";
		return result;
	}
	
	
	public static void Ascend() {
		ClimbPower = Settings.ClimbPower;
	}
	
	
	public static void Stop() {
		ClimbPower = 0;
	}
	
}
