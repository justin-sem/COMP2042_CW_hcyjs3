package GameMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// implement a button which can go back from guide to home menu ~
//  28/11/2021

public class GameGuide implements ActionListener {

    JFrame guideFrame = new JFrame();
    JLabel guideLabel1 = new JLabel();
    JLabel guideLabel2 = new JLabel();
    JLabel guideLabel3 = new JLabel();
    JButton backButton = new JButton();



    public GameGuide(JFrame owner) {

        guideFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guideFrame.setSize(650,500);
        guideFrame.setLayout(null);
        guideFrame.setVisible(true);
        guideFrame.setFocusable(true);
        guideFrame.setResizable(false);
        guideFrame.requestFocusInWindow();
        guideFrame.getContentPane().setBackground(new Color(16,20,66));
        centreWindow(guideFrame);
        guideFrame.add(guideLabel1);
        guideFrame.add(guideLabel2);
        guideFrame.add(guideLabel3);
        guideFrame.add(backButton);

        guideLabel1.setText("Game Guide");
        guideLabel1.setBounds(210,0,250,50);
        guideLabel1.setFont(new Font ("Algerian",Font.BOLD,35));
        guideLabel1.setForeground(new Color(166, 141, 16));

        guideLabel2.setText(" # Press Key 'A' / '<--' To Control The Paddle To Left.");
        guideLabel2.setBounds(0,70,800,50);
        guideLabel2.setFont(new Font ("Georgia",Font.PLAIN,20));
        guideLabel2.setForeground(new Color(197, 195, 225));

        guideLabel3.setText(" # Press Key 'D' / '-->' To Control The Paddle To Right.");
        guideLabel3.setBounds(0,120,800,50);
        guideLabel3.setFont(new Font ("Georgia",Font.PLAIN,20));
        guideLabel3.setForeground(new Color(197, 195, 225));

        backButton.setText("BACK");
        backButton.setFont(new Font ("Georgia",Font.BOLD,25));
        backButton.setForeground(new Color(166,141,16));
        backButton.setBackground(new Color(16,20,66));
        backButton.setBorder(BorderFactory.createCompoundBorder());
        backButton.setFocusable(false);
        backButton.setBounds(10,400,100,40);
        backButton.addActionListener(this);



    }

    public static void centreWindow(Window guideFrame) {            // make the guide window display at middle of screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - guideFrame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - guideFrame.getHeight()) / 2);
        guideFrame.setLocation(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e)  {                  // when back button clicked return to home menu
        if(e.getSource()==backButton){
            guideFrame.dispose();
            GameFrame x = new GameFrame();
            x.enableHomeMenu();

        }
    }
}


