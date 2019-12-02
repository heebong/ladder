package ladder.application;

import ladder.application.exception.TopCountException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
class LineTest {
    @Test
    void constructor() {
        int topCount = 5;
        VectorSelectStrategy selectStrategy = vectors -> Vector.STRAIGHT;
        Line line = new Line(topCount, selectStrategy);
        assertEquals(line, new Line(topCount, selectStrategy));
    }

    @Test
    void constructor_count_exception() {
        int topCount = 2;
        VectorSelectStrategy selectStrategy = vectors -> vectors.get(0);
        assertThrows(TopCountException.class, () -> new Line(topCount - 1, selectStrategy));
        assertDoesNotThrow(() -> new Line(topCount, selectStrategy));
    }

    @Test
    void constructor_count() {
        int topCount = 5;
        Line line = new Line(topCount, new RandomSelectStrategy());
        assertEquals(line.size(), topCount);
        assertNotEquals(line.get(0), new Point(Vector.LEFT));
        assertNotEquals(line.get(4), new Point(Vector.RIGHT));
    }

    @Test
    void constructor_list() {
        List<Point> points = Arrays.asList(new Point(Vector.RIGHT), new Point(Vector.LEFT));
        Line line = new Line(points);
        assertEquals(line.size(), points.size());
    }

    @Test
    void constructor_list_size_exception() {
        List<Point> points = Collections.singletonList(new Point(Vector.STRAIGHT));
        assertThrows(TopCountException.class, () -> new Line(points));
    }

    @Test
    void climb() {
        // |----|    |    |----|
        List<Point> points = Arrays.asList(new Point(Vector.RIGHT), new Point(Vector.LEFT), new Point(Vector.STRAIGHT), new Point(Vector.RIGHT), new Point(Vector.LEFT));
        Line line = new Line(points);
        List<Integer> result = line.climb(Arrays.asList(0, 1, 2, 3, 4));
        assertEquals(result, Arrays.asList(1, 0, 2, 4, 3));
    }

    @Test
    void climb_list() {
        // |----|    |    |----|
        // |    |----|    |----|
        List<Point> firstPoints = Arrays.asList(new Point(Vector.RIGHT), new Point(Vector.LEFT), new Point(Vector.STRAIGHT), new Point(Vector.RIGHT), new Point(Vector.LEFT));
        List<Point> secondPoints = Arrays.asList(new Point(Vector.STRAIGHT), new Point(Vector.RIGHT), new Point(Vector.LEFT), new Point(Vector.RIGHT), new Point(Vector.LEFT));

        List<Line> lines = Arrays.asList(new Line(firstPoints), new Line(secondPoints));
        List<Integer> result = IntStream.range(0, 5).boxed().collect(Collectors.toList());
        for (Line line : lines) {
            result = line.climb(result);
        }
        assertEquals(result, Arrays.asList(2, 0, 1, 3, 4));
    }
}