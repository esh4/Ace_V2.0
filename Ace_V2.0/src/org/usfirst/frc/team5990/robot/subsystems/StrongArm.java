package org.usfirst.frc.team5990.robot.subsystems;

import org.usfirst.frc.team5990.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class StrongArm extends Subsystem{
	DoubleSolenoid gearLift, gearClamp, gearEject;
	
	public StrongArm() {
		gearLift = new DoubleSolenoid(RobotMap.gearLiftSolenoidA, RobotMap.gearLiftSolenoidB);
		gearClamp = new DoubleSolenoid(RobotMap.gearClampSolenoidA, RobotMap.gearClampSolenoidB);
		gearEject = new DoubleSolenoid(RobotMap.gearEjectSolenoidA, RobotMap.gearEjectSolenoidB);
	}
	
	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
