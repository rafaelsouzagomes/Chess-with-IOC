package com.game.chess.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.game.chess.models.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.models.dtos.MovimentRequestDTO;
import com.game.chess.models.entities.Game;
import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.enums.EnumTypePiece;
import com.game.chess.models.repositories.GameRepository;
import com.game.chess.services.IMovimentService;
import com.game.chess.services.components.IBoard;
import com.game.chess.services.components.squareboard.SquareBoard;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.IMovimentPiece;
import com.game.chess.services.pieces.IMovimentPieceFactory;
import com.game.chess.services.pieces.pawn.ITeamManager;
import com.game.chess.services.pieces.pawn.ITeamManagerFactory;

@Service
public class MovimentServiceImpl implements IMovimentService {
	
	private GameRepository gameRepository;
	private IBoard chess;
	
	private ITeamManager team;
	private IMovimentPiece piece;
	private EnumNameNotaionSquare currentPosition;
	private IMovimentPieceFactory movimentPieceFactory;
	private IMovimentOptions iMovimentOptions;
	private ITeamManagerFactory teamManagerFactory;
	
	@Override
	public MovimentOptionsAvailableDTO getMovimentOptions(MovimentRequestDTO movDTO) {
		
		setUpGame(movDTO);
		
		setUpTeamManager(movDTO);
		
		setUpPieceMoviment(movDTO);
		
		setUpCurrentPosition(movDTO);
		
		piece.addMovimentsOptionsAvailable(team, currentPosition);
		 
		return iMovimentOptions.getMovimentsOptions();
	}

	private void setUpGame(MovimentRequestDTO movDTO) {
		Game game = gameRepository.findById(movDTO.getIdGame()).get();
		SquareBoard[][] squareBoard = game.getSquareBoard();
		chess.setChessBoard(squareBoard);
	}
	
	private void setUpCurrentPosition(MovimentRequestDTO mov) {
		currentPosition = EnumNameNotaionSquare.get(mov.getCurrentPosition());
		iMovimentOptions.setCurrentPosition(currentPosition);
	}

	private void setUpPieceMoviment(MovimentRequestDTO mov) {
		piece = movimentPieceFactory.getMovimentPiece(mov.getPieceToMove());
	}

	private void setUpTeamManager(MovimentRequestDTO mov) {
		team =  teamManagerFactory.getTeamManager(getEnumTypePiece(mov), getEnumTeam(mov));
		iMovimentOptions.setTeamManager(team);
	}

	private EnumTypePiece getEnumTypePiece(MovimentRequestDTO mov) {
		return EnumTypePiece.get(mov.getPieceToMove());
	}

	private EnumTeam getEnumTeam(MovimentRequestDTO mov) {
		return EnumTeam.get(mov.getTeam());
	}
	
	@Autowired
	public void setChessboard(IBoard chessboard) {
		this.chess = chessboard;
	}
	@Autowired
	public void setTeamManagerFactory(ITeamManagerFactory teamManagerFactory) {
		this.teamManagerFactory = teamManagerFactory;
	}
	@Autowired
	@Lazy
	public void setiMovimentOptions(IMovimentOptions iMovimentOptions) {
		this.iMovimentOptions = iMovimentOptions;
	}
	@Autowired
	public void setMovimentPieceFactory(IMovimentPieceFactory movimentPieceFactory) {
		this.movimentPieceFactory = movimentPieceFactory;
	}
	@Autowired
	public void setGameRepository(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}


}
