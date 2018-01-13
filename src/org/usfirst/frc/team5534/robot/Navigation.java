package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Navigation {

	
	public static void Init() {
//		DriveEncoderL.reset(); DriveEncoderL.setDistancePerPulse( Settings.DriveEcoderRatio );
		DriveEncoderR.reset(); DriveEncoderR.setDistancePerPulse( Settings.DriveEcoderRatio );
		Gyroscope.calibrate();
	}
	
	
	public static void Periodic() {
		
	}

	
	public static void Reset() {
//		DriveEncoderL.reset();
		DriveEncoderR.reset();
		Gyroscope.reset();
	}
	
	
	public static void Dashboard() {
		SmartDashboard.putNumber( "Heading",     GetDirection()  );
		SmartDashboard.putNumber( "Distance",    GetDistance()   );
		SmartDashboard.putNumber( "Drive Speed", GetDriveSpeed() );
		SmartDashboard.putNumber( "Turn Speed",  GetTurnSpeed()  );
		SmartDashboard.putNumber( "Front Range", GetFrontRange() );
//		SmartDashboard.putNumber( "Back Range",  GetBackRange()  );
	}


	public static String Telemetry() {
		String result = "";
		result += "Heading:"     + GetDirection()  + ";";
		result += "Distance:"    + GetDistance()   + ";";
		result += "Drive Speed:" + GetDriveSpeed() + ";";
		result += "Turn Speed:"  + GetTurnSpeed()  + ";";
		result += "Front Range:" + GetFrontRange() + ";";
//		result += "Back Range:"  + GetBackRange()  + ";";
		return result;
	}

	// ===

//	public static Encoder DriveEncoderL = new Encoder(
//		Ports.DIO_DriveEncoderL[0],
//		Ports.DIO_DriveEncoderL[1]
//	);

	public static Encoder DriveEncoderR = new Encoder(
		Ports.DIO_DriveEncoderR[0],
		Ports.DIO_DriveEncoderR[1],
		true
	);


	public static double GetDistance() {
//		return (DriveEncoderL.getDistance()+DriveEncoderR.getDistance()) / 2;
		return DriveEncoderR.getDistance();
	}
	
	
	public static double GetDriveSpeed() {
//		return (DriveEncoderL.getRate()+DriveEncoderR.getRate()) / 2;
		return DriveEncoderR.getRate();
	}
	
	// ===
	
	public static ADXRS450_Gyro Gyroscope = new ADXRS450_Gyro();

	
	public static double GetDirection() {
		return Gyroscope.getAngle();
	}
	
	
	public static double GetDelta( double Heading ) {
		return ( Heading - Gyroscope.getAngle() + 180 ) % 360 - 180;
	}

	
	public static double GetTurnSpeed() {
		return Gyroscope.getRate();
	}
	
	
	//	===

	public static Ultrasonic SonarFront = new Ultrasonic(
		Ports.DIO_SonarFront[0],
		Ports.DIO_SonarFront[1]
	);
	
	
//	public static Ultrasonic SonarBack = new Ultrasonic(
//		Ports.DIO_SonarBack[0],
//		Ports.DIO_SonarBack[1]
//	);
	
	
	public static double GetFrontRange() {
		return SonarFront.getRangeInches();
	}
	
	
//	public static double GetBackRange() {
//		return SonarBack.getRangeInches();
//	}
	
	
}
