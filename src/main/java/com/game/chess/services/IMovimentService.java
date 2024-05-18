package com.game.chess.services;

import com.game.chess.dtos.MovimentOptionsAvailable;
import com.game.chess.dtos.MovimentRequestDTO;

public interface IMovimentService {

	public MovimentOptionsAvailable getMovimentOptions(MovimentRequestDTO mov);
}
