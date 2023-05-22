package factories;

import models.Bot;
import models.BotDifficultyLevel;
import strategies.BotPlayingStrategy.BotPlayingStrategy;
import strategies.BotPlayingStrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategyByDifficulty(BotDifficultyLevel botDifficultyLevel) {
        // switch (botDifficultyLevel) {
        // case
        // }
        return new RandomBotPlayingStrategy();
    }
}
