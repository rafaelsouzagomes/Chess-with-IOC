package com.game.chess.services.impls.piece;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.components.IBoard;
import com.game.chess.configs.CustomTestConfig;
import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.pawn.ITeamManager;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(CustomTestConfig.class)
class MovimentOptionsTest {
	
	@Autowired
	@Qualifier("whitePawnTeamManager")
	private ITeamManager WhitePawnTeamManager;
	
	@Autowired
	@Qualifier("blackPawnTeamManager")
	private ITeamManager blackPawnTeamManager;
	
	@Autowired
	private IBoard chessBoard;
	
	@Autowired
	private IMovimentOptions movOptions;

	@BeforeEach
    void setUp() {
        chessBoard.createNewGame();
        movOptions.setChessBoard(chessBoard);
        movOptions.setTeamManager(blackPawnTeamManager);
    }
	  
	@Test
	void invalid_moviment_in_init_chessBoard() {
		movOptions.addMove(0, 0);
		MovimentOptionsAvailableDTO movimentsOptions = movOptions.getMovimentsOptions();
		assertEquals(0, movimentsOptions.getChessSquaresAvailable().size());
	}
	
	  
	@Test
	void valid_moviment_in_init_chessBoard() {
		movOptions.addMove(4, 2);
		MovimentOptionsAvailableDTO movimentsOptions = movOptions.getMovimentsOptions();
		assertEquals(1, movimentsOptions.getChessSquaresAvailable().size());
	}

}
