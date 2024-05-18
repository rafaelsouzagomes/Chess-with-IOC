package com.game.chess.components;

import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.game.chess.components.chessSquare.SquareBoard;
import com.game.chess.components.chessSquare.SquareBoardFactory;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.EnumTypePiece;

@Component
public class ChessBoard implements Board{

	private SquareBoard[][] chessBoard;
	
	private GameBoardFactory chessBoardFactory;

	@Override
	public void createNewGame() {
		chessBoard = chessBoardFactory.build();
	}
	
	@Override
	public SquareBoard[][] getBoard() {
		return chessBoard;
	}
	
	@Autowired
	public void setChessBoardFactory(ChessBoardFactory chessBoardFactory) {
		this.chessBoardFactory = chessBoardFactory;
	}
	
	public void showBoard(){
		Objects.requireNonNull(chessBoard);
		for(int line=0; line < chessBoard.length; line++) {
			for(int column=0; column < chessBoard[0].length; column++) {
				SquareBoard chessSquare = chessBoard[line][column];
				if(chessSquare.isEmpty()) 
					System.out.print(" ["+chessSquare.getNameNotationSquare()+"] ");
				else
					System.out.print(" ["+chessSquare.getPiece().toString()+"] ");
			}
			System.out.println("");
		}
	}
	

	
	
}
