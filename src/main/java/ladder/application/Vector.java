package ladder.application;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
public enum Vector {
    RIGHT(index -> index + 1),
    STRAIGHT(index -> index),
    LEFT(index -> index - 1);

    private IntFunction<Integer> nextIndex;

    Vector(IntFunction<Integer> nextIndex) {
        this.nextIndex = nextIndex;
    }

    public List<Vector> getNextVectors() {
        if (this.equals(RIGHT)) {
            return Collections.singletonList(LEFT);
        }
        if (this.equals(STRAIGHT)) {
            return Arrays.asList(RIGHT, STRAIGHT);
        }
        if (this.equals(LEFT)) {
            return Arrays.asList(RIGHT, STRAIGHT);
        }
        throw new IllegalArgumentException();
    }

    public IntFunction<Integer> getNextIndex() {
        return nextIndex;
    }
}
