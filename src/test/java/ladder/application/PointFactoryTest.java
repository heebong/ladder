package ladder.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
class PointFactoryTest {
    @Test
    void getPoint() {
        Point point = PointFactory.getPoint(Position.END, new Point(Vector.RIGHT), vectors -> vectors.get(0));
        assertEquals(point, new Point(Vector.LEFT));

        point = PointFactory.getPoint(Position.MIDDLE, new Point(Vector.RIGHT), vectors -> vectors.get(0));
        assertEquals(point, new Point(Vector.LEFT));
    }
}