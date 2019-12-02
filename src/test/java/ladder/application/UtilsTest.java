package ladder.application;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
class UtilsTest {

    @Test
    void findDuplicate() {
        List<Vector> endPosition = Arrays.asList(Vector.STRAIGHT, Vector.LEFT);
        List<Vector> preLeft = Arrays.asList(Vector.RIGHT, Vector.STRAIGHT);

        assertEquals(Utils.findDuplicate(endPosition, preLeft), Collections.singletonList(Vector.STRAIGHT));
    }

    @Test
    void findDuplicate_end_position() {
        List<Vector> position = Position.END.getNextVectors();
        List<Vector> pre = Vector.STRAIGHT.getNextVectors();

        assertEquals(Utils.findDuplicate(position, pre), Arrays.asList(Vector.STRAIGHT));
    }
}