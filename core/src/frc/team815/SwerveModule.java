package frc.team815;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class SwerveModule {
    private final Vector2 position;
    private float linearSpeed = 0;
    private float rotationSpeed = 0;
    private float rotation = 0;
    private final ShapeRenderer renderer = new ShapeRenderer();

    public SwerveModule(float x, float y) {
        position = new Vector2(x, y);
    }

    public void setLinearSpeed(float linearSpeed) {
        this.linearSpeed = clampSpeed(linearSpeed);
    }

    public void setRotationSpeed(float rotationSpeed) {
        this.rotationSpeed = clampSpeed(rotationSpeed);
    }

    public float getRotation() {
        return rotation;
    }

    private float clampSpeed(float speed) {
        return Math.min(1, Math.max(-1, speed));
    }

    public void render() {
        rotation += rotationSpeed * 8;
        if (linearSpeed >= 0.01) {
            var length = linearSpeed * 100;
            var halfLength = length / 2;
            renderer.begin(ShapeRenderer.ShapeType.Line);
            renderer.setColor(Color.BLACK);
            renderer.identity();
            renderer.translate(position.x, position.y, 0);
            renderer.rotate(0, 0, 1, rotation);
            renderer.line(-halfLength, 0, halfLength, 0);
            renderer.line(halfLength, 0, halfLength - 5, 5);
            renderer.line(halfLength, 0, halfLength - 5, -5);
        }
        renderer.end();
    }
}
