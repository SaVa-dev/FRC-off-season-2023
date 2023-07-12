// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.ArmRotation;
import frc.robot.subsystems.ChasisDrive;
  

public class Robot extends TimedRobot {
  public final ChasisDrive chasisDrive = new ChasisDrive(
    0, 1, 2, 3);
  public final ArmRotation armRotation = new ArmRotation(2);
  public PS4Controller controller = new PS4Controller(0);
  
  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    chasisDrive.input(controller.getLeftY(), controller.getLeftX());
    armRotation.rotateArm(controller.getRightY());
  }

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}
}
