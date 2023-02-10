package breakout;

import edu.macalester.graphics.CanvasWindow;
import java.util.ArrayList;
import java.awt.Color;
import java.util.List;


public class BrickManager {

    private CanvasWindow canvas;
    private List<Brick> bricks;
    private int rowCounter;
    private int colCounter;
    public int numRows = 5;
    public int numCols = 10;
    public static final Color BRICK_COLOR = new Color(201, 150, 216, 55);

    public BrickManager(CanvasWindow canvas) {
        bricks = new ArrayList<>();
        this.canvas = canvas;
    }

    /**
     * Generates the bricks to be hit.
     */
    public void generateBricks() {
        double startingY = BreakoutGame.CANVAS_HEIGHT*0.1;
        double spacing = BreakoutGame.CANVAS_WIDTH/60;
        double y = startingY;
        rowCounter = 0;
        colCounter = 0;
        for (int i = 0; i < numRows; i++) {
            double x = spacing;
            for(int j = 0; j < numCols; j++) {
                Brick brick = new Brick(x, y, BRICK_COLOR);
                canvas.add(brick);
                bricks.add(brick);
                x += (Brick.BRICK_WIDTH +spacing);
                colCounter += 1;
            }
            y += Brick.BRICK_HEIGHT + spacing;
            rowCounter += 1;

        }
        colCounter = colCounter / rowCounter;
    }

    public int getBrickRows() {
        return rowCounter;
    }

    public int getBrickCols() {
        return colCounter;
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
        rowCounter = 0;
        colCounter = 0;
        bricks.clear();
    }

    public int getListSize() {
        return bricks.size();
    }
}
