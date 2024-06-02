package com.game.chess.services.impls.piece.bishop.moviment;

import com.game.chess.services.pieces.moviment.ISenseDirection;

public class TopLeft implements ISenseDirection {

	@Override
	public boolean isFastReturn(int x, int y) {
		return x<=0 || y<=0  ;
	}
	
	@Override
	public int getYReturn(int y) {
		if(y<=0) {
			return 0;
		}
		return y;
	}

	@Override
	public int getFastXReturn(int x) {
		if(x<=0) {
			return 0;
		}
		return x;
	}

	@Override
	public int getY(int y) {
		return y-1;
	}

	@Override
	public int getX(int x) {
		return x-1;
	}



}
