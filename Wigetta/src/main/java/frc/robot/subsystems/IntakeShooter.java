// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class IntakeShooter extends SubsystemBase {

    VictorSPX intakeShooter;

    // Estados
    private enum State {
        CONO,
        CUBO,
        APAGADO
    }

    private State currentState;

    // Constructor del Shooter
    public IntakeShooter(int intakeShooter) {
        this.intakeShooter = new VictorSPX(intakeShooter);
        this.currentState = State.APAGADO;
    }

    // Funcion intake
    public void turnOnIntake(boolean square, boolean triangle, boolean circle) {

        // Maquina de estados Intake
        switch (currentState) {
            case APAGADO:
                intakeShooter.set(ControlMode.PercentOutput, 0);

                if (square) {
                    currentState = State.CUBO;
                } else if (triangle) {
                    currentState = State.CONO;
                }

                break;

            case CUBO:
                intakeShooter.set(ControlMode.PercentOutput, 0.3);

                if (circle) {
                    currentState = State.APAGADO;
                }

                break;

            case CONO:
                intakeShooter.set(ControlMode.PercentOutput, -0.3);

                if (circle) {
                    currentState = State.APAGADO;
                }

                break;
        }
    }
}
