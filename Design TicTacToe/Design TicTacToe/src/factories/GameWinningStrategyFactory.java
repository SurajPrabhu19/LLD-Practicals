package factories;

import models.GameWinningStrategyName;
import strategies.winningStrategy.GameWinningStrategy;
import strategies.winningStrategy.NotWinningGameStrategy;

public class GameWinningStrategyFactory {

    public static GameWinningStrategy getGameStrategyByName(GameWinningStrategyName gameWinningStrategyName) {
        // return switch (gameWinningStrategyName) {
        // case ROW -> null;
        // case COLUMN -> null;
        // case DIAGONAL -> null;
        // case CORNER -> null;
        // };
        return new NotWinningGameStrategy();
    }

}