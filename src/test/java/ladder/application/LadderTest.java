package ladder.application;

import ladder.application.exception.HeightException;
import ladder.application.exception.TopCountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-01
 */
class LadderTest {
    private Ladder defaultLadder;

    @BeforeEach
    void setUp() {
        // 3    1    0    2    4
        // |----|    |    |----|
        // |    |----|    |----|
        // |    |    |----|    |
        // |----|    |    |    |
        List<Point> points1 = Arrays.asList(new Point(Vector.RIGHT), new Point(Vector.LEFT), new Point(Vector.STRAIGHT), new Point(Vector.RIGHT), new Point(Vector.LEFT));
        List<Point> points2 = Arrays.asList(new Point(Vector.STRAIGHT), new Point(Vector.RIGHT), new Point(Vector.LEFT), new Point(Vector.RIGHT), new Point(Vector.LEFT));
        List<Point> points3 = Arrays.asList(new Point(Vector.STRAIGHT), new Point(Vector.STRAIGHT), new Point(Vector.RIGHT), new Point(Vector.LEFT), new Point(Vector.STRAIGHT));
        List<Point> points4 = Arrays.asList(new Point(Vector.RIGHT), new Point(Vector.LEFT), new Point(Vector.STRAIGHT), new Point(Vector.STRAIGHT), new Point(Vector.STRAIGHT));

        List<Line> lines = Arrays.asList(new Line(points1), new Line(points2), new Line(points3), new Line(points4));
        defaultLadder = new Ladder(lines);
    }

    @Test
    void constructor() {
        int topCount = 5;
        int height = 6;
        Ladder ladder = new Ladder(topCount, height, vectors -> Vector.STRAIGHT);
        assertEquals(ladder, new Ladder(topCount, height, vectors -> Vector.STRAIGHT));
    }

    @Test
    void constructor_topCount_exception() {
        assertThrows(TopCountException.class, () -> new Ladder(1, 6, new RandomSelectStrategy()));
    }

    @Test
    void constructor_height_exception() {
        assertThrows(HeightException.class, () -> new Ladder(3, 0, new RandomSelectStrategy()));
    }

    @Test
    void constructor_height_list_exception() {
        assertThrows(HeightException.class, () -> new Ladder(new ArrayList<>()));
    }

    @Test
    void generateResult() {
        int topCount = defaultLadder.getTopCount();

        List<Integer> result = defaultLadder.generateResult(IntStream.range(0, topCount).boxed().collect(Collectors.toList()));
        assertEquals(result, Arrays.asList(3, 1, 0, 2, 4));
    }
}