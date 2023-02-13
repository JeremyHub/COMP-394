package breakout;

import org.junit.jupiter.api.Test;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.*;

class BreakoutBallTest {

    /**
     * test that the ball changes color depending on the y position after calling update position
     */
    @Test
    void test_ballshape_changes_color() {
        BreakoutBall ball = new BreakoutBall(0,0,0,100,100);
        Color c = (Color) ball.getBallShape().getFillColor();
        ball.updatePosition(0.1);
        assertNotEquals(c, ball.getBallShape().getFillColor());
    }

    @Test
    void getCenterX() {
    }

    @Test
    void getCenterY() {
    }

    @Test
    void getInitialAngle() {
    }

    @Test
    void getmaxX() {
    }

    @Test
    void getMaxY() {
    }

    @Test
    void getLifeCount() {
    }

    @Test
    void updatePosition() {
    }

    @Test
    void resetToStartingPosition() {
    }

    @Test
    void rebound() {
    }

    @Test
    void collisionRebound() {
    }

    @Test
    void newRandomDrop() {
    }

    @Test
    void addToCanvas() {
    }

    @Test
    void removeFromCanvas() {
    }

    @Test
    void isDead() {
    }
}