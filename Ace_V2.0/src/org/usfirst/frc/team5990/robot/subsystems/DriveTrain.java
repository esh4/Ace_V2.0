package org.usfirst.frc.team5990.robot.subsystems;

import org.usfirst.frc.team5990.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class DriveTrain extends Subsystem{
	// define motor controllers for drive train
	private Talon frontRight;
	private Talon rearRight;
	private Talon frontLeft;
	private Talon rearLeft;
	
	private RobotDrive drive;

	//Drive Train sensors:
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	private ADXRS450_Gyro gyro;
	
	private NetworkTable table;
	
	public DriveTrain() {
		frontRight = new Talon(RobotMap.frontRightMotor);
		rearRight = new  Talon(RobotMap.rearRightMotor);
		frontLeft = new Talon(RobotMap.frontLeftMotor);
		rearLeft = new Talon(RobotMap.rearLeftMotor);
		
		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
		drive.setSafetyEnabled(false);
		
		leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
		rightEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
		gyro = new ADXRS450_Gyro(RobotMap.gyro);
		
		table = NetworkTable.getTable("Dashboard");
		
		
		LiveWindow.addActuator("Drive Train", "Front_Left Motor", (Talon) frontLeft);
		LiveWindow.addActuator("Drive Train", "Back Left Motor", (Talon) rearLeft);
		LiveWindow.addActuator("Drive Train", "Front Right Motor", (Talon) frontRight);
		LiveWindow.addActuator("Drive Train", "Back Right Motor", (Talon) rearRight);
		LiveWindow.addSensor("Drive Train", "Left Encoder", leftEncoder);
		LiveWindow.addSensor("Drive Train", "Right Encoder", rightEncoder);
		LiveWindow.addSensor("Drive Train", "Gyro", gyro);		
		
	}
	
	//send useful info to DB:
	public void log(){
		table.putNumber("leftEncoder", leftEncoder.getDistance());
		table.putNumber("rightEncoder", rightEncoder.getDistance());
		table.putNumber("gyro angle", this.getHeading());
		
		table.putNumber("front right motor", frontRight.get());
		table.putNumber("rear right motor", rearRight.get());
		table.putNumber("front left motor", frontLeft.get());
		table.putNumber("rear left motor", rearLeft.get());
	}
	
	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	}
	
	public void arcadeDrive(Joystick joystick) {
		drive.arcadeDrive(joystick.getY(), joystick.getX());
	}
	
	public void arcadeDrive(double yVal, double xVal){
		drive.arcadeDrive(-yVal, -xVal);
	}
	
	
	public double getHeading() {
		return gyro.getAngle();
	}
	
	public void gyroCalibrate(){
		gyro.calibrate();
	}
	
	public void resetGyro(){
		gyro.reset();
	}
	
	public double getDistance() {
		return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
