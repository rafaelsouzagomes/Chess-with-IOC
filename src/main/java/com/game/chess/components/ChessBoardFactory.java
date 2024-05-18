package com.game.chess.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.components.chessSquare.SquareBoard;
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
		boardFactory.addSquare_A8(EnumTypePiece.ROOK, EnumTeam.BLACK);
	    boardFactory.addSquare_B8(EnumTypePiece.KNIGHT, EnumTeam.BLACK);
	    boardFactory.addSquare_C8(EnumTypePiece.BISHOP, EnumTeam.BLACK);
	    boardFactory.addSquare_D8(EnumTypePiece.QUEEN, EnumTeam.BLACK);
	    boardFactory.addSquare_E8(EnumTypePiece.KING, EnumTeam.BLACK);
	    boardFactory.addSquare_F8(EnumTypePiece.BISHOP, EnumTeam.BLACK);
	    boardFactory.addSquare_G8(EnumTypePiece.KNIGHT, EnumTeam.BLACK);
	    boardFactory.addSquare_H8(EnumTypePiece.ROOK, EnumTeam.BLACK);

	    boardFactory.addSquare_A7(EnumTypePiece.PAWN, EnumTeam.BLACK);
	    boardFactory.addSquare_B7(EnumTypePiece.PAWN, EnumTeam.BLACK);
	    boardFactory.addSquare_C7(EnumTypePiece.PAWN, EnumTeam.BLACK);
	    boardFactory.addSquare_D7(EnumTypePiece.PAWN, EnumTeam.BLACK);
	    boardFactory.addSquare_E7(EnumTypePiece.PAWN, EnumTeam.BLACK);
	    boardFactory.addSquare_F7(EnumTypePiece.PAWN, EnumTeam.BLACK);
	    boardFactory.addSquare_G7(EnumTypePiece.PAWN, EnumTeam.BLACK);
	    boardFactory.addSquare_H7(EnumTypePiece.PAWN, EnumTeam.BLACK);

	    boardFactory.addSquare_A6();
	    boardFactory.addSquare_B6();
	    boardFactory.addSquare_C6();
	    boardFactory.addSquare_D6();
	    boardFactory.addSquare_E6();
	    boardFactory.addSquare_F6();
	    boardFactory.addSquare_G6();
	    boardFactory.addSquare_H6();

	    boardFactory.addSquare_A5();
	    boardFactory.addSquare_B5();
	    boardFactory.addSquare_C5();
	    boardFactory.addSquare_D5();
	    boardFactory.addSquare_E5();
	    boardFactory.addSquare_F5();
	    boardFactory.addSquare_G5();
	    boardFactory.addSquare_H5();

	    boardFactory.addSquare_A4();
	    boardFactory.addSquare_B4();
	    boardFactory.addSquare_C4();
	    boardFactory.addSquare_D4();
	    boardFactory.addSquare_E4();
	    boardFactory.addSquare_F4();
	    boardFactory.addSquare_G4();
	    boardFactory.addSquare_H4();

	    boardFactory.addSquare_A3();
	    boardFactory.addSquare_B3();
	    boardFactory.addSquare_C3();
	    boardFactory.addSquare_D3();
	    boardFactory.addSquare_E3();
	    boardFactory.addSquare_F3();
	    boardFactory.addSquare_G3();
	    boardFactory.addSquare_H3();

	    boardFactory.addSquare_A2(EnumTypePiece.PAWN, EnumTeam.WHITE);
	    boardFactory.addSquare_B2(EnumTypePiece.PAWN, EnumTeam.WHITE);
	    boardFactory.addSquare_C2(EnumTypePiece.PAWN, EnumTeam.WHITE);
	    boardFactory.addSquare_D2(EnumTypePiece.PAWN, EnumTeam.WHITE);
	    boardFactory.addSquare_E2(EnumTypePiece.PAWN, EnumTeam.WHITE);
	    boardFactory.addSquare_F2(EnumTypePiece.PAWN, EnumTeam.WHITE);
	    boardFactory.addSquare_G2(EnumTypePiece.PAWN, EnumTeam.WHITE);
	    boardFactory.addSquare_H2(EnumTypePiece.PAWN, EnumTeam.WHITE);

	    boardFactory.addSquare_A1(EnumTypePiece.ROOK, EnumTeam.WHITE);
	    boardFactory.addSquare_B1(EnumTypePiece.KNIGHT, EnumTeam.WHITE);
	    boardFactory.addSquare_C1(EnumTypePiece.BISHOP, EnumTeam.WHITE);
	    boardFactory.addSquare_D1(EnumTypePiece.QUEEN, EnumTeam.WHITE);
	    boardFactory.addSquare_E1(EnumTypePiece.KING, EnumTeam.WHITE);
	    boardFactory.addSquare_F1(EnumTypePiece.BISHOP, EnumTeam.WHITE);
	    boardFactory.addSquare_G1(EnumTypePiece.KNIGHT, EnumTeam.WHITE);
	    boardFactory.addSquare_H1(EnumTypePiece.ROOK, EnumTeam.WHITE);
	}
	
	@Autowired
	public void setBoardFactory(Board8x8Factory boardFactory) {
		this.boardFactory = boardFactory;
	}
}
