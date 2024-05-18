package com.game.chess;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessApplication implements CommandLineRunner  {
	
	public static void main(String[] args) {
		SpringApplication.run(ChessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}


}
