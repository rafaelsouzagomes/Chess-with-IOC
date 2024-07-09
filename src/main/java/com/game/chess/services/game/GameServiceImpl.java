package com.game.chess.services.game;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.chess.models.dtos.InitGameDTO;
import com.game.chess.models.entities.Game;
import com.game.chess.models.entities.Player;
import com.game.chess.models.enums.EnumTeam;
import com.game.chess.models.repositories.GameRepository;
import com.game.chess.models.repositories.PlayerRepository;
import com.game.chess.services.GameService;
import com.game.chess.services.components.ChessBoard;
import com.game.chess.services.components.squareboard.SquareBoard;

@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private ChessBoard chess;
	
	@Autowired
	private PlayerRepository playerRepo;
	
	private SquareBoard[][] squareBoards;
	private Player player_A;
	private Player player_B;
	
	@Override
	public Game initGame(InitGameDTO dto) {
		setUpNewChessGame();
		setUpPlayers(dto);
		return saveNewGame();
	}
	
	@Override
	public Game getGame(InitGameDTO dto) {
		Optional<Game> gameOpt = gameRepository.findById(dto.getIdGame());
		SquareBoard[][] squareBoard = gameOpt.get().getSquareBoard();
		chess.setChessBoard(squareBoard);
		chess.showBoard();
		if(gameOpt.isPresent())
			return gameOpt.get();
		return null;
	}

	private Game saveNewGame() {
		Game game = new Game();
		game.setName("Chess Game");
		game.setPlayer_A(player_A);
		game.setPlayer_B(player_B);
		game.setSquareBoard(squareBoards);
		
		return gameRepository.save(game);
	}

	private void setUpPlayers(InitGameDTO dto) {
		Optional<Player> player_A_opt = playerRepo.findById(dto.getIdPlayer_A());
		//Validate
		this.player_A = player_A_opt.get();
		player_A.setTeam(EnumTeam.BLACK);
		playerRepo.save(player_A);
		
		
		Optional<Player> player_B_opt = playerRepo.findById(dto.getIdPlayer_B());
		//Validate
		this.player_B = player_B_opt.get();
		player_B.setTeam(EnumTeam.WHITE);
		playerRepo.save(player_B);
	}

	private void setUpNewChessGame() {
		chess.createNewGame();
		this.squareBoards = chess.getBoard();
	}


}
