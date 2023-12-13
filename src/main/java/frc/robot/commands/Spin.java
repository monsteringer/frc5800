package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Spin extends CommandBase {
  private final Drivetrain drivetrain;
  private double maxAngle = 0.3;

  public Spin(Drivetrain drivetrain, double maxAngle) {
    this.maxAngle = maxAngle;
    this.drivetrain = drivetrain;

    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    drivetrain.resetGyro();
  }

  @Override
  public void execute() {
    if (maxAngle > 0){
      drivetrain.tankDrive(0.7, -0.7);
    } else if (maxAngle < 0){
      drivetrain.tankDrive(-0.7, 0.7);
    }
    
    SmartDashboard.putNumber("gyro", drivetrain.getAngle());
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.tankDrive(0, 0);
    
  }

  @Override
  public boolean isFinished() {

    if (maxAngle> 0){
      return drivetrain.getAngle() >= maxAngle;
    } else if(maxAngle < 0) {
      return drivetrain.getAngle() <= maxAngle;
    } else {
      return false;
    }
  }
}
