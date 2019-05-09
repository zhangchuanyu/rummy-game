package com.rummyGame;

public class Player 
{
	private String name;
	private Tile[] tiles= new Tile[100];
	private Tile[] checkMeld= new Tile[20];
	private Tile[] tableReuseMeld= new Tile[20];
	private int numOfTiles;
	private int numberCheckMeld;
	private int numberTableReuseMeld;
	private int countInCheckTilesFunction=0;
	private int tableIndex=0;
	private int initial30;
	
	private Tile[] showRecentlyPlayTiles= new Tile[30];
	private int numOfRecentlyPlayTiles=0;

	
	public Player(String theName)
	{
		this.name=theName;
		this.noTiles();
	}

	public void noTiles()
	{
		for(int t=0;t<100;t++)
		{
			this.tiles[t]=null;
		}
		for(int t=0;t<20;t++)
		{
			this.checkMeld[t]=null;
		}
		
		
	this.numOfTiles=0;
	this.numberCheckMeld=0;
	this.numberTableReuseMeld=0;
	this.countInCheckTilesFunction=0;
	this.initial30=0;
	}
	
	public int getInitial30()
	{
		return initial30;
	}
	
	public int addTilesOnInitial30(int tilesnumber)
	{
		return initial30+=tilesnumber;
	}
	
	public int subtractTilesOnInitial30(int tilesnumber)
	{
		return initial30-=tilesnumber;
	}
	public int initial30ToZero()
	{
		return initial30=0;
	}
	public int getNumTiles()
	{
		return numOfTiles;
	}
	public Tile[] theTiles()
	{
		return tiles;
	}
	public Tile[] theCheckMeld()
	{
		return checkMeld;
	}
	public Tile[] getTableReuseMeld()
	{
		return tableReuseMeld;
	}
	
	public Tile[] getPlayerRecentlyTile()
	{
		return showRecentlyPlayTiles;
	}
	
	
	public int getNumberRecentlyPlayTile()
	{
		return numOfRecentlyPlayTiles;
	}
	
	public int numberCheckMeld()
	{
		return numberCheckMeld;
	}
	public int getNumberTableReuse()
	{
		return numberTableReuseMeld;
	}
	public int numberCheckMeldPlus1()
	{
		return numberCheckMeld= numberCheckMeld+=1;
	}
	
	public void draw(Tile newTiles)
	{
		this.tiles[this.numOfTiles]=newTiles;
		this.numOfTiles=this.numOfTiles+1;
	}
	
	public void checkMeldAdd(Tile newTiles)
	{
		this.checkMeld[this.numberCheckMeld]=newTiles;
		this.numberCheckMeld=this.numberCheckMeld+1;
	}
	public void tableReuseMeldAdd(Tile newTiles)
	{
		this.tableReuseMeld[this.numberTableReuseMeld]= newTiles;
		this.numberTableReuseMeld+=1;
	}
	
	public void playerRecentlyPlayTilesAdd(Tile newTiles)
	{
		this.showRecentlyPlayTiles[this.numOfRecentlyPlayTiles]= newTiles;
		this.numOfRecentlyPlayTiles+=1;
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
	public void MeldsAscendingSortColorNumber()
	{
		Tile temp;
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			for(int j=i+1;j<this.numberCheckMeld;j++)
			{
				if(this.checkMeld[i].getColorValue()>this.checkMeld[j].getColorValue())
				{
					temp=this.checkMeld[i];
					this.checkMeld[i]=this.checkMeld[j];
					this.checkMeld[j]=temp;
				}
			}
		}
	}
	public void MeldsAscendingOrderByColor()
	{
		Tile temp;
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			for(int j=i+1;j<this.numberCheckMeld;j++)
			{
				if(this.checkMeld[i].getColorValue()>this.checkMeld[j].getColorValue())
				{
					temp=this.checkMeld[i];
					this.checkMeld[i]=this.checkMeld[j];
					this.checkMeld[j]=temp;
				}
			}
		}
		
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			for(int j=i+1;j<this.numberCheckMeld;j++)
			{
				if((this.checkMeld[i].getValue()>this.checkMeld[j].getValue())
						&& (this.checkMeld[i].getColorValue()==this.checkMeld[j].getColorValue()))
				{
					temp=this.checkMeld[i];
					this.checkMeld[i]=this.checkMeld[j];
					this.checkMeld[j]=temp;
				}
			}
		}
		
	}
	public void putSameNumberSameColorTilesInTheBack()
	{
		Tile temp;
		for(int i=1;i<this.numOfTiles;i++)
		{
			if(this.tiles[i-1].getValue()==this.tiles[i].getValue()
					&& this.tiles[i-1].getColorValue()==this.tiles[i].getColorValue())
			{
				temp=this.tiles[i-1];
			    for(int j=i;j<this.numOfTiles;j++)
			    {
			    	this.tiles[j-1]=this.tiles[j];
			    }
			    this.tiles[this.numOfTiles-1]=temp;
			}
		}
	}
	
	public boolean checkIsTilesCorrect(String s,int index)
	{
		int theColor = 0;
		int tilesNumber=0;
		switch(s)
		{
		case "1 Re":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=1;
			tilesNumber=1;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			
			break;
		case "2 Re":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=1;
			tilesNumber=2;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "3 Re":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=1;
			tilesNumber=3;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "4 Re":
			theColor=1;
			tilesNumber=4;
			break;
		case "5 Re":
			theColor=1;
			tilesNumber=5;
			break;
		case "6 Re":
			theColor=1;
			tilesNumber=6;
			break;
		case "7 Re":
			theColor=1;
			tilesNumber=7;
			break;
		case "8 Re":
			theColor=1;
			tilesNumber=8;
			break;
		case "9 Re":
			theColor=1;
			tilesNumber=9;
			break;
		case "10 R":
			theColor=1;
			tilesNumber=10;
			break;
		case "11 R":
			theColor=1;
			tilesNumber=11;
			this.countInCheckTilesFunction+=1;
			break;
		case "12 R":
			theColor=1;
			tilesNumber=12;			
			this.countInCheckTilesFunction+=1;
			break;
		case "13 R":
			theColor=1;
			tilesNumber=13;
			this.countInCheckTilesFunction+=1;
			break;
		case "1 Gr":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=2;
			tilesNumber=1;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "2 Gr":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=2;
			tilesNumber=2;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;

		case "3 Gr":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=2;
			tilesNumber=3;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;

		case "4 Gr":
			theColor=2;
			tilesNumber=4;
			break;

		case "5 Gr":
			theColor=2;
			tilesNumber=5;
			break;

		case "6 Gr":
			theColor=2;
			tilesNumber=6;
			break;

		case "7 Gr":
			theColor=2;
			tilesNumber=7;
			break;

		case "8 Gr":
			theColor=2;
			tilesNumber=8;
			break;

		case "9 Gr":
			theColor=2;
			tilesNumber=9;
			break;

		case "10 G":
			theColor=2;
			tilesNumber=10;
			break;

		case "11 G":
			theColor=2;
			tilesNumber=11;
			this.countInCheckTilesFunction+=1;
			break;

		case "12 G":
			theColor=2;
			tilesNumber=12;
			this.countInCheckTilesFunction+=1;
			break;

		case "13 G":
			theColor=2;
			tilesNumber=13;
			this.countInCheckTilesFunction+=1;
			break;
		case "1 Bl":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=3;
			tilesNumber=1;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "2 Bl":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=3;
			tilesNumber=2;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "3 Bl":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=3;
			tilesNumber=3;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "4 Bl":
			theColor=3;
			tilesNumber=4;
			break;
		case "5 Bl":
			theColor=3;
			tilesNumber=5;
			break;
		case "6 Bl":
			theColor=3;
			tilesNumber=6;
			break;
		case "7 Bl":
			theColor=3;
			tilesNumber=7;
			break;
		case "8 Bl":
			theColor=3;
			tilesNumber=8;
			break;
		case "9 Bl":
			theColor=3;
			tilesNumber=9;
			break;
		case "10 B":
			theColor=3;
			tilesNumber=10;
			break;
		case "11 B":
			theColor=3;
			tilesNumber=11;
			this.countInCheckTilesFunction+=1;
			break;
		case "12 B":
			theColor=3;
			tilesNumber=12;
			this.countInCheckTilesFunction+=1;
			break;
		case "13 B":
			theColor=3;
			tilesNumber=13;
			this.countInCheckTilesFunction+=1;
			break;
		case "1 Or":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=4;
			tilesNumber=1;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "2 Or":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=4;
			tilesNumber=2;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "3 Or":
			if(this.countInCheckTilesFunction==0)
			{
			theColor=4;
			tilesNumber=3;
			}
			else if(this.countInCheckTilesFunction==1)
			{
			theColor=0;
			tilesNumber=0;
			this.countInCheckTilesFunction=0;
			}
			break;
		case "4 Or":
			theColor=4;
			tilesNumber=4;
			break;
		case "5 Or":
			theColor=4;
			tilesNumber=5;
			break;
		case "6 Or":
			theColor=4;
			tilesNumber=6;
			break;
		case "7 Or":
			theColor=4;
			tilesNumber=7;
			break;
		case "8 Or":
			theColor=4;
			tilesNumber=8;
			break;
		case "9 Or":
			theColor=4;
			tilesNumber=9;
			break;
		case "10 O":
			theColor=4;
			tilesNumber=10;
			break;
		case "11 O":
			theColor=4;
			tilesNumber=11;
			this.countInCheckTilesFunction+=1;
			break;
		case "12 O":
			theColor=4;
			tilesNumber=12;
			this.countInCheckTilesFunction+=1;
			break;
		case "13 O":
			theColor=4;
			tilesNumber=13;
			this.countInCheckTilesFunction+=1;
			break;
		
		
		}
		for (int i=0;i<this.numOfTiles;i++)
		{		
			if((theColor==this.tiles[i].getColorValue())&& (tilesNumber==this.tiles[i].getValue()))
			{
				this.checkMeld[numberCheckMeld]=this.tiles[i];
				this.numberCheckMeld+=1;
				return true;
		    }
			
		}
		return false;
		
		
	}
	public boolean checkTheSameColor(Tile tiles,Meld table)
	{
		for(int i=0;i<table.getNumOfTiles();i++)
		{
			if(tiles.getColorValue()==table.getTiles()[i].getColorValue())
			{
				return false;
			}
		}
		return true;
	}
	public boolean checkInitial30()
	{
		int totalNumber=0;
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			totalNumber=totalNumber+this.checkMeld[i].getValue();
		}
		if(totalNumber>=30)
		{
			return true;
		}
		return false;
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
	
	public boolean checkMeldWithDifferentColor()
	{
		if(this.numberCheckMeld<3)
		{
			return false;
		}
		if(this.numberCheckMeld>=3)
		{
			for(int i=1;i<numberCheckMeld;i++)
			{
				if(this.checkMeld[i].getColorValue()==this.checkMeld[i-1].getColorValue())
				{
					return false;
				}
				else
				{
					if((this.checkMeld[i].getValue()==this.checkMeld[i-1].getValue()))
				
					{		
				
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
	public boolean checkPutTilesInTableInRun(Meld t)
	{
		
		if(this.checkMeld[0].getColor()==TileColor.Black)
		{
			return true;
		}
		for(int i=0;i<t.getNumOfTiles();i++)
		{
			if((this.checkMeld[0].getValue()==t.getTiles()[i].getValue()-1)
					&& this.checkMeld[0].getColorValue()==t.getTiles()[i].getColorValue())
			{
				return true;
			}
			
		}
		if((this.checkMeld[0].getValue()==t.getTiles()[t.getNumOfTiles()-1].getValue()+1)
				&& this.checkMeld[0].getColorValue()==t.getTiles()[t.getNumOfTiles()-1].getColorValue())
		{
			return true;
		}
		return false;
	}
	public boolean checkPutTilesInTableInSet(Meld t)
	{
		if(this.checkMeld[0].getColor()==TileColor.Black)
		{
			return true;
		}
		for(int i=0;i<t.getNumOfTiles();i++)
		{
			if(this.checkMeld[0].getValue()==t.getTiles()[i].getValue())
			{
				if(this.checkMeld[0].getColorValue()==t.getTiles()[i].getColorValue())
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	public void removeTiles(Meld t,int tableIndex)
	{
		int currentIndex=0;
		while(currentIndex<this.numOfTiles)
		{
			if(this.tiles[currentIndex].toString().equals(t.getTiles()[tableIndex].toString()))
			{
				break;
				
			}
			currentIndex++;
		}
		for(int i=currentIndex+1;i<this.numOfTiles;i++)
		{
			this.tiles[i-1]=this.tiles[i];
		}
		
		this.tiles[this.numOfTiles-1] = null;
		this.numOfTiles--;
	}
	
	public void removeItselfTiles(int index)
	{
		for(int i=(index+1);i<this.numOfTiles;i++)
		{   
			this.tiles[i-1]=this.tiles[i];
		}
		this.numOfTiles=this.numOfTiles-1;
	}
	public void removeTheTiles()
	{
		int currentIndex=0;
		while(currentIndex<this.numOfTiles)
		{
			if(this.tiles[currentIndex].toString().equals(this.checkMeld[0].toString()))
			{
				break;
				
			}
			currentIndex+=1;
		}
		for(int i=currentIndex+1;i<this.numOfTiles;i++)
		{
			this.tiles[i-1]=this.tiles[i];
			if(i==this.numOfTiles-1)
			{
				this.tiles[i]=null;
				this.numOfTiles-=1;
			}
		}
		
		if(this.tiles[this.numOfTiles-1].toString().equals(this.checkMeld[0].toString()))
		{
			this.tiles[this.numOfTiles-1]=null;
			this.numOfTiles-=1;
		}
	}
	
	public void removeTheTilesByGivenDetail(int colorNumber,int value)
	{
		int i=0;
		while(i<this.numOfTiles)		
		{
			if(tiles[i].getColorValue()==colorNumber && tiles[i].getValue()==value)
			{
				break;
			}
			i+=1;
		}
		for(int j=i+1;j<this.numOfTiles;j++)
		{
			this.tiles[j-1]=this.tiles[j];
			if(j==this.numOfTiles-1)
			{
				this.tiles[j]=null;
				this.numOfTiles-=1;
			}
		}
		if(this.tiles[this.numOfTiles-1].getColorValue()==colorNumber &&
				this.tiles[this.numOfTiles-1].getValue()==value)
		{
			this.tiles[this.numOfTiles-1]=null;
			
			this.numOfTiles-=1;
			
		}
	}
	
	public void recentlyTilesPlayRemove(int colorNumber, int value)
	{
		int i=0;
		while(i<this.numOfRecentlyPlayTiles)		
		{
			if(this.showRecentlyPlayTiles[i].getColorValue()==colorNumber && this.showRecentlyPlayTiles[i].getValue()==value)
			{
				break;
			}
			i+=1;
		}
		for(int j=i+1;j<this.numOfRecentlyPlayTiles;j++)
		{
			this.showRecentlyPlayTiles[j-1]=this.showRecentlyPlayTiles[j];
			if(j==this.numOfRecentlyPlayTiles-1)
			{
				this.showRecentlyPlayTiles[j]=null;
				this.numOfRecentlyPlayTiles-=1;
			}
		}
		
	}
	public void checkMeldRemoveTail()
	{
		this.checkMeld[this.numberCheckMeld-1]=null;
		this.numberCheckMeld=this.numberCheckMeld-1;
	}
	public void clearTiles()
	{
		for(int i=0;i<this.numOfTiles;i++)
		{
			this.tiles[i]=null;
		}
		this.numOfTiles=0;
	}
	public void clearTestMeld()
	{
		for(int i=0;i<this.numberCheckMeld;i++)
		{
			this.checkMeld[i]=null;
		}
		this.numberCheckMeld=0;
	}
	
	public void clearTableReuseMeld()
	{
		for(int i=0;i<this.numberTableReuseMeld;i++)
		{
			this.tableReuseMeld[i]=null;
		}
		this.numberTableReuseMeld=0;
	}
	
	public void clearRecentlyTableTile()
	{
		for(int i=0;i<this.numOfRecentlyPlayTiles;i++)
		{
			this.showRecentlyPlayTiles[i]=null;
		}
		this.numOfRecentlyPlayTiles=0;
	}
	public void printTiles()
	{
		System.out.println(this.name);
		for (int i=0;i<this.numOfTiles;i++)
		{
		System.out.print("(" + this.tiles[i].toString()+ ")" +" ");
		}

	}
	public void printCheckMeldTiles()
	{
		for (int i=0;i<this.numberCheckMeld;i++)
		{
		System.out.println(this.checkMeld[i].toString());
		}

	}
	
	
}
