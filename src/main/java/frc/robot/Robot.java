//Libraries url
//https://software-metadata.revrobotics.com/REVLib-2023.json
//https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix5-frc2023-latest.json

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Robot extends TimedRobot {
    private WPI_TalonSRX m_motor0;
    private WPI_TalonSRX m_motor1;
    private WPI_TalonSRX m_motor2;
    private WPI_TalonSRX m_motor3;
    private MotorControllerGroup m_right;
    private MotorControllerGroup m_left;
    private DifferentialDrive m_drive;
    private Joystick joystick;
    
    @Override
    public void robotInit() {
        m_motor0 = new WPI_TalonSRX(0);
        m_motor1 = new WPI_TalonSRX(1);
        m_motor2 = new WPI_TalonSRX(3);
        m_motor3 = new WPI_TalonSRX(4);

        m_left = new MotorControllerGroup(m_motor3, m_motor0);
        m_right = new MotorControllerGroup(m_motor2, m_motor1);

        m_drive = new DifferentialDrive(m_left, m_right);
        joystick = new Joystick(0);
    }

    @Override
    public void teleopPeriodic() {
        double turnSpeed = 0.5 * joystick.getRawAxis(0);
        double driveSpeed = 0.7 * joystick.getRawAxis(5);

        m_drive.arcadeDrive(turnSpeed, driveSpeed);
    }
}