package breakout;

import edu.macalester.graphics.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class BreakoutGameTest {

    BreakoutGame bg = mock(BreakoutGame.class);
    BreakoutBall ball = mock(BreakoutBall.class);
    Paddle paddle = mock(Paddle.class);


    @ParameterizedTest
    @ValueSource(ints={0,10,50,100,150,200,300,350, 360})
    void moveBall(int angle) {
        BreakoutGame game = new BreakoutGame();
        BreakoutBall ball = new BreakoutBall(0,0,angle,100,100);
        Point prev_point = ball.getPosition();
        game.moveBall(ball);
        assertNotEquals(prev_point.getX(), ball.getPosition().getX());
        assertNotEquals(prev_point.getY(), ball.getPosition().getY());

      
    }

    @Test
    void run() {
    }

    @Test
    void movePaddle() {
    }

    @Test
    void resetGame() {
    }

    @Test
    void resetNewLife() {
    }

    @Test
    void nextLife() {
    }

    @Test
    void loseGame() {
        BreakoutGame game = mock( BreakoutGame.class);
        when(game.loseGame()).thenReturn(true);
        assertEquals(true, game.loseGame());

    }

    @Test
    void winGame() {
        BreakoutGame game = mock( BreakoutGame.class);
        when(game.winGame()).thenReturn(true);
        assertEquals(true, game.winGame());
    }
}