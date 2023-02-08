package breakout;

import org.junit.jupiter.api.Test;
import breakout.*;
import edu.macalester.graphics.CanvasWindow;

import static org.junit.jupiter.api.Assertions.*;

class BrickManagerTest {

    @Test
    void generateBricks() {

        CanvasWindow canvas = new CanvasWindow("Breakout!", 600, 600);
        BrickManager bm = new BrickManager(canvas);
        
        bm.generateBricks();  
        assertEquals(5, bm.getBrickRows());
        assertEquals(10, bm.getBrickCols());
        
    }

    @Test
    void testHit() {
    }

    @Test
    void allBricksDead() {
    }

    @Test
    void destroyBrick() {
    }

    @Test
    void removeAllBricks() {
        CanvasWindow canvas = new CanvasWindow("Breakout!", 600, 600);
        BrickManager bm = new BrickManager(canvas);
        
        bm.generateBricks(); 
        assertEquals(50, bm.getBrickCols()*bm.getBrickRows());
        bm.removeAllBricks();
        assertEquals(0, bm.getListSize());
                
    }
}