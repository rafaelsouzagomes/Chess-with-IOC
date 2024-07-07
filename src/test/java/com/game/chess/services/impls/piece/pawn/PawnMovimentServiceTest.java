package com.game.chess.services.impls.piece.pawn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.game.chess.configs.CustomTestConfig;
import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.services.components.Board8x8Factory;
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
    
    
	@Autowired
	Board8x8Factory boardFactory;
	
    
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
    void testDoubleMoviment_Black() {
        pawnMovimentService.setIndex_x(EnumNameNotaionSquare.A3.getIndex_x());
        pawnMovimentService.setIndex_y(EnumNameNotaionSquare.A3.getIndex_y());
        
        int[] moves =  pawnMovimentService.addDoubleMoviment(blackPawnTeamManager);

        assertEquals(2, moves.length);
        
        EnumNameNotaionSquare enumAns = EnumNameNotaionSquare.get(moves[0], moves[1]);
        
        assertEquals(EnumNameNotaionSquare.A1, enumAns);
    }
    
    @Test
    void testDoubleMoviment_White() {
        pawnMovimentService.setIndex_x(EnumNameNotaionSquare.B3.getIndex_x());
        pawnMovimentService.setIndex_y(EnumNameNotaionSquare.B3.getIndex_y());
        
        int[] moves =  pawnMovimentService.addDoubleMoviment(whitePawnTeamManager);

        assertEquals(2, moves.length);
        
        EnumNameNotaionSquare enumAns = EnumNameNotaionSquare.get(moves[0], moves[1]);
        
        assertEquals(EnumNameNotaionSquare.B5, enumAns);
    }
    
    
    @Test
    void test_addCaptureMovimentLeft_Black() {
        pawnMovimentService.setIndex_x(EnumNameNotaionSquare.C4.getIndex_x());
        pawnMovimentService.setIndex_y(EnumNameNotaionSquare.C4.getIndex_y());
        
        int[] moves =  pawnMovimentService.addCaptureMovimentLeft(blackPawnTeamManager);

        assertEquals(2, moves.length);
        
        EnumNameNotaionSquare enumAns = EnumNameNotaionSquare.get(moves[0], moves[1]);
        
        assertEquals(EnumNameNotaionSquare.B3, enumAns);
    }
    
    
    @Test
    void test_addCaptureMovimentLeft_WHITE() {
        pawnMovimentService.setIndex_x(EnumNameNotaionSquare.C4.getIndex_x());
        pawnMovimentService.setIndex_y(EnumNameNotaionSquare.C4.getIndex_y());
        
        int[] moves =  pawnMovimentService.addCaptureMovimentLeft(whitePawnTeamManager);

        assertEquals(2, moves.length);
        
        EnumNameNotaionSquare enumAns = EnumNameNotaionSquare.get(moves[0], moves[1]);
        
        assertEquals(EnumNameNotaionSquare.B5, enumAns);
    }
    
    
    @Test
    void test_addCaptureMovimentRight_Black() {
        pawnMovimentService.setIndex_x(EnumNameNotaionSquare.D4.getIndex_x());
        pawnMovimentService.setIndex_y(EnumNameNotaionSquare.D4.getIndex_y());
        
        int[] moves =  pawnMovimentService.addCaptureMovimentLeft(blackPawnTeamManager);

        assertEquals(2, moves.length);
        
        EnumNameNotaionSquare enumAns = EnumNameNotaionSquare.get(moves[0], moves[1]);
        
        assertEquals(EnumNameNotaionSquare.C3, enumAns);
    }
    
    
    @Test
    void test_addCaptureMovimentleft_Black() {
        pawnMovimentService.setIndex_x(EnumNameNotaionSquare.D4.getIndex_x());
        pawnMovimentService.setIndex_y(EnumNameNotaionSquare.D4.getIndex_y());
        
        int[] moves =  pawnMovimentService.addCaptureMovimentLeft(blackPawnTeamManager);

        assertEquals(2, moves.length);
        
        EnumNameNotaionSquare enumAns = EnumNameNotaionSquare.get(moves[0], moves[1]);
        
        assertEquals(EnumNameNotaionSquare.C3, enumAns);
    }
    
    
}
