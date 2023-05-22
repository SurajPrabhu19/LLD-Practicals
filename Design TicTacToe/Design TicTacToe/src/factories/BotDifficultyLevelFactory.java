package factories;

import models.BotDifficultyLevel;

public class BotDifficultyLevelFactory {
    public static BotDifficultyLevel getBotDifficultyLevelFromString(String name) {
        if (name.equals("EASY"))
            return BotDifficultyLevel.EASY;

        return BotDifficultyLevel.MEDIUM; // default difficulty

    }
}
