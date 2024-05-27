package com.game.chess.services.impls.piece.pawn;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.game.chess.components.IBoard;
import com.game.chess.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.dtos.MovimentRequestDTO;
import com.game.chess.enums.EnumNameNotaionSquare;
import com.game.chess.enums.EnumTeam;
import com.game.chess.enums.NamePieces;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.pawn.IPawnTeamManager;
import com.game.chess.services.pieces.pawn.TeamManagerFactory;

@Service
@Qualifier(NamePieces.PAWN)
public class PawnMovimentService implements IMovimentPiece {
	
	private IBoard chessBoard;
	
	private TeamManagerFactory pawnTeamManagerFactory;
	
	private IMovimentOptions iMovimentOptions;
	
	private int index_y = -1;
	
	private int index_x = -1;
	
    @PostConstruct
    private void init() {
//        IMovimentOptions movimentOptions = getIMovimentOptions();
//        movimentOptions.setChessBoard(chessBoard);
//        movimentOptions.setTeamManager(globalTeamManager);
    }
	
	@Autowired
	@Lazy
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
	}
	
//    @Lookup
//    public IMovimentOptions getIMovimentOptions() {
//        return null; // Spring will override this method
//    }
	
	@Autowired
	public void setPawnTeamManagerFactory(TeamManagerFactory pawnTeamManagerFactory) {
		this.pawnTeamManagerFactory = pawnTeamManagerFactory;
	}
	
	@Autowired
	public void setChessBoard(IBoard chessBoard) {
		this.chessBoard = chessBoard;
	}
	
	@Override
	public MovimentOptionsAvailableDTO findMovimentsAvailable(MovimentRequestDTO mov) {

		EnumTeam team = EnumTeam.get(mov.getTeam());
		IPawnTeamManager pawnTeamManager = pawnTeamManagerFactory.getPawnTeamManager(mov.getPieceToMove(),team);
		iMovimentOptions.setTeamManager(pawnTeamManager); // isso precisa ser injetado apenas manualmente
		iMovimentOptions.setChessBoard(chessBoard);
		
		EnumNameNotaionSquare currentPosition = EnumNameNotaionSquare.get(mov.getCurrentPosition());
		index_x = currentPosition.getIndex_x();
		index_y = currentPosition.getIndex_y();
		
			
		addSimpleMoviment(pawnTeamManager);
		addDoubleMoviment(pawnTeamManager);
		addCaptureMovimentLeft(pawnTeamManager);
		addCaptureMovimentRight(pawnTeamManager);
		
		return iMovimentOptions.getMovimentsOptions();
	}

	private void addSimpleMoviment(IPawnTeamManager pawnTeamManager) {
		int index_x_to_move = pawnTeamManager.getSimpleMovimentAhead(index_x);
		int index_y_to_Move =index_y;
		iMovimentOptions.addMove(index_x_to_move, index_y_to_Move);
	}

	private void addDoubleMoviment(IPawnTeamManager pawnTeamManager) {
		boolean canMoveTwoSquares = pawnTeamManager.canMoveTwoSquares(index_x);
		if(canMoveTwoSquares) {
			 iMovimentOptions.addMove(pawnTeamManager.getDoubleMovimentAhead(index_x), index_y);
		}
	}

	private void addCaptureMovimentLeft(IPawnTeamManager pawnTeamManager) {
		int index_x_to_move = pawnTeamManager.getCaptureMovimentAhead(index_x);
		int index_y_to_Move = pawnTeamManager.getCaptureMovimentLeft(index_y);
		
		iMovimentOptions.addCaptureMove( index_x_to_move, index_y_to_Move);
	}

	private void addCaptureMovimentRight(IPawnTeamManager pawnTeamManager) {
		int index_x_to_move = pawnTeamManager.getCaptureMovimentAhead(index_x);
		int index_y_to_Move = pawnTeamManager.getCaptureMovimentRight(index_y);
		
		iMovimentOptions.addCaptureMove(index_x_to_move, index_y_to_Move);
	}
	
}
