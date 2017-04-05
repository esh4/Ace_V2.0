package org.usfirst.frc.team5990.robot;

import edu.wpi.first.wpilibj.SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// DriveTrain subsystem:
	// all talonSR controllers
	public static int frontLeftMotor = 1;
	public static int rearLeftMotor = 2;
	public static int frontRightMotor = 3;
	public static int rearRightMotor = 4;
	
	//Sensor ports:
	public static int leftEncoderA = 0;
	public static int leftEncoderB = 1;
	public static int rightEncoderA = 2;
	public static int rightEncoderB = 3;
	public static SPI.Port gyro = SPI.Port.kOnboardCS0; 
	
	//Climber Subsystem:
	public static int climbMotor1 = 5;
	public static int climbMotor2 = 7;
	
	//StrongArm Subsystem:
	public static int gearLiftSolenoidA = 3;
	public static int gearLiftSolenoidB = 2;
	public static int gearClampSolenoidA = 4;
	public static int gearClampSolenoidB = 5;
	public static int gearEjectSolenoidA = 0;
	public static int gearEjectSolenoidB = 1;
	
}
