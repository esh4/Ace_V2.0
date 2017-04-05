package org.usfirst.frc.team5990.robot.commands;

import org.usfirst.frc.team5990.robot.OI;
import org.usfirst.frc.team5990.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithXBox extends Command{

	private OI oi;
	public DriveWithXBox(OI oi) {
		this.oi = oi;
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void execute() {
		Robot.driveTrain.arcadeDrive(oi.getDriveY(), oi.getDriveX());
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void interrupted() {
		Robot.driveTrain.arcadeDrive(0, 0);
	}
	
	

}
