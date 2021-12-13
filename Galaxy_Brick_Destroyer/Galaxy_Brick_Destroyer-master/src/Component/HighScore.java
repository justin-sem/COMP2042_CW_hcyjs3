package Component;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * This is the High Score class
 */
public class HighScore extends JFrame {

    JFrame highScoreFrame = new JFrame();
    JLabel scoreLabel1 = new JLabel();
    JLabel scoreLabel2 = new JLabel();
    JTextArea scoreLabel3 = new JTextArea(10, 20);
    private int[] hsArray  ;


    /**
     * @param owner
     * High Score constructor which create the pop-up high score frame
     */
    public HighScore(JFrame owner) {

        highScoreFrame.setUndecorated(true);
        highScoreFrame.setSize(550, 350);
        highScoreFrame.setLayout(null);
        highScoreFrame.setVisible(true);
        highScoreFrame.setFocusable(true);
        highScoreFrame.setResizable(false);
        highScoreFrame.requestFocusInWindow();
        highScoreFrame.getContentPane().setBackground(new Color(0, 0, 0));
        centreWindow(highScoreFrame);
        highScoreFrame.add(scoreLabel1);
        highScoreFrame.add(scoreLabel2);
        highScoreFrame.add(scoreLabel3);

        highScoreFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(166, 141, 16)));
        highScoreFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
                    highScoreFrame.dispose();
                }

            }
        });

        scoreLabel1.setText("Hall of Galaxy");
        scoreLabel1.setBounds(135, 0, 300, 50);
        scoreLabel1.setFont(new Font("Algerian", Font.BOLD, 35));
        scoreLabel1.setForeground(new Color(166, 141, 16));

        scoreLabel2.setText("press SPACE to restart the game");
        scoreLabel2.setBounds(150, 300, 400, 50);
        scoreLabel2.setFont(new Font("GEORGIA", Font.BOLD, 15));
        scoreLabel2.setForeground(new Color(111, 229, 15));

        scoreLabel3.setBounds(5, 50, 535, 250);
        scoreLabel3.setFont(new Font("GEORGIA", Font.PLAIN, 21));
        scoreLabel3.setForeground(new Color(243, 66, 72));
        scoreLabel3.setBackground(Color.BLACK);


        // read file
        try {
            File myObj = new File("Galaxy_Brick_Destroyer/Galaxy_Brick_Destroyer-master/Others/HighScore");
            Scanner myReader = new Scanner(myObj);
            hsArray = new int[10];
            int i = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                hsArray[i] = Integer.valueOf(data);
                i++;
                    if(i == 10){
                        break;
                }
            }

            //sorting the points from high to low
            int temp;
            for (i = 0; i < 10; i++) {
                for(int j = i+1; j < 10 ; j++){
                    if(hsArray[j]>hsArray[i]){
                        temp = hsArray[j];
                        hsArray[j]=hsArray[i];
                        hsArray[i]=temp;
                    }
                }
            }

            scoreLabel3.setText("    Top 1: "+String.valueOf(hsArray[0])+ "   points\n" +
                    "    Top 2: "+String.valueOf(hsArray[1])+ "   points\n" +
                    "    Top 3: "+String.valueOf(hsArray[2])+ "   points\n" +
                    "    Top 4: "+String.valueOf(hsArray[3])+ "   points\n" +
                    "    Top 5: "+String.valueOf(hsArray[4])+ "   points\n" +
                    "    Top 6: "+String.valueOf(hsArray[5])+ "   points\n" +
                    "    Top 7: "+String.valueOf(hsArray[6])+ "   points\n" +
                    "    Top 8: "+String.valueOf(hsArray[7])+ "   points\n" +
                    "    Top 9: "+String.valueOf(hsArray[8])+ "   points\n" +
                    "    Top 10: "+String.valueOf(hsArray[9])+ "   points\n");

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    /**
     * @param highScoreFrame
     * method which locate the high score frame at the middle of screen
     */
    // make the high score window display at middle of screen
        public static void centreWindow (Window highScoreFrame)
        {
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - highScoreFrame.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - highScoreFrame.getHeight()) / 2);
            highScoreFrame.setLocation(x, y);

        }

    }






