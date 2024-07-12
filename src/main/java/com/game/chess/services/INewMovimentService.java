package com.game.chess.services;

import com.game.chess.models.dtos.NewMovimentDTO;
import com.game.chess.models.entities.Game;

public interface INewMovimentService {

	public Game addNewMoviment(NewMovimentDTO mov);
}
