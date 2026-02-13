package lld.stackoverflow.tictactoe.observer;

import lld.stackoverflow.tictactoe.entities.Game;

public interface GameObserver {
    void update(Game game);
}