package com.game.chess.services.impls.piece.rook.moviment;

import com.game.chess.services.pieces.moviment.ISenseDirection;

public class Top implements ISenseDirection{
	
	@Override
	public boolean isFastReturn(int x, int y) {
		return x<=0;
	}
	
	@Override
	public int getFastXReturn(int x) {
		return 0;
	}
	
	@Override
	public int getYReturn(int y) {
		return y;
	}
	
	@Override
	public int getX(int x) {
		return x-1;
	}
	
	@Override
	public int getY(int y) {
		return y;
	}

	@Override
	public ISenseDirection setInitPosition(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}