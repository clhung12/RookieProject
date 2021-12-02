// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.BaseTalon;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  private BaseTalon motor;
 // private DigitalInput bb;
  private final int MOTOR_ID = 0;
//  private final int BB_ID = 0;

  /** Creates a new Intake. */
  public Intake() {
 //   bb = new DigitalInput(BB_ID);
    motor = new TalonSRX(MOTOR_ID);
    motor.configVoltageCompSaturation(10);
    motor.configFactoryDefault();
    motor.setInverted(false);
    motor.enableVoltageCompensation(true);
  }

  public void run(double motorSpeed) {
    motor.set(ControlMode.PercentOutput, motorSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

 // public boolean isBroken(){
 //   return !bb.get();
 // }
}
