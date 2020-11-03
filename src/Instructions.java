/*
** Program Purpose: Create an Instructions page to be used in main program
** Author: Elizabeth Ruggiero
** Period: 3
** Date: 6/1/20
** Version: 1
*/

//import java libraries
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Instructions extends JFrame{
	//instance variables
	private JLayeredPane pane;
	private JLabel background;
	private JButton playButton;
	private ImageIcon icon;
	
	//constructor adds elements to instructions page
	public Instructions()
	{
		setTitle("Solitaire");
	    setSize(1400, 900);
	    pane = new JLayeredPane();
	    playButton = new JButton("P L A Y");
	    background = new JLabel();
	    
	    icon = new ImageIcon("images/instructions.png"); 
	    background.setIcon(icon);
	    background.setBounds(0, 0, 1400, 900);
	    playButton.setBounds(550, 625, 300, 100);
	    //playButton.setBackground(Color.red);//new Color(191, 48, 0));
	    playButton.setFont(new Font("Optima", Font.PLAIN, 60));
	    pane.add(playButton);
	    pane.add(background);
	    
	    pane.moveToFront(playButton);
	    
	    add(pane);
	    
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//returns playButton
	public JButton getPlayButton()
	{
		return playButton;
	}
}
