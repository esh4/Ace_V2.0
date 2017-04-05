package org.usfirst.frc.team5990.robot.commands;


import org.usfirst.frc.team5990.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class disableStrongArm extends Command{

	public disableStrongArm() {
		requires(Robot.strongArm);
	}

	@Override
	protected void initialize() {
		Robot.strongArm.disable();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
