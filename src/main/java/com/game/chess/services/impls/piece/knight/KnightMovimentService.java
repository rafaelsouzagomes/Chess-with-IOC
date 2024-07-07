package com.game.chess.services.impls.piece.knight;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.models.enums.NamePieces;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.pawn.ITeamManager;

@Service
@Qualifier(NamePieces.KNIGHT)
public class KnightMovimentService implements IMovimentPiece {

	private IMovimentOptions iMovimentOptions;
	
	private List<int[]> movimentsToTest = new ArrayList<>();
	private int index_x_toMove;
	private int index_y_toMove;
	
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
		
		List<int[]> movesToReturn = movimentsToTest;
		movimentsToTest = new ArrayList<>();
		return movesToReturn;
	}

	private void addMovimentBottomLeft(int index_x, int index_y) {
		index_x_toMove =index_x+2;
		index_y_toMove =index_y-1;	

		addMoviment();
	}


	
	private void addMovimentBottomRight(int index_x, int index_y) {
		index_x_toMove =index_x+2;
		index_y_toMove =index_y+1;	
		
		addMoviment();
	}
	
	private void addMovimentRightTop(int index_x, int index_y) {
		index_x_toMove =index_x-1;
		index_y_toMove =index_y+2;	
		
		addMoviment();
	}
	
	private void addMovimentRightBottom(int index_x, int index_y) {
		index_x_toMove =index_x+1;
		index_y_toMove =index_y+2;	
		
		addMoviment();
	}
	
	private void addMovimentTopRight(int index_x, int index_y) {
		index_x_toMove =index_x-2;
		index_y_toMove =index_y+1;	
		
		addMoviment();
	}
	
	private void addMovimentTopLeft(int index_x, int index_y) {
		index_x_toMove =index_x-2;
		index_y_toMove =index_y-1;	
		
		addMoviment();
	}

	private void addRightTop(int index_x, int index_y) {
		index_x_toMove =index_x-1;
		index_y_toMove =index_y-2;	
		
		addMoviment();
	}
	
	private void addRightBottom(int index_x, int index_y) {
		index_x_toMove =index_x+1;
		index_y_toMove =index_y-2;	

		addMoviment();
	}
	
	private void addMoviment() {
		iMovimentOptions.addAnyMoveType(index_x_toMove, index_y_toMove);
		
		if(Objects.nonNull(EnumNameNotaionSquare.get(index_x_toMove,index_y_toMove))) 			
			movimentsToTest.add(new int[] {index_x_toMove,index_y_toMove});
	}
	
	@Autowired
	@Lazy
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
	}
	
}
