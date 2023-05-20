import java.util.*;

import WinningStrategies.WinningStrategy;

public class Game {
    private List<Player> players;
    private List<Moves> moves;
    Board board;
    private List<WinningStrategy> winningStrategyList;
    private Player winner;
    private int currentPlayerIndex;
    private Status status;
}