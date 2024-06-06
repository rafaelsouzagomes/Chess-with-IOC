package com.game.chess.services.pieces.moviment;

public interface ISenseDirection {

	boolean isFastReturn(int x, int y);

	int getY(int y);

	int getX(int x);

	int getYReturn(int y);

	int getFastXReturn(int x);

	ISenseDirection setInitPosition(int x, int y);
}
