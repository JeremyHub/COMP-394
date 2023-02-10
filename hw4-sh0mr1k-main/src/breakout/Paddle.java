package breakout;

//import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Line;
//import edu.macalester.graphics.Point;

public class Paddle extends Line {
    public static final double PADDLE_WIDTH = 50;
    public static final double PADDLE_HEIGHT = 10;
    public static final double BALL_RADIUS = 5;

    public Paddle(double leftX, double leftY) {
        super(leftX, leftY, leftX+50, leftY);
        setStrokeWidth(5);
    }

    /**
     * Updates the position of the paddle
     * 
     * @param centerX center X coordinate
     * @param centerY center Y coordinate
     */
    public void updatePosition(double centerX, double centerY) {
        setPosition(centerX - 25, centerY);
    }

    /**
     * Determines if the paddle has hit the breakout ball.
     *
     * @param ball the ball the user is hitting
     * @return true, if the paddle hits the ball. Otherwise, false.
     */
    public boolean hitsBall(BreakoutBall ball) {
        double ballXPosition = ball.getCenterX();
        double ballYPosition = ball.getCenterY();
        if((ballXPosition < getCenter().getX()+30 && ballXPosition > getCenter().getX() - 30) 
        && (ballYPosition > (getY() - 5) && ballYPosition < (getY() + 5))) {
            return true;
        }
        return false;
    }
}
