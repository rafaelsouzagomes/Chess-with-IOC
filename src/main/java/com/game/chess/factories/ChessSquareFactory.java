package com.game.chess.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.components.ChessSquare;
import com.game.chess.components.Piece;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

@Service
public class ChessSquareFactory {
	
	@Autowired
	private PieceFactory pieceFactory;

	public ChessSquare build(EnumTypePiece rook, EnumTeam black, EnumNameNotaionSquare a8) {
		Piece piece = 
		
		
		ChessSquare cs = new ChessSquare();
		cs.setNameNotationSquare(a8);
		cs.setPiece(piece);
		return null;
	}

}
