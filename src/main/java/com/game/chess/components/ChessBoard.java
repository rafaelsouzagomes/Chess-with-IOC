package com.game.chess.components;

import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.game.chess.components.chessSquare.ChessSquare;
import com.game.chess.components.chessSquare.ChessSquareFactory;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

@Component
public class ChessBoard {

	public ChessSquare[][] chessBoard;
	
	
	private ChessSquareFactory chessSquareFactory;
	
	@PostConstruct
	public void initCheBoardDefault() {
		initBoard();
	}
	
	@Autowired
	public void setChessBoard(ChessSquare[][] chessBoard) {
		this.chessBoard = chessBoard;
	}
	
	@Autowired
	public void setChessSquareFactory(ChessSquareFactory chessSquareFactory) {
		this.chessSquareFactory = chessSquareFactory;
	}
	
	public void showBoard(){
		Objects.requireNonNull(chessBoard);
		for(int line=0; line < chessBoard.length; line++) {
			for(int column=0; column < chessBoard[0].length; column++) {
				ChessSquare chessSquare = chessBoard[line][column];
				if(chessSquare.isEmpty()) 
					System.out.print(" [ "+chessSquare.getNameNotationSquare()+" ] ");
				else
					System.out.print(" ["+ chessSquare.getPiece().toString()+" ] ");
			}
			System.out.println("");
		}
	}
	
	private void initBoard() {
		chessBoard = new ChessSquare[8][8];
		chessBoard[0][0] = chessSquareFactory.build(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.A8);
		chessBoard[0][1] = chessSquareFactory.build(EnumTypePiece.KNIGHT, EnumTeam.BLACK, EnumNameNotaionSquare.B8);
		chessBoard[0][2] = chessSquareFactory.build(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.C8);
		chessBoard[0][3] = chessSquareFactory.build(EnumTypePiece.QUEEN, EnumTeam.BLACK, EnumNameNotaionSquare.D8);
		chessBoard[0][4] = chessSquareFactory.build(EnumTypePiece.KING, EnumTeam.BLACK, EnumNameNotaionSquare.E8);
		chessBoard[0][5] = chessSquareFactory.build(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.F8);
		chessBoard[0][6] = chessSquareFactory.build(EnumTypePiece.KNIGHT, EnumTeam.BLACK, EnumNameNotaionSquare.G8);
		chessBoard[0][7] = chessSquareFactory.build(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.H8);
				
		chessBoard[1][0] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.A7);
		chessBoard[1][1] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.B7);
		chessBoard[1][2] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.C7);
		chessBoard[1][3] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.D7);
		chessBoard[1][4] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.E7);
		chessBoard[1][5] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.F7);
		chessBoard[1][6] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.G7);
		chessBoard[1][7] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.BLACK, EnumNameNotaionSquare.H7);
		
		chessBoard[2][0] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.A6);
		chessBoard[2][1] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.B6);
		chessBoard[2][2] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.C6);
		chessBoard[2][3] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.D6);
		chessBoard[2][4] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.E6);
		chessBoard[2][5] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.F6);
		chessBoard[2][6] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.G6);
		chessBoard[2][7] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.H6);
		
		chessBoard[3][0] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.A5);
		chessBoard[3][1] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.B5);
		chessBoard[3][2] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.C5);
		chessBoard[3][3] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.D5);
		chessBoard[3][4] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.E5);
		chessBoard[3][5] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.F5);
		chessBoard[3][6] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.G5);
		chessBoard[3][7] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.H5);
		
		chessBoard[4][0] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.A4);
		chessBoard[4][1] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.B4);
		chessBoard[4][2] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.C4);
		chessBoard[4][3] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.D4);
		chessBoard[4][4] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.E4);
		chessBoard[4][5] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.F4);
		chessBoard[4][6] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.G4);
		chessBoard[4][7] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.H4);
		
		chessBoard[5][0] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.A3);
		chessBoard[5][1] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.B3);
		chessBoard[5][2] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.C3);
		chessBoard[5][3] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.D3);
		chessBoard[5][4] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.E3);
		chessBoard[5][5] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.F3);
		chessBoard[5][6] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.G3);
		chessBoard[5][7] = chessSquareFactory.buildEmpty(EnumNameNotaionSquare.H3);
		
		chessBoard[6][0] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.A2);
		chessBoard[6][1] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.B2);
		chessBoard[6][2] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.C2);
		chessBoard[6][3] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.D2);
		chessBoard[6][4] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.E2);
		chessBoard[6][5] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.F2);
		chessBoard[6][6] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.G2);
		chessBoard[6][7] = chessSquareFactory.build(EnumTypePiece.PAWN, EnumTeam.WHITE, EnumNameNotaionSquare.H2);
		
		chessBoard[7][0] = chessSquareFactory.build(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.A1);
		chessBoard[7][1] = chessSquareFactory.build(EnumTypePiece.KNIGHT, EnumTeam.BLACK, EnumNameNotaionSquare.B1);
		chessBoard[7][2] = chessSquareFactory.build(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.C1);
		chessBoard[7][3] = chessSquareFactory.build(EnumTypePiece.KING, EnumTeam.BLACK, EnumNameNotaionSquare.D1);
		chessBoard[7][4] = chessSquareFactory.build(EnumTypePiece.QUEEN, EnumTeam.BLACK, EnumNameNotaionSquare.E1);
		chessBoard[7][5] = chessSquareFactory.build(EnumTypePiece.BISHOP, EnumTeam.BLACK, EnumNameNotaionSquare.F1);
		chessBoard[7][6] = chessSquareFactory.build(EnumTypePiece.KNIGHT, EnumTeam.BLACK, EnumNameNotaionSquare.G1);
		chessBoard[7][7] = chessSquareFactory.build(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.H1);
	}
}
