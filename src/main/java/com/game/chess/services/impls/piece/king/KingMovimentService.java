package com.game.chess.services.impls.piece.king;

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
@Qualifier(NamePieces.KING)
public class KingMovimentService implements IMovimentPiece {

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
		
		addMoviment1(index_x, index_y);
		addMoviment2(index_x, index_y);
		addMoviment3(index_x, index_y);
		addMoviment4(index_x, index_y);
		addMoviment5(index_x, index_y);
		addMoviment6(index_x, index_y);
		addMoviment7(index_x, index_y);
		addMoviment8(index_x, index_y);
		
		return movimentsToTest;
	}

	private void addMoviment8(int index_x, int index_y) {
		index_x_toMove = index_x -1;
		index_y_toMove = index_y +1;
		
		addMovimentOptions();
	}

	private void addMoviment7(int index_x, int index_y) {
		index_x_toMove = index_x +1;
		index_y_toMove = index_y -1;
		
		addMovimentOptions();
	}

	private void addMoviment6(int index_x, int index_y) {
		index_x_toMove = index_x;
		index_y_toMove = index_y -1;
		
		addMovimentOptions();
	}

	private void addMoviment5(int index_x, int index_y) {
		index_x_toMove = index_x -1;
		index_y_toMove = index_y;
		
		addMovimentOptions();
	}

	private void addMoviment4(int index_x, int index_y) {
		index_x_toMove = index_x -1;
		index_y_toMove = index_y -1;
		
		addMovimentOptions();
	}

	private void addMoviment3(int index_x, int index_y) {
		index_x_toMove = index_x;
		index_y_toMove = index_y +1;
		
		addMovimentOptions();
	}

	private void addMoviment2(int index_x, int index_y) {
		index_x_toMove = index_x +1;
		index_y_toMove = index_y +1;
		
		addMovimentOptions();
	}

	private void addMoviment1(int index_x, int index_y) {
		index_x_toMove = index_x +1;
		index_y_toMove = index_y;
		
		addMovimentOptions();
	}

	private void addMovimentOptions() {
		iMovimentOptions.addAnyMoveType(index_x_toMove, index_y_toMove);
		if(Objects.nonNull(EnumNameNotaionSquare.get(index_x_toMove,index_y_toMove))) 			
			movimentsToTest.add(new int[] {index_x_toMove,index_y_toMove});
	}
	
	@Lazy
	@Autowired
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
	}

}
