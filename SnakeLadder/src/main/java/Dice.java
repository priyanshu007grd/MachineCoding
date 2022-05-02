import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dice {
    private int minValue;
    private int maxValue;

    public int roll() {
        Random rand = new Random();
        return rand.nextInt(minValue, maxValue + 1);
    }
}
