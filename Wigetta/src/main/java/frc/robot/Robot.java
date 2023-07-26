// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.ArmExtention;
import frc.robot.subsystems.ArmRotation;
import frc.robot.subsystems.ChasisDrive;
import frc.robot.subsystems.IntakeShooter;
import edu.wpi.first.cameraserver.CameraServer;

public class Robot extends TimedRobot {
    Thread m_visionThread;
    public final ChasisDrive chasisDrive = new ChasisDrive(
            0, 1, 2, 3);
    public final IntakeShooter intakeShooter = new IntakeShooter(1);
    public final ArmRotation armRotation = new ArmRotation(2);
    public final ArmExtention armExtention = new ArmExtention(4);
    public PS4Controller controller = new PS4Controller(0);

    @Override
    public void robotInit() {
        m_visionThread = new Thread(
                () -> {
                    CameraServer.startAutomaticCapture();
                });
        m_visionThread.setDaemon(true);
        m_visionThread.start();
    }

    @Override
    public void robotPeriodic() {
    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void disabledExit() {
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void autonomousExit() {
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
        chasisDrive.controllerInput(controller.getLeftY(), controller.getLeftX(), controller.getL1Button(),
                controller.getR1Button());
        armRotation.rotateArm(controller.getRightY());
        armExtention.extendArm(controller.getPOV());
        intakeShooter.turnOnIntake(controller.getSquareButton(), controller.getTriangleButton(),
                controller.getCircleButton());
    }

    @Override
    public void teleopExit() {
    }

    @Override
    public void testInit() {
    }

    @Override
    public void testPeriodic() {
    }

    @Override
    public void testExit() {
    }
}
