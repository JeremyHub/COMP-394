package breakout;

import edu.macalester.graphics.CanvasWindow;
import java.util.ArrayList;
import java.awt.Color;
import java.util.List;


public class BrickManager {

    private CanvasWindow canvas;
    private List<Brick> bricks;
    public int numRows = 5;
    public int numCols = 10;
    public double boxWidth = 49.0;
    public static final Color BRICK_COLOR = new Color(201, 150, 216, 55);

    public BrickManager(CanvasWindow canvas) {
        bricks = new ArrayList<>();
        this.canvas = canvas;
    }

    /**
     * Generates the bricks to be hit.
     */
    public void generateBricks() {
        double startingY = 75.0;
        double startingX = 10.0;
        double spacing = 10.0;
        double y = startingY;
        for (int i = 0; i < numRows; i++) {
            double x = startingX;
            for(int j = 0; j < numCols; j++) {
                Brick brick = new Brick(x, y, BRICK_COLOR);
                canvas.add(brick);
                bricks.add(brick);
                x += (boxWidth +spacing);
            }
            y += 11.0 + spacing;
        }
    }

    /**
     * Determines if a brick has been hit by the Breakout ball.
     * 
     * @param breakoutBall the ball the user is hitting 
     * @return true, if the brick has been hit. Otherwise, false.
     */
    public boolean testHit(BreakoutBall breakoutBall) {
        for (Brick b : bricks) {
            if (b.intersects(breakoutBall)) {
                destroyBrick(b);
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if all bricks have been hit.
     * 
     * @return true, if all bricks have been hit. Otherwise, false.
     */
    public boolean allBricksDead() {
        if (bricks.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Destroys a brick when it has been hit by a breakoutball.
     */
    public void destroyBrick(Brick b) {
        canvas.remove(b);
        bricks.remove(b);
    }

    /**
     * Removes all bricks from the canvas.
     */
    public void removeAllBricks() {
        for (Brick b : bricks) {
            canvas.remove(b);
        }
        bricks.clear();
    }
}
