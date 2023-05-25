package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.DuplicateSymbolException;
import factories.GameWinningStrategyEnumFactory;
import factories.GameWinningStrategyFactory;
import strategies.winningStrategy.GameWinningStrategy;
import models.*;

public class Game {

    // Since we have a lot of params + requires validation, we go for BUILDER-DP
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private List<GameWinningStrategy> gameWinningStrategies;
    // private List<GameWinningStrategy> gameWinningStrategiesName;
    private int lastMovedPlayerIndex;
    private GameStatus gameStatus;
    private Player winner;
    private int filledCells = 0; // to check if its a DRAW

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

    public String makeMove() {
        // show the user the board before you make any move
        this.board.displayBoard();

        // set the index to 0 to take the last
        this.lastMovedPlayerIndex += 1;
        this.lastMovedPlayerIndex %= players.size();

        // get the potentialMove based on type of player [Bot or Human]
        Move potentialMove = this.players.get(this.lastMovedPlayerIndex).makeMove(this.board);

        // check for empty cell else tell them to make the move again:
        if (this.board.getCell(potentialMove.getRow() - 1, potentialMove.getCol() - 1).getPlayer() != null) {
            System.out.println("You cannot make this move");
            this.lastMovedPlayerIndex--;
            return "";
        }

        // add the move to the Moves[] to undo it in future if needed
        this.moves.add(potentialMove);

        // set the player for that cell
        this.board.getCell(potentialMove.getRow() - 1, potentialMove.getCol() - 1)
                .setPlayer(this.players.get(lastMovedPlayerIndex));

        filledCells += 1; // increment the cell count for checking DRAW in future

        // check the win based on winning strategy:
        for (GameWinningStrategy gameWinningStrategy : gameWinningStrategies) {
            if (gameWinningStrategy.checkVictory(board, lastMovedPlayerIndex, players)) {
                this.gameStatus = GameStatus.ENDED;
                this.board.displayBoard();
                winner = this.players.get(lastMovedPlayerIndex);
                return winner.getName();
            }
        }

        if (filledCells == (this.players.size() + 1) * (this.players.size() + 1)) {
            gameStatus = GameStatus.DRAW;
        }

        return "";
    }

    // Builder class is used for crating a new Object of the same class,
    // having -> lot of params + validations
    // and in builders we only put setters to set the values
    public static class Builder {
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;
        // private List<GameWinningStrategyName> gameWinningStrategiesName;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setGameWinningStrategies(List<GameWinningStrategyName> gameWinningStrategies) {
            this.gameWinningStrategies = new ArrayList<>();

            for (GameWinningStrategyName strategy : gameWinningStrategies) {
                this.gameWinningStrategies.add(GameWinningStrategyFactory.getGameStrategyByName(strategy));
            }
            // this.gameWinningStrategiesName = gameWinningStrategies;
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