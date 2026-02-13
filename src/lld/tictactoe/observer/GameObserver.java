package lld.tictactoe.observer;

import lld.tictactoe.entities.Game;

public interface GameObserver {
    void update(Game game);
}