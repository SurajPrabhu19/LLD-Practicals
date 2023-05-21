package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.DuplicateSymbolException;
import strategies.winningStrategy.GameWinningStrategy;

public class Game {

    // Since we have a lot of params + requires validation, we go for BUILDER-DP
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<GameWinningStrategy> gameWinningStrategies;
    private int lastMovedPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;
    private int filledCells = 0;

    // Builder class is used for crating a new Object of the same class,
    // having -> lot of params + validations
    // and in builders we only put setters to set the values
    public static class Builder {
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
            this.gameWinningStrategies = gameWinningStrategies;
            return this;
        }

        public Game build() {
            Set<Character> alreadyExistingCharacters = new HashSet<>();
            for (Player player : players) {
                if (alreadyExistingCharacters.contains(player.getSymbol().getCharacter())) {
                    throw new DuplicateSymbolException(player.getSymbol().getCharacter());
                }
                alreadyExistingCharacters.add(player.getSymbol().getCharacter());
            }

            Game game = new Game();
            game.gameStatus = GameStatus.IN_PROGRESS;
            game.gameWinningStrategies = gameWinningStrategies;
            game.players = players;
            game.moves = new ArrayList<>();
            game.board = new Board(players.size() + 1);
            game.lastMovedPlayerIndex = -1;

            return game;
        }

    }

}

// Game class:
// i. Lots of attributes
// ii. Need validation (every player must have a different symbol