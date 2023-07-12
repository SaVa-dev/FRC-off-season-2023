// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ArmRotation extends SubsystemBase {

  private VictorSPX m_robotArm;

  /** Creates a new ArmRotation. */
  public ArmRotation(int robotArm) {
    this.m_robotArm = new VictorSPX(robotArm);
    this.m_robotArm.clearStickyFaults();
    this.m_robotArm.setNeutralMode(NeutralMode.Brake);
  }

  public void rotateArm(double input) {
    this.m_robotArm.set(ControlMode.PercentOutput, input);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
