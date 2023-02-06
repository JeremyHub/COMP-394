package breakout;

import edu.macalester.graphics.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BreakoutGameTest {

    @Test
    @ParameterizedTest
    @ValueSource(ints={0,10,50,100,150,200,300,350,360})
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
    }

    @Test
    void winGame() {
    }
}