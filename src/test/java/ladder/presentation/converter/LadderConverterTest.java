package ladder.presentation.converter;

import ladder.application.Ladder;
import ladder.application.Line;
import ladder.application.Point;
import ladder.application.Vector;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-02
 */
class LadderConverterTest {
    @Test
    void toLadderResponse() {
        // |----|    |    |----|
        // |    |----|    |----|

        List<Point> points1 = Arrays.asList(new Point(Vector.RIGHT), new Point(Vector.LEFT), new Point(Vector.STRAIGHT), new Point(Vector.RIGHT), new Point(Vector.LEFT));
        List<Point> points2 = Arrays.asList(new Point(Vector.STRAIGHT), new Point(Vector.RIGHT), new Point(Vector.LEFT), new Point(Vector.RIGHT), new Point(Vector.LEFT));

        List<Line> lines = Arrays.asList(new Line(points1), new Line(points2));
        Ladder ladder = new Ladder(lines);

        List<String> response = LadderConverter.toLadderResponse(ladder);
        List<String> result = Arrays.asList("RLSRL", "SRLRL");
        assertEquals(response, result);
    }
}