// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.extendy;
import frc.robot.subsystems.flippy;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class flipBack extends Command {
  private extendy e_Extendy;
  private flippy f_Flippy;
  /** Creates a new flipBack. */
  public flipBack(flippy f_Flippy, extendy e_Extendy) {
    addRequirements(f_Flippy);
    this.e_Extendy = e_Extendy;
    this.f_Flippy = f_Flippy;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
      f_Flippy.leftPivot.setVoltage(f_Flippy.wristPID.calculate(f_Flippy.WristPosition(), Math.toRadians(10)) + f_Flippy.wristFeedForward.calculate(f_Flippy.WristPosition(), 0));
      f_Flippy.rightPivot.setVoltage(f_Flippy.wristPID.calculate(f_Flippy.WristPosition(), Math.toRadians(10)) + f_Flippy.wristFeedForward.calculate(f_Flippy.WristPosition(), 0));
    
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    f_Flippy.leftPivot.setVoltage(f_Flippy.wristFeedForward.calculate(f_Flippy.WristPosition(), 0));
    f_Flippy.rightPivot.setVoltage(f_Flippy.wristFeedForward.calculate(f_Flippy.WristPosition(), 0));
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    if (Math.abs(-90-f_Flippy.WristPosition())< 1.5){
      return true;
    }
      return false;
    }
  }

