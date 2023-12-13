package frc.commandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.commandGroups.Quadrado;
import frc.robot.commands.MoveForward;
import frc.robot.commands.Spin;

public class Quadrado extends SequentialCommandGroup {

  public Quadrado(Drivetrain drivetrain) {

    addCommands(
      new MoveForward(drivetrain, 0.5, 3),
      new Spin(drivetrain, 75.765),
      new MoveForward(drivetrain, 0.5, 3),
      new Spin(drivetrain, 170.587),
      new MoveForward(drivetrain, 0.5, 6),
      new Spin(drivetrain, 170.587),
      new MoveForward(drivetrain, 0.5, 2),
      new Spin(drivetrain, 261.765),
      new MoveForward(drivetrain, 0.5, 3)

    );
  }
}
