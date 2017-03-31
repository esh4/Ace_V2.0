package org.usfirst.frc.team5990.robot.subsystems;

import org.usfirst.frc.team5990.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{
	VictorSP climb1, climb2;
	
	public Climber() {
		climb1 = new VictorSP(RobotMap.climbMotor1);
		climb2 = new VictorSP(RobotMap.climbMotor2);
	}

	public void setPower(double power) {
		climb1.set(power);
		climb2.set(power);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
