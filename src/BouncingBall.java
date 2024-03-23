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
        StdDraw.setPenColor(ballColor);
        StdDraw.filledCircle(xCenter, yCenter, ballRadius);
    }

    public void move() {
        xCenter += velocityX;
        yCenter += velocityY;
        if (xCenter + ballRadius >= 1 || xCenter - ballRadius <= 0) {
            velocityX = -velocityX;
        }
        if (yCenter + ballRadius >= 1 || yCenter - ballRadius <= 0) {
            velocityY = -velocityY;
        }
    }

    public void checkCollision() {
        // @TODO: Implement checkCollision class method
    }
}

class Obstacle {
    private double xCenter;
    private double yCenter;
    private double width;
    private double height;

    public Obstacle(double xCenter, double yCenter, double width, double height) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.width = width;
        this.height = height;
    }

    public void draw() {
        // @TODO: Implement draw class method
    }

    public double getXCenter() {
        return xCenter;
    }

    public double getYCenter() {
        return yCenter;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}