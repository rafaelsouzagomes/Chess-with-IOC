package com.game.chess.services.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.models.dtos.PlayerDTO;
import com.game.chess.models.entities.Player;
import com.game.chess.models.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository playerRepo;
	
	public Player createPlayer(PlayerDTO dto) {
		Player p1 = new Player();
		p1.setUsername(dto.getName());
		
		return playerRepo.save(p1);	
	}

	public List<Player> getPlayers() {
		return playerRepo.findAll();
	}

}
