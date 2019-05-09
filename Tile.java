package com.rummyGame;

public class Tile {
	private TileColor color;
	private int value;

	public Tile(TileColor color, int value) {
		this.color = color;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int i)
	{
		this.value=i;
	}
	public TileColor getColor() 
	{
		return color;
	}

	public int getColorValue() {
		return color.getValue();
	}
	
	public boolean isJoker() {
		return color == TileColor.Black;
	}
	
	public String valueToString()
	{
		String theValue= Integer.toString(value);
		if(color==TileColor.Black)
		{
			theValue ="JOKERS";
		}
		return theValue;
	}

	public String toString() {
		return valueToString() + " " + color.toString();
	}

}
