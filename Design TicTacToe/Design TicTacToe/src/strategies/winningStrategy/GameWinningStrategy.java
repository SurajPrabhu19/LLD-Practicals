package strategies.winningStrategy;

import models.*;

public interface GameWinningStrategy {

    boolean checkVictory(Board board, Move lastMove);
}