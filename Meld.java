package com.rummyGame;

public class Meld 
{
	
	private int numOfTiles;
	private Tile[] tiles= new Tile[100];
	private Tile[] checkMeld= new Tile[100];

	private int numberCheckMeld=0;

	
	public Meld()
	{
		this.noTiles();
	}
	public void noTiles()
	{
		for(int t=0;t<100;t++)
		{
			this.tiles[t]=null;
		}
		this.numOfTiles=0;
	}
	public Tile[] theCheckMeld()
	{
		return checkMeld;
	}
	public int getNumOfTiles()
	{
		return numOfTiles;
	}
	public int numberCheckMeld()
	{
		return numberCheckMeld;
	}
	public void copy(Tile newTiles)
	{
		this.tiles[this.numOfTiles]=newTiles;
		this.numOfTiles=this.numOfTiles+1;
	}
	
	public Tile[] getTiles()
	{
		return tiles;
	}
	public void checkMeldAdd(Tile newTiles)
	{
		this.checkMeld[this.numberCheckMeld]=newTiles;
		this.numberCheckMeld=this.numberCheckMeld+1;
	}
	public void checkMeld2Add(Tile newTiles)
	{
		this.checkMeld[this.numberCheckMeld]=newTiles;
		this.numberCheckMeld=this.numberCheckMeld+1;
	}
	public void TilesAscendingOrderByNumber()
	{
		Tile temp;
		
		for(int i=0;i<this.numOfTiles;i++)
		{
			for(int j=i+1;j<this.numOfTiles;j++)
			{
				if(this.tiles[i].getValue()>this.tiles[j].getValue())
				{
					temp=this.tiles[i];
					this.tiles[i]=this.tiles[j];
					this.tiles[j]=temp;
				}
			}
		}
	}
	public void TilesAscendingOrderByColor()
	{
		Tile temp;
		for(int i=0;i<this.numOfTiles;i++)
		{
			for(int j=i+1;j<this.numOfTiles;j++)
			{
				if(this.tiles[i].getColorValue()>this.tiles[j].getColorValue())
				{
					temp=this.tiles[i];
					this.tiles[i]=this.tiles[j];
					this.tiles[j]=temp;
				}
			}
		}
		
		for(int i=0;i<this.numOfTiles;i++)
		{
			for(int j=i+1;j<this.numOfTiles;j++)
			{
				if((this.tiles[i].getValue()>this.tiles[j].getValue())
						&& (this.tiles[i].getColorValue()==this.tiles[j].getColorValue()))
				{
					temp=this.tiles[i];
					this.tiles[i]=this.tiles[j];
					this.tiles[j]=temp;
				}
			}
		}
		
	}
	
	public MeldType getType()
	{
		if(this.tiles[0].getValue()==this.tiles[1].getValue())
		{
			return MeldType.SET;
		}
		return MeldType.RUN;
	}
	
	public boolean isHead(int colorNumber,int tilesNumber)
	{
		if(colorNumber==tiles[0].getColorValue()&& tilesNumber==tiles[0].getValue())
		{
			return true;
		}
		return false;
	}
	public boolean isTail(int colorNumber,int tilesNumber)
	{
		if(colorNumber==tiles[numOfTiles-1].getColorValue()&& tilesNumber==tiles[numOfTiles-1].getValue())
		{
			return true;
		}
		return false;
	}
	
	public boolean canReuseTheTiles(int colorNumber,int tilesNumber)
	{
		if(containTiles(colorNumber,tilesNumber))
		{		
			if(this.numOfTiles>3)		
			{			
				if(getType()==MeldType.SET)			
				{
				return true;		
				}		
				else if (getType()==MeldType.RUN)		
				{
					if(isHead(colorNumber,tilesNumber) || isTail(colorNumber,tilesNumber))
					{
						return true;
					}
					
					if(this.numOfTiles>=7)
					{
						System.out.println(numOfTiles);
						for(int i=3;i<numOfTiles-3;i++)
						{
							if(colorNumber==tiles[i].getColorValue()&& tilesNumber==tiles[i].getValue())
							{
								return true;
							}
						}
					}
					
				}
			}
		}
		return false;
	}
	
	public boolean checkIsRun()
	{
		if(this.numOfTiles<3)
		{
			return false;
		}

		TilesAscendingOrderByNumber();
		int numOfJokers = 0;
		for (int i = numOfTiles - 1; i >=0; i--) { 
			if (tiles[i].isJoker()) {
				numOfJokers++;
			}
		}
		
		if (numOfJokers > 2) {
			throw new RuntimeException("Number of jokers: " + numOfJokers);
		}
		
		int numOfJokersUsed = 0;
		for(int i=1;i<numOfTiles-numOfJokers;i++) {
			if (this.tiles[i-1].getColorValue()!= this.tiles[i].getColorValue()) {
				return false;
			}
			
			if (this.tiles[i].getValue() - this.tiles[i-1].getValue() > numOfJokers + 1) {
				return false;
			} 
			
			if (this.tiles[i].getValue() - this.tiles[i-1].getValue() == 2) {
				this.tiles[this.numOfTiles-1].setValue(this.tiles[i-1].getValue()+1);
				numOfJokersUsed = 1;
			} else if(this.tiles[i].getValue() - this.tiles[i-1].getValue() == 3) {
				this.tiles[this.numOfTiles-1].setValue(this.tiles[i-1].getValue()+1);
				this.tiles[this.numOfTiles-2].setValue(this.tiles[i-1].getValue()+2);
				numOfJokersUsed = 2;
			}
		}
		TilesAscendingOrderByNumber();
		if (numOfJokersUsed != numOfJokers) {
			if (tiles[0].getValue() > 1) {
				this.tiles[numOfTiles-1].setValue(tiles[0].getValue()-1);
			} else {
				this.tiles[numOfTiles-1].setValue(tiles[numOfTiles-1-numOfJokers].getValue()+1);
			}
		}
		TilesAscendingOrderByNumber();
		return true;
	}
	
	public boolean checkIsSet()
	{
		if(this.numOfTiles<3)
		{
			return false;
		}
		if(this.numOfTiles>=3)
		{
		for(int i=0;i<this.numOfTiles;i++)
		{
			for(int j=i+1;j<this.numOfTiles;j++)
			{
				if(this.tiles[i].getValue()==this.tiles[j].getValue())
				{
				
					if(this.tiles[i].getColorValue()==this.tiles[j].getColorValue())	
					{
					return false;
					}
				}
				else
				{
					if(this.tiles[i].getColor()==TileColor.Black || this.tiles[j].getColor()==TileColor.Black)
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
		for(int i=0;i<this.numOfTiles;i++)
		{
			if(this.tiles[i].getColor()==TileColor.Black)
			{
				this.tiles[i].setValue(tiles[0].getValue());
			}
		}
		return true;
	}
	
	public boolean containTiles(int colorNumber,int tilesNumber)
	{
		for(int i=0;i<numOfTiles;i++)
		{
			if(colorNumber==tiles[i].getColorValue() && tilesNumber==tiles[i].getValue())
			{
				return true;
			}
		}
		return false;
	}
	public void removeTilesTail()
	{
		this.tiles[this.numOfTiles-1]=null;
		this.numOfTiles--;
	}
	
	public void removeTiles(int index)
	{
		for(int i=(index+1);i<this.numOfTiles;i++)
		{   
			this.tiles[i-1]=this.tiles[i];
		}
		
		this.tiles[this.numOfTiles-1] = null;
		this.numOfTiles--;
	}

	public void removeTilesFindingByTiles(int ColorNumber,int tilesNumber)
	{
		for(int i=0;i<numOfTiles;i++)
		{
			if(ColorNumber==tiles[i].getColorValue() && tilesNumber==tiles[i].getValue())
			{
				removeTiles(i);
			}
		}
	}
	
	public void clearTestMeld()
	{
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			this.checkMeld[i]=null;
		}
		this.numberCheckMeld=0;
	}
	public void printTable()
	{
		
		for (int i=0;i<this.numOfTiles;i++)
		{
		System.out.print(this.tiles[i].toString() + " ");
		}

	}
	
	
	

	

}
