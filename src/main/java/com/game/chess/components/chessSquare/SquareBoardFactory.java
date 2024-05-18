package com.game.chess.components.chessSquare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.components.piece.Piece;
import com.game.chess.components.piece.PieceFactory;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

@Service
public class SquareBoardFactory {
	
	private PieceFactory pieceFactory;

	public SquareBoard build(EnumTypePiece typePiece, EnumTeam team, EnumNameNotaionSquare notationSquare) {
		Piece piece = pieceFactory.build(typePiece, team);
		SquareBoard cs = new SquareBoard();
		cs.setNameNotationSquare(notationSquare);
		cs.setPiece(piece);
		return cs;
	}
	
	public SquareBoard buildEmpty(EnumNameNotaionSquare notationSquare) {
		SquareBoard cs = new SquareBoard();
		cs.setNameNotationSquare(notationSquare);
		return cs;
	}
	
	@Autowired
	public void setPieceFactory(PieceFactory pieceFactory) {
		this.pieceFactory = pieceFactory;
	}

}
