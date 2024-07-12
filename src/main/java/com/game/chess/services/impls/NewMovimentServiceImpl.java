package com.game.chess.services.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.models.dtos.NewMovimentDTO;
import com.game.chess.models.entities.Game;
import com.game.chess.models.entities.Player;
import com.game.chess.models.enums.EnumNameNotaionSquare;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.repositories.GameRepository;
import com.game.chess.models.repositories.PlayerRepository;
import com.game.chess.services.INewMovimentService;
import com.game.chess.services.components.piece.Piece;
import com.game.chess.services.components.squareboard.SquareBoard;

@Service
public class NewMovimentServiceImpl implements INewMovimentService{
	
	GameRepository gameRepository;
	PlayerRepository playerRepo;
	
	@Override
	public Game addNewMoviment(NewMovimentDTO mov) {
		Game game = gameRepository.findById(mov.getIdGame()).get();
		Player player = playerRepo.findById(mov.getIdPlayer()).get();
		
		SquareBoard[][] squareBoard = game.getSquareBoard();
		
		EnumNameNotaionSquare enumNameNotarionSquareOrigin = EnumNameNotaionSquare.get(mov.getEnumNameNotaionSquare_origin());
		EnumNameNotaionSquare enumNameNotarionSquaredestination = EnumNameNotaionSquare.get(mov.getEnumNameNotaionSquare_destination());
		
		SquareBoard squareWithPieceToMove = squareBoard[enumNameNotarionSquareOrigin.getIndex_x()][enumNameNotarionSquareOrigin.getIndex_y()];
		Piece piece = squareWithPieceToMove.getPiece();
		EnumTeam pieceTeam = piece.getTeam();
		
		if(!pieceTeam.equals(player.getTeam())) {
			//validate
		}
		squareWithPieceToMove.removePiece();
		
		SquareBoard squareToPutPiece = squareBoard[enumNameNotarionSquaredestination.getIndex_x()][enumNameNotarionSquaredestination.getIndex_y()];
		squareToPutPiece.setPiece(piece);
		
		game.setSquareBoard(squareBoard);
		gameRepository.save(game);
		
		return game;
	}
	
	@Autowired
	public void setGameRepository(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	@Autowired
	public void setPlayerRepo(PlayerRepository playerRepo) {
		this.playerRepo = playerRepo;
	}

}
