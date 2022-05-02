import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    Integer boardSize;
    Queue<Player> playerQ;
    Map<Player,Integer> playerM;
    Map<Integer,Snake> snakeM;
    Map<Integer,Ladder> ladderM;
    Dice dice;


    public void playGame() {
        while (true) {
            Player player = playerQ.poll();
            int val = dice.roll();
            int newPosition = getPosition(playerM.getOrDefault(player,0), val);

            playerM.put(player,newPosition);
            if (newPosition == boardSize) {
                System.out.println("Player " + player.getName() + " Won.");
            } else {
                System.out.println("Setting " + player.getName() + "'s new position to " + playerM.get(player));
                playerQ.add(player);
            }
            if (playerQ.size() < 2) {
                break;
            }
        }
    }

    private Integer getPosition(Integer startPos,Integer dice) {

        Integer newPos = startPos + dice;

        if (snakeM.containsKey(newPos)) {
            System.out.println("Snake Bit");
            Snake snake = snakeM.get(newPos);
            return snake.getTail();
        }

        if (ladderM.containsKey(newPos)) {
            System.out.println("Climbed ladder");
            Ladder ladder = ladderM.get(newPos);
            return ladder.getEnd();
        }
        return newPos>boardSize?startPos:newPos;
    }
}
