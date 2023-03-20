package breakout;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;


class BreakoutBallTest {

    BreakoutGame bg = mock(BreakoutGame.class);
    BreakoutBall ball = mock(BreakoutBall.class);
    Paddle paddle = mock(Paddle.class);

    /**
     * test that the ball changes color depending on the y position after calling update position
     */
    @Test
    void ballshape_changes_color() {
        BreakoutBall ball = new BreakoutBall(0,0,0,100,100);
        Color c = (Color) ball.getBallShape().getFillColor();
        ball.updatePosition(0.1);
        assertNotEquals(c, ball.getBallShape().getFillColor());
    }


    @Test
    void testGetCenterX() {
        BreakoutBall ball = mock(BreakoutBall.class);
        when(ball.getCenterX()).thenReturn(50.0); 
        assertEquals(50.0, ball.getCenterX()); 
        assertFalse(ball.getCenterX() == 0.0);

    }

    @Test
    void getCenterY() {
        BreakoutBall ball = mock(BreakoutBall.class);
        when(ball.getCenterY()).thenReturn(50.0); 
        assertEquals(50.0, ball.getCenterY()); 
        assertFalse(ball.getCenterY() == 0.0);
    }

    @Test
    void getInitialAngle() {
        BreakoutBall ball = mock(BreakoutBall.class);
        when(ball.getInitialAngle()).thenReturn(50.0); // mock the getCenterX() method to return 50.0
        assertEquals(50.0, ball.getInitialAngle()); // test that the method returns the expected value
    }

    @Test
    void getmaxX() {
    }

    @Test
    void getMaxY() {
    }

    @Test
    void getLifeCount() {
        BreakoutBall ball = mock(BreakoutBall.class);
        when(ball.getLifeCount()).thenReturn(3.0); 
        assertEquals(3.0, ball.getLifeCount());
        
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