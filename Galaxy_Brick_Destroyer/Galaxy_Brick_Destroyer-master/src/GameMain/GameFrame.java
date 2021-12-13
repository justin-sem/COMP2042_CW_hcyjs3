package GameMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import Component.HighScore;


/**
 * This is the Game Frame class
 * which build the main frame of this game
 */
public class GameFrame extends JFrame implements WindowFocusListener {

    private static final String DEF_TITLE = "Galaxy Brick Destroyer";
    private GameBoard gameBoard;
    private HomeMenu homeMenu;
    private GameGuide gameGuide;
    private HighScore highScore;
    private boolean gaming;


    /**
     * Game Frame constructor
     */
    public GameFrame(){                                 // GameFrame constructor

        super();
        gaming = false;

        this.setLayout(new BorderLayout());
        gameBoard = new GameBoard(this);
        homeMenu = new HomeMenu(this,new Dimension(650,500));
        this.add(homeMenu,BorderLayout.CENTER);
        this.setUndecorated(true);
        ImageIcon galaxyLogo = new ImageIcon("Galaxy_Brick_Destroyer/Galaxy_Brick_Destroyer-master/Others/galaxy.jpg");     // change icon
        this.setIconImage(galaxyLogo.getImage());
        ImageIcon universeBG = new ImageIcon("Galaxy_Brick_Destroyer/Galaxy_Brick_Destroyer-master/Others/universe.jpg");     // change BG


    }


    /**
     * initialise method with build the main game frame
     */
    public void initialize(){
        this.setTitle(DEF_TITLE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.autoLocate();
        this.setVisible(true);

    }

    /**
     * method which to start the game board frame from home menu frame
     * to avoid problems with graphics focus controller is also added here
     */
    public void enableGameBoard(){
        this.dispose();
        this.remove(homeMenu);
        this.add(gameBoard,BorderLayout.CENTER);
        this.setUndecorated(false);
        this.setResizable(false);
        initialize();
        this.addWindowFocusListener(this);

    }

    /**
     * method which to switch to guide frame from home menu frame
     */
    public void enableGameGuide(){
        gameGuide = new GameGuide(this);
        this.dispose();
        this.remove(homeMenu);
        this.add(gameGuide,BorderLayout.CENTER);
        this.setUndecorated(false);

    }

    /**
     * method which allowed user to come back to home menu from any other frame
     */
    public void enableHomeMenu(){                   // used when back button from guide is clicked
        this.remove(gameGuide);
        this.add(homeMenu,BorderLayout.CENTER);
        this.dispose();
        this.setUndecorated(true);
        this.setResizable(false);
        initialize();
    }

    /**
     * method which to pop up the high score frame
     */
    public void enableHighScore(){
        highScore = new HighScore(this);
        this.add(highScore,BorderLayout.CENTER);
        this.setUndecorated(false);
        this.setResizable(false);

    }

    private void remove(GameGuide gameGuide) {
    }

    private void add(GameGuide gameGuide, String center) {
    }
    private void add(HighScore highScore, String center){

    }

    /**
     * method which to locate the game frame at the middle of screen
     */
    private void autoLocate(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (size.width - this.getWidth())/2 ;
        int y = (size.height - this.getHeight())/2 ;
        this.setLocation(x,y);
    }


    /**
     * @param windowEvent
     *   the first time the frame loses focus is because
     *   it has been disposed to install the GameBoard,
     *   so went it regains the focus it's ready to play.
     *   of course calling a method such as 'onLostFocus'
     *   is useful only if the GameBoard as been displayed
     *   at least once
     */
    @Override
    public void windowGainedFocus(WindowEvent windowEvent) {
        gaming = true;
    }

    @Override
    public void windowLostFocus(WindowEvent windowEvent) {
        if(gaming)
            gameBoard.onLostFocus();

    }

}



