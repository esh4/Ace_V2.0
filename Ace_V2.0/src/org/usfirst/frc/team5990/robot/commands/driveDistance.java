package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;
import org.usfirst.frc.team5990.robot.assists.DummyPIDOutput;
import org.usfirst.frc.team5990.robot.assists.DummyPIDSource;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class driveDistance extends Command{
	
	PIDController headingControl;
	DummyPIDOutput gyroPIDOut;
	DummyPIDSource gyroPIDSource;
	
	double distance;
	double power;
	
	double setpoint;
	double kP;
	double error;
	double correction;
	
	public driveDistance(double distance, double power){
		this.distance = distance;
		this.power = power;
		this.kP = 0.2;
		//gyroPIDOut = new DummyPIDOutput();
		//gyroPIDSource = new DummyPIDSource();
		
		requires(Robot.driveTrain);
		//headingControl = new PIDController(0.5, 0, 0, gyroPIDSource, gyroPIDOut);
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.resetEncoders();
		this.setpoint = Robot.driveTrain.getHeading();
	}
	
	@Override
	protected void execute() {
		this.error = this.setpoint - Robot.driveTrain.getHeading();
		this.correction = this.error * this.kP;
		Robot.driveTrain.drive(this.power + this.correction, this.power - this.correction);
		Robot.driveTrain.log();
	}

	
	
	@Override
	protected boolean isFinished() {
		if (Robot.driveTrain.getDistance() >= this.distance){
			return true;
		}
		else{
			return false;
		}
	}
}
