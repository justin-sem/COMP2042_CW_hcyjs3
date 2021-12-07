package Brick;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.Random;



public class Crack{

    public static final int LEFT = 10;
    public static final int RIGHT = 20;
    public static final int UP = 30;
    public static final int DOWN = 40;
    public static final int VERTICAL = 100;
    public static final int HORIZONTAL = 200;

    private GeneralPath crack;
    private int crackDepth;
    private int steps;
    private static Random rnd;
    private Shape brickFace;


    public Crack(int crackDepth, int steps,Shape brickFace){

        rnd = new Random();
        crack = new GeneralPath();
        this.brickFace = brickFace;
        this.crackDepth = crackDepth;
        this.steps = steps;

    }



    public GeneralPath draw(){ return crack; }

    public void reset(){
        crack.reset();
    }

    protected void makeCrack(Point2D point, int direction){

        Rectangle bounds = brickFace.getBounds();
        Point impact = new Point((int)point.getX(),(int)point.getY());
        Point start = new Point();
        Point end = new Point();

        switch(direction){
            case LEFT:
                start.setLocation(bounds.x + bounds.width, bounds.y);
                end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
                Point tmp = makeRandomPoint(start,end,VERTICAL);
                makeCrack(impact,tmp);
                break;

            case RIGHT:
                start.setLocation(bounds.getLocation());
                end.setLocation(bounds.x, bounds.y + bounds.height);
                tmp = makeRandomPoint(start,end,VERTICAL);
                makeCrack(impact,tmp);
                break;

            case UP:
                start.setLocation(bounds.x, bounds.y + bounds.height);
                end.setLocation(bounds.x + bounds.width, bounds.y + bounds.height);
                tmp = makeRandomPoint(start,end,HORIZONTAL);
                makeCrack(impact,tmp);
                break;

            case DOWN:
                start.setLocation(bounds.getLocation());
                end.setLocation(bounds.x + bounds.width, bounds.y);
                tmp = makeRandomPoint(start,end,HORIZONTAL);
                makeCrack(impact,tmp);
                break;

        }
    }

    protected void makeCrack(Point start, Point end){

        GeneralPath path = new GeneralPath();
        path.moveTo(start.x,start.y);

        double w = (end.x - start.x) / (double)steps;
        double h = (end.y - start.y) / (double)steps;
        int bound = crackDepth;
        double x,y;

        for(int i = 1; i < steps;i++){

            x = (i * w) + start.x;
            y = (i * h) + start.y + randomInBounds(bound);
            path.lineTo(x,y);
        }

        path.lineTo(end.x,end.y);
        crack.append(path,true);
    }


    private int randomInBounds(int bound){
        int n = (bound * 2) + 1;
        return rnd.nextInt(n) - bound;
    }



    private Point makeRandomPoint(Point from,Point to, int direction){

        Point out = new Point();
        int pos;

        switch(direction){

            case HORIZONTAL:
                pos = rnd.nextInt(to.x - from.x) + from.x;
                out.setLocation(pos,to.y);
                break;

            case VERTICAL:
                pos = rnd.nextInt(to.y - from.y) + from.y;
                out.setLocation(to.x,pos);
                break;
        }
        return out;
    }

}
