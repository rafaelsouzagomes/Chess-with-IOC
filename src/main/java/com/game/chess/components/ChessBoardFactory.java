package com.game.chess.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

@Service
public class ChessBoardFactory implements GameBoardFactory {

	private Board8x8Factory boardFactory;
	
	@Override
	public SquareBoard[][] build() {
		createFields();
		return boardFactory.build();
	}

	private void createFields() {
	    boardFactory.addSquare(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.A8);
	    boardFactory.addSquare(EnumTypePiece.KNIGHT, EnumTeam.BLACK, EnumNameNotaionSquare.B8);
	    boardFactory.addSquare(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.C8);
	    boardFactory.addSquare(EnumTypePiece.QUEEN, EnumTeam.BLACK, EnumNameNotaionSquare.D8);
	    boardFactory.addSquare(EnumTypePiece.KING, EnumTeam.BLACK, EnumNameNotaionSquare.E8);
	    boardFactory.addSquare(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.F8);
	    boardFactory.addSquare(EnumTypePiece.KNIGHT, EnumTeam.BLACK, EnumNameNotaionSquare.G8);
	    boardFactory.addSquare(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.H8);

	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.A7);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.B7);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.C7);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.D7);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.E7);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.F7);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.G7);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.H7);

	    boardFactory.addSquare_empty(EnumNameNotaionSquare.A6);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.B6);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.C6);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.D6);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.E6);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.F6);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.G6);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.H6);

	    boardFactory.addSquare_empty(EnumNameNotaionSquare.A5);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.B5);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.C5);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.D5);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.E5);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.F5);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.G5);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.H5);

	    boardFactory.addSquare_empty(EnumNameNotaionSquare.A4);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.B4);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.C4);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.D4);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.E4);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.F4);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.G4);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.H4);

	    boardFactory.addSquare_empty(EnumNameNotaionSquare.A3);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.B3);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.C3);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.D3);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.E3);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.F3);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.G3);
	    boardFactory.addSquare_empty(EnumNameNotaionSquare.H3);

	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.A2);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.B2);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.C2);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.D2);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.E2);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.F2);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.G2);
	    boardFactory.addSquare(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.H2);

	    boardFactory.addSquare(EnumTypePiece.ROOK, EnumTeam.WHITE, EnumNameNotaionSquare.A1);
	    boardFactory.addSquare(EnumTypePiece.KNIGHT, EnumTeam.WHITE, EnumNameNotaionSquare.B1);
	    boardFactory.addSquare(EnumTypePiece.BISHOP, EnumTeam.WHITE, EnumNameNotaionSquare.C1);
	    boardFactory.addSquare(EnumTypePiece.QUEEN, EnumTeam.WHITE, EnumNameNotaionSquare.D1);
	    boardFactory.addSquare(EnumTypePiece.KING, EnumTeam.WHITE, EnumNameNotaionSquare.E1);
	    boardFactory.addSquare(EnumTypePiece.BISHOP, EnumTeam.WHITE, EnumNameNotaionSquare.F1);
	    boardFactory.addSquare(EnumTypePiece.KNIGHT, EnumTeam.WHITE, EnumNameNotaionSquare.G1);
	    boardFactory.addSquare(EnumTypePiece.ROOK, EnumTeam.WHITE, EnumNameNotaionSquare.H1);
	}


	
	@Autowired
	public void setBoardFactory(Board8x8Factory boardFactory) {
		this.boardFactory = boardFactory;
	}
}
