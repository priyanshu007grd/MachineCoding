package org.example;

import org.example.Model.Player;
import org.example.Strategy.GameWinningStrategy;

import java.util.List;
import java.util.Queue;

public class Game {
    Board board;
    Queue<Player> playerQ;
    List<GameWinningStrategy> gameWinningStrategyList;
}
