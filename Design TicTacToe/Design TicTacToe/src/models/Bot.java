package models;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(BotDifficultyLevel botDifficultyLevel) {
        super();
        this.botDifficultyLevel = botDifficultyLevel;
    }
}