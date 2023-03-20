package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Point;

import java.lang.Math;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    public static final int CANVAS_WIDTH = 600;
    public static final int CANVAS_HEIGHT = 600;
    private CanvasWindow canvas;
    private BrickManager brickManager;
    private BreakoutBall ball;
    private Paddle paddle;

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        brickManager = new BrickManager(canvas);
        double initialAngle = Math.toRadians(Math.random()*180.0 - 1); 
        this.ball = new BreakoutBall(300, 400, initialAngle, 600, 600);
        this.paddle = new Paddle(CANVAS_WIDTH/2, CANVAS_HEIGHT*0.8);
        resetGame();
    }

    public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
           game.run();  
    }

    /**
     * Moves ball and cotrols it's interactions with the 
     * other objects in the game. 
     * 
     * @param ball The BreakoutBall the user plays with
     */
    public void moveBall(BreakoutBall ball) {
        ball.updatePosition(0.1);     
        canvas.draw();
        if(paddle.hitsBall(ball)) {
            ball.collisionRebound();
        }
        if(brickManager.testHit(ball)) {
            ball.collisionRebound();
        }
        if(brickManager.allBricksDead()) {
            winGame();
        }
    }

    /**
     * Runs the Breakout game.
     */
    public void run() {
        canvas.animate(() -> {
            moveBall(ball);
        });
        canvas.onMouseMove((event) -> {
            movePaddle(paddle, event.getPosition());
        });
        canvas.animate(() -> {
            nextLife();
        });

    }

    /**
     * Moves the paddle in accordance with the user's mouse location,
     * thus allowing the user to control the position of the paddle
     * 
     * @param paddle the paddle the user uses to hit the ball
     * @param location the location of the user's mouse
     */
    public void movePaddle(Paddle paddle, Point location) {
        double mouseX = location.getX();
        paddle.updatePosition(mouseX, paddle.getY());
    } 

    /**
     * Sets up the Breakout game.
     */
    public void resetGame() {
        brickManager.removeAllBricks();
        canvas.removeAll();
        brickManager.generateBricks();
        ball.addToCanvas(canvas);
        canvas.add(paddle);
        canvas.draw();
    }

    /**
     * Reset's the ball to the starting position once
     * a life has been exhausted by the user.
     */
    public void resetNewLife() {
        ball.resetToStartingPosition();
        canvas.draw();
    }

    /**
     * Determines wether the user has  more lives left and if so,
     * commences another round of the game. 
     */
     public void nextLife() {
         if(ball.isDead() && ball.getLifeCount() < 3) {
            resetNewLife();
            moveBall(ball);
        }
        else if(ball.isDead()) {
            loseGame();
        }
    }      

    /**
     * Displays a losing message to the user.
     */
    public boolean loseGame() {
        canvas.removeAll();
        GraphicsText lose = new GraphicsText("You Lost!", CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
        canvas.add(lose);
        return true;
    }

    /**
     * Displays a winning message to the user.
     */
    public boolean winGame() {
        canvas.removeAll();
        GraphicsText win = new GraphicsText("You Won!", CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
        canvas.add(win);
        return true;
    }
}