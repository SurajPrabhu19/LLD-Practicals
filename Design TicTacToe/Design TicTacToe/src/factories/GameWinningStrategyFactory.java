import models.GameWinningStrategyName;

public class GameWinningStrategyFactory {

    public static GameWinningStrategy getGameStrategyByName(GameWinningStrategyName gameWinningStrategyName)
    {
        return switch(gameWinningStrategyName)
        {
            case ROW -> null; 
            case COLUMN -> null;
            case DIAGONAL -> null;
            case CORNER -> null;
        }
    }

}