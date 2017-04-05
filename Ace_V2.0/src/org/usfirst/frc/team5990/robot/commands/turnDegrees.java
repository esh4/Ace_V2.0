package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class turnDegrees extends Command{
	
	double power;
	double targetHeading;

	public turnDegrees(double heading, double power) {
		this.targetHeading = heading;
		this.power = power;
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize() {
		Robot.driveTrain.resetGyro();
		Robot.driveTrain.drive(this.power, -this.power);
	}
	

	@Override
	protected boolean isFinished() {
		if (Math.abs(Robot.driveTrain.getHeading()) >= this.targetHeading){
			return true;
		}
		else{
			return false;
		}
	}

}
