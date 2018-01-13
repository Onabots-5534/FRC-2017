package org.usfirst.frc.team5534.robot;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Telemetry {

	public static PrintWriter pw          = null;
	public static File        file        = new File("/home/lvuser/data.txt");
	public static long        initialTime = 0;
	

	public static void Periodic() {
		if ( pw != null ) {
			
			String result = Timestamp();

//			result += Claw.Telemetry();
//			result += Climber.Telemetry();
			result += Drivetrain.Telemetry();
//			result += Lift.Telemetry();
			result += Navigation.Telemetry();
			result += Stage.Telemetry();
			result += Vision.Telemetry();

			pw.print( result + "\n" );

		}		
	}
	
	
	public static void Open() {
		file.delete();
		initialTime = System.currentTimeMillis();
		try { pw = new PrintWriter( file ); } catch (IOException ioe) {}
	}

	
	public static void Close() {
		if ( pw != null ) {	pw.close(); pw = null; }
	}

	
	public static String Timestamp() {
		return "Timestamp:" + System.currentTimeMillis() + ";";
	}

}
