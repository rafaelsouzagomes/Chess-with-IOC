package com.game.chess.components;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;
import com.game.chess.factories.ChessSquareFactory;

@Component
public class ChessBoard {

	public ChessSquare[][] chessBoard;
	
	
	private ChessSquareFactory chessSquareFactory;
	
	@PostConstruct
	public void initCheBoardDefault() {
		chessBoard = new ChessSquare[8][8];
		chessBoard[0][0] = chessSquareFactory.build(EnumTypePiece.ROOK, EnumTeam.BLACK, EnumNameNotaionSquare.A8);
		
		
	}
	
	@Autowired
	public void setChessBoard(ChessSquare[][] chessBoard) {
		this.chessBoard = chessBoard;
	}
	
	@Autowired
	public void setChessSquareFactory(ChessSquareFactory chessSquareFactory) {
		this.chessSquareFactory = chessSquareFactory;
	}
}
