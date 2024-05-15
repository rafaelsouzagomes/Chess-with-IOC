package com.game.chess.services;

import com.game.chess.dtos.MovimentOptions;
import com.game.chess.dtos.MovimentRequestDTO;

public interface IMovimentService {

	public MovimentOptions getMovimentOptions(MovimentRequestDTO mov);
}
