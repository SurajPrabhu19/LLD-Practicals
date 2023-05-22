package factories;

import models.Bot;
import models.BotDifficultyLevel;
import models.Player;
import models.PlayerType;
import models.Symbol;

public class PlayerFactory {
    public static Player createHumanPlayer(String name, Character symbol) {
        Player player = new Player();
        player.setName(name);
        player.setPlayerType(PlayerType.HUMAN);
        player.setSymbol(new Symbol(symbol));
        return player;
    }

    public static Player createBotPlayer(String name, Character symbol, BotDifficultyLevel botDifficultyLevel) {
        Bot bot = new Bot(botDifficultyLevel);
        bot.setName(name);
        bot.setPlayerType(PlayerType.BOT);
        bot.setSymbol(new Symbol(symbol));

        return bot;
    }
}
