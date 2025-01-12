package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import frc.lib.util.COTSTalonFXSwerveConstants;
import frc.lib.util.SwerveModuleConstants;

public final class Constants {
  public static final double stickDeadband = 0.12;

  public static final class Swerve {
    // public static final boolean invertGyro = true; // Always ensure Gyro is CCW+
    // CW-
    
    public static final int pigeonID = 23;
    public static final COTSTalonFXSwerveConstants chosenModule =
        COTSTalonFXSwerveConstants.SDS.MK4.Falcon500(
            COTSTalonFXSwerveConstants.SDS.MK4.driveRatios.L2);
    
    /* Drivetrain Constants */
    public static final double trackWidth = Units.inchesToMeters(24.75);
    public static final double wheelBase = Units.inchesToMeters(22.5);
    public static final double wheelCircumference = chosenModule.wheelCircumference;

    /*
     * Swerve Kinematics
     * No need to ever change this unless you are not doing a traditional
     * rectangular/square 4 module swerve
     */
    public static final SwerveDriveKinematics swerveKinematics =
        new SwerveDriveKinematics(
            new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));

    /* Module Gear Ratios */
    public static final double driveGearRatio = chosenModule.driveGearRatio;
    public static final double angleGearRatio = chosenModule.angleGearRatio;

    /* Motor Inverts */
    public static final InvertedValue angleMotorInvert = chosenModule.angleMotorInvert;
    public static final InvertedValue driveMotorInvert = chosenModule.driveMotorInvert;

    /* Angle Encoder Invert */
    public static final SensorDirectionValue cancoderInvert = chosenModule.cancoderInvert;

    /* Swerve Current Limiting */
    public static final int angleCurrentLimit = 25;
    public static final int angleCurrentThreshold = 40;
    public static final double angleCurrentThresholdTime = 0.1;
    public static final boolean angleEnableCurrentLimit = true;

    public static final int driveCurrentLimit = 35;
    public static final int driveCurrentThreshold = 60;
    public static final double driveCurrentThresholdTime = 0.1;
    public static final boolean driveEnableCurrentLimit = true;

    /*
     * These values are used by the drive falcon to ramp in open loop and closed
     * loop driving.
     * We found a small open loop ramp (0.25) helps with tread wear, tipping, etc
     */
    public static final double openLoopRamp = 0.25;
    public static final double closedLoopRamp = 0.0;

    /* Angle Motor PID Values */
    public static final double angleKP = chosenModule.angleKP;
    public static final double angleKI = chosenModule.angleKI;
    public static final double angleKD = chosenModule.angleKD;

    /* Drive Motor PID Values */
    public static final double driveKP = 0.12;
    public static final double driveKI = 0.0;
    public static final double driveKD = 0.0;
    public static final double driveKF = 0.0;

    /* Drive Motor Characterization Values From SYSID */
    public static final double driveKS = 0.32;
    public static final double driveKV = 1.51;
    public static final double driveKA = 0.27;

    /* Swerve Profiling Values */
    /** Meters per Second */
    public static final double maxSpeed =
        4.5; // Originally 4.5, change if needed... Nah, FULL POWER

    /** Radians per Second */
    public static final double maxAngularVelocity = 8.0; // Originally 10.0

    /* Neutral Modes */
    public static final NeutralModeValue angleNeutralMode = NeutralModeValue.Coast;
    public static final NeutralModeValue driveNeutralMode = NeutralModeValue.Brake;

    /* Module Specific Constants */
    /* Front Left Module - Module 0 */
    public static final class Mod0 {
      public static final int driveMotorID = 5;
      public static final int angleMotorID = 9;
      public static final int canCoderID = 7;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(107.27);
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
    }

    /* Front Right Module - Module 1 */
    public static final class Mod1 {
      public static final int driveMotorID = 10;
      public static final int angleMotorID = 4;
      public static final int canCoderID = 13;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-143.08);
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
    }

    /* Back Left Module - Module 2 */
    public static final class Mod2 {
      public static final int driveMotorID = 3;
      public static final int angleMotorID = 2;
      public static final int canCoderID = 12;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(177.14);
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
    }

    /* Back Right Module - Module 3 */
    public static final class Mod3 {
      public static final int driveMotorID = 6;
      public static final int angleMotorID = 11;
      public static final int canCoderID = 8;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(-107.57);
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
    }
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1;
    public static final double kPYController = 1;
    public static final double kPThetaController = 1;

    /* Constraint for the motion profilied robot angle controller */
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
        new TrapezoidProfile.Constraints(
            kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }



  /* limelight */
  public static final class vision {
    
  }
   public class Pose {
        public static final int pigeonID = 1;

        public static final Rotation2d blueDumpAngle = new Rotation2d(Units.degreesToRadians(-38.0));
        public static final Rotation2d redDumpAngle = new Rotation2d(Units.degreesToRadians(-142.0));
        public static final double maxDumpError = 1.5; // degrees
        public static final Rotation2d blueSlideAngle = new Rotation2d(Units.degreesToRadians(0.0));
        public static final Rotation2d redSlideAngle = new Rotation2d(Units.degreesToRadians(180.0));
        public static final double maxSlideError = 2.0; // degrees
        public static final double maxShuttleError = 1.5; // degrees
        public static final PIDController rotationPID = new PIDController(0.0070, 0.000, 0.0); // kI was 0.050 for NCCMP
        public static final PIDController maintainPID = new PIDController(0.0040, 0.000, 0.0);
        public static final double rotationKS = 0.015;
        public static final double rotationIZone = 2.5; // degrees

        public static final Translation2d blueSpeakerLocation = new Translation2d(0.0, 5.548);
        public static final Translation2d redSpeakerLocation = new Translation2d(16.579, 5.548);
        public static final Translation2d blueShuttleLocation = new Translation2d(1.25, 6.7);
        public static final Translation2d redShuttleLocation = new Translation2d(15.25, 6.7);
        public static final Translation2d blueFarShuttleLocation = new Translation2d(7.5, 7.0);
        public static final Translation2d redFarShuttleLocation = new Translation2d(9.1, 7.0);
        public static final Translation2d blueAmpLocation = new Translation2d(1.84, 8.2);
        public static final Translation2d redAmpLocation = new Translation2d(14.7, 8.2);
        public static final double fieldLength = 16.54;
        public static final double zoneMiddleStart = 5.3;
        public static final double zoneSpeakerEnd = 5.8;
        public static final double zoneSourceStart = 11.5;
        public static final double zoneMiddleEnd = 12.5;
    }

}
