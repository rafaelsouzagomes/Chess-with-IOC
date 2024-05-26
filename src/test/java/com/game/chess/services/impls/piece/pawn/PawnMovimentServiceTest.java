package com.game.chess.services.impls.piece.pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.configs.CustomTestConfig;
import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.services.impls.piece.MovimentOptions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(CustomTestConfig.class)
class PawnMovimentServiceTest {

    @Autowired
    private PawnMovimentService pawnMovimentService;

    @Autowired
    private ChessBoard chessBoard;
    
    @Autowired
    private MovimentOptions movimentOptions;

    @BeforeEach
    void setUp() {
        chessBoard.createNewGame();
        pawnMovimentService.setChessBoard(chessBoard);
        pawnMovimentService.setiMovimentOptions(movimentOptions);
    }

    @Test
    void validateBlackPawnMovimentsInChessBoardInit() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("G7");
        request.setTeam(EnumTeam.BLACK.getName());

        MovimentOptionsAvailableDTO result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(2, moves.size());
        assertEquals(EnumNameNotaionSquare.G6, moves.get(0).getNameNotationSquare());
        assertEquals(EnumNameNotaionSquare.G5, moves.get(1).getNameNotationSquare());
    }
    
    @Test
    void validateBlackPawnMovimentsInChessBoardInit_1() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("G6");
        request.setTeam(EnumTeam.BLACK.getName());

        MovimentOptionsAvailableDTO result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(1, moves.size());
        assertEquals(EnumNameNotaionSquare.G5, moves.get(0).getNameNotationSquare());
    }
    
    
    @Test
    void validateBlackPawnMovimentsInChessBoardInit_V2() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("A7");
        request.setTeam(EnumTeam.BLACK.getName());

        MovimentOptionsAvailableDTO result = pawnMovimentService.findMovimentsAvailable(request);

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

        MovimentOptionsAvailableDTO result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        for(SquareBoard move: moves) {
        	System.out.println("Resultado: " + move.getNameNotationSquare());
        }
        
        assertEquals(2, moves.size());
        assertEquals(EnumNameNotaionSquare.E2, moves.get(0).getNameNotationSquare());
        assertEquals(EnumNameNotaionSquare.G2, moves.get(1).getNameNotationSquare());
    }
    
    @Test
    void validateWhitePawnMovimentsInChessBoardInit() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("F2");
        request.setTeam(EnumTeam.WHITE.getName());

        MovimentOptionsAvailableDTO result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(2, moves.size());
        
        for(SquareBoard move: moves) {
        	System.out.println("Resultado: " + move.getNameNotationSquare());
        }
        assertEquals(EnumNameNotaionSquare.F3, moves.get(0).getNameNotationSquare());
        assertEquals(EnumNameNotaionSquare.F4, moves.get(1).getNameNotationSquare());
    }
    
    @Test
    void validateWhitePawnMovimentsInChessBoardInit_V2() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("G6");
        request.setTeam(EnumTeam.WHITE.getName());

        MovimentOptionsAvailableDTO result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();
        for(SquareBoard move: moves) {
        	System.out.println("Resultado: " + move.getNameNotationSquare());
        }
        
        assertEquals(2, moves.size());
        assertEquals(EnumNameNotaionSquare.F7, moves.get(0).getNameNotationSquare());
        assertEquals(EnumNameNotaionSquare.H7, moves.get(1).getNameNotationSquare());
    }
    
    @Test
    void validateWhitePawnMovimentsInChessBoardInit_V3() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("G1");
        request.setTeam(EnumTeam.WHITE.getName());

        MovimentOptionsAvailableDTO result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(0, moves.size());
    }
}
