package com.rummyGame;

import java.util.Random;



public class RummyDeck 
{
   


private int TileNumber;
   
   private Tile[] myTiles;
   
   public RummyDeck(boolean shuffle)
   {
	   this.TileNumber= 106;
	   this.myTiles= new Tile[this.TileNumber];
	   
	   int tile=0;
		for (int d = 0; d < 2; d++) {

					for (int n = 13; n > 0; n--) {
						for (int s = 0; s < 4; s++) {

					this.myTiles[tile] = new Tile(TileColor.values()[s], n);
					tile= tile+1;
				}
			}
		}
		for (int i=0;i<2;i++)
		{
			this.myTiles[tile]= new Tile(TileColor.Black,20);
			tile=tile+1;
		}
	 
	if(shuffle==true)
	{
		this.shuffle();
	}

	   
   }
   public Tile[] getTile()
   {
	   return myTiles;
   }
   
   public int theNumOfTiles()
   {
	   return this.TileNumber;
   }
   public int theNumOfTilesMinus1()
   {
	   return this.TileNumber-=1;
   }
   public int theNumOfTilesPlus1()
   {
	   return this.TileNumber+=1;
   }
   public void shuffle()
   {
	   Random tiles= new Random();
	   
	   Tile temp;
	   int k;
	   
	   for (int i = 0; i < this.TileNumber; i++) {
			k = tiles.nextInt(this.TileNumber);

			temp = this.myTiles[i];
			this.myTiles[i] = this.myTiles[k];
			this.myTiles[k] = temp;
		}
   }
   public Tile myNextTiles() {
		Tile firstCard = this.myTiles[0];

		for (int i = 1; i < this.TileNumber; i++) {
			this.myTiles[i - 1] = this.myTiles[i];
		}

		this.myTiles[this.TileNumber - 1] = null;
		this.TileNumber = this.TileNumber - 1;
		return firstCard;
	}
   
   public void print(int num) {
		for (int t = 0; t < num; t++) {
			System.out.println((t + 1) + " " + this.TileNumber + " " + this.myTiles[t].toString() + " "
					+ this.myTiles[t].getValue());
		}

		System.out.println(this.TileNumber - num);
}
}
