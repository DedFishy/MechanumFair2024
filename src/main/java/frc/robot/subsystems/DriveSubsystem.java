// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {

  private final VictorSPX kFrontLeft;
  private final VictorSPX kFrontRight;
  private final VictorSPX kBackLeft;
  private final VictorSPX kBackRight;

  private double kFrontLeftPower = 0;
  private double kFrontRightPower = 0;
  private double kBackLeftPower = 0;
  private double kBackRightPower = 0;
  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    kFrontLeft = new VictorSPX(DriveConstants.kFrontLeftCANID);
    kFrontRight = new VictorSPX(DriveConstants.kFrontRightCANID);
    kBackLeft = new VictorSPX(DriveConstants.kBackLeftCANID);
    kBackRight = new VictorSPX(DriveConstants.kBackRightCANID);

    kFrontLeft.setInverted(true);
  }


  /**
   * Example command factory method.
   *
   * @return a command
   */
  /*public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          // one-time action goes here
        });
  }*/

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    kFrontLeft.set(VictorSPXControlMode.PercentOutput, kFrontLeftPower);
    kFrontRight.set(VictorSPXControlMode.PercentOutput, kFrontRightPower);
    kBackLeft.set(VictorSPXControlMode.PercentOutput, kBackLeftPower);
    kBackRight.set(VictorSPXControlMode.PercentOutput, kBackRightPower);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void drive(double frontLeft, double frontRight, double backLeft, double backRight) {
    kFrontLeftPower = frontLeft;
    kFrontRightPower = frontRight;
    kBackLeftPower = backLeft;
    kBackRightPower = backRight;
    
  }
}
