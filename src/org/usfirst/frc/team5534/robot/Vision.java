package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.cscore.UsbCamera;

public class Vision {

    public static UsbCamera PilotCamera;

    public static void Init() {
	    PilotCamera = CameraServer.getInstance().startAutomaticCapture();
	    PilotCamera.setFPS(30);
    }

    // ===
    
    public static NetworkTableInstance NTI = NetworkTableInstance.getDefault();
    public static NetworkTable VisionTable = NTI.getTable("Vision");
  
 
    public static void Periodic() {
    }


    public static void Dashboard() {
    	SmartDashboard.putNumber( "Target Score",  GetTargetScore() );
    	SmartDashboard.putNumber( "Target X",      GetTargetX()     );
    	SmartDashboard.putNumber( "Target Y",      GetTargetY()     );
    }

    
    public static String TelemetryHead() {
    	String result = "";
    	result += "TargetScore,";
    	result += "TargetX,";
    	result += "TargetY,";
    	return result;
    }

    
    public static String TelemetryData() {
    	String result = "";
    	result += GetTargetScore() + ",";
    	result += GetTargetX()     + ",";
    	result += GetTargetY()     + ",";
    	return result;
    }
    
    
    public static double TargetScore;
    public static double TargetX;
    public static double TargetY;

    
	public static double GetTargetScore() {
    	return VisionTable.getEntry("Score").getDouble(0);
    }
    
    
	public static double GetTargetX() {
    	return VisionTable.getEntry("X").getDouble(0) - Settings.CameraCenterX;
    }
    
    
	public static double GetTargetY() {
    	return VisionTable.getEntry("Y").getDouble(0) - Settings.CameraCenterY;
    }
    
}
