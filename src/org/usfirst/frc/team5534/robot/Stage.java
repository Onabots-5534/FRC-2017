package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Stage {

	public static double  AutonStartTime;
	public static double  AutonFinalTime;

	public static double  StageStartTime;
	public static double  StageStartDistance;
	
	public static int     Number;
	public static boolean ReadyToAdvance;
	
	
	public static void Init() {
		AutonStartTime = System.currentTimeMillis();
		StageStartTime = AutonStartTime;
		Number = 0;
	}

	
	public static void Dashboard() {
		SmartDashboard.putNumber( "Stage Number",   Number             );
		SmartDashboard.putNumber( "Stage Distance", GetStageDistance() );
	}
	
	
	public static String TelemetryHead() {
		String result = "";
		result += "StageNumber,";
		result += "StageDistance,";
		return result;
	}
	
	
	public static String TelemetryData() {
		String result = "";
		result += Number             + ",";
		result += GetStageDistance() + ",";
		return result;
	}
		
	// ===
	
	public static void Next() {
		if ( ReadyToAdvance == true ) {
			StageStartDistance = Navigation.GetDistance();
			StageStartTime     = System.currentTimeMillis();
			Number++;
		}
	}

	
	public static void Reset() {
		ReadyToAdvance = true;
	}

	
	public static void Last() {
		ReadyToAdvance = false;
	}

	
	// ===

	
	public static double GetAutonDuration() {
		return ( System.currentTimeMillis() - AutonStartTime ) / 1000.0;
	}


	public static double GetStageTime() {
		return ( System.currentTimeMillis() - StageStartTime ) / 1000.0;
	}
	

	public static double GetStageDistance() {
		return Navigation.GetDistance() - StageStartDistance;
	}

	// ===
	
	public static void StopBeyondForwardDistance( double distance ) {
		if ( GetStageDistance() < distance ) { ReadyToAdvance = false; } else {
			Drivetrain.Stop();
		}
	}
	
	
	public static void StopBeyondReverseDistance( double distance ) {
		if ( GetStageDistance() > -distance ) { ReadyToAdvance = false; } else {
			Drivetrain.Stop();
		}
	}
	
	
	public static void StopNearFrontSurface( double Range, double tolerance ) {
		if ( Math.abs(Navigation.GetFrontRange()-Range) > tolerance ) { ReadyToAdvance = false; } else {
			Drivetrain.Stop();
		}
	}
	
	
	public static void StopNearBackSurface( double Range, double tolerance ) {
//		if ( Math.abs(Navigation.GetFrontRange()-Range) > tolerance ) { ReadyToAdvance = false; } else {
//			Drivetrain.Stop();
//		}
	}
	
	
	public static void WaitForDuration( double duration ) {
		if ( GetStageTime() < duration ) { ReadyToAdvance = false; }
	}

	
	public static void StopNearHeading( double heading, double tolerance ) {
		if ( Math.abs(Navigation.GetDelta(heading)) > tolerance ) { ReadyToAdvance = false; } else {
			Drivetrain.Stop();
		}
	}

	
	public static void StopNearTargetHeading( double tolerance ) {
		if ( Math.abs(Vision.GetTargetX()) > tolerance ) { ReadyToAdvance = false; } else {
			Drivetrain.Stop();
		}
	}	

}
