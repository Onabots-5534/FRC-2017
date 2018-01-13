package org.usfirst.frc.team5534.robot;

public class Ports {

	// TODO: Too many DIO ports are allocated so some sensors
	// will need to be eliminated. Candidates are:
	// -  DriveEncoderL (2 ports)
	// -  LiftSwitchMax (1 port)
	//
	// Alternative is to eliminate the NavX board and use the
	// REV More board.
	//
	// Alternative 2 is to use a MXP extension cable and stack
	// the boards.
	//
	// TODO: Use PWM Y cables to consolidate the left and right 
	// drive motors.
	//

//	public static final int[] DIO_DriveEncoderL = { 0, 1 };
	public static final int[] DIO_DriveEncoderR = { 2, 3 };
//	public static final int[] DIO_LiftEncoder   = { 4, 5 };
	
	public static final int[] DIO_SonarFront    = { 6, 7 };
//	public static final int[] DIO_SonarBack     = { 8, 9 };

//	public static final int   DIO_LiftSwitchMax  = 10;
//	public static final int   DIO_LiftSwitchMin  = 11;
//	public static final int   DIO_ClawSwitch     = 12;
	
	
//	public static final int[] PCM_ElevatorArms  = { 0, 1 };
//	public static final int[] PCM_ElevatorFoot  = { 2, 3 };
	
	
	public static final int   PWM_DriveMotorLF  = 1;
	public static final int   PWM_DriveMotorLR  = 2;
	public static final int   PWM_DriveMotorRF  = 3;
	public static final int   PWM_DriveMotorRR  = 4;
	
//	public static final int   PWM_ClimbMotor    = 0;
	
//	public static final int   PWM_LiftMotor     = 0;

//	public static final int   PWM_ClawMotorL    = 0;
//	public static final int   PWM_ClawMotorR    = 0;
	
	
	public static final int   USB_DriveStickL   = 0;
//	public static final int   USB_DriveStickR   = 1;
	
}
