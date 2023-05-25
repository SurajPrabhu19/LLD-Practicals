package strategies.winningStrategy;

import models.Board;
import models.Cell;
import models.Move;
import models.Player;

import java.util.*;

public class NotWinningGameStrategy implements GameWinningStrategy {
    private static List<List<Cell>> board;
    private static Integer size;
    private static Character symbol;
    private static int symbolCount;

    @Override
    public boolean checkVictory(Board boardObj, int lastMove, List<Player> players) {

        board = boardObj.getBoard();
        size = board.size();
        symbol = players.get(lastMove).getSymbol().getCharacter();
        symbolCount = 0;

        return checkRowVictory() || checkColVictory() || checkDiagonalVictory();
    }

    public boolean checkRowVictory() {

        for (int r = 0; r < size; r++) {
            symbolCount = 0;
            for (int c = 0; c < size; c++) {
                if (board.get(r).get(c).getPlayer() != null
                        && board.get(r).get(c).getPlayer().getSymbol().getCharacter() == symbol)
                    symbolCount++;
            }
            if (symbolCount == 3)
                return true;
        }
        return false;
    }

    public boolean checkColVictory() {

        for (int c = 0; c < size; c++) {
            symbolCount = 0;
            for (int r = 0; r < size; r++) {
                if (board.get(r).get(c).getPlayer() != null
                        && board.get(r).get(c).getPlayer().getSymbol().getCharacter() == symbol)
                    symbolCount++;
            }
            if (symbolCount == 3)
                return true;
        }
        return false;
    }

    public boolean checkDiagonalVictory() {

        for (int x = 0; x < size; x++) {
            if (board.get(x).get(x).getPlayer() != null
                    && board.get(x).get(x).getPlayer().getSymbol().getCharacter() == symbol)
                symbolCount++;
        }
        if (symbolCount == 3)
            return true;
        return false;

    }
}
