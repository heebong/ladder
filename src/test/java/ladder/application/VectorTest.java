package ladder.application;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
class VectorTest {
    @Test
    void getNextVectors() {
        assertEquals(Vector.RIGHT.getNextVectors(), Collections.singletonList(Vector.LEFT));
        assertEquals(Vector.STRAIGHT.getNextVectors(), Arrays.asList(Vector.RIGHT, Vector.STRAIGHT));
        assertEquals(Vector.LEFT.getNextVectors(), Arrays.asList(Vector.RIGHT, Vector.STRAIGHT));
    }

    @Test
    void calculateNextIndex() {
        int index = 3;
        assertEquals(Vector.LEFT.getNextIndex().apply(index), index - 1);
        assertEquals(Vector.STRAIGHT.getNextIndex().apply(index), index);
        assertEquals(Vector.RIGHT.getNextIndex().apply(index), index + 1);
    }
}