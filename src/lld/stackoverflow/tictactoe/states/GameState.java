package lld.stackoverflow.tictactoe.states;

import lld.stackoverflow.tictactoe.entities.Game;
import lld.stackoverflow.tictactoe.entities.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
