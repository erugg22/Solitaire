/*
** Program Purpose: Create a Card class to be used in main program
** Author: Elizabeth Ruggiero
** Period: 3
** Date: 5/17/20
** Version: 1
*/

//import java libraries
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Card
{
	private String suit; //s, c, d, h
	private String value; // 2, 3, 4, 5, 6, 7, 8, 9, 10, j, q, k, a
	private int number; // 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1
	private String color; // r, b
	private JButton cardButton = new JButton();
	private String imageName = "cardBack"; //imageName is used to set icon of cardButton
	private String cardName; //concatenation of suit and value
	private int offset; //for icon sizing purposes
	private ArrayList<Integer> cardNums = new ArrayList<Integer>();

	//Card constructor
	public Card(String suit, String value, JLayeredPane pane)
	{
		cardNums.add(2);
		cardNums.add(3);
		cardNums.add(4);
		cardNums.add(5);
		cardNums.add(6);
		cardNums.add(7);
		cardNums.add(8);
		cardNums.add(9);
		cardNums.add(10);
		
		this.suit = suit;
		this.value = value;
		if(suit.equals("s") || suit.equals("c"))
			color = "b";
		else if(suit.equals("d") || suit.equals("h"))
			color = "r";
		this.cardName = suit + value;
		if(value.equals("j"))
			number = 11;
		else if(value.equals("q"))
			number = 12;
		else if(value.equals("k"))
			number = 13;
		else if(value.equals("a"))
			number = 1;
		else if(cardNums.contains(Integer.valueOf(value)))
			number = Integer.valueOf(value);
		
		cardButton.setBounds(0, 0, 100, 140);
		offset = cardButton.getInsets().left;
		cardButton.setIcon(resizeIcon(new ImageIcon("images/" + imageName + ".png"), cardButton.getWidth() - offset, cardButton.getHeight() - offset));
		cardButton.setVisible(false);
        
		pane.add(cardButton);
	}
	
	//get methods
	public int getX()
	{
		return cardButton.getX();
	}
	public int getY()
	{
		return cardButton.getY();
	}
	public JButton getButton()
	{
		return cardButton;
	}
	public String getSuit()
	{
		return suit;
	}
	public String getValue()
	{
		return value;
	}
	public int getNumber()
	{
		return number;
	}
	public String getColor()
	{
		return color;
	}
	public ImageIcon getImage()
	{
		return new ImageIcon("images/" + imageName + ".png");
	}
	//checks if card is face up
	public boolean faceUp()
	{
		if(imageName.equals(cardName))
			return true;
		return false;
	}
	
	//set methods
	public void buttonVisible()
	{
		cardButton.setVisible(true);
	}
	//switches cardButton to face down
	public void toFaceDown()
	{
		imageName = "cardBack";
		cardButton.setIcon(resizeIcon(new ImageIcon("images" + imageName + ".png"), cardButton.getWidth() - offset, cardButton.getHeight() - offset));
	}
	//switches cardButton to face up
	public void toFaceUp()
	{
		imageName = cardName;
		cardButton.setIcon(resizeIcon(new ImageIcon("images/" + imageName + ".png"), cardButton.getWidth() - offset, cardButton.getHeight() - offset));
	}
	//flips card to face up or face down
	public void flipCard()
	{
		if(imageName.equals("cardBack"))
		{
			toFaceUp();
		}
		else if(imageName.equals(cardName))
		{
			toFaceDown();
		}
	}
	//sets cardButton location
	public void setButtonLoc(int x, int y)
	{
		cardButton.setLocation(x, y);
	}
	//resizes cardButton icon
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
	
	public String toString()
	{
		return " " + cardName;
	}
}
