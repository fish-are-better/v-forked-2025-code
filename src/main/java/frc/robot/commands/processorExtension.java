// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.extendy;
import frc.robot.subsystems.flippy;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class processorExtension extends Command {
  private final extendy e_Extendy;
  /** Creates a new processorExtension. */
  public processorExtension(extendy e_Extendy) {
    addRequirements(e_Extendy);
    this.e_Extendy = e_Extendy;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (flippy.wristAngle< 270 && flippy.wristAngle > 90){
    
      e_Extendy.spoolMotor.setVoltage(e_Extendy.elevatorPID.calculate(e_Extendy.extendyPosition.getDistance(), 20) + e_Extendy.elevatorFeedForward.calculate(0,0));
      }
      else {
        e_Extendy.spoolMotor.setVoltage(e_Extendy.elevatorFeedForward.calculate(0,0));
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    e_Extendy.spoolMotor.setVoltage(e_Extendy.elevatorFeedForward.calculate(0,0));
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Math.abs(e_Extendy.elevatorPID.calculate(e_Extendy.extendyPosition.getDistance(), 20)) < .005){
      return true;
    }
    else{
      return false;
    }
  }
}
