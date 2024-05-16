package com.game.chess.components.chessSquare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.components.piece.Piece;
import com.game.chess.components.piece.PieceFactory;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

@Service
public class ChessSquareFactory {
	
	private PieceFactory pieceFactory;

	public ChessSquare build(EnumTypePiece typePiece, EnumTeam team, EnumNameNotaionSquare notationSquare) {
		Piece piece = pieceFactory.build(typePiece, team);
		ChessSquare cs = new ChessSquare();
		cs.setNameNotationSquare(notationSquare);
		cs.setPiece(piece);
		return cs;
	}
	
	public ChessSquare buildEmpty(EnumNameNotaionSquare notationSquare) {
		ChessSquare cs = new ChessSquare();
		cs.setNameNotationSquare(notationSquare);
		return cs;
	}
	
	@Autowired
	public void setPieceFactory(PieceFactory pieceFactory) {
		this.pieceFactory = pieceFactory;
	}

}
