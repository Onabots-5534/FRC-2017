package org.usfirst.frc.team5534.robot;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Telemetry {

	public static String      directorySrc = "/home/lvuser/";
	public static String      fileName     = "onabots-telemetry-data.txt";
	public static PrintWriter pw           = null;
	public static File        file         = new File( directorySrc + fileName );
	public static long        initialTime  = 0;


	public static void Init() {
		if ( pw != null ) {
			String result = "Timestamp ";
			result += Claw.TelemetryHead();
			result += Climber.TelemetryHead();
			result += Drivetrain.TelemetryHead();
			result += Lift.TelemetryHead();
			result += Navigation.TelemetryHead();
			result += Stage.TelemetryHead();
			result += Vision.TelemetryHead();
			pw.print( result + "\n" );
		}
	}


	public static void Periodic() {
		if ( pw != null ) {
			
			String result = Timestamp();

			result += Claw.TelemetryData();
			result += Climber.TelemetryData();
			result += Drivetrain.TelemetryData();
			result += Lift.TelemetryData();
			result += Navigation.TelemetryData();
			result += Stage.TelemetryData();
			result += Vision.TelemetryData();

			pw.print( result + "\n" );

		}		
	}


	public static void Open() {
		file.delete();
		initialTime = System.currentTimeMillis();
		try { pw = new PrintWriter( file ); Init(); } catch (IOException ioe) { }
	}


	public static void Close() {
		if ( pw != null ) { pw.close(); pw = null; }
	}


//	public static void Send() throws IOException {
//		String command = "scp " + directorySrc + fileName + " pi@10.55.34.83/home/pi/" + fileName;
//		java.lang.Runtime.getRuntime().exec( command );
//	}


	public static String Timestamp() {
		return (System.currentTimeMillis() - initialTime) + " ";
	}

}
