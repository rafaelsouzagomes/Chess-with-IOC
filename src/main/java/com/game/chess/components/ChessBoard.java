package com.game.chess.components;

import org.springframework.stereotype.Component;

@Component
public class ChessBoard {

	public ChessSquare[][] chessBoard;
	
	public void setChessBoard(ChessSquare[][] chessBoard) {
		this.chessBoard = chessBoard;
	}
}
