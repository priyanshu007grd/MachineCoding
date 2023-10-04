package org.example.Strategy;

import org.example.Board;
import org.example.Model.Player;

public interface GameWinningStrategy {
    boolean checkIfWon(Board board, Player player);
}
