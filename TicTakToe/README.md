https://github.com/Naman-Bhalla/ticTacToeJul22/blob/master/src/main/java/com/scaler/tictactoe/models/Game.java


interface GameWinningStrategy
    boolean checkIfWon(Board board, Player player);

public interface BotPlayingStrategy
    Move makeNextMove(Board board, Player player); take symbol form player and return move



Board
    dimension;
    List<List<Cell>> board
        Cell
            row
            column
            Symbol
                character




Player
    HumanPlayer
            symbol
            playerType
            name
            Move makeMove(Board board)
    BotPlayer
            symbol
            playerType
            name
            Move makeMove(Board board)
            BotPlayingStrategy



Game
    List<Player> players
    Board board
    List<GameWinningStrategy> gameWinningStrategies
    
    playGame()
        get next player from   queue
        player will return move
        process move
        check if current player won
        back to setp 1
                