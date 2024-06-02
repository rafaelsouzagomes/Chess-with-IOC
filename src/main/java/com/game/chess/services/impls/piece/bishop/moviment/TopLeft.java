package com.game.chess.services.impls.piece.bishop.moviment;

import com.game.chess.services.pieces.moviment.ISenseDirection;

public class TopLeft implements ISenseDirection {

	@Override
	public boolean isFastReturn(int x, int y) {
		return y>=0;
	}
	
	@Override
	public int getYReturn(int y) {
		return 0;
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
		return x+1;
	}



}
