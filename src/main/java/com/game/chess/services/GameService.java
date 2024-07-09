package com.game.chess.services;

import com.game.chess.models.dtos.InitGameDTO;
import com.game.chess.models.entities.Game;

public interface GameService {

	Game initGame(InitGameDTO dto);

	Game getGame(InitGameDTO dto);

}
