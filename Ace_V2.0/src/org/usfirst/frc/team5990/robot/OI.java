package org.usfirst.frc.team5990.robot;

import org.usfirst.frc.team5990.robot.commands.AnnoyEshel;
import org.usfirst.frc.team5990.robot.commands.CloseArm;
import org.usfirst.frc.team5990.robot.commands.Eject;
import org.usfirst.frc.team5990.robot.commands.LiftGear;
import org.usfirst.frc.team5990.robot.commands.LowerArm;
import org.usfirst.frc.team5990.robot.commands.OpenArm;
import org.usfirst.frc.team5990.robot.commands.RaiseArm;
import org.usfirst.frc.team5990.robot.commands.ReadyToGrab;
import org.usfirst.frc.team5990.robot.commands.disableStrongArm;
import org.usfirst.frc.team5990.robot.commands.driveDistance;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.usfirst.frc.team5990.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	XboxController driveStick = new XboxController(3);
	Joystick operatorStick = new Joystick(2);
	
	public OI(){
		SmartDashboard.putData("drive", new driveDistance(1000, 0.4));
		SmartDashboard.putData("disable strongarm", new disableStrongArm());
		SmartDashboard.putData(new ReadyToGrab());
		SmartDashboard.putData(new AnnoyEshel());
		
		SmartDashboard.putData(new CloseArm());
		SmartDashboard.putData(new OpenArm());
		SmartDashboard.putData(new LowerArm());
		SmartDashboard.putData(new RaiseArm());
		SmartDashboard.putData(new Eject());
		SmartDashboard.putData(new LiftGear());
		
		
		
		Button aButton = new JoystickButton(driveStick, 1);
		Button bButton = new JoystickButton(driveStick, 2);
		
		aButton.whenPressed(new ReadyToGrab());
		bButton.whenPressed(new LiftGear());
	}
	
	public double getDriveX(){
		return driveStick.getX();
	}
	
	public double getDriveY(){
		return driveStick.getY();
	}
	
	
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
