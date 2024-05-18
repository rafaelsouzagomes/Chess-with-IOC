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
	
	private final int LINES = 8;
	private final int COLUMNS = 8;
	
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
		for(int line=0; line < squareBoard.length; line++) {
			for(int column=0; column < squareBoard[0].length; column++) {
				Objects.requireNonNull(squareBoard[line][column]);
			}
			System.out.println("");
		}
	}

	public void addSquare_A8(EnumTypePiece typePiece, EnumTeam team) {
		squareBoard[0][0] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.A8);
	}
	public void addSquare_B8(EnumTypePiece typePiece, EnumTeam team) {
		squareBoard[0][1] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.B8);
	}
	public void addSquare_C8(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[0][2] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.C8);
    }

    public void addSquare_D8(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[0][3] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.D8);
    }

    public void addSquare_E8(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[0][4] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.E8);
    }

    public void addSquare_F8(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[0][5] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.F8);
    }

    public void addSquare_G8(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[0][6] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.G8);
    }

    public void addSquare_H8(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[0][7] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.H8);
    }

    public void addSquare_A7(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[1][0] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.A7);
    }

    public void addSquare_B7(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[1][1] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.B7);
    }

    public void addSquare_C7(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[1][2] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.C7);
    }

    public void addSquare_D7(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[1][3] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.D7);
    }

    public void addSquare_E7(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[1][4] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.E7);
    }

    public void addSquare_F7(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[1][5] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.F7);
    }

    public void addSquare_G7(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[1][6] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.G7);
    }

    public void addSquare_H7(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[1][7] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.H7);
    }

    public void addSquare_A6() {
        squareBoard[2][0] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.A6);
    }

    public void addSquare_B6() {
        squareBoard[2][1] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.B6);
    }

    public void addSquare_C6() {
        squareBoard[2][2] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.C6);
    }

    public void addSquare_D6() {
        squareBoard[2][3] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.D6);
    }

    public void addSquare_E6() {
        squareBoard[2][4] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.E6);
    }

    public void addSquare_F6() {
        squareBoard[2][5] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.F6);
    }

    public void addSquare_G6() {
        squareBoard[2][6] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.G6);
    }

    public void addSquare_H6() {
        squareBoard[2][7] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.H6);
    }

    public void addSquare_A5() {
        squareBoard[3][0] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.A5);
    }

    public void addSquare_B5() {
        squareBoard[3][1] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.B5);
    }

    public void addSquare_C5() {
        squareBoard[3][2] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.C5);
    }

    public void addSquare_D5() {
        squareBoard[3][3] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.D5);
    }

    public void addSquare_E5() {
        squareBoard[3][4] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.E5);
    }

    public void addSquare_F5() {
        squareBoard[3][5] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.F5);
    }

    public void addSquare_G5() {
        squareBoard[3][6] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.G5);
    }

    public void addSquare_H5() {
        squareBoard[3][7] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.H5);
    }

    public void addSquare_A4() {
        squareBoard[4][0] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.A4);
    }

    public void addSquare_B4() {
        squareBoard[4][1] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.B4);
    }

    public void addSquare_C4() {
        squareBoard[4][2] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.C4);
    }

    public void addSquare_D4() {
        squareBoard[4][3] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.D4);
    }

    public void addSquare_E4() {
        squareBoard[4][4] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.E4);
    }

    public void addSquare_F4() {
        squareBoard[4][5] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.F4);
    }

    public void addSquare_G4() {
        squareBoard[4][6] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.G4);
    }

    public void addSquare_H4() {
        squareBoard[4][7] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.H4);
    }

    public void addSquare_A3() {
        squareBoard[5][0] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.A3);
    }

    public void addSquare_B3() {
        squareBoard[5][1] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.B3);
    }

    public void addSquare_C3() {
        squareBoard[5][2] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.C3);
    }

    public void addSquare_D3() {
        squareBoard[5][3] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.D3);
    }

    public void addSquare_E3() {
        squareBoard[5][4] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.E3);
    }

    public void addSquare_F3() {
        squareBoard[5][5] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.F3);
    }

    public void addSquare_G3() {
        squareBoard[5][6] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.G3);
    }

    public void addSquare_H3() {
        squareBoard[5][7] = squareBoardFactory.buildEmpty(EnumNameNotaionSquare.H3);
    }
    
    public void addSquare_A2(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[6][0] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.A2);
    }

    public void addSquare_B2(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[6][1] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.B2);
    }

    public void addSquare_C2(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[6][2] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.C2);
    }

    public void addSquare_D2(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[6][3] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.D2);
    }

    public void addSquare_E2(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[6][4] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.E2);
    }

    public void addSquare_F2(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[6][5] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.F2);
    }

    public void addSquare_G2(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[6][6] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.G2);
    }

    public void addSquare_H2(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[6][7] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.H2);
    }

    public void addSquare_A1(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[7][0] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.A1);
    }

    public void addSquare_B1(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[7][1] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.B1);
    }

    public void addSquare_C1(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[7][2] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.C1);
    }

    public void addSquare_D1(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[7][3] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.D1);
    }

    public void addSquare_E1(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[7][4] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.E1);
    }

    public void addSquare_F1(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[7][5] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.F1);
    }

    public void addSquare_G1(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[7][6] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.G1);
    }

    public void addSquare_H1(EnumTypePiece typePiece, EnumTeam team) {
        squareBoard[7][7] = squareBoardFactory.build(typePiece, team, EnumNameNotaionSquare.H1);
    }
    
    @Autowired
    public void setChessSquareFactory(SquareBoardFactory chessSquareFactory) {
        this.squareBoardFactory = chessSquareFactory;
    }

}
