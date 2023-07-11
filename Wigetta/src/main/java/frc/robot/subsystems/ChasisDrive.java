// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ChasisDrive extends SubsystemBase {
  /** Creates a new ChasisDrive. */

  private Spark m_leftFront, m_rightFront, m_leftBack, m_rightBack;
  private MotorControllerGroup m_left, m_right;
  private DifferentialDrive driveTrain;

  public ChasisDrive(int m_leftFront, int m_rightFront, int m_leftBack, int m_rightBack) {
    this.m_leftBack = new Spark(m_leftBack);
    this.m_rightBack = new Spark(m_rightBack);
    this.m_leftFront = new Spark(m_leftFront);
    this.m_rightFront = new Spark(m_rightFront);
    this.m_left = new MotorControllerGroup(this.m_leftBack, this.m_leftFront);
    this.m_right = new MotorControllerGroup(this.m_rightBack, this.m_rightFront);
    this.driveTrain = new DifferentialDrive(m_left, m_right);
    this.m_right.setInverted(true);
  }

  public void input(double yAxis, double zAxis) {
    driveTrain.arcadeDrive(yAxis, zAxis);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
