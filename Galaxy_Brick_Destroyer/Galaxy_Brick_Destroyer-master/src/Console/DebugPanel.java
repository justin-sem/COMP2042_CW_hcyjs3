package Console;

import Component.Wall;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionListener;


/**
 * This is the Debug Panel class
 * which include the components in the debug console
 */
public class DebugPanel extends JPanel {

    private static final Color DEF_BKG = Color.BLACK;
    private JButton skipLevel;
    private JButton resetBalls;
    private JSlider ballXSpeed;
    private JSlider ballYSpeed;
    private Wall wall;


    /**
     * @param wall
     * Debug Panel constructor which add the components to the panel
     */
    public DebugPanel(Wall wall){

        this.wall = wall;
        initialize();

        skipLevel = makeButton("Skip Level",e -> wall.nextLevel());
        resetBalls = makeButton("Reset Balls",e -> wall.resetBallCount());

        ballXSpeed = makeSlider(-4,4,e -> wall.setBallXSpeed(ballXSpeed.getValue()));
        ballYSpeed = makeSlider(-4,4,e -> wall.setBallYSpeed(ballYSpeed.getValue()));

        this.add(skipLevel);
        this.add(resetBalls);
        this.add(ballXSpeed);
        this.add(ballYSpeed);

    }


    /**
     * initialize method which set the background of the debug panel
     */
    private void initialize(){
        this.setBackground(DEF_BKG);
        this.setLayout(new GridLayout(4,4));
    }

    /**
     * @param title
     * @param e
     * @return
     * method which create the buttons in the debug panel
     */
    private JButton makeButton(String title, ActionListener e){
        JButton out = new JButton(title);
        out.addActionListener(e);
        out.setBackground(Color.BLACK);
        out.setForeground(new Color(166,141,16));
        return  out;
    }

    /**
     * @param min
     * @param max
     * @param e
     * @return
     * method which create the slider in the debug panel
     */
    private JSlider makeSlider(int min, int max, ChangeListener e){
        JSlider out = new JSlider(min,max);
        out.setBackground(Color.BLACK);
        out.setMajorTickSpacing(1);
        out.setSnapToTicks(true);
        out.setPaintTicks(true);
        out.setForeground(new Color(166,141,16));
        out.addChangeListener(e);
        return out;
    }

    /**
     * @param x
     * @param y
     * method which update the new ball speed after the change in the sliders
     */
    public void setValues(int x,int y){
        ballXSpeed.setValue(x);
        ballYSpeed.setValue(y);
    }

}
