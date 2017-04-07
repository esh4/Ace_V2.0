package org.usfirst.frc.team5990.robot.subsystems;

import org.usfirst.frc.team5990.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class StrongArm extends Subsystem{
	DoubleSolenoid gearLift, gearClamp, gearEject;
	Compressor compressor;
	
	public StrongArm() {
		gearLift = new DoubleSolenoid(RobotMap.gearLiftSolenoidA, RobotMap.gearLiftSolenoidB);
		gearClamp = new DoubleSolenoid(RobotMap.gearClampSolenoidA, RobotMap.gearClampSolenoidB);
		gearEject = new DoubleSolenoid(RobotMap.gearEjectSolenoidA, RobotMap.gearEjectSolenoidB);
		compressor = new Compressor();
		compressor.start();
	}
	
	public void raiseArm() {
		gearLift.set(Value.kForward);
	}
	
	public void lowerArm() {
		gearLift.set(Value.kReverse);
	}
	
	public void openArm() {
		gearClamp.set(Value.kForward);
	}
	
	public void closeArm() {
		gearClamp.set(Value.kReverse);
	}
	
	public void ejectGear() {
		gearEject.set(Value.kForward);
	}
	
	public void retractGear() {
		gearEject.set(Value.kReverse);
	}
	
	public void disable(){
		gearClamp.set(Value.kOff);
		gearEject.set(Value.kOff);
		gearLift.set(Value.kOff);
		compressor.stop();
	}
	
	public void enable(){
		compressor.start();
	}
	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
