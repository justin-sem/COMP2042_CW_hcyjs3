package Brick;

import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class CrackTest {

    Shape brickFace;
    DiamondBrick diamondBrick = new DiamondBrick(new Point(0,0), new Dimension(20,10));
    Crack crack = new Crack(1,1,brickFace);

    @Test
    void draw() {
        crack.makeCrack(new Point(10,10),new Point(10,10));
        crack.draw();
        assertNotNull(crack);
    }

    @Test
    void reset() {
        crack.reset();
        assertFalse(diamondBrick.isBroken());
    }


    @Test
    void testMakeCrack() {
        crack.makeCrack(new Point(10,10), new Point(10,10));
        assertNotNull(crack);
    }
}