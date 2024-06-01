package com.game.chess.services.impls.piece.rook.moviment;

import com.game.chess.services.pieces.moviment.ISenseDirection;

public class Init implements ISenseDirection {

	@Override
	public boolean isFastReturn(int x, int y) {
		return y>=7;
	}
	
	@Override
	public int getYReturn(int y) {
		return 7;
	}

	@Override
	public int getFastXReturn(int x) {
		return x;
	}

	@Override
	public int getY(int y) {
		return y+1;
	}

	@Override
	public int getX(int x) {
		return x;
	}
}
