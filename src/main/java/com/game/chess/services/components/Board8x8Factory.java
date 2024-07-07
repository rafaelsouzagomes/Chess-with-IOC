package com.game.chess.services.components;

import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.enums.EnumTypePiece;
import com.game.chess.services.components.squareboard.SquareBoard;
import com.game.chess.services.components.squareboard.SquareBoardFactory;

@Component
public class Board8x8Factory implements IBoard8x8Factory{
	
	private SquareBoard[][] squareBoard;
	
	private SquareBoardFactory squareBoardFactory;
	
	public static final int LINES = 8;
	public static final int COLUMNS = 8;
	
	@PostConstruct
	public void initBoardDefault8x8() {
		squareBoard = new SquareBoard[LINES][COLUMNS];
	}
	
	@Override
	public SquareBoard[][] build(){
		validateBoard();
		return squareBoard;
	}

	private void validateBoard() {
		Objects.requireNonNull(squareBoard);
		for(int line=0; line < LINES; line++) {
			for(int column=0; column < COLUMNS; column++) {
				Objects.requireNonNull(squareBoard[line][column]);
			}
			System.out.println("");
		}
	}
	
	@Override
	public void addSquare(EnumTypePiece typePiece, EnumTeam team, EnumNameNotaionSquare enumNameNotation) {
		squareBoard[enumNameNotation.getIndex_x()][enumNameNotation.getIndex_y()] = squareBoardFactory.build(typePiece, team, enumNameNotation);
	}
	
	@Override
    public void addSquare_empty(EnumNameNotaionSquare enumNameNotation) {
        squareBoard[enumNameNotation.getIndex_x()][enumNameNotation.getIndex_y()] = squareBoardFactory.buildEmpty(enumNameNotation);
    }
    
    @Override
    public void addAllSquare_empty() {
    	for(int line=0; line < LINES; line++) {
			for(int column=0; column < COLUMNS; column++) {
				EnumNameNotaionSquare enumNameNotaionSquare = EnumNameNotaionSquare.get(column, line);
				squareBoard[line][column] = squareBoardFactory.buildEmpty(enumNameNotaionSquare);
			}
		}
    }

	
    @Autowired
    public void setChessSquareFactory(SquareBoardFactory chessSquareFactory) {
        this.squareBoardFactory = chessSquareFactory;
    }

}
