//commit from ubuntu!
package org.usfirst.frc.team5990.robot;

import org.usfirst.frc.team5990.robot.subsystems.Climber;
import org.usfirst.frc.team5990.robot.subsystems.DriveTrain;
import org.usfirst.frc.team5990.robot.subsystems.StrongArm;
import org.usfirst.frc.team5990.robot.commands.AnnoyEshel;
import org.usfirst.frc.team5990.robot.commands.ReadyToGrab;
import org.usfirst.frc.team5990.robot.commands.driveDistance;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.usfirst.frc.team5990.robot.commands.ExampleCommand;
//import org.usfirst.frc.team5990.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static DriveTrain driveTrain;
	public static Climber climber;
	public static StrongArm strongArm;
	
	//public static Compressor compressor;
 
	Command autonomousCommand;
	//SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		driveTrain = new DriveTrain();
		strongArm = new StrongArm();
		
		//driveTrain.gyroCalibrate();
		climber = new Climber();
		oi = new OI();
		driveTrain.setOI(oi);
		//compressor.start();
		//chooser.addDefault("Default Auto", new ExampleCommand());
		//chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", chooser);

	}
	

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */


	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = new driveDistance(1000, 0.3);

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		driveTrain.log();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//driveTrain.arcadeDrive(oi.driveStick.getY(), oi.driveStick.getX());
		driveTrain.log();
		
		SmartDashboard.putBoolean("A pressed", new JoystickButton(oi.driveStick, 1).get());
		SmartDashboard.putBoolean("B pressed", new JoystickButton(oi.driveStick, 2).get());
		
		climber.setPower(Math.abs(oi.operatorStick.getY()));
	}

	@Override
	public void disabledPeriodic() {
		driveTrain.log();
	}
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
