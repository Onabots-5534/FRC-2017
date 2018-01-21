package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw {

	public static Spark ClawMotorL = new Spark( Ports.PWM_ClawMotorL );
	public static Spark ClawMotorR = new Spark( Ports.PWM_ClawMotorR );
	
	
	public static double ClawPower = 0;

	
	public static void Init() {
		ClawMotorR.setInverted( true );
	}

	
	public static void Periodic() {
		ClawMotorL.set( ClawPower );
		ClawMotorR.set( ClawPower );		
	}
	
	
	public static void Dashboard() {
		SmartDashboard.putNumber( "ClawPower", ClawPower );
	}

	
	public static String TelemetryHead() {
		String result = "";
		result += "ClawPower ";
		return result;
	}
	
	
	public static String TelemetryData() {
		String result = "";
		result += ClawPower + "";
		return result;
	}
	
	
	public static void Stop() { ClawPower = 0; }
	
	public static void Grab() { ClawPower = -Settings.ClawPower; }
	
	public static void Drop() { ClawPower = +Settings.ClawPower; }
	
}
