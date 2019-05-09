package com.rummyGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.border.Border;

import javafx.scene.layout.TilePane;

public class GameGUI 
{
	
	private Player player = new Player("Human Player");
	private Player humanPlayer1= new Player("Human Player 1");
	private Player humanPlayer2= new Player("Human Player 2");
	private Player humanPlayer3= new Player("Human Player 3");


	private Player AIplayer2 = new Player("AI player 1");
	private Player AIplayer3 = new Player("AI player 2");
	private Player AIplayer4 = new Player("AI player 3");


	//for tie Breaker
	private Player tiePlayer= new Player("Human Player");
	private Player tieAIPlayer1= new Player("Human Player");

	private RummyDeck thedeck = new RummyDeck(true);
	private RummyDeck tieBreaker= new RummyDeck(true);
	
	private Meld[] table = new Meld[200];
	private int tableIndex;
	
	private int tableCountForAIPlayer1;
	private int player2DoSomethingCount;
	
	private int tableCountForAIPlayer2;
	private int tableCountForAIPlayer3;

	private int AIplayer3IsDoSomething;
	private int player4DoSomething;

	private int player2Turn;
	private int player3Turn;
	private int player4Turn;
	
	private String determinePlayerTurn;
	
	//For game Rigging
	private RummyDeck newDeck= new RummyDeck(false);
	private Tile[] checkMeld= new Tile[20];
	private int numberCheckMeld=0;
	
	public GameGUI(String playerTurn)
	{
		
		tableIndex=0;
		tableCountForAIPlayer1 = 0;
		tableCountForAIPlayer2 = 0;
		tableCountForAIPlayer3 = 0;
		player2DoSomethingCount = 0;
		AIplayer3IsDoSomething = 0;
		player4DoSomething = 0;
		player2Turn = 1;
		player3Turn = 1;
		player4Turn= 1;

		this.determinePlayerTurn= playerTurn;
	}
	
	public String getDetermineTurn()
	{
		return determinePlayerTurn;
	}
	public void setPlayerTurn(String s)
	{
		this.determinePlayerTurn= s;
	}
	public void init() {
		
		//Two human and AI strategy 1
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2), Human Player 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 2 (2), AI player strategy 1 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 1 (2), Human Player 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		
		//Two Human Player and AI strategy 2
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 2 (2), Human Player 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 2 (2), AI player strategy 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 2 (2), Human Player 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		
		//Two human Player and AI strategy 3
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 3 (2), Human Player 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 2 (2), AI player strategy 3 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Human Player 2 (2), AI player strategy 3 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 3 (2), Human Player 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		
		//One human and AI 1 and AI 2
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 2 (2), AI player strategy 1 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		
		//One human player and AI 1 and AI 3
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2), Human Player 1 (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3), Human Player 1 (4)")
				|| this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), AI player strategy 1 (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 1 (4)")
				|| this.determinePlayerTurn.equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 1 (4)")
				|| this.determinePlayerTurn.equals("Yourself(1), AI player strategy 3 (2), AI player strategy 1 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 1 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 1 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 1 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 1 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Yourself (2), AI player strategy 1 (3), Human Player 1 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 1 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 1 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 1 (3), Yourself (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3), Human Player 1 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 3 (1), AI player strategy 1 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 1 (4)")
				|| this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 1 (2), AI player strategy 3 (3), Yourself (4)")
				|| this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 1 (3), Yourself (4)")
				|| this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		
		//One human Player and AI 2 and AI 3
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 3 (2), Human Player 1 (3), AI player strategy 2 (4)")
				|| this.determinePlayerTurn.equals("Yourself(1), AI player strategy 3 (2), AI player strategy 2 (3), Human Player 1 (4)")
				|| this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), AI player strategy 3 (3), AI player strategy 2 (4)")
				|| this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), AI player strategy 2 (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("Yourself(1), AI player strategy 2 (2), Human Player 1 (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Yourself (2), AI player strategy 2 (3), Human Player 1 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 3 (1), Yourself (2), Human Player 1 (3), AI player strategy 2 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 3 (1), Human Player 1 (2), Yourself (3), AI player strategy 2 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 3 (1), Human Player 1 (2), AI player strategy 2 (3), Yourself (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3), Human Player 1 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 3 (1), AI player strategy 2 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Yourself (2), AI player strategy 3 (3), Human Player 1 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 2 (1), Yourself (2), Human Player 1 (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 2 (1), Human Player 1 (2), Yourself (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 2 (1), Human Player 1 (2), AI player strategy 3 (3), Yourself (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3), Human Player 1 (4)")
				|| this.determinePlayerTurn.equals("AI player strategy 2 (1), AI player strategy 3 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 2 (4)")
				|| this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 3 (4)")
				|| this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 3 (2), AI player strategy 2 (3), Yourself (4)")
				|| this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 2 (4)")
				|| this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 2 (2), AI player strategy 3 (3), Yourself (4)")
				|| this.determinePlayerTurn.equals("Human Player 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		
		//All human Player
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), Human Player 2 (3), Human Player 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 1 (2), Human Player 3 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 2 (2), Human Player 1 (3), Human Player 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 2 (2), Human Player 3 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 3 (2), Human Player 1 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player 3 (2), Human Player 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), Human Player 2 (3), Human Player 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Yourself (2), Human Player 3 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Human Player 2 (2), Yourself (3), Human Player 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Human Player 2 (2), Human Player 3 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Human Player 3 (2), Yourself (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 1 (1), Human Player 3 (2), Human Player 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Yourself (2), Human Player 1 (3), Human Player 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Yourself (2), Human Player 3 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Human Player 1 (2), Yourself (3), Human Player 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Human Player 1 (2), Human Player 3 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Human Player 3 (2), Yourself (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 2 (1), Human Player 3 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 3 (1), Yourself (2), Human Player 1 (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 3 (1), Yourself (2), Human Player 2 (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 3 (1), Human Player 1 (2), Human Player 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 3 (1), Human Player 1 (2), Yourself (3), Human Player 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 3 (1), Human Player 2 (2), Human Player 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Human Player 3 (1), Human Player 2 (2), Yourself (3), Human Player 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				humanPlayer2.draw(thedeck.myNextTiles());
				humanPlayer3.draw(thedeck.myNextTiles());

			}
		}
		
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player (2), AI player strategy 1 (3)")
				||this.determinePlayerTurn.equals("Human Player(1), Yourself(2), AI player strategy 1 (3)")
						||this.determinePlayerTurn.equals("AI player strategy 1 (1), Yourself(2), Human Player (3)")
						||this.determinePlayerTurn.equals("Yourself (1), AI player strategy 1 (2), Human Player (3)")
						||this.determinePlayerTurn.equals("AI player strategy 1 (1), Human Player (2), Yourself (3)")
						||this.determinePlayerTurn.equals("Human Player (1), AI player strategy 1 (2), Yourself (3)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player (2), AI player strategy 2 (3)")
				||this.determinePlayerTurn.equals("Human Player(1), Yourself(2), AI player strategy 2 (3)")
						||this.determinePlayerTurn.equals("AI player strategy 2 (1), Yourself(2), Human Player (3)")
						||this.determinePlayerTurn.equals("Yourself (1), AI player strategy 2 (2), Human Player (3)")
						||this.determinePlayerTurn.equals("AI player strategy 2 (1), Human Player (2), Yourself (3)")
						||this.determinePlayerTurn.equals("Human Player (1), AI player strategy 2 (2), Yourself (3)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player (2), AI player strategy 3 (3)")
				||this.determinePlayerTurn.equals("Human Player(1), Yourself(2), AI player strategy 3 (3)")
						||this.determinePlayerTurn.equals("AI player strategy 3 (1), Yourself(2), Human Player (3)")
						||this.determinePlayerTurn.equals("Yourself (1), AI player strategy 3 (2), Human Player (3)")
						||this.determinePlayerTurn.equals("AI player strategy 3 (1), Human Player (2), Yourself (3)")
						||this.determinePlayerTurn.equals("Human Player (1), AI player strategy 3 (2), Yourself (3)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), Human Player(2)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				humanPlayer1.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Human Player(1), Yourself(2)"))
		{
			for(int i=0;i<14;i++)
			{
				humanPlayer1.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Yourself (2)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 2 (2)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Yourself (2)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 3 (2)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Yourself (2)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1(1), Yourself(2), AI player strategy 2 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2(1), Yourself(2), AI player strategy 1 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());

			}
		}
		if(this.determinePlayerTurn.equals("Yourself (1), AI player strategy 2 (2), AI player strategy 1 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		
		
		
		
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1(1), Yourself(2), AI player strategy 3 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3(1), Yourself(2), AI player strategy 1 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself (1), AI player strategy 3 (2), AI player strategy 1 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3)"))
		{
			for(int i=0;i<14;i++)
			{
				
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3)"))
		{
			for(int i=0;i<14;i++)
			{
				
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		
		//component is AI player 2 and AI player 3
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2(1), Yourself(2), AI player strategy 3 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3(1), Yourself(2), AI player strategy 2 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself (1), AI player strategy 3 (2), AI player strategy 2 (3)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		
		
		//component with three AI players
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2), AI player strategy 2 (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 1 (2), AI player strategy 3 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 2 (2), AI player strategy 1 (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 2 (2), AI player strategy 3 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 3 (2), AI player strategy 1 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("Yourself(1), AI player strategy 3 (2), AI player strategy 2 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), AI player strategy 2 (2), AI player strategy 3 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 1 (1), AI player strategy 3 (2), AI player strategy 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		
		
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), Yourself (2), AI player strategy 3 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 3 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), AI player strategy 1 (2), AI player strategy 3 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), AI player strategy 3 (2), Yourself (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 2 (1), AI player strategy 3 (2), AI player strategy 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Yourself (2), AI player strategy 1 (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), Yourself (2), AI player strategy 2 (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer4.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), AI player strategy 1 (2), Yourself (3), AI player strategy 2 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), AI player strategy 1 (2), AI player strategy 2 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), AI player strategy 2 (2), Yourself (3), AI player strategy 1 (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
			}
		}
		if(this.determinePlayerTurn.equals("AI player strategy 3 (1), AI player strategy 2 (2), AI player strategy 1 (3), Yourself (4)"))
		{
			for(int i=0;i<14;i++)
			{
				AIplayer4.draw(thedeck.myNextTiles());
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer2.draw(thedeck.myNextTiles());
				player.draw(thedeck.myNextTiles());
			}
		}
		
	}
	public RummyDeck getRiggingDeck()
	{
		return newDeck;
	}
	public Tile[] theCheckMeld()
	{
		return checkMeld;
	}
	public Player getHumanPlayer(int index)
	{
		switch (index) {
		case 1:
			return player;
		case 2:
			return humanPlayer1;
		case 3:
			return humanPlayer2;
		case 4:
			return humanPlayer3;
		default:
			throw new RuntimeException("No AI player wiht index: " + index);
		}
	}
	
	public RummyDeck getDeck()
	{
		return thedeck;
	}
	public Meld[] getTable()
	{
		return table;
	}
	
	public Meld getMeld(int index) {
		return table[index];
	}
	
	public int getTableIndex()
	{
		return tableIndex;
	}
	
	public int getTableIndexPlus1()
	{
		return tableIndex+=1;
	}
	
	public int getTableIndexMinus(int i)
	{
		return tableIndex-=i;
	}
	public int numberCheckMeld()
	{
		return numberCheckMeld;
	}
	
	public Player getTieHumanPlayer()
	{
			return tiePlayer;
		
	}
	public Player getTieAIPlayer1()
	{
			return tieAIPlayer1;
		
	}
	public RummyDeck getTieDeck()
	{
		return tieBreaker;
	}
	
	
	
	public Player getAIPlayer(int index) {
		switch (index) {
		case 1:
			return AIplayer2;
		case 2:
			return AIplayer3;
		case 3:
			return AIplayer4;
		default:
			throw new RuntimeException("No AI player wiht index: " + index);
		}
	}

	
	public void AIplayer1Play()
	{
		
		AIplayer2.initial30ToZero();
		player2DoSomethingCount=0;
		tableCountForAIPlayer1 = 0;
		System.out.println();
		System.out.println("AI Player 1 play tiles");
		System.out.println();
		 
		
		AIplayer1PlayRun();
		 
		AIPlayer1PlaySet();
		
		System.out.println();
		System.out.println();
		System.out.println("Player1 score is " + AIplayer2.getInitial30());

		AIplayer1CheckInitial30IsPass();
		
		if (player2Turn >= 2) {
			AIplayer1PutTilesIntoTableRun();
			AIplayer1PutTilesInTableSet();
			AIplayer1PlayTheRunWithTableReuse();
			AIplayer1PlaySetWithBoardReuse();
		}
		AIplayer2.printTiles();
		
		System.out.println("Player1 score is " + AIplayer2.getInitial30());
		//draw if player1 cannot play tiles
		if (player2DoSomethingCount == 0 || (AIplayer2.getInitial30()==0 && player2Turn>=2)) {
			System.out.println();
			AIplayer2.draw(thedeck.myNextTiles());
			AIplayer2.printTiles();
			System.out.println();
		}
		
		
		//display the table
		tableDisplay();
		
		System.out.println("AI player 1 have " + AIplayer2.getNumTiles() + " left");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");

		player2DoSomethingCount = 0;
		System.out.println(thedeck.theNumOfTiles());
	}
	public void AIplayer2Play()
	{
		AIplayer3.initial30ToZero();
		AIplayer3IsDoSomething=0;
		
		//AI player2 can play tiles if other players play tiles on the table
		if (tableIndex >= 1) {
			System.out.println();
			System.out.println("AI Player 2 play tiles");
			System.out.println();

			tableCountForAIPlayer2 = 0;
			AIplayer2PlayRuns();
			AIplayer2PlaySet();
			
			//display the score
			System.out.println();
			System.out.println();
			System.out.println("Player2 score is " + AIplayer3.getInitial30());
			
			//AI player 2 should draw the tiles if he/she did not pass the Initial 30 points
			player2DoSomethingForInitial30();
			
			if (AIplayer3IsDoSomething == 0 || (AIplayer3.getInitial30()==0 && player3Turn>1)) {
				System.out.println();
				AIplayer3.draw(thedeck.myNextTiles());
				AIplayer3.printTiles();
			}
			
			if (player3Turn >= 2) {
				AIplayer2PlayTheRunWithTableReuse();
				AIplayer2PlaySetWithBoardReuse();
			}
			//display the table
			tableDisplay();

			System.out.println("AI player 2 have " + AIplayer3.getNumTiles() + " left");
			System.out.println();
			System.out.println("----------------------------------------------------------------------------");

			AIplayer3IsDoSomething = 0;
		} else if (tableIndex == 0) {
			AIplayer3.draw(thedeck.myNextTiles());
		    AIplayer3.printTiles();
		}
	}
	public void AIplayer3Play()
	{
		AIplayer4.initial30ToZero();
	    player4DoSomething=0;
		System.out.println();
		System.out.println("AI Player 3 play tiles");
		System.out.println();

		tableCountForAIPlayer3 = 0;
		
		//AI player 3 Play Runs
		AIplayer3PlayRuns();
		
		//AI player 3 Play Sets
		AIplayer3PlaySet();
		
		System.out.println();
		System.out.println();
		System.out.println("Player3 score is " + AIplayer4.getInitial30());
		
		
		if (AIplayer4.getNumTiles()-player.getNumTiles()<3) {
			//AI player 3 play tiles of the run tiles of the table
			AIplayer3PlayTilesIntoTableRun();
		
			//AI player 3 play tiles of the set of the table
			AIplayer3PlayTilesIntoTableSet();
			
			//AI player 3 play tiles of the set and run of board reuse 
			AIplayer3PlayTheRunWithTableReuse();
			AIplayer3PlaySetWithBoardReuse();
			
			
		}
		AIplayer4.printTiles();
		

		if (player4DoSomething == 0 ||  (AIplayer4.getInitial30()==0 && player4Turn>1)) {
			System.out.println();
			AIplayer4.draw(thedeck.myNextTiles());
			AIplayer4.printTiles();
		}
		//display the table
		tableDisplay();
		
		System.out.println("AI player 3 have " + AIplayer4.getNumTiles() + " left");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		player4DoSomething = 0;
	}
	
	public void tableDisplay()
	{
		System.out.println();
		System.out.println();
		System.out.println("Table");
		System.out.println();
		for (int i = 0; i < (tableIndex); i++) {
			table[i].printTable();
			System.out.println("(Meld " + i + ")");
			System.out.println();
		}
		System.out.println();
	}
	public void AIplayer1PlayRun()
	{
		AIplayer2.TilesAscendingOrderByColor();
		AIplayer2.putSameNumberSameColorTilesInTheBack();
		AIplayer2.printTiles();
		System.out.println();
		int numberCount = 1;
		for (int i = 1; i < AIplayer2.getNumTiles(); i++) {
			if ((AIplayer2.theTiles()[i - 1].getColorValue() == AIplayer2.theTiles()[i].getColorValue())) {
				if (AIplayer2.theTiles()[i - 1].getValue() == AIplayer2.theTiles()[i].getValue()
						- 1)

				{
					AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i - 1];
					AIplayer2.numberCheckMeldPlus1();
					numberCount += 1;
					if (i == AIplayer2.getNumTiles() - 1) {
						if (numberCount >= 3) {
							AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i];
							AIplayer2.numberCheckMeldPlus1();
							table[tableIndex] = new Meld();
							player2DoSomethingCount += 1;
							tableCountForAIPlayer1 += 1;
							for (int j = 0; j < AIplayer2.numberCheckMeld(); j++) {
								table[tableIndex].copy(AIplayer2.theCheckMeld()[j]);
								AIplayer2.playerRecentlyPlayTilesAdd(AIplayer2.theCheckMeld()[j]);
								AIplayer2.removeTiles(table[tableIndex], j);
								AIplayer2.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

							}
							tableIndex += 1;

							AIplayer2.clearTestMeld();
						}
						AIplayer2.clearTestMeld();
						numberCount = 1;
					}

				}

				else {
					if (numberCount >= 3) {
						AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i - 1];
						AIplayer2.numberCheckMeldPlus1();
						table[tableIndex] = new Meld();
						player2DoSomethingCount += 1;
						tableCountForAIPlayer1 += 1;
						for (int j = 0; j < AIplayer2.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer2.theCheckMeld()[j]);
							AIplayer2.playerRecentlyPlayTilesAdd(AIplayer2.theCheckMeld()[j]);
							AIplayer2.removeTiles(table[tableIndex], j);
							AIplayer2.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

						}
						tableIndex += 1;

						AIplayer2.clearTestMeld();
					}
					AIplayer2.clearTestMeld();
					numberCount = 1;
				}
			} else {
				if (numberCount >= 3) {
					AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i - 1];
					AIplayer2.numberCheckMeldPlus1();
					table[tableIndex] = new Meld();
					player2DoSomethingCount += 1;
					tableCountForAIPlayer1 += 1;
					for (int j = 0; j < AIplayer2.numberCheckMeld(); j++) {
						table[tableIndex].copy(AIplayer2.theCheckMeld()[j]);
						AIplayer2.playerRecentlyPlayTilesAdd(AIplayer2.theCheckMeld()[j]);
						AIplayer2.removeTiles(table[tableIndex], j);
						AIplayer2.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

					}
					tableIndex += 1;

					AIplayer2.clearTestMeld();
				}
				AIplayer2.clearTestMeld();
				numberCount = 1;
			}
		}
	}
	
	
	public void AIPlayer1PlaySet()
	{
		AIplayer2.TilesAscendingOrderByNumber();
		AIplayer2.printTiles();
		int numberCount = 1;
		for (int i = 1; i < AIplayer2.getNumTiles(); i++) {
			if ((AIplayer2.theTiles()[i - 1].getValue() == AIplayer2.theTiles()[i].getValue())) {

				AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i - 1];
				AIplayer2.numberCheckMeldPlus1();
				numberCount += 1;

				if (i == AIplayer2.getNumTiles() - 1) {
					if (numberCount >= 3) {
						AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i];
						AIplayer2.numberCheckMeldPlus1();
						AIplayer2.MeldsAscendingSortColorNumber();

						table[tableIndex] = new Meld();
						player2DoSomethingCount += 1;
						tableCountForAIPlayer1 += 1;
						for (int j = 0; j < AIplayer2.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer2.theCheckMeld()[j]);
							AIplayer2.playerRecentlyPlayTilesAdd(AIplayer2.theCheckMeld()[j]);
							AIplayer2.removeTiles(table[tableIndex], j);
							AIplayer2.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());
						}
					   
						for (int e = 0; e < table[tableIndex].getNumOfTiles(); e++) {
							for (int f = (e + 1); f < table[tableIndex].getNumOfTiles(); f++) {
								if (table[tableIndex].getTiles()[e].getColorValue() == table[tableIndex].getTiles()[f]
										.getColorValue()) {
									AIplayer2.draw(table[tableIndex].getTiles()[e]);
									AIplayer2.recentlyTilesPlayRemove(table[tableIndex].getTiles()[f].getColorValue()
											, table[tableIndex].getTiles()[f].getValue());
									System.out.println("the recent number is" + AIplayer2.getNumberRecentlyPlayTile());
									table[tableIndex].removeTiles(e);
									AIplayer2.subtractTilesOnInitial30(
											table[tableIndex].getTiles()[e].getValue());
								}
							}
						}
						
						if (table[tableIndex].getNumOfTiles() < 3) {
							for (int c = 0; c < table[tableIndex].getNumOfTiles(); c++) {
								AIplayer2.draw(table[tableIndex].getTiles()[c]);
								AIplayer2.recentlyTilesPlayRemove(table[tableIndex].getTiles()[c].getColorValue()
										, table[tableIndex].getTiles()[c].getValue());
								System.out.println("the recent number is" + AIplayer2.getNumberRecentlyPlayTile());
								AIplayer2.subtractTilesOnInitial30(
										table[tableIndex].getTiles()[c].getValue());
							}
							 
							table[tableIndex] = null;
							tableCountForAIPlayer1 -= 1;

						} else if (table[tableIndex].getNumOfTiles() >= 3) {
							tableIndex += 1;
						}
						AIplayer2.clearTestMeld();
					}
					AIplayer2.clearTestMeld();
					numberCount = 1;
				}

			}

			else {

				if (numberCount >= 3) {
					AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()] = AIplayer2.theTiles()[i - 1];
					AIplayer2.numberCheckMeldPlus1();
					AIplayer2.MeldsAscendingSortColorNumber();

					table[tableIndex] = new Meld();
					player2DoSomethingCount += 1;
					tableCountForAIPlayer1 += 1;
					for (int j = 0; j < AIplayer2.numberCheckMeld(); j++) {
						table[tableIndex].copy(AIplayer2.theCheckMeld()[j]);
						AIplayer2.playerRecentlyPlayTilesAdd(AIplayer2.theCheckMeld()[j]);
						AIplayer2.removeTiles(table[tableIndex], j);
						AIplayer2.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());
					}
					 
					for (int e = 0; e < table[tableIndex].getNumOfTiles(); e++) {
						for (int f = (e + 1); f < table[tableIndex].getNumOfTiles(); f++) {
							if (table[tableIndex].getTiles()[e].getColorValue() == table[tableIndex].getTiles()[f]
									.getColorValue()) {
								AIplayer2.draw(table[tableIndex].getTiles()[e]);
								AIplayer2.recentlyTilesPlayRemove(table[tableIndex].getTiles()[f].getColorValue()
										, table[tableIndex].getTiles()[f].getValue());
								System.out.println("the recent number is" + AIplayer2.getNumberRecentlyPlayTile());
								table[tableIndex].removeTiles(e);
								AIplayer2.subtractTilesOnInitial30(
										table[tableIndex].getTiles()[e].getValue());
							}
						}
					}
					
					if (table[tableIndex].getNumOfTiles() < 3) {
						for (int c = 0; c < table[tableIndex].getNumOfTiles(); c++) {
							AIplayer2.draw(table[tableIndex].getTiles()[c]);
							AIplayer2.recentlyTilesPlayRemove(table[tableIndex].getTiles()[c].getColorValue()
									, table[tableIndex].getTiles()[c].getValue());
							System.out.println("the recent number is" + AIplayer2.getNumberRecentlyPlayTile());
							AIplayer2.subtractTilesOnInitial30(table[tableIndex].getTiles()[c].getValue());
						}
						table[tableIndex] = null;
						tableCountForAIPlayer1 -= 1;

					} else if (table[tableIndex].getNumOfTiles() >= 3) {
						tableIndex += 1;
					}
					AIplayer2.clearTestMeld();
				}
				AIplayer2.clearTestMeld();
				numberCount = 1;
			}
		}
	}
	
	public void AIplayer1CheckInitial30IsPass()
	{
		if (player2Turn == 1) {
			if (AIplayer2.getInitial30() >= 30) {
				player2Turn += 1;
			} else if (AIplayer2.getInitial30() < 30) {
				for (int q = (tableIndex - tableCountForAIPlayer1); q < tableIndex; q++) {
					for (int c = 0; c < table[q].getNumOfTiles(); c++) {
						AIplayer2.draw(table[q].getTiles()[c]);
					}
					table[q] = null;
				}
				AIplayer2.clearRecentlyTableTile();
				tableIndex = tableIndex - tableCountForAIPlayer1;
				player2DoSomethingCount = 0;
			}
		}
	}
	public void AIplayer1PutTilesIntoTableRun()
	{
		for (int a = 0; a < AIplayer2.getNumTiles(); a++) {
			for (int b = 0; b < tableIndex; b++) {

				if ((table[b].getTiles()[1].getValue() == table[b].getTiles()[0].getValue() + 1)
						&& (AIplayer2.theTiles()[a].getColorValue() == table[b].getTiles()[0].getColorValue()
								&& AIplayer2.theTiles()[a]
										.getValue() == table[b].getTiles()[0].getValue() - 1))

				{
					table[b].copy(AIplayer2.theTiles()[a]);
					AIplayer2.playerRecentlyPlayTilesAdd(AIplayer2.theTiles()[a]);
					AIplayer2.addTilesOnInitial30(AIplayer2.theTiles()[a].getValue());
					AIplayer2.removeItselfTiles(a);
					table[b].TilesAscendingOrderByNumber();
					player2DoSomethingCount += 1;
					
				}

			}
		}
		for (int a = 0; a < AIplayer2.getNumTiles(); a++) {
			for (int b = 0; b < tableIndex; b++) {

				if ((table[b].getTiles()[1].getValue() == table[b].getTiles()[0].getValue() + 1)
						&& (AIplayer2.theTiles()[a].getColorValue() == table[b].getTiles()[0].getColorValue()
								&& AIplayer2.theTiles()[a]
										.getValue() == table[b].getTiles()[table[b].getNumOfTiles() - 1]
												.getValue() + 1))

				{
					table[b].copy(AIplayer2.theTiles()[a]);
					AIplayer2.playerRecentlyPlayTilesAdd(AIplayer2.theTiles()[a]);
					AIplayer2.addTilesOnInitial30(AIplayer2.theTiles()[a].getValue());
					AIplayer2.removeItselfTiles(a);
					table[b].TilesAscendingOrderByNumber();
					player2DoSomethingCount += 1;
				}

			}
		}
	}
	public void AIplayer1PutTilesInTableSet()
	{
		for (int a = 0; a < AIplayer2.getNumTiles(); a++) {
			for (int b = 0; b < tableIndex; b++) {

				if ((table[b].getTiles()[0].getValue() == table[b].getTiles()[1].getValue())
						&& (table[b].getTiles()[0].getValue() == AIplayer2.theTiles()[a]
								.getValue())) {
					if (AIplayer2.checkTheSameColor(AIplayer2.theTiles()[a], table[b]) == true) {
						table[b].copy(AIplayer2.theTiles()[a]);
						AIplayer2.playerRecentlyPlayTilesAdd(AIplayer2.theTiles()[a]);
						AIplayer2.addTilesOnInitial30(AIplayer2.theTiles()[a].getValue());
						AIplayer2.removeItselfTiles(a);
						table[b].TilesAscendingOrderByNumber();
						player2DoSomethingCount += 1;
						
					}
				}
			}
		}
	}
	
	public void AIplayer2PlayRuns()
	{
		AIplayer3.TilesAscendingOrderByColor();
		AIplayer3.putSameNumberSameColorTilesInTheBack();
		AIplayer3.printTiles();
		System.out.println();
		int numberCount = 1;
		for (int i = 1; i < AIplayer3.getNumTiles(); i++) {
			if ((AIplayer3.theTiles()[i - 1].getColorValue() == AIplayer3.theTiles()[i].getColorValue())) {
				if (AIplayer3.theTiles()[i - 1].getValue() == AIplayer3.theTiles()[i].getValue()
						- 1)

				{
					AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i - 1];
					AIplayer3.numberCheckMeldPlus1();
					numberCount += 1;
					if (i == AIplayer3.getNumTiles() - 1) {
						if (numberCount >= 3) {
							AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i];
							AIplayer3.numberCheckMeldPlus1();
							table[tableIndex] = new Meld();
							AIplayer3IsDoSomething += 1;
							tableCountForAIPlayer2 += 1;
							for (int j = 0; j < AIplayer3.numberCheckMeld(); j++) {
								table[tableIndex].copy(AIplayer3.theCheckMeld()[j]);
								AIplayer3.playerRecentlyPlayTilesAdd(AIplayer3.theCheckMeld()[j]);
								AIplayer3.removeTiles(table[tableIndex], j);
								AIplayer3
										.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

							}
							tableIndex += 1;

							AIplayer3.clearTestMeld();
						}
						AIplayer3.clearTestMeld();
						numberCount = 1;
					}

				} else {
					if (numberCount >= 3) {
						AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i - 1];
						AIplayer3.numberCheckMeldPlus1();
						table[tableIndex] = new Meld();
						AIplayer3IsDoSomething += 1;
						tableCountForAIPlayer2 += 1;
						for (int j = 0; j < AIplayer3.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer3.theCheckMeld()[j]);
							AIplayer3.playerRecentlyPlayTilesAdd(AIplayer3.theCheckMeld()[j]);
							AIplayer3.removeTiles(table[tableIndex], j);
							AIplayer3.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

						}
						tableIndex += 1;
						AIplayer3.clearTestMeld();
					}
					AIplayer3.clearTestMeld();
					numberCount = 1;
				}

			} else {
				if (numberCount >= 3) {
					AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i - 1];
					AIplayer3.numberCheckMeldPlus1();
					table[tableIndex] = new Meld();
					AIplayer3IsDoSomething += 1;
					tableCountForAIPlayer2 += 1;
					for (int j = 0; j < AIplayer3.numberCheckMeld(); j++) {
						table[tableIndex].copy(AIplayer3.theCheckMeld()[j]);
						AIplayer3.playerRecentlyPlayTilesAdd(AIplayer3.theCheckMeld()[j]);
						AIplayer3.removeTiles(table[tableIndex], j);
						AIplayer3.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

					}
					tableIndex += 1;
					AIplayer3.clearTestMeld();
				}
				AIplayer3.clearTestMeld();
				numberCount = 1;
			}
		}
	}
	
	public void AIplayer2PlaySet()
	{
		AIplayer3.TilesAscendingOrderByNumber();
		AIplayer3.printTiles();
		int numberCount = 1;
		for (int i = 1; i < AIplayer3.getNumTiles(); i++) {
			if ((AIplayer3.theTiles()[i - 1].getValue() == AIplayer3.theTiles()[i]
					.getValue())) {

				AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i - 1];
				AIplayer3.numberCheckMeldPlus1();
				numberCount += 1;
				if (i == AIplayer3.getNumTiles() - 1) {
					if (numberCount >= 3) {
						AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i];
						AIplayer3.numberCheckMeldPlus1();
						AIplayer3.MeldsAscendingSortColorNumber();

						table[tableIndex] = new Meld();
						AIplayer3IsDoSomething += 1;
						tableCountForAIPlayer2 += 1;
						for (int j = 0; j < AIplayer3.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer3.theCheckMeld()[j]);
							AIplayer3.playerRecentlyPlayTilesAdd(AIplayer3.theCheckMeld()[j]);
							AIplayer3.removeTiles(table[tableIndex], j);
							AIplayer3.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());
						}
						for (int e = 0; e < table[tableIndex].getNumOfTiles(); e++) {
							for (int f = (e + 1); f < table[tableIndex].getNumOfTiles(); f++) {
								if (table[tableIndex].getTiles()[e]
										.getColorValue() == table[tableIndex].getTiles()[f].getColorValue()) {
									AIplayer3.draw(table[tableIndex].getTiles()[e]);
									AIplayer3.recentlyTilesPlayRemove(table[tableIndex].getTiles()[f].getColorValue(), 
											table[tableIndex].getTiles()[f].getValue());
									table[tableIndex].removeTiles(e);
									AIplayer3.subtractTilesOnInitial30(
											table[tableIndex].getTiles()[e].getValue());
								}
							}
						}
						if (table[tableIndex].getNumOfTiles() < 3) {
							for (int c = 0; c < table[tableIndex].getNumOfTiles(); c++) {
								AIplayer3.draw(table[tableIndex].getTiles()[c]);
								AIplayer3.recentlyTilesPlayRemove(table[tableIndex].getTiles()[c].getColorValue(), 
										table[tableIndex].getTiles()[c].getValue());
								AIplayer3.subtractTilesOnInitial30(
										table[tableIndex].getTiles()[c].getValue());

							}
							table[tableIndex] = null;
							tableCountForAIPlayer2 -= 1;
						} else if (table[tableIndex].getNumOfTiles() >= 3) {
							tableIndex += 1;
						}
						AIplayer3.clearTestMeld();
					}
					AIplayer3.clearTestMeld();
					numberCount = 1;
				}

			}

			else {

				if (numberCount >= 3) {
					AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()] = AIplayer3.theTiles()[i - 1];
					AIplayer3.numberCheckMeldPlus1();
					AIplayer3.MeldsAscendingSortColorNumber();

					table[tableIndex] = new Meld();
					AIplayer3IsDoSomething += 1;
					tableCountForAIPlayer2 += 1;
					for (int j = 0; j < AIplayer3.numberCheckMeld(); j++) {
						table[tableIndex].copy(AIplayer3.theCheckMeld()[j]);
						AIplayer3.playerRecentlyPlayTilesAdd(AIplayer3.theCheckMeld()[j]);
						AIplayer3.removeTiles(table[tableIndex], j);
						AIplayer3.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());
					}
					for (int e = 0; e < table[tableIndex].getNumOfTiles(); e++) {
						for (int f = (e + 1); f < table[tableIndex].getNumOfTiles(); f++) {
							if (table[tableIndex].getTiles()[e].getColorValue() == table[tableIndex].getTiles()[f]
									.getColorValue()) {
								AIplayer3.draw(table[tableIndex].getTiles()[e]);
								AIplayer3.recentlyTilesPlayRemove(table[tableIndex].getTiles()[f].getColorValue(), 
										table[tableIndex].getTiles()[f].getValue());
								table[tableIndex].removeTiles(e);
								AIplayer3.subtractTilesOnInitial30(
										table[tableIndex].getTiles()[e].getValue());
							}
						}
					}
					if (table[tableIndex].getNumOfTiles() < 3) {
						for (int c = 0; c < table[tableIndex].getNumOfTiles(); c++) {
							AIplayer3.draw(table[tableIndex].getTiles()[c]);
							AIplayer3.recentlyTilesPlayRemove(table[tableIndex].getTiles()[c].getColorValue(), 
									table[tableIndex].getTiles()[c].getValue());
							AIplayer3.subtractTilesOnInitial30(
									table[tableIndex].getTiles()[c].getValue());

						}
						table[tableIndex] = null;
						tableCountForAIPlayer2 -= 1;
					} else if (table[tableIndex].getNumOfTiles() >= 3) {
						tableIndex += 1;
					}
					AIplayer3.clearTestMeld();
				}
				AIplayer3.clearTestMeld();
				numberCount = 1;
			}
		}
	}
	public void player2DoSomethingForInitial30()
	{
		if (player3Turn == 1) {
			if (AIplayer3.getInitial30() >= 30) {
				player3Turn += 1;
			} else if (AIplayer3.getInitial30() < 30) {
				for (int q = (tableIndex - tableCountForAIPlayer2); q < tableIndex; q++) {
					for (int c = 0; c < table[q].getNumOfTiles(); c++) {
						AIplayer3.draw(table[q].getTiles()[c]);
					}
					table[q] = null;
				}
				AIplayer3.clearRecentlyTableTile();

				tableIndex = tableIndex - tableCountForAIPlayer2;
				AIplayer3IsDoSomething = 0;
			}
		}
	}
	
	public void AIplayer3PlayRuns()
	{
		AIplayer4.TilesAscendingOrderByColor();
		AIplayer4.putSameNumberSameColorTilesInTheBack();
		AIplayer4.printTiles();
		System.out.println();
		int numberCount = 1;
		for (int i = 1; i < AIplayer4.getNumTiles(); i++) {
			if ((AIplayer4.theTiles()[i - 1].getColorValue() == AIplayer4.theTiles()[i].getColorValue())) {
				if (AIplayer4.theTiles()[i - 1].getValue() == AIplayer4.theTiles()[i].getValue()
						- 1)

				{
					AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i - 1];
					AIplayer4.numberCheckMeldPlus1();
					numberCount += 1;
					if (i == AIplayer4.getNumTiles() - 1) {
						if (numberCount >= 3) {
							AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i];
							AIplayer4.numberCheckMeldPlus1();
							table[tableIndex] = new Meld();
							player4DoSomething += 1;
							tableCountForAIPlayer3 += 1;
							for (int j = 0; j < AIplayer4.numberCheckMeld(); j++) {
								table[tableIndex].copy(AIplayer4.theCheckMeld()[j]);
								AIplayer4.playerRecentlyPlayTilesAdd(AIplayer4.theCheckMeld()[j]);

								AIplayer4.removeTiles(table[tableIndex], j);
								AIplayer4.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

							}
							tableIndex += 1;

							AIplayer4.clearTestMeld();
						}
						AIplayer4.clearTestMeld();
						numberCount = 1;
					}

				}

				else {
					if (numberCount >= 3) {
						AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i - 1];
						AIplayer4.numberCheckMeldPlus1();
						table[tableIndex] = new Meld();
						player4DoSomething += 1;
						tableCountForAIPlayer3 += 1;
						for (int j = 0; j < AIplayer4.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer4.theCheckMeld()[j]);
							AIplayer4.playerRecentlyPlayTilesAdd(AIplayer4.theCheckMeld()[j]);
							AIplayer4.removeTiles(table[tableIndex], j);
							AIplayer4.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

						}

						tableIndex += 1;
						AIplayer4.clearTestMeld();
					}
					AIplayer4.clearTestMeld();
					numberCount = 1;
				}
			} else {
				if (numberCount >= 3) {
					AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i - 1];
					AIplayer4.numberCheckMeldPlus1();
					table[tableIndex] = new Meld();
					player4DoSomething += 1;
					tableCountForAIPlayer3 += 1;
					for (int j = 0; j < AIplayer4.numberCheckMeld(); j++) {
						table[tableIndex].copy(AIplayer4.theCheckMeld()[j]);
						AIplayer4.playerRecentlyPlayTilesAdd(AIplayer4.theCheckMeld()[j]);
						AIplayer4.removeTiles(table[tableIndex], j);
						AIplayer4.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

					}
					tableIndex += 1;
					AIplayer4.clearTestMeld();
				}
				AIplayer4.clearTestMeld();
				numberCount = 1;
			}
		}
	}
	
	public void AIplayer3PlaySet()
	{
		AIplayer4.TilesAscendingOrderByNumber();
		AIplayer4.printTiles();
		int numberCount = 1;
		for (int i = 1; i < AIplayer4.getNumTiles(); i++) {
			if ((AIplayer4.theTiles()[i - 1].getValue() == AIplayer4.theTiles()[i].getValue())) {

				AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i - 1];
				AIplayer4.numberCheckMeldPlus1();
				numberCount += 1;
				if (i == AIplayer4.getNumTiles() - 1) {
					if (numberCount >= 3) {
						AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i];
						AIplayer4.numberCheckMeldPlus1();
						AIplayer4.MeldsAscendingSortColorNumber();

						table[tableIndex] = new Meld();
						player4DoSomething += 1;
						tableCountForAIPlayer3 += 1;
						for (int j = 0; j < AIplayer4.numberCheckMeld(); j++) {
							table[tableIndex].copy(AIplayer4.theCheckMeld()[j]);
							AIplayer4.playerRecentlyPlayTilesAdd(AIplayer4.theCheckMeld()[j]);
							AIplayer4.removeTiles(table[tableIndex], j);
							AIplayer4.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

						}
						for (int e = 0; e < table[tableIndex].getNumOfTiles(); e++) {
							for (int f = (e + 1); f < table[tableIndex].getNumOfTiles(); f++) {
								if (table[tableIndex].getTiles()[e].getColorValue() == table[tableIndex].getTiles()[f]
										.getColorValue()) {
									AIplayer4.draw(table[tableIndex].getTiles()[e]);
									AIplayer4.recentlyTilesPlayRemove(table[tableIndex].getTiles()[f].getColorValue(), 
											table[tableIndex].getTiles()[f].getValue());
									table[tableIndex].removeTiles(e);
									AIplayer4.subtractTilesOnInitial30(
											table[tableIndex].getTiles()[e].getValue());

								}
							}
						}

						if (table[tableIndex].getNumOfTiles() < 3) {
							for (int c = 0; c < table[tableIndex].getNumOfTiles(); c++) {
								AIplayer4.draw(table[tableIndex].getTiles()[c]);
								AIplayer4.recentlyTilesPlayRemove(table[tableIndex].getTiles()[c].getColorValue(), 
										table[tableIndex].getTiles()[c].getValue());
								AIplayer4.subtractTilesOnInitial30(
										table[tableIndex].getTiles()[c].getValue());
							}
							table[tableIndex] = null;
							tableCountForAIPlayer3 -= 1;

						} else if (table[tableIndex].getNumOfTiles() >= 3) {
							tableIndex += 1;
						}

						AIplayer4.clearTestMeld();
					}
					AIplayer4.clearTestMeld();
					numberCount = 1;
				}

			}

			else {

				if (numberCount >= 3) {
					AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()] = AIplayer4.theTiles()[i - 1];
					AIplayer4.numberCheckMeldPlus1();
					AIplayer4.MeldsAscendingSortColorNumber();

					table[tableIndex] = new Meld();
					player4DoSomething += 1;
					tableCountForAIPlayer3 += 1;
					for (int j = 0; j < AIplayer4.numberCheckMeld(); j++) {
						table[tableIndex].copy(AIplayer4.theCheckMeld()[j]);
						AIplayer4.playerRecentlyPlayTilesAdd(AIplayer4.theCheckMeld()[j]);
						AIplayer4.removeTiles(table[tableIndex], j);
						AIplayer4.addTilesOnInitial30(table[tableIndex].getTiles()[j].getValue());

					}
					for (int e = 0; e < table[tableIndex].getNumOfTiles(); e++) {
						for (int f = (e + 1); f < table[tableIndex].getNumOfTiles(); f++) {
							if (table[tableIndex].getTiles()[e].getColorValue() == table[tableIndex].getTiles()[f]
									.getColorValue()) {
								AIplayer4.draw(table[tableIndex].getTiles()[e]);
								AIplayer4.recentlyTilesPlayRemove(table[tableIndex].getTiles()[f].getColorValue(), 
										table[tableIndex].getTiles()[f].getValue());
								table[tableIndex].removeTiles(e);
								AIplayer4.subtractTilesOnInitial30(
										table[tableIndex].getTiles()[e].getValue());

							}
						}
					}

					if (table[tableIndex].getNumOfTiles() < 3) {
						for (int c = 0; c < table[tableIndex].getNumOfTiles(); c++) {
							AIplayer4.draw(table[tableIndex].getTiles()[c]);
							AIplayer4.recentlyTilesPlayRemove(table[tableIndex].getTiles()[c].getColorValue(), 
									table[tableIndex].getTiles()[c].getValue());
							AIplayer4.subtractTilesOnInitial30(table[tableIndex].getTiles()[c].getValue());
						}
						table[tableIndex] = null;
						tableCountForAIPlayer3 -= 1;

					} else if (table[tableIndex].getNumOfTiles() >= 3) {
						tableIndex += 1;
					}

					AIplayer4.clearTestMeld();
				}
				AIplayer4.clearTestMeld();
				numberCount = 1;
			}
		}
	}
	
	public void AIplayer3DoSomethingForInitial30()
	{
		if (player4Turn == 1) {
			if (AIplayer4.getInitial30() >= 30) {
				player4Turn += 1;
			} else if (AIplayer4.getInitial30() < 30) {
				for (int q = (tableIndex - tableCountForAIPlayer3); q < tableIndex; q++) {
					for (int c = 0; c < table[q].getNumOfTiles(); c++) {
						AIplayer4.draw(table[q].getTiles()[c]);
					}
					table[q] = null;
				}
				AIplayer4.clearRecentlyTableTile();

				tableIndex = tableIndex - tableCountForAIPlayer3;
				player4DoSomething = 0;
			}
		}
	}
	public void AIplayer3PlayTilesIntoTableRun()
	{
		for (int a = 0; a < AIplayer4.getNumTiles(); a++) {
			for (int b = 0; b < tableIndex; b++) {
				if ((table[b].getTiles()[1].getValue() == table[b].getTiles()[0].getValue() + 1)
						&& (AIplayer4.theTiles()[a].getColorValue() == table[b].getTiles()[0].getColorValue()
								&& AIplayer4.theTiles()[a]
										.getValue() == table[b].getTiles()[0].getValue() - 1))

				{
					table[b].copy(AIplayer4.theTiles()[a]);
					AIplayer4.playerRecentlyPlayTilesAdd(AIplayer4.theTiles()[a]);
					AIplayer4.addTilesOnInitial30(AIplayer4.theTiles()[a].getValue());
					AIplayer4.removeItselfTiles(a);
					table[b].TilesAscendingOrderByNumber();
					player4DoSomething += 1;
				}
			}
		}
		for (int a = 0; a < AIplayer4.getNumTiles(); a++) {
			for (int b = 0; b < tableIndex; b++) {
				if ((table[b].getTiles()[1].getValue() == table[b].getTiles()[0].getValue() + 1)
						&& (AIplayer4.theTiles()[a].getColorValue() == table[b].getTiles()[0].getColorValue()
								&& AIplayer4.theTiles()[a]
										.getValue() == table[b].getTiles()[table[b].getNumOfTiles() - 1]
												.getValue() + 1))

				{
					table[b].copy(AIplayer4.theTiles()[a]);
					AIplayer4.playerRecentlyPlayTilesAdd(AIplayer4.theTiles()[a]);
					AIplayer4.addTilesOnInitial30(AIplayer4.theTiles()[a].getValue());
					AIplayer4.removeItselfTiles(a);
					table[b].TilesAscendingOrderByNumber();
					player4DoSomething += 1;
				}
			}
		}
	}
	
	public void AIplayer3PlayTilesIntoTableSet()
	{
		for (int a = 0; a < AIplayer4.getNumTiles(); a++) {
			for (int b = 0; b < tableIndex; b++) {

				if ((table[b].getTiles()[0].getValue() == table[b].getTiles()[1].getValue())
						&& (table[b].getTiles()[0].getValue() == AIplayer4.theTiles()[a]
								.getValue())) {
					if (AIplayer4.checkTheSameColor(AIplayer4.theTiles()[a], table[b]) == true) {
						table[b].copy(AIplayer4.theTiles()[a]);
						AIplayer4.playerRecentlyPlayTilesAdd(AIplayer4.theTiles()[a]);
						AIplayer4.addTilesOnInitial30(AIplayer4.theTiles()[a].getValue());
						AIplayer4.removeItselfTiles(a);
						table[b].TilesAscendingOrderByNumber();
						player4DoSomething += 1;
						
					}
				}
			}
		}
	}
	
	public void AIplayer1PlayTheRunWithTableReuse()
	{
		//one case that the player already have two tiles in hands
		AIplayer2.TilesAscendingOrderByColor();
		AIplayer2.putSameNumberSameColorTilesInTheBack();
		AIplayer2.printTiles();
		for(int i=1;i<AIplayer2.getNumTiles();i++)
		{
			if(AIplayer2.theTiles()[i].getColorValue()==AIplayer2.theTiles()[i-1].getColorValue()
					&& AIplayer2.theTiles()[i].getValue()==AIplayer2.theTiles()[i-1].getValue()+1)
			{
				AIplayer2.checkMeldAdd(AIplayer2.theTiles()[i-1]);
				AIplayer2.checkMeldAdd(AIplayer2.theTiles()[i]);
				
				for(int j=0;j<tableIndex;j++)
				{
					//find the head that table can reuse
					if(table[j].canReuseTheTiles(AIplayer2.theCheckMeld()[0].getColorValue(),AIplayer2.theCheckMeld()[0].getValue()-1))
					{
						table[j].removeTilesFindingByTiles(AIplayer2.theCheckMeld()[0].getColorValue(),
								AIplayer2.theCheckMeld()[0].getValue()-1);
						Tile t= new Tile(AIplayer2.theCheckMeld()[0].getColor(),AIplayer2.theCheckMeld()[0].getValue()-1);
						AIplayer2.checkMeldAdd(t);
						AIplayer2.MeldsAscendingOrderByColor();
						
					}
					//find the tail that table can reuse
					if(table[j].canReuseTheTiles(AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()-1].getColorValue(),
							AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()-1].getValue()+1))
					{
						table[j].removeTilesFindingByTiles(AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()-1].getColorValue(),
								AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()-1].getValue()+1);
						Tile t= new Tile(AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()-1].getColor(),
							AIplayer2.theCheckMeld()[AIplayer2.numberCheckMeld()-1].getValue()+1);
						AIplayer2.checkMeldAdd(t);
						AIplayer2.MeldsAscendingOrderByColor();
						
					}
					
					
					
				}
				
				//After reusing the table of tiles, and the new meld is valid
				if(AIplayer2.numberCheckMeld()>=3)
				{
					table[tableIndex]= new Meld();
					for(int a=0;a<AIplayer2.numberCheckMeld();a++)
					{
						table[tableIndex].copy(AIplayer2.theCheckMeld()[a]);
						AIplayer2.playerRecentlyPlayTilesAdd(AIplayer2.theCheckMeld()[a]);
						AIplayer2.addTilesOnInitial30(AIplayer2.theCheckMeld()[a].getValue());
					}
					AIplayer2.removeItselfTiles(i-1);
					AIplayer2.removeItselfTiles(i-1);
					player2DoSomethingCount+=1;
					tableIndex+=1;
				}
				AIplayer2.clearTestMeld();

			}
			
		}
		System.out.println();
		tableDisplay();
		System.out.println();
		AIplayer2.printTiles();
		
	}
	
	public void AIplayer1PlaySetWithBoardReuse()
	{
		AIplayer2.TilesAscendingOrderByNumber();
		AIplayer2.printTiles();
		for(int i=1;i<AIplayer2.getNumTiles();i++)
		{
			if(AIplayer2.theTiles()[i].getValue()==AIplayer2.theTiles()[i-1].getValue())
			{
				if(AIplayer2.theTiles()[i].getColor()==AIplayer2.theTiles()[i-1].getColor())
				{
					
				}
				else
				{
					AIplayer2.checkMeldAdd(AIplayer2.theTiles()[i-1]);
					AIplayer2.checkMeldAdd(AIplayer2.theTiles()[i]);
				}		
			}
			for(int j=0;j<tableIndex;j++)
			{
				if(table[j].canReuseTheTiles(1, AIplayer2.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Red,AIplayer2.theTiles()[i-1].getValue());
					AIplayer2.checkMeldAdd(tiles);
					if(AIplayer2.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(1, AIplayer2.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer2.checkMeldRemoveTail();
					}  
				}
				if(table[j].canReuseTheTiles(2, AIplayer2.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Green,AIplayer2.theTiles()[i-1].getValue());
					AIplayer2.checkMeldAdd(tiles);
					if(AIplayer2.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(2, AIplayer2.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer2.checkMeldRemoveTail();
					}  
				}
				if(table[j].canReuseTheTiles(3, AIplayer2.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Blue,AIplayer2.theTiles()[i-1].getValue());
					AIplayer2.checkMeldAdd(tiles);
					if(AIplayer2.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(3, AIplayer2.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer2.checkMeldRemoveTail();
					}  
				}
				if(table[j].canReuseTheTiles(4, AIplayer2.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Orange,AIplayer2.theTiles()[i-1].getValue());
					AIplayer2.checkMeldAdd(tiles);
					if(AIplayer2.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(4, AIplayer2.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer2.checkMeldRemoveTail();
					}  
				}
			}
			
			//After reusing the table of tiles, and the new meld is valid
			if(AIplayer2.numberCheckMeld()>=3)
			{
				table[tableIndex]= new Meld();
				for(int a=0;a<AIplayer2.numberCheckMeld();a++)
				{
					table[tableIndex].copy(AIplayer2.theCheckMeld()[a]);
					AIplayer2.playerRecentlyPlayTilesAdd(AIplayer2.theCheckMeld()[a]);
					AIplayer2.addTilesOnInitial30(AIplayer2.theCheckMeld()[a].getValue());
				}
				AIplayer2.removeItselfTiles(i-1);
				AIplayer2.removeItselfTiles(i-1);
				player2DoSomethingCount+=1;
				tableIndex+=1;
			}
			AIplayer2.clearTestMeld();
		}
		System.out.println();
		tableDisplay();
		System.out.println();
		AIplayer2.printTiles();
	}
	
	public void AIplayer2PlayTheRunWithTableReuse()
	{
		//one case that the player already have two tiles in hands
		AIplayer3.TilesAscendingOrderByColor();
		AIplayer3.putSameNumberSameColorTilesInTheBack();
		AIplayer3.printTiles();
		for(int i=1;i<AIplayer3.getNumTiles();i++)
		{
			if(AIplayer3.theTiles()[i].getColorValue()==AIplayer3.theTiles()[i-1].getColorValue()
					&& AIplayer3.theTiles()[i].getValue()==AIplayer3.theTiles()[i-1].getValue()+1)
			{
				AIplayer3.checkMeldAdd(AIplayer3.theTiles()[i-1]);
				AIplayer3.checkMeldAdd(AIplayer3.theTiles()[i]);
				
				for(int j=0;j<tableIndex;j++)
				{
					//find the head that table can reuse
					if(table[j].canReuseTheTiles(AIplayer3.theCheckMeld()[0].getColorValue(),AIplayer3.theCheckMeld()[0].getValue()-1))
					{
						table[j].removeTilesFindingByTiles(AIplayer3.theCheckMeld()[0].getColorValue(),
								AIplayer3.theCheckMeld()[0].getValue()-1);
						Tile t= new Tile(AIplayer3.theCheckMeld()[0].getColor(),AIplayer3.theCheckMeld()[0].getValue()-1);
						AIplayer3.checkMeldAdd(t);
						AIplayer3.MeldsAscendingOrderByColor();
						
					}
					//find the tail that table can reuse
					if(table[j].canReuseTheTiles(AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()-1].getColorValue(),
							AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()-1].getValue()+1))
					{
						table[j].removeTilesFindingByTiles(AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()-1].getColorValue(),
								AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()-1].getValue()+1);
						Tile t= new Tile(AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()-1].getColor(),
							AIplayer3.theCheckMeld()[AIplayer3.numberCheckMeld()-1].getValue()+1);
						AIplayer3.checkMeldAdd(t);
						AIplayer3.MeldsAscendingOrderByColor();
						
					}
					
					
					
				}
				
				//After reusing the table of tiles, and the new meld is valid
				if(AIplayer3.numberCheckMeld()>=3)
				{
					table[tableIndex]= new Meld();
					for(int a=0;a<AIplayer3.numberCheckMeld();a++)
					{
						table[tableIndex].copy(AIplayer3.theCheckMeld()[a]);
						AIplayer3.playerRecentlyPlayTilesAdd(AIplayer3.theCheckMeld()[a]);
						AIplayer3.addTilesOnInitial30(AIplayer3.theCheckMeld()[a].getValue());
					}
					AIplayer3.removeItselfTiles(i-1);
					AIplayer3.removeItselfTiles(i-1);
					AIplayer3IsDoSomething+=1;
					tableIndex+=1;
				}
				AIplayer3.clearTestMeld();

			}
			
		}
		System.out.println();
		tableDisplay();
		System.out.println();
		AIplayer3.printTiles();
		
	}
	
	public void AIplayer2PlaySetWithBoardReuse()
	{
		AIplayer3.TilesAscendingOrderByNumber();
		AIplayer3.printTiles();
		for(int i=1;i<AIplayer3.getNumTiles();i++)
		{
			if(AIplayer3.theTiles()[i].getValue()==AIplayer3.theTiles()[i-1].getValue())
			{
				if(AIplayer3.theTiles()[i].getColor()==AIplayer3.theTiles()[i-1].getColor())
				{
					
				}
				else
				{
					AIplayer3.checkMeldAdd(AIplayer3.theTiles()[i-1]);
					AIplayer3.checkMeldAdd(AIplayer3.theTiles()[i]);
				}		
			}
			for(int j=0;j<tableIndex;j++)
			{
				if(table[j].canReuseTheTiles(1, AIplayer3.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Red,AIplayer3.theTiles()[i-1].getValue());
					AIplayer3.checkMeldAdd(tiles);
					if(AIplayer3.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(1, AIplayer3.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer3.checkMeldRemoveTail();
					}  
				}
				if(table[j].canReuseTheTiles(2, AIplayer3.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Green,AIplayer3.theTiles()[i-1].getValue());
					AIplayer3.checkMeldAdd(tiles);
					if(AIplayer3.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(2, AIplayer3.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer3.checkMeldRemoveTail();
					}  
				}
				if(table[j].canReuseTheTiles(3, AIplayer3.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Blue,AIplayer3.theTiles()[i-1].getValue());
					AIplayer3.checkMeldAdd(tiles);
					if(AIplayer3.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(3, AIplayer3.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer3.checkMeldRemoveTail();
					}  
				}
				if(table[j].canReuseTheTiles(4, AIplayer3.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Orange,AIplayer3.theTiles()[i-1].getValue());
					AIplayer3.checkMeldAdd(tiles);
					if(AIplayer3.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(4, AIplayer3.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer3.checkMeldRemoveTail();
					}  
				}
			}
			
			//After reusing the table of tiles, and the new meld is valid
			if(AIplayer3.numberCheckMeld()>=3)
			{
				table[tableIndex]= new Meld();
				for(int a=0;a<AIplayer3.numberCheckMeld();a++)
				{
					table[tableIndex].copy(AIplayer3.theCheckMeld()[a]);
					AIplayer3.playerRecentlyPlayTilesAdd(AIplayer3.theCheckMeld()[a]);
					AIplayer3.addTilesOnInitial30(AIplayer3.theCheckMeld()[a].getValue());
				}
				AIplayer3.removeItselfTiles(i-1);
				AIplayer3.removeItselfTiles(i-1);
				AIplayer3IsDoSomething+=1;
				tableIndex+=1;
			}
			AIplayer3.clearTestMeld();
		}
		System.out.println();
		tableDisplay();
		System.out.println();
		AIplayer3.printTiles();
	}
	
	public void AIplayer3PlayTheRunWithTableReuse()
	{
		//one case that the player already have two tiles in hands
		AIplayer4.TilesAscendingOrderByColor();
		AIplayer4.putSameNumberSameColorTilesInTheBack();
		AIplayer4.printTiles();
		for(int i=1;i<AIplayer4.getNumTiles();i++)
		{
			if(AIplayer4.theTiles()[i].getColorValue()==AIplayer4.theTiles()[i-1].getColorValue()
					&& AIplayer4.theTiles()[i].getValue()==AIplayer4.theTiles()[i-1].getValue()+1)
			{
				AIplayer4.checkMeldAdd(AIplayer4.theTiles()[i-1]);
				AIplayer4.checkMeldAdd(AIplayer4.theTiles()[i]);
				
				for(int j=0;j<tableIndex;j++)
				{
					//find the head that table can reuse
					if(table[j].canReuseTheTiles(AIplayer4.theCheckMeld()[0].getColorValue(),AIplayer4.theCheckMeld()[0].getValue()-1))
					{
						table[j].removeTilesFindingByTiles(AIplayer4.theCheckMeld()[0].getColorValue(),
								AIplayer4.theCheckMeld()[0].getValue()-1);
						Tile t= new Tile(AIplayer4.theCheckMeld()[0].getColor(),AIplayer4.theCheckMeld()[0].getValue()-1);
						AIplayer4.checkMeldAdd(t);
						AIplayer4.MeldsAscendingOrderByColor();
						
					}
					//find the tail that table can reuse
					if(table[j].canReuseTheTiles(AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()-1].getColorValue(),
							AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()-1].getValue()+1))
					{
						table[j].removeTilesFindingByTiles(AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()-1].getColorValue(),
								AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()-1].getValue()+1);
						Tile t= new Tile(AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()-1].getColor(),
							AIplayer4.theCheckMeld()[AIplayer4.numberCheckMeld()-1].getValue()+1);
						AIplayer4.checkMeldAdd(t);
						AIplayer4.MeldsAscendingOrderByColor();
						
					}
					
					
					
				}
				
				//After reusing the table of tiles, and the new meld is valid
				if(AIplayer4.numberCheckMeld()>=3)
				{
					table[tableIndex]= new Meld();
					for(int a=0;a<AIplayer4.numberCheckMeld();a++)
					{
						table[tableIndex].copy(AIplayer4.theCheckMeld()[a]);
						AIplayer4.playerRecentlyPlayTilesAdd(AIplayer4.theCheckMeld()[a]);

						AIplayer4.addTilesOnInitial30(AIplayer4.theCheckMeld()[a].getValue());
					}
					AIplayer4.removeItselfTiles(i-1);
					AIplayer4.removeItselfTiles(i-1);
					player4DoSomething+=1;
					tableIndex+=1;
				}
				AIplayer4.clearTestMeld();

			}
			
		}
		System.out.println();
		tableDisplay();
		System.out.println();
		AIplayer4.printTiles();
		
	}
	
	public void AIplayer3PlaySetWithBoardReuse()
	{
		AIplayer4.TilesAscendingOrderByNumber();
		AIplayer4.printTiles();
		for(int i=1;i<AIplayer4.getNumTiles();i++)
		{
			if(AIplayer4.theTiles()[i].getValue()==AIplayer4.theTiles()[i-1].getValue())
			{
				if(AIplayer4.theTiles()[i].getColor()==AIplayer4.theTiles()[i-1].getColor())
				{
					
				}
				else
				{
					AIplayer4.checkMeldAdd(AIplayer4.theTiles()[i-1]);
					AIplayer4.checkMeldAdd(AIplayer4.theTiles()[i]);
				}		
			}
			for(int j=0;j<tableIndex;j++)
			{
				if(table[j].canReuseTheTiles(1, AIplayer4.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Red,AIplayer4.theTiles()[i-1].getValue());
					AIplayer4.checkMeldAdd(tiles);
					if(AIplayer4.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(1, AIplayer4.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer4.checkMeldRemoveTail();
					}  
				}
				if(table[j].canReuseTheTiles(2, AIplayer4.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Green,AIplayer4.theTiles()[i-1].getValue());
					AIplayer4.checkMeldAdd(tiles);
					if(AIplayer4.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(2, AIplayer4.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer4.checkMeldRemoveTail();
					}  
				}
				if(table[j].canReuseTheTiles(3, AIplayer4.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Blue,AIplayer4.theTiles()[i-1].getValue());
					AIplayer4.checkMeldAdd(tiles);
					if(AIplayer4.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(3, AIplayer4.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer4.checkMeldRemoveTail();
					}  
				}
				if(table[j].canReuseTheTiles(4, AIplayer4.theTiles()[i-1].getValue()))
				{
					Tile tiles= new Tile(TileColor.Orange,AIplayer4.theTiles()[i-1].getValue());
					AIplayer4.checkMeldAdd(tiles);
					if(AIplayer4.checkIsSet())
					{
						table[j].removeTilesFindingByTiles(4, AIplayer4.theTiles()[i-1].getValue());	
					}
					else
					{
					    AIplayer4.checkMeldRemoveTail();
					}  
				}
			}
			
			//After reusing the table of tiles, and the new meld is valid
			if(AIplayer4.numberCheckMeld()>=3)
			{
				table[tableIndex]= new Meld();
				for(int a=0;a<AIplayer4.numberCheckMeld();a++)
				{
					table[tableIndex].copy(AIplayer4.theCheckMeld()[a]);
					AIplayer4.playerRecentlyPlayTilesAdd(AIplayer4.theCheckMeld()[a]);
					AIplayer4.addTilesOnInitial30(AIplayer4.theCheckMeld()[a].getValue());
				}
				AIplayer4.removeItselfTiles(i-1);
				AIplayer4.removeItselfTiles(i-1);
				player4DoSomething+=1;
				tableIndex+=1;
			}
			AIplayer4.clearTestMeld();
		}
		System.out.println();
		tableDisplay();
		System.out.println();
		AIplayer4.printTiles();
	}
	
	public void addNewDeck(Tile newTile)
	{
		this.newDeck.getTile()[this.newDeck.theNumOfTiles()]=newTile;
		this.newDeck.theNumOfTilesPlus1();
	}
	public void removeNewDeck(TileColor color, int value)
	{
		int i=0;
		while(i<this.newDeck.theNumOfTiles())		
		{
			if(this.newDeck.getTile()[i].getColor()==color && this.newDeck.getTile()[i].getValue()==value)
			{
				break;
			}
			i+=1;
		}
		for(int j=i+1;j<this.newDeck.theNumOfTiles();j++)
		{
			this.newDeck.getTile()[j-1]=this.newDeck.getTile()[j];
			if(j==this.newDeck.theNumOfTiles()-1)
			{
				this.newDeck.getTile()[j]=null;
				this.newDeck.theNumOfTilesMinus1();
			}
		}
		/*
		if(this.newDeck.getTile()[this.newDeck.theNumOfTiles()-1].getColor()==color &&
				this.newDeck.getTile()[this.newDeck.theNumOfTiles()-1].getValue()==value)
		{
			this.newDeck.getTile()[this.newDeck.theNumOfTiles()-1]=null;
			this.newDeck.theNumOfTilesMinus1();
		}
		*/
	}
	public void checkMeldAdd(Tile newTiles)
	{
		this.checkMeld[this.numberCheckMeld]=newTiles;
		this.numberCheckMeld=this.numberCheckMeld+1;
	}
	
	public boolean checkIsSet()
	{
		if(this.numberCheckMeld<3)
		{
			return false;
		}
		if(this.numberCheckMeld>=3)
		{
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			for(int j=i+1;j<this.numberCheckMeld;j++)
			{
				if(this.checkMeld[i].getValue()==this.checkMeld[j].getValue())
				{
				
					if(this.checkMeld[i].getColorValue()==this.checkMeld[j].getColorValue())	
					{
					return false;
					}
				}
				else
				{
					if(this.checkMeld[i].getColor()==TileColor.Black || this.checkMeld[j].getColor()==TileColor.Black)
					{
						
					}
					else
					{
					return false;
					}
				}
			}
		}
		}
		//set Jokers to be the same value with another tiles in set
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			if(this.checkMeld[i].getColor()==TileColor.Black)
			{
				this.checkMeld[i].setValue(checkMeld[0].getValue());
			}
		}
		return true;
	}
	public void MeldsAscendingOrderByNumber()
	{
		Tile temp;
		
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			for(int j=i+1;j<this.numberCheckMeld;j++)
			{
				if(this.checkMeld[i].getValue()>this.checkMeld[j].getValue())
				{
					temp=this.checkMeld[i];
					this.checkMeld[i]=this.checkMeld[j];
					this.checkMeld[j]=temp;
				}
			}
		}
	}
	public boolean checkIsRun()
	{
		MeldsAscendingOrderByNumber();
		if(this.numberCheckMeld<3)
		{
			return false;
		}
		if(this.numberCheckMeld>=3)
		{
			for(int i=1;i<numberCheckMeld;i++)
			{
				if((this.checkMeld[i].getValue()==this.checkMeld[i-1].getValue()+1)
						&& this.checkMeld[i-1].getColorValue()== this.checkMeld[i].getColorValue())
				{		
				}
				else
				{
					if(this.checkMeld[i-1].getColor()==TileColor.Black)
					{
						
					}
					if(this.checkMeld[this.numberCheckMeld-1].getColor()==TileColor.Black)
					{
						this.checkMeld[this.numberCheckMeld-1].setValue(this.checkMeld[i-1].getValue()+1);
						MeldsAscendingOrderByNumber();
					}
					else
					{
					return false;
					}
				}
			}
		}
		return true;
	}
	public void clearTestMeld()
	{
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			this.checkMeld[i]=null;
		}
		this.numberCheckMeld=0;
	}
	
}
