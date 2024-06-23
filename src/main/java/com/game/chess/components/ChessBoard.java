package com.game.chess.components;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.game.chess.components.chessSquare.SquareBoard;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChessBoard implements IBoard{

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
	
	@Override
	public void addChessSquareBoard(SquareBoard[][] especificChess) {
		chessBoard = especificChess;
	}
	
	@Override
	public void showBoard(){
		Objects.requireNonNull(chessBoard);
		for(int line=0; line < chessBoard.length; line++) {
			for(int column=0; column < chessBoard[0].length; column++) {
				SquareBoard chessSquare = chessBoard[column][line];
				if(chessSquare.isEmpty()) 
					System.out.print(" ["+chessSquare.getNameNotationSquare()+"] ");
				else
					System.out.print(" ["+chessSquare.getPiece().toString()+"] ");
			}
			System.out.println("");
		}
	}
	
	@Override
	public void setChessBoard(SquareBoard[][] chessBoard) {
		this.chessBoard = chessBoard;
	}
	

	
	
}
