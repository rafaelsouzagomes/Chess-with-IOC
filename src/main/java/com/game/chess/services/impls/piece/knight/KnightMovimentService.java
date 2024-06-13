package com.game.chess.services.impls.piece.knight;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.NamePieces;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Qualifier(NamePieces.KNIGHT)
public class KnightMovimentService implements IMovimentPiece {

	private IMovimentOptions iMovimentOptions;
	
	private List<int[]> moviments = new ArrayList<>();
	
	@Override
	public void addMovimentsOptionsAvailable(ITeamManager teamManager, EnumNameNotaionSquare currentPosition) {
		addMoviments(currentPosition);
	}

	protected List<int[]> addMoviments(EnumNameNotaionSquare currentPosition) {
		int index_x = currentPosition.getIndex_x();
		int index_y = currentPosition.getIndex_y();
		
		addMovimentBottomLeft(index_x, index_y);
		addMovimentBottomRight(index_x, index_y);
		
		addMovimentRightTop(index_x, index_y);
		addMovimentRightBottom(index_x,index_y);
		
		addMovimentTopRight(index_x,index_y);
		addMovimentTopLeft(index_x,index_y);
		
		addRightTop(index_x,index_y);
		addRightBottom(index_x,index_y);
		
		return moviments;
	}

	private void addMovimentBottomLeft(int index_x, int index_y) {
		int index_x_toMove =index_x+2;
		int index_y_toMove =index_y-1;	
		iMovimentOptions.addAnyMoveType(index_x_toMove, index_y_toMove);
		
		moviments.add(new int[] {index_x_toMove,index_y_toMove});
	}
	
	private void addMovimentBottomRight(int index_x, int index_y) {
		int index_x_toMove =index_x+2;
		int index_y_toMove =index_y+1;	
		iMovimentOptions.addAnyMoveType(index_x_toMove, index_y_toMove);
		
		moviments.add(new int[] {index_x_toMove,index_y_toMove});
	}
	
	private void addMovimentRightTop(int index_x, int index_y) {
		int index_x_toMove =index_x-1;
		int index_y_toMove =index_y+2;	
		iMovimentOptions.addAnyMoveType(index_x_toMove, index_y_toMove);
		
		moviments.add(new int[] {index_x_toMove,index_y_toMove});
	}
	
	private void addMovimentRightBottom(int index_x, int index_y) {
		int index_x_toMove =index_x+1;
		int index_y_toMove =index_y+2;	
		iMovimentOptions.addAnyMoveType(index_x_toMove, index_y_toMove);
		
		moviments.add(new int[] {index_x_toMove,index_y_toMove});
	}
	
	private void addMovimentTopRight(int index_x, int index_y) {
		int index_x_toMove =index_x+2;
		int index_y_toMove =index_y+1;	
		iMovimentOptions.addAnyMoveType(index_x_toMove, index_y_toMove);
		
		moviments.add(new int[] {index_x_toMove,index_y_toMove});
	}
	
	private void addMovimentTopLeft(int index_x, int index_y) {
		int index_x_toMove =index_x+2;
		int index_y_toMove =index_y-1;	
		iMovimentOptions.addAnyMoveType(index_x_toMove, index_y_toMove);
		
		moviments.add(new int[] {index_x_toMove,index_y_toMove});
	}

	private void addRightTop(int index_x, int index_y) {
		int index_x_toMove =index_x-1;
		int index_y_toMove =index_y-2;	
		iMovimentOptions.addAnyMoveType(index_x_toMove, index_y_toMove);
		
		moviments.add(new int[] {index_x_toMove,index_y_toMove});
	}
	
	private void addRightBottom(int index_x, int index_y) {
		int index_x_toMove =index_x+1;
		int index_y_toMove =index_y-2;	
		iMovimentOptions.addAnyMoveType(index_x_toMove, index_y_toMove);
		
		moviments.add(new int[] {index_x_toMove,index_y_toMove});
	}
	
	@Autowired
	@Lazy
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
	}
	
}
