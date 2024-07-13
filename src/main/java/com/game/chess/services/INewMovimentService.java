package com.game.chess.services;

import com.game.chess.models.dtos.GameDTO;
import com.game.chess.models.dtos.NewMovimentDTO;

public interface INewMovimentService {

	public GameDTO addNewMoviment(NewMovimentDTO mov);
}
