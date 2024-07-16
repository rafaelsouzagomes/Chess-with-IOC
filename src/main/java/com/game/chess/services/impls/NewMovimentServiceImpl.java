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
import com.game.chess.services.components.piece.Piece;
import com.game.chess.services.components.squareboard.SquareBoard;
import com.game.chess.services.impls.piece.EndPlayChecker;
import com.game.chess.validations.ValidationException;

@Service
public class NewMovimentServiceImpl implements INewMovimentService{
	
	private GameRepository gameRepository;
	private PlayerRepository playerRepo;
	private EndPlayChecker endPlayChecker;
	
	private Game game;
	private Player player;
	private SquareBoard[][] squareBoard;
	
	@Override
	public GameDTO addNewMoviment(NewMovimentDTO mov) {
		setUpGameVariables(mov);
		
		Piece pieceChanged = changePiecePosition(mov);
		Game gameManaged = updateGameEntityWithCurrentBoard();
		
		GameDTO resultsGame = endPlayChecker.getResults(gameManaged, pieceChanged.getTeam());
		return resultsGame;
	}

	private Game updateGameEntityWithCurrentBoard() {
		game.setSquareBoard(squareBoard);
		Game gameManaged = gameRepository.save(game);
		return gameManaged;
	}

	private void setUpGameVariables(NewMovimentDTO mov) {
		game = gameRepository.findById(mov.getIdGame()).get();
		player = playerRepo.findById(mov.getIdPlayer()).get();
		squareBoard = game.getSquareBoard();
	}

	private Piece changePiecePosition(NewMovimentDTO mov) {
		EnumNameNotaionSquare origen = EnumNameNotaionSquare.get(mov.getEnumNameNotaionSquare_origin());
		EnumNameNotaionSquare destination = EnumNameNotaionSquare.get(mov.getEnumNameNotaionSquare_destination());
		
		SquareBoard squareWithPieceToMove = squareBoard[origen.getIndex_x()][origen.getIndex_y()];
		Piece piece = squareWithPieceToMove.getPiece();
		EnumTeam pieceTeam = piece.getTeam();
		
		validatePositionPiece(player, squareWithPieceToMove, pieceTeam);
		
		squareWithPieceToMove.removePiece();
		
		SquareBoard squareToPutPiece = squareBoard[destination.getIndex_x()][destination.getIndex_y()];
		
		piece = changePawnByAQueenIfItIsOnTopOrBottom(piece, pieceTeam, squareToPutPiece); 
		
		squareToPutPiece.setPiece(piece);
		return piece;
	}

	private Piece changePawnByAQueenIfItIsOnTopOrBottom(Piece piece, EnumTeam pieceTeam, SquareBoard squareToPutPiece) {
		EnumNameNotaionSquare squareToPutNotation = squareToPutPiece.getNameNotationSquare();
		if(piece.isPawn() && squareToPutNotation.isBottomOrTop()) 
			piece = new Piece(EnumTypePiece.QUEEN, pieceTeam);
		return piece;
	}

	private void validatePositionPiece(Player player, SquareBoard squareWithPieceToMove, EnumTeam pieceTeam) {
		if(!pieceTeam.equals(player.getTeam())) 
			throw new ValidationException("Moviment invalid - this piece isn't on " 
											+ squareWithPieceToMove.getNameNotationSquare());
	}

	@Autowired
	public void setGameRepository(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	@Autowired
	public void setPlayerRepo(PlayerRepository playerRepo) {
		this.playerRepo = playerRepo;
	}
	@Autowired
	public void setEndPlayChecker(EndPlayChecker endGameChecker) {
		this.endPlayChecker = endGameChecker;
	}

}
