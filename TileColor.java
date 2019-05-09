package com.rummyGame;

public enum TileColor {
	Red(1), Green(2),  Blue(3),Orange(4),Black(5);

	private final int value;

	TileColor(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
