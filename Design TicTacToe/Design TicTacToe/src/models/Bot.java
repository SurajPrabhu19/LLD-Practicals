package models;

import factories.BotPlayingStrategyFactory;
import strategies.BotPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(BotDifficultyLevel botDifficultyLevel) {
        super();
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyByDifficulty(this.botDifficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        return this.botPlayingStrategy.makeMove(board, this);
    }
}