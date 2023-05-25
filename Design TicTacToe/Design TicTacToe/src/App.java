import java.util.*;

import factories.BotDifficultyLevelFactory;
import factories.GameWinningStrategyEnumFactory;
import factories.PlayerFactory;
import models.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many players?");
        int numberOfPlayers = scanner.nextInt();

        System.out.println("How many bots?");
        int numberOfBots = scanner.nextInt();

        List<Player> players = new ArrayList<>();

        new ArrayList<Object>();
        for (int i = 0; i < numberOfBots; ++i) {
            System.out.println("Name of Bot " + (i + 1));
            String botName = scanner.next();

            System.out.println("Symbol of Bot " + (i + 1));
            Character character = scanner.next().charAt(0);

            System.out.println("Difficulty of Bot " + (i + 1));
            String difficultyLevel = scanner.next();
            BotDifficultyLevel botDifficultyLevel = BotDifficultyLevelFactory
                    .getBotDifficultyLevelFromString(difficultyLevel);

            players.add(PlayerFactory.createBotPlayer(botName, character, botDifficultyLevel));
        }

        for (int i = numberOfBots; i < numberOfPlayers; ++i) {
            System.out.println("Name of Player " + (i - numberOfBots + 1));
            String name = scanner.next();

            System.out.println("Symbol of Player " + (i - numberOfBots + 1));
            Character character = scanner.next().charAt(0);

            players.add(PlayerFactory.createHumanPlayer(name, character));
        }

        System.out.println("How many winning strategis?");
        Integer winningStrategiesCount = scanner.nextInt();

        List<GameWinningStrategyName> gameWinningStrategyNames = new ArrayList<>();

        for (int i = 0; i < winningStrategiesCount; ++i) {
            System.out.println("Name strategy " + i);
            gameWinningStrategyNames
                    .add(GameWinningStrategyEnumFactory.getGameWinningStrategyNameFromString(scanner.next()));
        }

        Game game = Game.getBuilder()
                .setGameWinningStrategies(gameWinningStrategyNames)
                .setPlayers(players)
                .build();

        String winner = "";
        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
            winner = game.makeMove();
        }

        System.out.println("Winner is: " + winner);
    }
}

// Client -> Main -> Controller -> Models

// person interacts by 1 by 1 giving inputs into the command line and playing
// the game
// Lifecycle of a game
// 0. Start a game
// 1. Create Players, choose symbols
// 2. Determine the size
// 3. Decide Winning Rules

// Break till 10: 35 PM

// Client -> AppClass -> Controller -> Models

/*
 * -------------------- LifeCycle of Game --------------------
 * 1. start the game
 * 2. create players, choose symbols
 * 3. determine the size
 * 4. decide/choose the winning rules
 */
