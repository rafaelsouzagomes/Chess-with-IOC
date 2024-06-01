package com.game.chess.services.impls.piece.rook.moviment;

import com.game.chess.services.pieces.moviment.ISenseDirection;

public class Bottom implements ISenseDirection {

	@Override
	public boolean isFastReturn(int x, int y) {
		return x>=7;
	}
	
	@Override
	public int getYReturn(int y) {
		return y;
	}

	@Override
	public int getFastXReturn(int x) {
		return 7;
	}

	@Override
	public int getY(int y) {
		return y;
	}

	@Override
	public int getX(int x) {
		return x+1;
	}
}