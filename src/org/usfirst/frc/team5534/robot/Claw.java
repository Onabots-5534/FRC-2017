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
	
	public static void Suck() { ClawPower = -Settings.ClawPower; }
	
	public static void Spit() { ClawPower = +Settings.ClawPower; }
	
	
//	public static Spark ClawMotorL = new Spark( Ports.PWM_ClawMotorL );
//	public static Spark ClawMotorR = new Spark( Ports.PWM_ClawMotorR );
//
//	public static DigitalInput ClawSwitch = new DigitalInput( Ports.DIO_ClawSwitch );
//	
//	public static double ClawPower = 0;
//
//
//	public static void Init() {
//	
//	}
//
//
//	public static void Periodic() {
//		
//	}
//	
//	
//	public static void Dashboard() {
//		SmartDashboard.putNumber( "ClawPower", ClawPower );
//	}
//	
//	
//	public static String Telemetry() {
//		String result = "";
//		result += "ClawPower:" + ClawPower + ";";
//		return result;
//	}
//	
//	
//	public static void Pull() {
//		
//	}
//	
//	
//	public static void Push( ) {
//		
//	}
	
}
