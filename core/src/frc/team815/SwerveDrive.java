package frc.team815;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

public class SwerveDrive {
    private final PidSwerveModule[] pidSwerveModules = new PidSwerveModule[4];
    private final SwerveDriveKinematics swerveDrive;

    public SwerveDrive(double width, double length) {
        pidSwerveModules[0] = new PidSwerveModule(100, 300, .01, 0, 0);
        pidSwerveModules[1] = new PidSwerveModule(300, 300, .01, 0, 0);
        pidSwerveModules[2] = new PidSwerveModule(100, 100, .01, 0, 0);
        pidSwerveModules[3] = new PidSwerveModule(300, 100, .01, 0, 0);

        var halfWidth = width / 2;
        var halfLength = length / 2;

        swerveDrive = new SwerveDriveKinematics(
                new Translation2d(halfLength, -halfWidth),
                new Translation2d(-halfLength, -halfWidth),
                new Translation2d(halfLength, halfWidth),
                new Translation2d(-halfLength, halfWidth)
        );
    }

    public void setModules(double forwardSpeed, double sideSpeed, double rotationSpeed) {
        var chassisSpeeds = new ChassisSpeeds(forwardSpeed, sideSpeed, rotationSpeed);
        var moduleStates = swerveDrive.toSwerveModuleStates(chassisSpeeds);
        for (var i = 0; i < moduleStates.length; i++) {
            var moduleState = moduleStates[i];
            var pidSwerveModule = pidSwerveModules[i];
            pidSwerveModule.setLinearSpeed((float) moduleState.speedMetersPerSecond);
            pidSwerveModule.setSetpoint((float) moduleState.angle.getDegrees());
        }
    }

    public void render() {
        for (PidSwerveModule pidSwerveModule : pidSwerveModules) {
            pidSwerveModule.render();
        }
    }
}
