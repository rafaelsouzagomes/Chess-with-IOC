package com.game.chess.services.impls.piece;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.config.TestConfig;
import com.game.chess.dtos.MovimentOptionsAvailable;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@ContextConfiguration(classes = TestConfig.class)
class PawnMovimentServiceTest {

    @Autowired
    private PawnMovimentService pawnMovimentService;

    @Autowired
    private ChessBoard chessBoard;

    @BeforeEach
    void setUp() {
        chessBoard.createNewGame();
        pawnMovimentService.setChessBoard(chessBoard);
    }

    @Test
    void validateBlackPawnMovimentsInChessBoardInit() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("G7");
        request.setTeam(EnumTeam.BLACK.getName());

        MovimentOptionsAvailable result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(2, moves.size());
        assertEquals(EnumNameNotaionSquare.G6, moves.get(0).getNameNotationSquare());
        assertEquals(EnumNameNotaionSquare.G5, moves.get(1).getNameNotationSquare());
    }
    
    
    @Test
    void validateBlackPawnMovimentsInChessBoardInit_V2() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("A7");
        request.setTeam(EnumTeam.BLACK.getName());

        MovimentOptionsAvailable result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(2, moves.size());
        assertEquals(EnumNameNotaionSquare.A6, moves.get(0).getNameNotationSquare());
        assertEquals(EnumNameNotaionSquare.A5, moves.get(1).getNameNotationSquare());
    }
    
    @Test
    void validateBlackPawnMovimentsInChessBoardInit_V3() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("F3");
        request.setTeam(EnumTeam.BLACK.getName());

        MovimentOptionsAvailable result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(2, moves.size());
        assertEquals(EnumNameNotaionSquare.E2, moves.get(0).getNameNotationSquare());
        assertEquals(EnumNameNotaionSquare.G2, moves.get(1).getNameNotationSquare());
    }
    
    @Test
    void validateWhitePawnMovimentsInChessBoardInit() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("F2");
        request.setTeam(EnumTeam.WHITE.getName());

        MovimentOptionsAvailable result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(2, moves.size());
        assertEquals(EnumNameNotaionSquare.F3, moves.get(0).getNameNotationSquare());
        assertEquals(EnumNameNotaionSquare.F4, moves.get(1).getNameNotationSquare());
    }
    
    @Test
    void validateWhitePawnMovimentsInChessBoardInit_V2() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("G6");
        request.setTeam(EnumTeam.WHITE.getName());

        MovimentOptionsAvailable result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(2, moves.size());
        assertEquals(EnumNameNotaionSquare.F7, moves.get(0).getNameNotationSquare());
        assertEquals(EnumNameNotaionSquare.H7, moves.get(1).getNameNotationSquare());
    }
    
    @Test
    void validateWhitePawnMovimentsInChessBoardInit_V3() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("G1");
        request.setTeam(EnumTeam.WHITE.getName());

        MovimentOptionsAvailable result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(0, moves.size());
    }
}
