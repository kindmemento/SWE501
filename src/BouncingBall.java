import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

public class BouncingBall {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.enableDoubleBuffering();

        Obstacle[] obstacles = {
                new Obstacle(40, 20),
                new Obstacle(60, 80)
        };

        Ball ball = new Ball(20, 50, 1, 1, 3, Color.RED);

        while (true) {
            StdDraw.clear(Color.WHITE);

            for (Obstacle obstacle : obstacles) {
                obstacle.draw();
            }

            ball.move();
            ball.draw();

            ball.bounce(0, 100, 0, 100, obstacles);

            StdDraw.show();

            StdDraw.pause(20);
        }

    }
}

class Ball {
    private double xCenter;
    private double yCenter;
    private double velocityX;
    private double velocityY;
    private double ballRadius;
    private Color ballColor;

    public Ball(double xCenter, double yCenter, double velocityX, double velocityY, double ballRadius, Color ballColor) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.ballRadius = ballRadius;
        this.ballColor = ballColor;
    }

    public void draw() {
        StdDraw.setPenColor(ballColor);
        StdDraw.filledCircle(xCenter, yCenter, ballRadius);
    }

    public void move() {
        xCenter += velocityX;
        yCenter += velocityY;
    }

    public void bounce(double xMin, double xMax, double yMin, double yMax, Obstacle[] obstacles) {
        if (xCenter - ballRadius <= xMin || xCenter + ballRadius >= xMax) {
            velocityX *= -1;
        }

        if (yCenter - ballRadius <= yMin || yCenter + ballRadius >= yMax) {
            velocityY *= -1;
        }

        for (Obstacle obstacle : obstacles) {
            double obstacleLeft = obstacle.getXCenter() - 0.5;
            double obstacleRight = obstacle.getXCenter() + 0.5;
            double obstacleTop = obstacle.getYCenter() + 0.5;
            double obstacleBottom = obstacle.getYCenter() - 0.5;

            if (xCenter + ballRadius >= obstacleLeft && xCenter - ballRadius <= obstacleRight &&
                yCenter + ballRadius >= obstacleBottom && yCenter - ballRadius <= obstacleTop) {
                if (Math.abs(xCenter - obstacle.getXCenter()) > Math.abs(yCenter - obstacle.getYCenter())) {
                    velocityX *= -1;
                } else {
                    velocityY *= -1;
                }
            }
        }
    }
}

class Obstacle {
    private double xCenter;
    private double yCenter;

    public Obstacle(double xCenter, double yCenter) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
    }

    public void draw() {
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.rectangle(xCenter, yCenter, 7.5, 10.0);
    }

    public double getXCenter() {
        return xCenter;
    }

    public double getYCenter() {
        return yCenter;
    }
}