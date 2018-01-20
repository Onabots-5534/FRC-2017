package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lift {

	public static DoubleSolenoid CubeLift = new DoubleSolenoid(
		Ports.PCM_CubeLift[0],  
		Ports.PCM_CubeLift[1]
	);


	public static String LiftState = "Raise";


	public static void Init() {
		Lower();
	}


	public static void Periodic() {
		switch ( LiftState ) {
			case "Lower": CubeLift.set( DoubleSolenoid.Value.kReverse  ); break;
			case "Raise": CubeLift.set( DoubleSolenoid.Value.kForward  ); break;
			default:      CubeLift.set( DoubleSolenoid.Value.kOff      );
		}
	}


	public static void Dashboard() {
		SmartDashboard.putString( "LiftState", LiftState );
	}


	public static String TelemetryHead() {
		String result = "LiftState ";
		return result;
	}


	public static String TelemetryData() {
		String result = LiftState + "";
		return result;
	}


	public static void Relax() { LiftState = "Off";   }
	
	public static void Raise() { LiftState = "Raise"; }

	public static void Lower() { LiftState = "Lower"; }

}
