package com.rummyGame;

import org.junit.Assert;
import org.junit.Test;


public class GameTest {

	//test question 1
	@Test
	public void testInitial14TilesOfEachPlayer()
	{
		GameGUI game= new GameGUI("");
		
		game.init();
		
		Assert.assertEquals("Incorrect number of Tiles of each Player", 14, game.getHumanPlayer(0).getNumTiles());

		for(int i=1;i<=3;i++)
		{
			Assert.assertEquals("Incorrect number of Tiles of each Player", 14, game.getAIPlayer(i).getNumTiles());

		}
	}
	
	//test question 1
	
	
	

}
