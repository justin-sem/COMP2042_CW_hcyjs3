package Brick;

import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.geom.Point2D;
import static org.junit.jupiter.api.Assertions.*;

class DiamondBrickTest {

    Rectangle brickObj = new Rectangle(new Point(0,0),new Dimension(20,10));
    LeadBrick diamondBrickObj = new LeadBrick(new Point(0,0),new Dimension(20,10));

    @Test
    void makeBrickFace() {
        Point pos = new Point(0,0);
        Dimension size = new Dimension(20,10);
        assertEquals(brickObj,diamondBrickObj.makeBrickFace(pos,size));
    }

    @Test
    void getBrick() {
        assertEquals(brickObj,diamondBrickObj.getBrick());
    }

    @Test
    void setImpact() {
        int down = 10;
        Point2D up = new Point2D.Double();
        up.setLocation(100.0, 100.0);
        assertTrue(diamondBrickObj.setImpact(up,down));
    }


    @Test
    void repair() {
        diamondBrickObj.repair();
        assertFalse(diamondBrickObj.isBroken());
    }
}