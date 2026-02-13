package lld.tictactoe.states;

import lld.tictactoe.entities.Game;
import lld.tictactoe.entities.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
