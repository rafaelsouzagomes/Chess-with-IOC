package com.game.chess.dtos;

import org.springframework.lang.NonNull;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.Piece;

public class MovimentRequestDTO {

	@NonNull
	private ChessBoard chessboard;
	
	@NonNull
	private Piece pieceToMove;
}
