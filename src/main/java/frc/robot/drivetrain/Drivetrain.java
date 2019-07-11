package frc.robot.drivetrain;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain {

  private CANSparkMax leftPrimary;
  private CANSparkMax leftSecondary;
  private CANSparkMax leftTertiary;
  private CANSparkMax rightPrimary, rightSecondary, rightTertiary;

    public Drivetrain() {
        rightPrimary = new CANSparkMax(10, MotorType.kBrushless);
        rightSecondary = new CANSparkMax(11, MotorType.kBrushless);
        rightTertiary = new CANSparkMax(12, MotorType.kBrushless);
        leftPrimary = new CANSparkMax(23, MotorType.kBrushless);
        leftSecondary = new CANSparkMax(24, MotorType.kBrushless);
        leftTertiary = new CANSparkMax(25, MotorType.kBrushless);

        leftSecondary.follow(leftPrimary);
        leftTertiary.follow(leftPrimary);
        rightSecondary.follow(rightPrimary);
        rightTertiary.follow(rightPrimary);

        rightPrimary.setInverted(true);
        rightSecondary.setInverted(true);
        rightTertiary.setInverted(true);
    }

    public void arcadeDrive(double x, double y) {
        setSpeed(y-x, y+x);
        SmartDashboard.putNumber("Right DT Position", rightPrimary.getEncoder().getPosition());
        SmartDashboard.putNumber("Left DT Position", leftPrimary.getEncoder().getPosition());

        SmartDashboard.putNumber("Right DT Speed", rightPrimary.getEncoder().getVelocity());
        SmartDashboard.putNumber("Left DT Speed", leftPrimary.getEncoder().getVelocity());

    }

    public void setSpeed(double leftSpeed, double rightSpeed) {
        setLeftSpeed(leftSpeed);
        setRightSpeed(rightSpeed);
    }

    public void setLeftSpeed(double speed) {
        leftPrimary.set(speed);
    }

    public void setRightSpeed(double speed) {
        rightPrimary.set(speed);
    }


}