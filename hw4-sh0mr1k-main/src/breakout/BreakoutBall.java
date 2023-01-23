package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.GraphicsGroup;
public class BreakoutBall extends GraphicsGroup{

    public static final double BALL_RADIUS = 2.5;
    private static final double INITIAL_SPEED = 50.0;
    private static final double INITIAL_X_POSITION = 300.0;
    private static final double INITIAL_Y_POSITION = 400.0;

    private double centerX;
    private double centerY;
    private double initialAngle;
    private double maxX;
    private double maxY;
    private double xVelocity;
    private double yVelocity;
    private int lifeCount;

    private Ellipse ballShape;

    public BreakoutBall(
            double centerX,
            double centerY,
            double initialAngle,
            double maxX,
            double maxY) {
        this.centerX = INITIAL_X_POSITION;
        this.centerY = INITIAL_Y_POSITION;
        ballShape = new Ellipse(centerX, centerY, BreakoutBall.BALL_RADIUS*2, BreakoutBall.BALL_RADIUS*2);
        initialAngle = -((Math.random())*180);
        this.maxX = maxX;
        this.maxY = maxY;
        this.lifeCount = 1;
        double initialAngleRadians = Math.toRadians(initialAngle);
        this.xVelocity = INITIAL_SPEED * Math.cos(initialAngleRadians);
        this.yVelocity = INITIAL_SPEED * (-1) * Math.sin(initialAngleRadians);
    }
    /**
     * Gets the X value of the center coordinate of the cannonball.
     * @return center's X coordinate
     */
    public double getCenterX() {
        return centerX;
    }
    /**
     * Gets the Y value of the center coordinate of the cannonball.
     * @return center's Y coordinate
     */
    public double getCenterY() {
        return centerY;
    }
    
    /**
     * Gets the initial angle of aim for the cannonball.
     * @return initial angle of aim
     */
    public double getInitialAngle() {
        return initialAngle;
    }
    /**
     * Gets the max X boundary of the canvas.
     * @return max X boundary
     */
    public double getmaxX() {
        return maxX;
    }
    /**
     * Gets the max Y boundary of the canvas.
     * @return max Y boundary
     */
    public double getMaxY() {
        return maxY;
    }
    /**
     * Gets the life count of the breakout ball
     * @return lifeCount of breakout ball
     */
    public double getLifeCount() {
        return lifeCount;
    }
    /**
     * Update the cannon ball's position if it is in bounds
     * @return true if the ball is in within the maxXBound and maxYBound
     */
    public void updatePosition(double dt) {
        double newCenterX = centerX + xVelocity*dt;
        double newCenterY = centerY + yVelocity*dt;
        if (newCenterX > 0 && newCenterX < maxX 
        && newCenterY > 0 && newCenterY < maxY) {
            ballShape.setCenter(newCenterX, newCenterY);
            centerX = newCenterX;
            centerY = newCenterY;
        }
        else if (isDead()) {
            centerX = INITIAL_X_POSITION;
            centerY = INITIAL_Y_POSITION;
            setCenter(centerX, centerY);
            lifeCount++;
            initialAngle = -((Math.random())*180);
            newRandomDrop(initialAngle);
        }
        else {
            rebound();
        }
        
    }

    /**
     * Resets ball to the starting position in center of the game.
     */
    public void resetToStartingPosition() {
        ballShape.setCenter(INITIAL_X_POSITION, INITIAL_Y_POSITION);
    }

    /**
     * Rebounds the ball when it hits a wall.
     */
    public void rebound() {
        if(getCenterX() <= (0+BALL_RADIUS*2)) {
            xVelocity = -1*xVelocity;
        }
        if(getCenterX() >= (maxX - BALL_RADIUS*2)) {
            xVelocity = -1*xVelocity;
        }
        if(getCenterY() <= (0+BALL_RADIUS*2)) {
            yVelocity = -1*yVelocity;
        }
    }

    /**
     * Rebounds the ball when it hits an object.
     */
    public void collisionRebound() {
        yVelocity = -1*yVelocity;
    }

    /**
     * Gets a new random angle and velocity for the ball drop on the next round. 
     * @param initialAngle the revised drop angle
     */
    public void newRandomDrop(double initialAngle) {
        double initialAngleRadians = Math.toRadians(initialAngle);
        this.xVelocity = INITIAL_SPEED * Math.cos(initialAngleRadians);
        this.yVelocity = INITIAL_SPEED * (-1) * Math.sin(initialAngleRadians);
    }


    /**
     * Adds the cannonball's shape to the given canvas.
     */
    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(ballShape);
    }

    /**
     * Removes the cannonball's shape from the given canvas.
     */
    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(ballShape);
    }

    /**
     * Determines if the ball has hit the ground.
     * 
     * @return true, if the ball has hit the ground. Otherwise, false.
     */
    public boolean isDead() {
        if(getCenterY() >= (maxY - BALL_RADIUS*2)) {
            return true;
        }
        return false;
    }
}
