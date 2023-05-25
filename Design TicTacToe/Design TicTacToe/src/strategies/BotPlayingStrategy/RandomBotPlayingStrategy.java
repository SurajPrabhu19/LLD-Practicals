package strategies.BotPlayingStrategy;

import models.Board;
import models.Move;
import models.Player;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board, Player player) {

        // TODO Auto-generated method stub
        for (var row : board.getBoard()) {
            for (var cell : row) {
                if (cell.getPlayer() == null) {
                    return new Move(cell.getRow(), cell.getColumn(), player);
                }
            }
        }
        return null;
    }

}
