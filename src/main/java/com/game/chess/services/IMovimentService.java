package com.game.chess.services;

import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.dtos.MovimentRequestDTO;

public interface IMovimentService {

	public MovimentOptionsAvailableDTO getMovimentOptions(MovimentRequestDTO mov);
}
