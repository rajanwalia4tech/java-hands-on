package lld.tictactoe.states;

import lld.tictactoe.entities.Game;
import lld.tictactoe.entities.Player;
import lld.tictactoe.exceptions.InvalidMoveException;

public class DrawState implements GameState{

    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game is already over. It was a draw.");
    }
}
