package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain {

	public static Spark DriveMotorLF = new Spark( Ports.PWM_DriveMotorLF );
	public static Spark DriveMotorLR = new Spark( Ports.PWM_DriveMotorLR );
	public static Spark DriveMotorRF = new Spark( Ports.PWM_DriveMotorRF );
	public static Spark DriveMotorRR = new Spark( Ports.PWM_DriveMotorRR );
	
	public static double PowerL = 0;
	public static double PowerR = 0;


	public static void Init() {
		DriveMotorRF.setInverted( true );
		DriveMotorRR.setInverted( true );
		Stop();
	}

	public static void Periodic() {
		DriveMotorLF.set( PowerL ); DriveMotorRF.set( PowerR );
		DriveMotorLR.set( PowerL ); DriveMotorRR.set( PowerR );
	}


	public static void Dashboard() {
		SmartDashboard.putNumber( "Power L", PowerL  );
		SmartDashboard.putNumber( "Power R", PowerR  );
	}


	public static String Telemetry() {
		String result = "";
		result += "PowerL:" + PowerL + ";";
		result += "PowerR:" + PowerR + ";";
		return result;
	}


	public static void DriveArcade( double D, double T ) {
		PowerL = D + T;
		PowerR = D - T;
	}


	public static void DriveTank( double L, double R ) {
		PowerL = L;
		PowerR = R;
	}
	
	
	public static void Stop() {
		PowerL = 0;
		PowerR = 0;
	}
	
}
