/*
** Program Purpose: Create a Deck class to be used in main program
** Author: Elizabeth Ruggiero
** Period: 3
** Date: 5/21/20
** Version: 1
*/

//import java libraries
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	//instance variables
	private ArrayList<Card> dDeck; //face down deck
	private ArrayList<Card> uDeck; //face up deck
	
	//constructor initializes dDeck and uDeck
	public Deck()
	{
		dDeck = new ArrayList<Card>();
		uDeck = new ArrayList<Card>();
	}
	
	//get methods
	public int getSize()
	{
		return dDeck.size();
	}
	public ArrayList<Card> getDown()
	{
		return dDeck;
	}
	public ArrayList<Card> getUp()
	{
		return uDeck;
	}
	//checks if card is in uDeck
	public boolean inUp(Card card1)
	{
		for(Card card2:uDeck)
		{
			if(card1 == card2)
				return true;
		}
		return false;
	}
	//checks if dDeck is empty
	public boolean downEmpty()
	{
		if(getSize() == 0)
			return true;
		return false;
	}
	
	//adds card to dDeck
	public void addToDown(Card card)
	{
		dDeck.add(card);
	}
	//removes card from uDeck
	public void removeFromUp(Card card)
	{
		uDeck.remove(card);
	}
	//moves top card of dDeck to uDeck
	public void DownToUp()
	{
		uDeck.add(dDeck.remove(0));
	}
	//moves cards from uDeck to dDeck
	public void UpToDown()
	{
		for(int i = uDeck.size()-1; i >= 0; i--)
		{
			dDeck.add(uDeck.remove(i));
		}
	}
	//shuffle dDeck
	public void shuffle()
	{
		int index;
		Card temp;
	    Random random = new Random();
	    for (int i = dDeck.size() - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = dDeck.get(index);
	        dDeck.set(index, dDeck.get(i));
	        dDeck.set(i, temp);
	    }
	}
	//shuffles uDeck
	public void shuffleUp()
	{
		int index;
		Card temp;
	    Random random = new Random();
	    for (int i = uDeck.size() - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = uDeck.get(index);
	        uDeck.set(index, uDeck.get(i));
	        uDeck.set(i, temp);
	    }
	}
	//sets uDeck invisible
	public void setUpInvisible()
	{
		for(Card card:uDeck)
		{
			card.getButton().setVisible(false);
		}
	}
	
	public String toString()
	{
		return "Down deck: " + dDeck + "\n" + "Up deck: " + uDeck;
	}
	
}
