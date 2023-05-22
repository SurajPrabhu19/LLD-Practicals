package factories;

import models.GameWinningStrategyName;

public class GameWinningStrategyEnumFactory {
    public static GameWinningStrategyName getGameWinningStrategyNameFromString(String name) {
        if (name.equals("ROW")) {
            return GameWinningStrategyName.ROW;
        }
        return GameWinningStrategyName.CORNER; // default win
    }
}
