package ladder.application;

import java.util.List;
import java.util.Random;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
public class RandomSelectStrategy implements VectorSelectStrategy {
    @Override
    public Vector select(List<Vector> vectors) {
        int number = new Random().nextInt(vectors.size());
        return vectors.get(number);
    }
}
