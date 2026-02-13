package lld.stackoverflow.tictactoe.states;

import lld.stackoverflow.tictactoe.entities.Game;
import lld.stackoverflow.tictactoe.entities.Player;
import lld.stackoverflow.tictactoe.exceptions.InvalidMoveException;

public class DrawState implements GameState{

    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game is already over. It was a draw.");
    }
}
