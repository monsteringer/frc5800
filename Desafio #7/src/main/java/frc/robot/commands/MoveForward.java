package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class MoveForward extends CommandBase {
  
  private final Drivetrain drivetrain;
  private final Timer timer = new Timer();

  private final double duration = 3;
  private double speed = 0.6;

  public MoveForward (Drivetrain drivetrain, double speed) {
    this.speed = speed;
    this.drivetrain = drivetrain;

    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    timer.restart();
    timer.start();
  }

  @Override
  public void execute() {
    drivetrain.tankDrive(speed, speed);
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.tankDrive(0, 0);
    timer.stop();
  }

  @Override
  public boolean isFinished() {
    return timer.get() >= this.duration;
  }
}
