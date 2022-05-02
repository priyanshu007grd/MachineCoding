import java.util.*;

public class GameFactory {

    private static Scanner scanner = new Scanner(System.in);
    private static Random rand = new Random();

    public static Game StandardSnakeLadderGame() {

        System.out.println("Enter board Size");
        Integer boardSize = scanner.nextInt();

        Queue<Player> playerQ = getPlayerQueue();
        Map<Player,Integer> playerM = new HashMap<>();
        Map<Integer,Snake> snakeM = getSnakeMap(boardSize);
        Map<Integer,Ladder> ladderM = getLadderMap(boardSize);

        return Game.builder()
                .boardSize(boardSize)
                .playerQ(playerQ)
                .playerM(playerM)
                .snakeM(snakeM)
                .ladderM(ladderM)
                .dice(new Dice(1,6))
                .build();
    }

    private static Queue<Player> getPlayerQueue() {
        Queue<Player> playerQ = new LinkedList<>();
        System.out.println("Enter number of players");
        int numberOfPlayers = scanner.nextInt();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter player name");
            String pName = scanner.next();
            Player player = new Player(pName);
            playerQ.add(player);
        }

        return playerQ;
    }

    private static Map<Integer,Snake> getSnakeMap(Integer boardSize) {
        Map<Integer,Snake> snakeM = new HashMap<>();
        System.out.println("Enter number of snakes");
        int numSnakes = scanner.nextInt();

        for (int i = 0; i < numSnakes; i++) {
            while (true) {
                int snakeHead = rand.nextInt(1, boardSize);
                int snakeTail = rand.nextInt(1, boardSize);
                if (snakeTail >= snakeHead)
                    continue;
                if (!snakeM.containsKey(snakeHead)) {
                    Snake snake = new Snake(snakeHead, snakeTail);
                    snakeM.put(snake.head,snake);
                    break;
                }
            }
        }
        return snakeM;
    }

    private static Map<Integer,Ladder> getLadderMap(Integer boardSize) {
        Map<Integer,Ladder> ladderM = new HashMap<>();

        System.out.println("Enter number of ladders");
        int numLadders = scanner.nextInt();

        for (int i = 0; i < numLadders; i++) {
            while (true) {
                int ladderStart = rand.nextInt(1, boardSize);
                int ladderEnd = rand.nextInt(1, boardSize);
                if (ladderEnd <= ladderStart)
                    continue;
                if (!ladderM.containsKey(ladderStart)) {
                    Ladder ladder = new Ladder(ladderStart, ladderEnd);
                    ladderM.put(ladderStart,ladder);
                    break;
                }
            }
        }
        return ladderM;
    }
}
