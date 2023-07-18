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

	public void extendArm(boolean b_extendArm, boolean b_retractArm) {
		if (b_extendArm) {
			armExtention.set(ControlMode.PercentOutput, 0.875);
		} else if (b_retractArm) {
			armExtention.set(ControlMode.PercentOutput, -0.8);
		} else {
			armExtention.set(ControlMode.PercentOutput, 0);
		}
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
