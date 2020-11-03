/*
** Program Purpose: Create a Tableau class to be used in main program
** Author: Elizabeth Ruggiero
** Period: 3
** Date: 5/20/20
** Version: 1
*/

//import java libraries
import java.util.ArrayList;
import javax.swing.JLayeredPane;

public class Tableau {
	//instance variables
	private ArrayList<ArrayList<Card>> tableau;
	private ArrayList<Card> t1;
	private ArrayList<Card> t2;
	private ArrayList<Card> t3;
	private ArrayList<Card> t4;
	private ArrayList<Card> t5;
	private ArrayList<Card> t6;
	private ArrayList<Card> t7;
	private int tabX = 40;
	private int tabY = 175;
	private int betweenColsX = 200;
	
	//constructor initializes tableau
	public Tableau()
	{
		tableau = new ArrayList<ArrayList<Card>>();
		t1 = new ArrayList<Card>();
		t2 = new ArrayList<Card>();
		t3 = new ArrayList<Card>();
		t4 = new ArrayList<Card>();
		t5 = new ArrayList<Card>();
		t6 = new ArrayList<Card>();
		t7 = new ArrayList<Card>();
		
		tableau.add(t1);
		tableau.add(t2);
		tableau.add(t3);
		tableau.add(t4);
		tableau.add(t5);
		tableau.add(t6);
		tableau.add(t7);
	}
	
	//check if the card is in the tableau
	public boolean inTableau(Card card)
	{
		for(int i = 0; i < tableau.size(); i++)
		{
			if(tableau.get(i).contains(card))
				return true;
		}
		return false;
	}
	//checks if card is at the end of specified tableau pile
	public boolean atEnd(int index, Card card)
	{
		if(inTableau(card))
		{
			if(tableau.get(index).indexOf(card) == tableau.get(index).size()-1)
				return true;
		}
		return false;
	}
	//checks if card is at any end of tableau
	public boolean atAnyEnd(Card card)
	{
		if(inTableau(card))
		{
			if(tableau.get(getCol(card)).indexOf(card) == tableau.get(getCol(card)).size()-1)
				return true;
		}
		return false;
	}
	//returns pile size of specified tableau pile
	public int getPileSize(int index)
	{
		return tableau.get(index).size();
	}
	//checks if there is an empty column in the tableau
	public boolean emptyCol()
	{
		for(int i = 0; i < tableau.size(); i++)
		{
			if(tableau.get(i).size() == 0)
				return true;
		}
		return false;
	}
	//checks if target comes one before card in tableau pile
	public boolean comesBefore(Card target, Card card)
	{
		if(!onlyOneUp(card))
		{
			if(tableau.get(getCol(card)).get(getIndexOfCol(card) - 1) == target)
				return true;
		}
		return false;
	}
	//checks if card is the only one face up in that tableau pile
	public boolean onlyOneUp(Card card)
	{
		if(tableau.get(getCol(card)).get(getIndexOfCol(card) - 1).faceUp())
			return false;
		return true;
	}
	//return column that card is in
	public int getCol(Card card1)
	{
		for(int i = 0; i < tableau.size(); i++)
		{
			for(Card card2:tableau.get(i))
			{
				if(card2 == card1)
					return i;		
			}
		}
		return -1;
	}
	//returns index of column that card is in
	public int getIndexOfCol(Card card)
	{
		int pile = getCol(card);
		for(int i = 0; i < tableau.get(pile).size(); i++)
		{
			if(tableau.get(pile).get(i) == card)
				return i;
		}
		return -1;
	}
	//returns index of empty column
	public int getEmptyCol()
	{
		for(int i = 0; i < tableau.size(); i++)
		{
			if(tableau.get(i).size() == 0)
				return i;
		}
		return -1;
	}
	//returns x value location of column
	public int getColX(int index)
	{
		return tabX + betweenColsX * index;
	}
	//returns group of face up cards under and including card
	public ArrayList<Card> getGroup(Card card)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		int startIndex = getIndexOfCol(card);
		ArrayList<Card> pile = tableau.get(getCol(card));
		for(int i = startIndex; i < pile.size(); i++)
		{
			cards.add(pile.get(i));
		}
		return cards;
	}
	//adds card to tab at specified column
	public void addToTab(Card card, int index)
	{
		tableau.get(index).add(card);
	}
	//initializes tableau by setting locations of cardButtons
	public void initTab(int index, JLayeredPane pane)
	{
		ArrayList<Card> pile = tableau.get(index);
		for(int i = 0; i < pile.size(); i++)
		{
			pile.get(i).getButton().setLocation(tabX + betweenColsX * index,  tabY + i * 35);
			pile.get(i).getButton().setVisible(true);
			pane.moveToFront(pile.get(i).getButton());
			if(i == pile.size()-1)
				pile.get(i).toFaceUp();
				
		}
	}
	//changes column of card in tableau
	public void changeCol(int fromIndex, int toIndex, Card card)
	{
		if(inTableau(card))
		{
			//if card is at end of column
			if(atAnyEnd(card))
			{
				tableau.get(toIndex).add(card);
				tableau.get(fromIndex).remove(card);
			}
			//if card is not at end of column, move group of cards
			else
			{
				int tempSize = tableau.get(fromIndex).size();
				int startIndex = getIndexOfCol(card);
				
				for(int i = startIndex; i < tempSize; i++)
				{
					tableau.get(toIndex).add(tableau.get(fromIndex).remove(startIndex));
				}
			}
		}
	}
	//removes card from tableau
	public void removeFromTab(Card card)
	{
		tableau.get(getCol(card)).remove(getIndexOfCol(card));
	}
	
	public String toString()
	{
		return "Tableau: " + tableau;
	}
}
