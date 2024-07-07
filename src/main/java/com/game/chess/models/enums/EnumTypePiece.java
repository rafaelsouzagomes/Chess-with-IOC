package com.game.chess.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumTypePiece {

	PAWN("P", NamePieces.PAWN,1), 
	ROOK("R", NamePieces.ROOK, 5), 
	KNIGHT("N", NamePieces.KNIGHT, 3), 
	BISHOP("B", NamePieces.BISHOP, 3), 
	QUEEN("Q", NamePieces.QUEEN, 9),
	KING("K", NamePieces.KING, 0);
	
	private String abr; 
	private String name; 
	private int points;
	
	private static final Map<String, EnumTypePiece> ENUM_MAP;
	
	static {
		ENUM_MAP = new HashMap<>();

		for (EnumTypePiece instance : EnumTypePiece.values()) {
            ENUM_MAP.put(instance.getName(), instance);
        }
    }
	
    public static EnumTypePiece get(String value) {
        return ENUM_MAP.get(value);
    }
	
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
