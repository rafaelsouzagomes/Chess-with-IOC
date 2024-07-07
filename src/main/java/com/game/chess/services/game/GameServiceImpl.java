package com.game.chess.services.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.entities.Game;
import com.game.chess.repositories.GameRepository;
import com.game.chess.services.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	GameRepository gameRepository;
	
	@Override
	public void initGame() {
		Game game = new Game();
		game.setName("game1");
		
		gameRepository.save(game);
	}
}
