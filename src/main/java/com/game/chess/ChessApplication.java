package com.game.chess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.game.chess.components.ChessBoard;
import com.game.chess.components.chessSquare.ChessSquare;

@SpringBootApplication
public class ChessApplication implements CommandLineRunner  {
	
	@Autowired
	ChessBoard x;

	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);
		

	}

	@Override
	public void run(String... args) throws Exception {
		ChessSquare[][] patternInitGame = x.getPatternInitGame();
		for(ChessSquare[] linhas: patternInitGame ) {
			for(ChessSquare coluna: linhas) {
				System.out.print(coluna.getPiece() + " ") ;
			}
			System.out.println(" ");
		}
		
	}


}
