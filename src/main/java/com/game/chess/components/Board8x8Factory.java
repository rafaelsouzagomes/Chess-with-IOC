package com.game.chess.components;

import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.components.chessSquare.SquareBoardFactory;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

@Component
public class Board8x8Factory {
	
	private SquareBoard[][] squareBoard;
	
	private SquareBoardFactory squareBoardFactory;
	
	public static final int LINES = 8;
	public static final int COLUMNS = 8;
	
	@PostConstruct
	public void initBoardDefault8x8() {
		squareBoard = new SquareBoard[LINES][COLUMNS];
	}
	
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
	
	public void addSquare(EnumTypePiece typePiece, EnumTeam team, EnumNameNotaionSquare enumNameNotation) {
		squareBoard[enumNameNotation.getIndex_x()][enumNameNotation.getIndex_y()] = squareBoardFactory.build(typePiece, team, enumNameNotation);
	}
	
    public void addSquare_empty(EnumNameNotaionSquare enumNameNotation) {
        squareBoard[enumNameNotation.getIndex_x()][enumNameNotation.getIndex_y()] = squareBoardFactory.buildEmpty(enumNameNotation);
    }

	
    @Autowired
    public void setChessSquareFactory(SquareBoardFactory chessSquareFactory) {
        this.squareBoardFactory = chessSquareFactory;
    }

}
