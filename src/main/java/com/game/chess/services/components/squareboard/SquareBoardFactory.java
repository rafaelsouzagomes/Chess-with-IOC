package com.game.chess.services.components.squareboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.enums.EnumTypePiece;
import com.game.chess.services.components.piece.Piece;
import com.game.chess.services.components.piece.PieceBuilder;

@Service
public class SquareBoardFactory {
	
	private PieceBuilder pieceFactory;

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
	public void setPieceFactory(PieceBuilder pieceFactory) {
		this.pieceFactory = pieceFactory;
	}

}
