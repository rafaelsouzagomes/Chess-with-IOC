package com.game.chess.services;

import com.game.chess.models.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.models.dtos.MovimentRequestDTO;
import com.game.chess.models.dtos.NewMovimentDTO;

public interface IMovimentService {

	public MovimentOptionsAvailableDTO getMovimentOptions(MovimentRequestDTO mov);

}
