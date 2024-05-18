package com.game.chess.components;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.game.chess.components.chessSquare.ChessSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

@Service
public class ChessBoardFactory {
	
	private ChessSquare[][] chessBoard;
	
	@PostConstruct
	public void initCheBoardDefault8x8() {
		chessBoard = new ChessSquare[8][8];
	}

	public void addSquare_A8(EnumTypePiece rook, EnumTeam black) {
		
	}

}
