package com.game.chess.services.impls;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.models.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.models.dtos.MovimentRequestDTO;
import com.game.chess.services.components.squareboard.SquareBoard;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MovimentServiceImplTest {
	
	@Autowired
	MovimentServiceImpl service;

	@Test
	@Disabled
    void validate() {
		MovimentRequestDTO movDTO = new MovimentRequestDTO();
		movDTO.setTeam("Black");
		movDTO.setCurrentPosition("C5");
		movDTO.setPieceToMove("Bishop");
		
		
		MovimentOptionsAvailableDTO movimentOptions = service.getMovimentOptions(movDTO);
		List<SquareBoard> moves = movimentOptions.getChessSquaresAvailable();
		assertEquals(7, moves.size());
	}
}
