// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ArmExtention extends SubsystemBase {

	private VictorSPX armExtention;

	/** Creates a new ArmExtention. */
	public ArmExtention(int ID_robotArm) {
		armExtention = new VictorSPX(ID_robotArm);
		armExtention.clearStickyFaults();
		armExtention.setNeutralMode(NeutralMode.Brake);
	}

	public void extendArm(double t_extendArm, double t_retractArm) {
		if (t_extendArm > 0.2 ^ t_retractArm > 0.2) {
			if (t_extendArm > 0.2) {
				armExtention.setInverted(true);
				armExtention.set(ControlMode.PercentOutput, t_extendArm * 0.7);
			} else if (t_retractArm > 0.2) {
				armExtention.setInverted(false);
				armExtention.set(ControlMode.PercentOutput, t_extendArm * 0.7);
			}
		} else {
			armExtention.set(ControlMode.PercentOutput, 0);
		}
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
