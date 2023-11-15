package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.MoveForward;
import frc.robot.subsystems.Drivetrain;


public class RobotContainer {

  private final Drivetrain drivetrain = new Drivetrain();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return new MoveForward(drivetrain, 0.3);
  }
}
