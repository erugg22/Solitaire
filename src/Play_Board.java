/*
** Program Purpose: Create a play board to be used in main program
** Author: Elizabeth Ruggiero
** Period: 3
** Date: 5/21/20
** Version: 1
*/

//import java libraries
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Play_Board extends JFrame implements ActionListener
{
	//instance variables
	private JLayeredPane pane;
    private JButton deckButton;
    private JButton shuffleButton;
    private JButton restartButton =  new JButton("Restart");
    private JLabel winLabel;
    private JLabel countLabel;
	private ArrayList<Card> allCards = new ArrayList<Card>();
	private ArrayList<Card> tempCards;
	private Deck deck;
	private Tableau tab;
	private Foundation foun;
	private ActionListener cardClicked;
	private int factor;
	private int sCount = 1;
	private int cCount = 1;
	private int dCount = 1;
	private int hCount = 1;
	private String currentSuit;
	private int moveCount = 0;
	private int topY = 10;
	private int tabY = 175;
	private int betweenCardsY = 35;
	private int startFoX = 800;
	private int betweenFoX = 150;
	
	//constructor
    public Play_Board()
	{	
    	
    	setTitle("Solitaire");
        setSize(1400, 900);
        
        deckButton = new JButton();
        shuffleButton = new JButton("Refresh");
        countLabel = new JLabel("Moves: " + moveCount);
        winLabel = new JLabel();
        pane = new JLayeredPane();
        pane.setOpaque(true);
        pane.setBackground(new Color(50, 138, 60));
        deckButton.setBounds(50, topY, 100, 140); //x value of 200 is the face up deck
        shuffleButton.setBounds(60, topY + 10, 80, 120);
        restartButton.setBounds(670, 12, 100, 35);
        winLabel.setBounds(400, 500, 700, 300);
        winLabel.setFont(new Font("Optima", Font.PLAIN, 25));
        countLabel.setBounds(580, 20, 100, 15);
        countLabel.setFont(new Font("Optima", Font.PLAIN, 17));
        restartButton.setFont(new Font("Optima", Font.PLAIN, 17));
        winLabel.setVisible(false);
        setIcon(deckButton, new ImageIcon("images/cardBack.png"));
        
        //add buttons to pane
        pane.add(deckButton);
        pane.add(shuffleButton);
        pane.add(restartButton);
        pane.add(winLabel);
        pane.add(countLabel);
        
        initCards();
    	
        //add pane to frame
        add(pane);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        assignCards();
	}
    
	//return restart button
    public JButton getRestartButton()
    {
    	return restartButton;
    }
    //initialize 52 cards
	public void initCards()
	{
		allCards = new ArrayList<Card>();
		for(int i = 2; i < 11; i++)
    	{
    		allCards.add(new Card("c", Integer.toString(i), pane));
    	}
    	for(int i = 2; i < 11; i++)
    	{
    		allCards.add(new Card("s", Integer.toString(i), pane));
    	}
    	for(int i = 2; i < 11; i++)
    	{
    		allCards.add(new Card("d", Integer.toString(i), pane));
    	}
    	for(int i = 2; i < 11; i++)
    	{
    		allCards.add(new Card("h", Integer.toString(i), pane));
    	}
    	allCards.add(new Card("c", "j", pane));
    	
    	allCards.add(new Card("s", "j", pane));
    	
    	allCards.add(new Card("d", "j", pane));
    	
    	allCards.add(new Card("h", "j", pane));
    	
    	allCards.add(new Card("c", "q", pane));
    	
    	allCards.add(new Card("s", "q", pane));
    	
    	allCards.add(new Card("d", "q", pane));
    	
    	allCards.add(new Card("h", "q", pane));
    	
    	allCards.add(new Card("c", "k", pane));
    	
    	allCards.add(new Card("s", "k", pane));
    	
    	allCards.add(new Card("d", "k", pane));
    	
    	allCards.add(new Card("h", "k", pane));
    	
    	allCards.add(new Card("c", "a", pane));
    	
    	allCards.add(new Card("s", "a", pane));
    	
    	allCards.add(new Card("d", "a", pane));
    	
    	allCards.add(new Card("h", "a", pane));
	}
	
	//destroy jFrame object
	public void end()
	{
		dispose();
	}
	//adds label to pane
	public void addLabel(JLabel label)
	{
		label.setBounds(400, 400, 800, 300);
        label.setFont(new Font("Verdana", Font.PLAIN, 17));
		pane.add(label);
	}
	//assigns cards to deck, tableau and foundation
	public void assignCards()
	{
		deck = new Deck();
		tab = new Tableau();
		foun = new Foundation();
		shuffleList(allCards);
		
		for(int j = 0; j < 24; j++)
		{
			deck.addToDown(allCards.get(j));
		}
		
		tab.addToTab(allCards.get(24), 0);
		tab.addToTab(allCards.get(25), 1);
		tab.addToTab(allCards.get(26), 1);
		for(int i = 27; i < 30; i++)
		{
			tab.addToTab(allCards.get(i), 2);
		}
		for(int i = 30; i < 34; i++)
		{
			tab.addToTab(allCards.get(i), 3);
		}
		for(int i = 34; i < 39; i++)
		{
			tab.addToTab(allCards.get(i), 4);
		}
		for(int i = 39; i < 45; i++)
		{
			tab.addToTab(allCards.get(i), 5);
		}
		for(int i = 45; i < 52; i++)
		{
			tab.addToTab(allCards.get(i), 6);
		}
		
		for(int i = 0; i < 7; i++)
		{
			tab.initTab(i, pane);
		}
	}
	//shuffles list of cards
	public void shuffleList(ArrayList<Card> list)
	{
		int index;
		Card temp;
	    Random random = new Random();
	    for (int i = list.size() - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = list.get(index);
	        list.set(index, list.get(i));
	        list.set(i, temp);
	    }
	}
	//sets button icon with resized icon
	public void setIcon(JButton button, ImageIcon icon)
	{
		int offset = button.getInsets().left;
		button.setIcon(resizeIcon(icon, deckButton.getWidth() - offset, deckButton.getHeight() - offset));
	}
	//resizes icon
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//action events
	public void action()
	{
		//adds action listener to deckButton
		deckButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
            {
            	if(deck.getSize() != 0)
            	{
					deck.DownToUp();
					Card current = deck.getUp().get(deck.getUp().size()-1);
	            	current.getButton().setLocation(200, topY);
	            	moveCount ++;
	            	countLabel.setText("Moves: " + moveCount);
	            	pane.moveToFront(current.getButton());
	            	if(!current.faceUp())
	            		current.flipCard();
	            	current.buttonVisible();
	            	if(deck.getSize() == 0)
	            		deckButton.setVisible(false);
            	}
            }
		});
		//adds action listener to shuffleButton
		shuffleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				deck.shuffleUp();
				deckButton.setVisible(true);
				pane.moveToFront(deckButton);
				deck.setUpInvisible();
				deck.UpToDown();
			}
		});
		
		//creating cardClicked ActionListener object
		cardClicked = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				for(Card card:allCards)
				{
					//gets card object of cardButton clicked
					if(e.getSource() == card.getButton())
					{
						currentSuit = card.getSuit();
						//checks if card is face up
						 if(card.faceUp())
						 {
							//checks if card is a king, at the end of a pile, and if an empty tableau column is open
							if(card.getNumber() == 13 && tab.emptyCol() && (tab.atAnyEnd(card) || deck.inUp(card)) && !((currentSuit.equals("s") && card.getNumber() == sCount) || (currentSuit.equals("c") && card.getNumber() == cCount) || (currentSuit.equals("d") && card.getNumber() == dCount) || (currentSuit.equals("h") && card.getNumber() == hCount)))
							{
								int temp = tab.getEmptyCol();
								card.setButtonLoc(tab.getColX(temp),  tabY);
								moveCount ++;
				            	countLabel.setText("Moves: " + moveCount);
								if(tab.inTableau(card))
									tab.changeCol(tab.getCol(card), temp, card);
								else
								{
									tab.addToTab(card, temp);
									deck.removeFromUp(card);
								}
							}
							//checks if the card is a king, if an empty tableau column is open, and if it is in a group of face up cards
							else if(card.getNumber() == 13 && tab.emptyCol() && !tab.atAnyEnd(card))
							{
								ArrayList<Card> cards = tab.getGroup(card);
								factor = 0;
								int temp = tab.getEmptyCol();
								for(Card element:cards)
								{
									pane.moveToFront(element.getButton());
									element.setButtonLoc(tab.getColX(temp), tabY + (betweenCardsY * factor));
									tab.changeCol(tab.getCol(element), temp, element);
									factor ++;
								}
								moveCount ++;
				            	countLabel.setText("Moves: " + moveCount);
							}
							
							else //card is not a king
							{
								//checks if card can be moved to foundation pile
								if(currentSuit.equals("s") && card.getNumber() == sCount && (tab.atAnyEnd(card) || deck.inUp(card)))
								{
									foun.addToF(card);
									sCount ++;
									card.setButtonLoc(startFoX, topY);
									moveCount ++;
					            	countLabel.setText("Moves: " + moveCount);
									pane.moveToFront(card.getButton());
									if(deck.inUp(card))
										deck.removeFromUp(card);
									else if(tab.inTableau(card))
										tab.removeFromTab(card);
								}
								else if(currentSuit.equals("c") && card.getNumber() == cCount && (tab.atAnyEnd(card) || deck.inUp(card)))
								{
									foun.addToF(card);
									cCount ++;
									card.setButtonLoc(startFoX + betweenFoX, topY);
									moveCount ++;
					            	countLabel.setText("Moves: " + moveCount);
									pane.moveToFront(card.getButton());
									if(deck.inUp(card))
										deck.removeFromUp(card);
									else if(tab.inTableau(card))
										tab.removeFromTab(card);
								}
								else if(currentSuit.equals("d") && card.getNumber() == dCount && (tab.atAnyEnd(card) || deck.inUp(card)))
								{
									foun.addToF(card);
									dCount ++;
									card.setButtonLoc(startFoX + betweenFoX*2, topY);
									moveCount ++;
					            	countLabel.setText("Moves: " + moveCount);
									pane.moveToFront(card.getButton());
									if(deck.inUp(card))
										deck.removeFromUp(card);
									else if(tab.inTableau(card))
										tab.removeFromTab(card);
								}
								else if(currentSuit.equals("h") && card.getNumber() == hCount && (tab.atAnyEnd(card) || deck.inUp(card)))
								{
									foun.addToF(card);
									hCount ++;
									card.setButtonLoc(startFoX + betweenFoX*3, topY);
									moveCount ++;
					            	countLabel.setText("Moves: " + moveCount);
									pane.moveToFront(card.getButton());
									if(deck.inUp(card))
										deck.removeFromUp(card);
									else if(tab.inTableau(card))
										tab.removeFromTab(card);
								}
								else //card cannot be moved to a foundation pile
								{
									//retrieves card object of card that current card can be moved to, called target
									for(Card target:allCards)
									{
										if(!target.getColor().equals(card.getColor()) && target.getNumber() - card.getNumber() == 1 && tab.inTableau(target) && tab.atEnd(tab.getCol(target), target) && target.faceUp())
										{
											pane.moveToFront(card.getButton());
											//if card is in tableau
											if(tab.inTableau(card))
											{
												//if card is at the end of pile
												if(tab.atAnyEnd(card))
												{
													tab.changeCol(tab.getCol(card), tab.getCol(target), card);
													card.setButtonLoc(target.getX(), target.getY()+betweenCardsY);
													moveCount ++;
									            	countLabel.setText("Moves: " + moveCount);
												}
												//if card is at the top of a group of face up cards
												else
												{
													ArrayList<Card> cards = tab.getGroup(card);
													//System.out.println(cards);
													factor = 1;
													
													for(Card element:cards)
													{
														pane.moveToFront(element.getButton());
														//element.setButtonLoc(target.getX(), target.getY()+ (40 * factor));
														element.setButtonLoc(target.getX(), target.getY() + (betweenCardsY * factor));
														tab.changeCol(tab.getCol(element), tab.getCol(target), element);
														factor ++;
														
													}
													moveCount ++;
									            	countLabel.setText("Moves: " + moveCount);
													
												}
												break;
												
											}
											//if card is in uDeck
											else if(deck.inUp(card) && target.faceUp())
											{
												card.setButtonLoc(target.getX(), target.getY() + betweenCardsY);
												tab.addToTab(card,  tab.getCol(target));
												deck.removeFromUp(card);
												moveCount ++;
								            	countLabel.setText("Moves: " + moveCount);
											}
											//if card is in foundation
											else if(foun.inFoundation(card))
											{
												card.setButtonLoc(target.getX(), target.getY() + betweenCardsY);
												moveCount ++;
								            	countLabel.setText("Moves: " + moveCount);
												tab.addToTab(card,  tab.getCol(target));
												foun.removeFromF(card);
												if(currentSuit.equals("s"))
													sCount --;
												else if(currentSuit.equals("c"))
													cCount --;
												else if(currentSuit.equals("d"))
													dCount --;
												else if(currentSuit.equals("h"))
													hCount--;
											}
										}
									}
								}
							}
						}
						//if card is at the bottom of a tableau pile and is face down
						else
						{
							if(tab.atAnyEnd(card))
								card.toFaceUp();
						}
					}
				}
				//if all foundation piles have been filled, end game
				if(foun.fullFoundation())
				{
					winLabel.setText("You won with " + moveCount + " moves! Click the restart button to play again.");
					winLabel.setVisible(true);
				}
					
			}	
		};
		//adds cardClicked ActionListener to 52 card objects
		for(int i = 0; i < allCards.size(); i++)
		{
			allCards.get(i).getButton().addActionListener(cardClicked);
		}

	}
}
