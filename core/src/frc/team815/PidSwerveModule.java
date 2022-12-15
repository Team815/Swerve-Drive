package frc.team815;

import edu.wpi.first.math.controller.PIDController;

public class PidSwerveModule extends SwerveModule {
    private final PIDController pid;

    public PidSwerveModule(float x, float y, double p, double i, double d) {
        super(x, y);
        pid = new PIDController(p, i, d);
    }

    public void setSetpoint(double setpoint) {
        var difference = getRotation() - setpoint;
        var loops = (int) (Math.abs(difference) + 180) / 360;
        setpoint += 360 * loops * Math.signum(difference);
        pid.setSetpoint(setpoint);
    }

    @Override
    public void render() {
        var response = (float) pid.calculate(getRotation());
        setRotationSpeed(response);
        super.render();
    }
}
