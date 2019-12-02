package ladder.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
class PointTest {
    @Test
    void constructor() {
        Point point = new Point(Vector.RIGHT);
        assertEquals(point, new Point(Vector.RIGHT));
    }
}