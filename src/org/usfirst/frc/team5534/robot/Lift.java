package org.usfirst.frc.team5534.robot;

//import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Spark;

public class Lift {

//	public static DoubleSolenoid LiftArms = new DoubleSolenoid(
//		Ports.PCM_ElevatorArms[0],
//		Ports.PCM_ElevatorArms[1]
//	);
//
//	public static DoubleSolenoid LiftFoot = new DoubleSolenoid(
//		Ports.PCM_ElevatorFoot[0],
//		Ports.PCM_ElevatorFoot[1]
//	);
//
//	public static DigitalInput LiftSwitchMin = new DigitalInput(
//		Ports.DIO_LiftSwitchMin
//	);
//
//	public static DigitalInput LiftSwitchMax = new DigitalInput(
//			Ports.DIO_LiftSwitchMax
//		);
//
//	public static DigitalInput LiftSwitchGrab = new DigitalInput(
//			Ports.DIO_LiftSwitchGrab
//		);
//
//	public static Spark LiftMotor = new Spark(
//		Ports.PWM_LiftMotor
//	);
//	
//	public static Encoder LiftEncoder = new Encoder(
//		Ports.DIO_LiftEncoder[0],
//		Ports.DIO_LiftEncoder[1],
//		false
//	);
//	
//	// ===
//	
//	public static double LiftLevel = 0;
//	public static double LiftPower = 0;
//	public static double LiftSpeed = 0;
//	
//	public static Value ArmsState = DoubleSolenoid.Value.kOff;
//	public static Value FootState = DoubleSolenoid.Value.kOff;
//	
//	// ===
//	
//	public static void Init() {
//		Calibrate();
//		LiftEncoder.reset();
//		LiftEncoder.setDistancePerPulse( Settings.LiftEncoderRatio );
//	}
//
//
//	public static void Periodic() {
//		LiftMotor.set( LiftPower );
//		LiftArms.set( ArmsState );
//		LiftFoot.set( FootState );
//
//	}
//
//
//	public static void Dashboard() {
//		SmartDashboard.putNumber( "Lift Power", LiftPower );
////		SmartDashboard.putNumber( "ArmsState",  ArmsState );
////		SmartDashboard.putNumber( "FootState",  FootState );
//	}
//
//
//	public static String Telemetry() {
//		String result = "";
//		result += "LiftSpeed:" + LiftSpeed + ";";
//		result += "ArmsState:" + ArmsState + ";";
//		result += "FootState:" + ArmsState + ";";
//		return result;
//	}
//	
//	
////	public static void Reset() {
////		Height( 0.00 );
////		Drop();
////		Pull();
////	}
//	
//	
//	public static void Calibrate() {
//		// Lower the lift slowly until LimitSwitchMin is triggered.
//		// At that point, drop power and reset the encoder.
//	}
//
//
//	public static void Grab() { ArmsState = DoubleSolenoid.Value.kForward; }
//
//	public static void Drop() { ArmsState = DoubleSolenoid.Value.kReverse; }
//	
//	public static void Push() { FootState = DoubleSolenoid.Value.kForward; }
//	
//	public static void Pull() { FootState = DoubleSolenoid.Value.kReverse; }
//
//
//	public static void Height( double height ) {
//		
//		// Height restrictions for safety.
//		height = Math.max(  0, height );
//		height = Math.min( 48, height );
//		
//		double heighterror = height - LiftEncoder.getDistance();
//		double targetspeed = heighterror * 0.1;
//
//		// Maximum lift speed of 12 in/s over 55 in takes 5-6 seconds. Slower going down.
//		if ( targetspeed > 0 ) { targetspeed = Math.min( +12.0, targetspeed ); }
//		if ( targetspeed < 0 ) { targetspeed = Math.max( -10.0, targetspeed ); }
//		
//		double speedError = targetspeed - LiftEncoder.getRate();
//		double powerDelta = 0;
//
//		// Linear change in power. Consider making proportional to speedError
//		powerDelta += 0.0001 * Math.signum(speedError);
////		if ( speedError < 0 ) { powerDelta = -0.0001; }
////		if ( speedError > 0 ) { powerDelta = +0.0001; }
//	
//		LiftPower += powerDelta;
//		
//		// Limit Switches for additional safety
//		if ( LiftSwitchMin.get() == true && LiftPower < 0 ) { LiftPower = 0; }
//		if ( LiftSwitchMax.get() == true && LiftPower > 0 ) { LiftPower = 0; }
//	}
//	
}
