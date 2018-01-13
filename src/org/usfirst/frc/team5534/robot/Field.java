package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Field {

	public static String gameData = "---";
		

	public static void Periodic() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
	
	
	public static void Dashboard() {
		SmartDashboard.putString( "Game Data", gameData );
	}

	
	public static char Get0() {
		return gameData.charAt(0);
	}
	
	
	public static char Get1() {
		return gameData.charAt(1);
	}
	
	
	public static char Get2() {
		return gameData.charAt(2);
	}
	

}
