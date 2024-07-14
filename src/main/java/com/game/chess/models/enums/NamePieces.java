 package com.game.chess.models.enums;

import java.util.ArrayList;
import java.util.List;

public class NamePieces {

	public static final String ROOK= "Rook";
	public static final String PAWN = "Pawn";
	public static final String KNIGHT = "Knight";
	public static final String BISHOP = "Bishop";
	public static final String QUEEN = "Queen";
	public static final String KING = "King";
	
	public static List<String> pieces;
	
	static {
		pieces.add(ROOK);
		pieces.add(PAWN);
		pieces.add(KNIGHT);
		pieces.add(BISHOP);
		pieces.add(QUEEN);
		pieces.add(KING);
	}
	
	public static List<String> getPieces() {
		return new ArrayList<>(pieces);
	}
	
}
