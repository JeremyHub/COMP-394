package breakout;


import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.Line;
import java.awt.Color;

public class Brick extends Line {
    private double upperLeftX;
    private double upperLeftY;
    
    public static final double BRICK_HEIGHT = 11.0;
    public static final double BRICK_WIDTH = 49;
    public static final Color BRICK_COLOR = new Color(201, 150, 216, 55);


    public Brick(double upperLeftX, double upperLeftY, Color color) {
        super(upperLeftX, upperLeftY, upperLeftX+BRICK_WIDTH, upperLeftY);
        this.setPosition(upperLeftX, upperLeftY);
        createBrickDrawing();
    }

    /**
     * Creates a Rectangle object to signify the brick.
     */
    private void createBrickDrawing() {
        Rectangle rectangle = new Rectangle(upperLeftX, upperLeftY, BRICK_WIDTH, BRICK_HEIGHT);
        setStrokeWidth(7);
        rectangle.setFillColor(BRICK_COLOR);
        rectangle.setFilled(true);
        rectangle.setStroked(false);

    }

    /**
     * Determines if the brick has been hit by the ball.
     * 
     * @param ball the ball that the user is hitting 
     * @return true, if the ball hits the brick. Otherwise, false.
     */
    public boolean intersects(BreakoutBall ball) {
        double ballXPosition = ball.getCenterX();
        double ballYPosition = ball.getCenterY();
        if(ballXPosition < getCenter().getX()+29.5 & ballXPosition > getCenter().getX() - 29.5) {
            if(ballYPosition > getY() - 5 & ballYPosition < getY()) {
                return true;
            }
            else if(ballYPosition < getY() + 5 & ballYPosition > getY()) {
                return true;
            }
        }
        return false;
    }
}
