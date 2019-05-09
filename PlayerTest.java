package com.rummyGame;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

	//Qusetion 1
	@Test
	public void testAscendingOrderByDifferentColor() {
		Player player = new Player("player");
		player.draw(new Tile(TileColor.Blue, 1));
		player.draw(new Tile(TileColor.Red, 1));
		player.draw(new Tile(TileColor.Green, 1));
		player.draw(new Tile(TileColor.Orange, 1));
		player.draw(new Tile(TileColor.Red, 2));

		player.TilesAscendingOrderByColor();
		Assert.assertEquals("Incorrect tile color", TileColor.Red, player.theTiles()[0].getColor());
		Assert.assertEquals("Incorrect tile color", TileColor.Red, player.theTiles()[1].getColor());
		Assert.assertEquals("Incorrect tile color", TileColor.Green, player.theTiles()[2].getColor());
		Assert.assertEquals("Incorrect tile color", TileColor.Blue, player.theTiles()[3].getColor());
		Assert.assertEquals("Incorrect tile color", TileColor.Orange, player.theTiles()[4].getColor());
	}
	
	//Question 1
	@Test
	public void testAscendingOrderByNumber()
	{
		Player player= new Player("player");
		player.draw(new Tile(TileColor.Blue, 1));
		player.draw(new Tile(TileColor.Red, 1));
		player.draw(new Tile(TileColor.Red, 4));
		player.draw(new Tile(TileColor.Red, 5));
		player.draw(new Tile(TileColor.Green, 1));
		player.draw(new Tile(TileColor.Orange, 1));
		player.draw(new Tile(TileColor.Orange, 5));
		player.draw(new Tile(TileColor.Red, 2));
		
		player.TilesAscendingOrderByNumber();
		Assert.assertEquals("Incorrect tile number", 1, player.theTiles()[0].getValue());
		Assert.assertEquals("Incorrect tile number", 1, player.theTiles()[1].getValue());
		Assert.assertEquals("Incorrect tile number", 1, player.theTiles()[2].getValue());
		Assert.assertEquals("Incorrect tile number", 1, player.theTiles()[3].getValue());
		Assert.assertEquals("Incorrect tile number", 2, player.theTiles()[4].getValue());
		Assert.assertEquals("Incorrect tile number", 4, player.theTiles()[5].getValue());
		Assert.assertEquals("Incorrect tile number", 5, player.theTiles()[6].getValue());
		Assert.assertEquals("Incorrect tile number", 5, player.theTiles()[7].getValue());

	}
	
	//Question 4
	@Test
	public void testInitial30()
	{
		//Player play one meld exactly 30 points
		GameGUI game= new GameGUI("");
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 9));
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 10));
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 11));
		
		game.AIplayer1Play();
		Assert.assertEquals("The meld points is not equal to 30", 30, game.getAIPlayer(1).getInitial30());
		
		//Player play one meld more than 30 points
		game.getAIPlayer(1).draw(new Tile(TileColor.Blue, 11));
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 11));
		game.getAIPlayer(1).draw(new Tile(TileColor.Orange, 11));
		
		game.AIplayer1Play();
		Assert.assertEquals("The meld points is not equal to 33", 33, game.getAIPlayer(1).getInitial30());
		
		//player play serveral melds adding up to 30 points
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 1));
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 2));
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 3));
		game.getAIPlayer(1).draw(new Tile(TileColor.Blue, 8));
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 8));
		game.getAIPlayer(1).draw(new Tile(TileColor.Orange, 8));
		
		game.AIplayer1Play();
		Assert.assertEquals("The meld points is not equal to 30", 30, game.getAIPlayer(1).getInitial30());
		
		//player play serveral melds adding up to 30 points
				
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 1));
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 2));
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 3));
		game.getAIPlayer(1).draw(new Tile(TileColor.Blue, 11));
		game.getAIPlayer(1).draw(new Tile(TileColor.Red, 11));
		game.getAIPlayer(1).draw(new Tile(TileColor.Orange, 11));
		game.AIplayer1Play();
		Assert.assertEquals("The meld points is not equal to 39", 39, game.getAIPlayer(1).getInitial30());


		
		
	}
	
}
