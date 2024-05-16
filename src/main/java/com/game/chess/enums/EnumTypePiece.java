package com.game.chess.enums;

public enum EnumTypePiece {

	PAWN("P", "Pawn",1), 
	ROOK("R", "Rook", 5), 
	KNIGHT("N", "Knight", 3), 
	BISHOP("B", "Bishop", 3), 
	QUEEN("Q", "Queen", 9),
	KING("K", "King", 0);
	
	private String abr; 
	private String name; 
	private int points;
	
	EnumTypePiece(String abr, String name, int points){
		this.abr = abr;
		this.name = name;
		this.points = points;
	}
	
	public String getAbr() {
		return abr;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPoints() {
		return points;
	}
	
}
