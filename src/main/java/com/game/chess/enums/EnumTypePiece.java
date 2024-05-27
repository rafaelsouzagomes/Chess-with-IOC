package com.game.chess.enums;

public enum EnumTypePiece {

	PAWN("P", NamePieces.PAWN,1), 
	ROOK("R", NamePieces.ROOK, 5), 
	KNIGHT("N", NamePieces.KNIGHT, 3), 
	BISHOP("B", NamePieces.BISHOP, 3), 
	QUEEN("Q", NamePieces.QUEEN, 9),
	KING("K", NamePieces.King, 0);
	
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

	public boolean isPawn() {
		return getName()==EnumTypePiece.PAWN.getName();
	}
	
}
