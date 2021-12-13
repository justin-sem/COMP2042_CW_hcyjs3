package Brick;

import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.geom.Point2D;
import static org.junit.jupiter.api.Assertions.*;

class CopperBrickTest {

    Rectangle brickObj = new Rectangle(new Point(0,0),new Dimension(20,10));
    LeadBrick copperBrickObj = new LeadBrick(new Point(0,0),new Dimension(20,10));

    @Test
    void makeBrickFace() {
        Point pos = new Point(0,0);
        Dimension size = new Dimension(20,10);
        assertEquals(brickObj,copperBrickObj.makeBrickFace(pos,size));
    }

    @Test
    void setImpact() {
        int down = 10;
        Point2D up = new Point2D.Double();
        up.setLocation(100.0, 100.0);
        assertTrue(copperBrickObj.setImpact(up,down));
    }

    @Test
    void getBrick() {

        assertEquals(brickObj,copperBrickObj.getBrick());
    }

    @Test
    void repair() {
        copperBrickObj.repair();
        assertFalse(copperBrickObj.isBroken());
    }
}