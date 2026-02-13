package lld.stackoverflow.tictactoe.strategy;

import lld.stackoverflow.tictactoe.entities.Board;
import lld.stackoverflow.tictactoe.entities.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);
}
