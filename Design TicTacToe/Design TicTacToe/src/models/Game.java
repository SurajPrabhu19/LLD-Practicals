package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.DuplicateSymbolException;
import strategies.winningStrategy.GameWinningStrategy;
import models.*;

public class Game {

    // Since we have a lot of params + requires validation, we go for BUILDER-DP
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<GameWinningStrategyName> gameWinningStrategies;
    private int lastMovedPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;
    private int filledCells = 0;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getLastMovedPlayerIndex() {
        return lastMovedPlayerIndex;
    }

    public void setLastMovedPlayerIndex(int lastMovedPlayerIndex) {
        this.lastMovedPlayerIndex = lastMovedPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getFilledCells() {
        return filledCells;
    }

    public void setFilledCells(int filledCells) {
        this.filledCells = filledCells;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void makeMove() {
        this.lastMovedPlayerIndex += 1;
        this.lastMovedPlayerIndex %= players.size();

        this.players.get(this.lastMovedPlayerIndex).makeMove(board);
    }

    // Builder class is used for crating a new Object of the same class,
    // having -> lot of params + validations
    // and in builders we only put setters to set the values
    public static class Builder {
        private List<Player> players;
        private List<GameWinningStrategyName> gameWinningStrategies;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setGameWinningStrategies(List<GameWinningStrategyName> gameWinningStrategies) {
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
            game.moves = new ArrayList<Move>();
            game.board = new Board(players.size() + 1);
            game.lastMovedPlayerIndex = -1;

            return game;
        }

    }

}

// Game class:
// i. Lots of attributes
// ii. Need validation (every player must have a different symbol