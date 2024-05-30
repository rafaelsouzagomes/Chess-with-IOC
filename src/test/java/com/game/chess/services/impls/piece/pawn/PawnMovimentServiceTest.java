package com.game.chess.services.impls.piece.pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.configs.CustomTestConfig;
import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;
import com.game.chess.services.impls.piece.MovimentOptions;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Import(CustomTestConfig.class)
class PawnMovimentServiceTest {

    @Autowired
    private PawnMovimentService pawnMovimentService;

    @MockBean
    private MovimentOptions movimentOptions;
        
    @Autowired
    private BlackPawnTeamManager blackPawnTeamManager;
    
    
    @Autowired
    private WhitePawnTeamManager whitePawnTeamManager;
    
    @BeforeEach
    void setUp() {
        doNothing().when(movimentOptions).addCaptureMove(anyInt(), anyInt());
        doNothing().when(movimentOptions).addMove(anyInt(), anyInt());
    }

    @Test
    void testSimpleMoviment_Black() {
        pawnMovimentService.setIndex_x(EnumNameNotaionSquare.G7.getIndex_x());
        pawnMovimentService.setIndex_y(EnumNameNotaionSquare.G7.getIndex_y());
        
        int[] moves =  pawnMovimentService.addSimpleMoviment(blackPawnTeamManager);

        assertEquals(2, moves.length);
        
        EnumNameNotaionSquare enumAns = EnumNameNotaionSquare.get(moves[0], moves[1]);
        
        assertEquals(EnumNameNotaionSquare.G6, enumAns);
    }
    
    
    @Test
    void testSimpleMoviment_White() {
        pawnMovimentService.setIndex_x(EnumNameNotaionSquare.F5.getIndex_x());
        pawnMovimentService.setIndex_y(EnumNameNotaionSquare.F5.getIndex_y());
        
        int[] moves =  pawnMovimentService.addSimpleMoviment(whitePawnTeamManager);

        assertEquals(2, moves.length);
        
        EnumNameNotaionSquare enumAns = EnumNameNotaionSquare.get(moves[0], moves[1]);
        
        assertEquals(EnumNameNotaionSquare.F6, enumAns);
    }
    
    @Test
    void validateBlackPawnMovimentsInChessBoardInit_1() {
        MovimentRequestDTO request = new MovimentRequestDTO();
        request.setCurrentPosition("G6");
        request.setTeam(EnumTeam.BLACK.getName());
        request.setPieceToMove(EnumTypePiece.PAWN.getName());

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
        request.setPieceToMove(EnumTypePiece.PAWN.getName());

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
        request.setPieceToMove(EnumTypePiece.PAWN.getName());

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
        request.setPieceToMove(EnumTypePiece.PAWN.getName());

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
        request.setPieceToMove(EnumTypePiece.PAWN.getName());

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
        request.setPieceToMove(EnumTypePiece.PAWN.getName());

        MovimentOptionsAvailableDTO result = pawnMovimentService.findMovimentsAvailable(request);

        List<SquareBoard> moves = result.getChessSquaresAvailable();

        assertEquals(0, moves.size());
    }
}
