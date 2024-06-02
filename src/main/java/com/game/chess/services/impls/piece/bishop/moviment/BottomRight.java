package com.game.chess.services.impls.piece.bishop.moviment;

import com.game.chess.services.pieces.moviment.ISenseDirection;

public class BottomRight implements ISenseDirection {

	@Override
	public boolean isFastReturn(int x, int y) {
		return 7 >=y;
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
		return x+1;
	}

	

}
