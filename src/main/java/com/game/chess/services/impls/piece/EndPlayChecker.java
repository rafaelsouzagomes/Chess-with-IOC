package com.game.chess.services.impls.piece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.models.dtos.GameDTO;
import com.game.chess.models.dtos.MovimentOptionsAvailableDTO;
import com.game.chess.models.dtos.MovimentRequestDTO;
import com.game.chess.models.entities.Game;
import com.game.chess.models.enums.EnumResultGame;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.enums.EnumTypePiece;
import com.game.chess.services.IMovimentService;
import com.game.chess.services.components.piece.Piece;
import com.game.chess.services.components.squareboard.SquareBoard;
import com.game.chess.services.pieces.IMovimentOptions;
import com.game.chess.services.pieces.pawn.ITeamManager;
import com.game.chess.services.pieces.pawn.ITeamManagerFactory;


@Service
public class EndPlayChecker {
	
	private CheckMateChecker checkMateChecker;
	private ITeamManagerFactory iTeamManagerFactory;
	private IMovimentService movimentService;
	private IMovimentOptions movimentOptions;
	
	private SquareBoard[][] squareBoard;
	private EnumTeam adversaryteam;
	private EnumTeam teamPlayer;
	
	
	public GameDTO getResults(Game game, EnumTeam  teamthatPlayed) {
		setUpGameVariables(game, teamthatPlayed);
		
		boolean isAdversaryInCheck = checkIfAdversaryIsInCheck();
		
		Map<String, List<SquareBoard>> adversaryPiecesWithMovimentsAvailable = extractAvailableAdversaryMoviments(game);
		
		boolean isCheckMate = adversaryPiecesWithMovimentsAvailable.isEmpty();
		EnumResultGame result = getResultGame(isAdversaryInCheck, isCheckMate);
		
		GameDTO gameDTO = new GameDTO();
		gameDTO.setAdversaryPiecesWithMovimentsAvailable(adversaryPiecesWithMovimentsAvailable);
		gameDTO.setEnumResultGame(result);
		gameDTO.setIdGame(game.getIdGame());
		gameDTO.setTeamPlayer(teamthatPlayed.name());
		return gameDTO;
	}

	private Map<String, List<SquareBoard>> extractAvailableAdversaryMoviments(Game game) {
		Map<String, List<SquareBoard>> adversaryPiecesWithMovimentsAvailable = new HashMap<>();
		
		for(int line=0; line <= 7; line++) {
			for(int column=0; column<=7; column++) {
				SquareBoard currentSquare = squareBoard[line][column];
				if(currentSquare.isEmpty() || currentSquare.getPiece().getTeam().equals(teamPlayer))	
					continue;
				
				Piece piece = currentSquare.getPiece();
				EnumTypePiece typePiece = piece.getType();
				String squareName = currentSquare.getNameNotationSquare().name();
				
				MovimentRequestDTO movRequestDTO = new MovimentRequestDTO();
				movRequestDTO.setCurrentPosition(squareName);
				movRequestDTO.setIdGame(game.getIdGame());
				movRequestDTO.setPieceToMove(typePiece.getName());
				movRequestDTO.setTeam(adversaryteam.getName());
				
				movimentOptions.clear();
				MovimentOptionsAvailableDTO movsAvailable = movimentService.getMovimentOptions(movRequestDTO);
				
				if(!movsAvailable.getChessSquaresAvailable().isEmpty()) 
					adversaryPiecesWithMovimentsAvailable.put(squareName+":"+typePiece.getName(), movsAvailable.getChessSquaresAvailable());
				
			}
		}
		return adversaryPiecesWithMovimentsAvailable;
	}

	private EnumResultGame getResultGame(boolean isAdversaryInCheck, boolean isCheckMate) {
		EnumResultGame result = EnumResultGame.NOTHING;
		if(isAdversaryInCheck && isCheckMate)
			result = teamPlayer.isBlack() ? EnumResultGame.BLACK_WON : EnumResultGame.WHITE_WON;
		if(!isAdversaryInCheck && isCheckMate)
			result = EnumResultGame.TIE;
		return result;
	}

	private void setUpGameVariables(Game game, EnumTeam teamthatPlayed) {
		squareBoard = game.getSquareBoard();
		adversaryteam = EnumTeam.getAdversaryTeam(teamthatPlayed);
		teamPlayer = teamthatPlayed;
	}

	private boolean checkIfAdversaryIsInCheck() {
		ITeamManager teamManagerAdversary = iTeamManagerFactory.getTeamManager(adversaryteam);
		
		checkMateChecker.setTeamManager(teamManagerAdversary);
		movimentOptions.setSquareBoard(squareBoard);
		boolean isAvailableMoviment = checkMateChecker.isAvailableForTeamToCheck(squareBoard);
		
		boolean isAdversaryInCheck = false;
		if(!isAvailableMoviment)
			isAdversaryInCheck = true;
		
		return isAdversaryInCheck;
	}
	
	@Autowired
	public void setCheckMateChecker(CheckMateChecker checkMateChecker) {
		this.checkMateChecker = checkMateChecker;
	}
	
	@Autowired
	public void setiTeamManagerFactory(ITeamManagerFactory iTeamManagerFactory) {
		this.iTeamManagerFactory = iTeamManagerFactory;
	}
	
	@Autowired
	public void setMovimentService(IMovimentService movimentService) {
		this.movimentService = movimentService;
	}
	@Autowired
	public void setMovimentOptions(IMovimentOptions movimentOptions) {
		this.movimentOptions = movimentOptions;
	}
	
}
