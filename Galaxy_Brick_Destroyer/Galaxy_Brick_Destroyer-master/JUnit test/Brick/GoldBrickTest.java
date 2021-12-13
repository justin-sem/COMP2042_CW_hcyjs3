package Brick;

import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.geom.Point2D;
import static org.junit.jupiter.api.Assertions.*;

class GoldBrickTest {

    Rectangle brickObj = new Rectangle(new Point(0,0),new Dimension(20,10));
    LeadBrick goldBrickObj = new LeadBrick(new Point(0,0),new Dimension(20,10));


    @Test
    void makeBrickFace() {
        Point pos = new Point(0,0);
        Dimension size = new Dimension(20,10);
        assertEquals(brickObj,goldBrickObj.makeBrickFace(pos,size));
    }

    @Test
    void getBrick() {

        assertEquals(brickObj,goldBrickObj.getBrick());
    }

    @Test
    void setImpact() {
        int down = 10;
        Point2D up = new Point2D.Double();
        up.setLocation(100.0, 100.0);
        assertTrue(goldBrickObj.setImpact(up,down));
    }


    @Test
    void repair() {
        goldBrickObj.repair();
        assertFalse(goldBrickObj.isBroken());
    }
}