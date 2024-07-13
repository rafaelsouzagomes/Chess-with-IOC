package com.game.chess.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.models.dtos.GameDTO;
import com.game.chess.models.dtos.NewMovimentDTO;
import com.game.chess.models.entities.Game;
import com.game.chess.models.entities.Player;
import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.enums.EnumTypePiece;
import com.game.chess.models.repositories.GameRepository;
import com.game.chess.models.repositories.PlayerRepository;
import com.game.chess.services.INewMovimentService;
import com.game.chess.services.components.ChessBoard;
import com.game.chess.services.components.piece.Piece;
import com.game.chess.services.components.squareboard.SquareBoard;
import com.game.chess.services.impls.piece.CheckMateChecker;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.pawn.ITeamManager;
import com.game.chess.services.pieces.pawn.ITeamManagerFactory;
import com.game.chess.validations.ValidationException;

@Service
public class NewMovimentServiceImpl implements INewMovimentService{
	
	private GameRepository gameRepository;
	private PlayerRepository playerRepo;
	private CheckMateChecker checkMateChecker;
	private IMovimentOptions movimentOptions;
	private ChessBoard chessBoard;
	private ITeamManagerFactory iTeamManagerFactory;
	
	@Override
	public GameDTO addNewMoviment(NewMovimentDTO mov) {
		Game game = gameRepository.findById(mov.getIdGame()).get();
		Player player = playerRepo.findById(mov.getIdPlayer()).get();
		
		SquareBoard[][] squareBoard = game.getSquareBoard();
		
		EnumNameNotaionSquare origen = EnumNameNotaionSquare.get(mov.getEnumNameNotaionSquare_origin());
		EnumNameNotaionSquare destination = EnumNameNotaionSquare.get(mov.getEnumNameNotaionSquare_destination());
		
		SquareBoard squareWithPieceToMove = squareBoard[origen.getIndex_x()][origen.getIndex_y()];
		Piece piece = squareWithPieceToMove.getPiece();
		EnumTeam pieceTeam = piece.getTeam();
		
		if(!pieceTeam.equals(player.getTeam())) 
			throw new ValidationException("Moviment invalid - this piece isn't on " 
											+ squareWithPieceToMove.getNameNotationSquare());
		
		squareWithPieceToMove.removePiece();
		
		SquareBoard squareToPutPiece = squareBoard[destination.getIndex_x()][destination.getIndex_y()];
		squareToPutPiece.setPiece(piece);
		
		game.setSquareBoard(squareBoard);
		gameRepository.save(game);
		
		return checker(mov, squareBoard, pieceTeam);
	}

//	private GameDTO checker(NewMovimentDTO mov, SquareBoard[][] squareBoard, EnumTeam pieceTeam) {
//		chessBoard.setChessBoard(squareBoard);
//		movimentOptions.setChessBoard(chessBoard);
//		
//		
//		EnumTeam team = EnumTeam.BLACK;
//		if(pieceTeam.isBlack())
//			team = EnumTeam.WHITE;
//		
//		ITeamManager teamManager = iTeamManagerFactory.getTeamManager(team);
//		movimentOptions.setTeamManager(teamManager);
//		
//		boolean otherTeamisInCheck = checkMateChecker.isAvailable(squareBoard);
//		
//		boolean checkMate;
//		boolean istie;
//		if(otherTeamisInCheck) {
//			checkMate = verifiyifIsCheckMate();
//		} else {
//			istie = verifiyifIsTie();
//		}
//			
//			
//		GameDTO gameDTO = new GameDTO();
//		gameDTO.setIdGame(mov.getIdGame());
//		gameDTO.setIdPlayer(mov.getIdPlayer());
//		gameDTO.setEnumResultGame(null);
//		return gameDTO;
//	}
	
	@Autowired
	public void setGameRepository(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	@Autowired
	public void setPlayerRepo(PlayerRepository playerRepo) {
		this.playerRepo = playerRepo;
	}
	@Autowired
	public void setCheckMateChecker(CheckMateChecker checkMateChecker) {
		this.checkMateChecker = checkMateChecker;
	}
	@Autowired
	public void setMovimentOptions(IMovimentOptions movimentOptions) {
		this.movimentOptions = movimentOptions;
	}

}
