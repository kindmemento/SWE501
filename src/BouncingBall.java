import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

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

    public void checkCollision(ArrayList<Obstacle> obstacles) {
        for (Obstacle obstacle : obstacles) {
            if (xCenter + ballRadius >= obstacle.getXCenter() - obstacle.getWidth() / 2 &&
                xCenter - ballRadius <= obstacle.getXCenter() + obstacle.getWidth() / 2 &&
                yCenter + ballRadius >= obstacle.getYCenter() - obstacle.getHeight() / 2 &&
                yCenter - ballRadius <= obstacle.getYCenter() + obstacle.getHeight() / 2) {
                velocityX = -velocityX;
                velocityY = -velocityY;
                break;
            }
        }
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
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.filledRectangle(xCenter, yCenter, width / 2, height / 2);
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