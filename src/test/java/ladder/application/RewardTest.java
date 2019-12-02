package ladder.application;

import ladder.application.exception.RewardNotMatchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-01
 */
class RewardTest {
    private Reward defaultReward;

    @BeforeEach
    void setUp() {
        List<String> tops = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        List<String> results = Arrays.asList("1", "2", "3", "4", "5");
        Items items = new Items(tops);
        items.addResultItems(results);

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
        Ladder ladder = new Ladder(lines);
        defaultReward = new Reward(items, ladder);
    }

    @Test
    void constructor() {
        Items items = new Items(Arrays.asList("aa", "bb"));
        items.addResultItems(Arrays.asList("11", "22"));
        List<Point> points1 = Arrays.asList(new Point(Vector.STRAIGHT), new Point(Vector.STRAIGHT));
        List<Point> points2 = Arrays.asList(new Point(Vector.STRAIGHT), new Point(Vector.STRAIGHT));
        List<Line> lines = Arrays.asList(new Line(points1), new Line(points2));

        Ladder ladder = new Ladder(lines);
        Reward reward = new Reward(items, ladder);

        assertEquals(reward, new Reward(items, ladder));
    }

    @Test
    void getAll() {
        Map<String, String> result = new HashMap<>();
        result.put("aa", "4");
        result.put("bb", "2");
        result.put("cc", "1");
        result.put("dd", "3");
        result.put("ee", "5");

        assertEquals(result, defaultReward.getAll());

    }

    @Test
    void get() {
        assertThrows(RewardNotMatchException.class, () -> defaultReward.get("11"));
    }
}