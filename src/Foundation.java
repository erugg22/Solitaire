/*
** Program Purpose: Create a Foundation class to be used in main program
** Author: Elizabeth Ruggiero
** Period: 3
** Date: 5/25/20
** Version: 1
*/

//import java libraries
import java.util.ArrayList;

public class Foundation {
	//instance variables
	private ArrayList<ArrayList<Card>> foundation;
	private ArrayList<Card> s;
	private ArrayList<Card> c;
	private ArrayList<Card> d;
	private ArrayList<Card> h;
	
	//constructor initializes foundation and indices of foundation
	public Foundation()
	{
		foundation = new ArrayList<ArrayList<Card>>();
		s = new ArrayList<Card>();
		c = new ArrayList<Card>();
		d = new ArrayList<Card>();
		h = new ArrayList<Card>();
		foundation.add(s);
		foundation.add(c);
		foundation.add(d);
		foundation.add(h);
	}
	
	//get methods
	//returns specified foundation pile size
	public int getPileSize(int index)
	{
		return foundation.get(index).size();
	}
	//checks if specified foundation pile is empty
	public boolean empty(int index)
	{
		return(foundation.get(index).size() == 0);
	}
	//checks if card is in foundation
	public boolean inFoundation(Card card)
	{
		for(int i = 0; i < foundation.size(); i++)
		{
			if(foundation.get(i).contains(card))
				return true;
		}
		return false;
	}
	//checks if foundation is full
	public boolean fullFoundation()
	{
		if(s.size() == 13 && c.size() == 13 && d.size() == 13 && h.size() == 13)
			return true;
		return false;
	}
	//adds card to foundation
	public void addToF(Card card)
	{
		if(card.getSuit().equals("s"))
			s.add(card);
		else if(card.getSuit().equals("c"))
			c.add(card);
		else if(card.getSuit().equals("d"))
			d.add(card);
		else if(card.getSuit().equals("h"))
			h.add(card);
			
	}
	//removes card from foundation
	public void removeFromF(Card card)
	{
		foundation.get(getCol(card)).remove(card);
	}
	//returns foundation pile of card
	public int getCol(Card card1)
	{
		for(int i = 0; i < foundation.size(); i++)
		{
			for(Card card2:foundation.get(i))
			{
				if(card2 == card1)
					return i;		
			}
		}
		return -1;
	}
	public String toString()
	{
		return "Foundation: " + foundation;
	}
	
}
