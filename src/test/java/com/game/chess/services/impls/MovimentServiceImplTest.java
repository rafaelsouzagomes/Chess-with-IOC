package com.game.chess.services.impls;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.game.chess.components.ChessBoard;
import com.game.chess.dtos.MovimentRequestDTO;

class MovimentServiceImplTest {
	
	@Autowired
	MovimentServiceImpl movService;

	@Test
	void shouldReturnInitMovsForPawns() {
	
		MovimentRequestDTO mov = new MovimentRequestDTO();
		ChessBoard chessBoard = new ChessBoard();
		
		
		mov.setChessboard(chessBoard);
		movService.getMovimentOptions(mov);
	}

}
