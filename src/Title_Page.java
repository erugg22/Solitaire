/*
** Program Purpose: Create a title page to be used in main program
** Author: Elizabeth Ruggiero
** Period: 3
** Date: 6/1/20
** Version: 1
*/

//import java libraries
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Title_Page extends JFrame implements ActionListener{
	//instance variables
	private JLayeredPane pane;
	private JLabel background;
	private JButton playButton;
	private JButton insButton;
	private ImageIcon homeIcon;
	private ImageIcon insIcon;
	
	//constructor initializes elements on title page
	public Title_Page()
	{
		setTitle("Solitaire");
	    setSize(1400, 900);
	    pane = new JLayeredPane();
	    playButton = new JButton("Play");
	    background = new JLabel();
	    insButton = new JButton("Instructions");
	    
	    homeIcon = new ImageIcon("images/cover.png");
	    insIcon = new ImageIcon("images/instructions.png");
	    background.setIcon(homeIcon);
	    background.setBounds(0, 0, 1400, 900);
	    playButton.setBounds(380, 625, 300, 100);
	    insButton.setBounds(720, 625, 300, 100);
	    playButton.setFont(new Font("Optima", Font.PLAIN, 60));
	    insButton.setFont(new Font("Optima", Font.PLAIN, 50));
	    pane.add(playButton);
	    pane.add(background);
	    pane.add(insButton);
	    
	    pane.moveToFront(playButton);
	    pane.moveToFront(insButton);
	    
	    add(pane);
	    
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	}
	//returns playButton
	public JButton getPlayButton()
	{
		return playButton;
	}
	//action events
	public void action()
	{
		//if instructions button is clicked, changes background to display instructions
		insButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				background.setIcon(insIcon);
				insButton.setVisible(false);
				playButton.setBounds(600, 720, 200, 70);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
