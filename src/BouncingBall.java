import java.awt.Color;
import java.util.Random;

public class BouncingBall {
    public static void main(String[] args) {
        System.out.println("This is a bouncing ball game.");
    }
}

class Ball {
    private double xCenter;
    private double yCenter;
    private double velocityX;
    private double velocityY;
    private double ballRadius;
    private Color ballColor;

    public Ball() {
        Random random = new Random();
        xCenter = random.nextDouble();
        yCenter = random.nextDouble();
        velocityX = random.nextDouble() * 0.03 - 0.01;
        velocityY = random.nextDouble() * 0.03 - 0.01;
        ballRadius = 0.02;
        ballColor = Color.BLUE;
    }

    public void draw() {
        // @TODO: Implement draw class method
    }

    public void move() {
        // @TODO: Implement move class method
    }

    public void checkCollision() {
        // @TODO: Implement checkCollision class method
    }
}
