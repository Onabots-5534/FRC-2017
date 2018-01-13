package org.usfirst.frc.team5534.robot;

import edu.wpi.first.wpilibj.Preferences;

public class Prefs {

	public static Preferences prefs = Preferences.getInstance();
	
	public static double Stage0 = 0.00;

	
	public static void ResetIt() {
		Stage0 = prefs.getDouble( "First Auto Distance", 0.00 );
	}

}
