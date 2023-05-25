package strategies.winningStrategy;

import models.*;
import java.util.*;

public interface GameWinningStrategy {

    boolean checkVictory(Board board, int lastMove, List<Player> players);
}