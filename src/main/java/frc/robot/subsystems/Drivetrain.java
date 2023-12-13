package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;


public class Drivetrain extends SubsystemBase {

  private WPI_PigeonIMU pigeon = new WPI_PigeonIMU(8);

  private WPI_TalonSRX leftMaster = new WPI_TalonSRX(1);
  private VictorSPX leftSlave = new VictorSPX(2);
  private WPI_TalonSRX rightMaster = new WPI_TalonSRX(3);
  private VictorSPX rightSlave = new VictorSPX(4);

  private DifferentialDrive diffDrive = new DifferentialDrive(leftMaster, rightMaster); 

  public void resetGyro(){
    pigeon.reset();
  }

  public double getAngle(){
    return pigeon.getAngle();
  }

  public Drivetrain() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

    rightMaster.setInverted(true);
    rightSlave.setInverted(true);

    leftMaster.setInverted(false);
    leftSlave.setInverted(false);
  }

  @Override
  public void periodic() {}
/*
    public void tankDrive(double leftSpeed, double rightSpeed) {
    leftMaster.set(leftSpeed);
    rightMaster.set(rightSpeed);
}
 */

  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed, rightSpeed);
  }
}
