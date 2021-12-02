// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class RunUntilBroken extends CommandBase {

  private Intake intake;
  private double startTime;

  /** Creates a new RunUntilBroken. */
  public RunUntilBroken(Intake intakeIn) {
    // Use addRequirements() here to declare subsystem dependencies.
    intake = intakeIn;
    startTime = -1.0;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
    intake.run(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.run(0.05);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.run(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return  Math.abs(Timer.getFPGATimestamp() - startTime) >= 3;
  }
}
