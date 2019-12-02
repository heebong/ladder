package ladder.application;

import java.util.Arrays;
import java.util.List;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
public enum Position {
    START(Arrays.asList(Vector.RIGHT, Vector.STRAIGHT)),
    MIDDLE(Arrays.asList(Vector.RIGHT, Vector.STRAIGHT, Vector.LEFT)),
    END(Arrays.asList(Vector.STRAIGHT, Vector.LEFT));

    private List<Vector> nextVectors;

    Position(List<Vector> nextVectors) {
        this.nextVectors = nextVectors;
    }

    public List<Vector> getNextVectors(Point prePoint) {
        if (this == START) {
            return nextVectors;
        }
        return Utils.findDuplicate(nextVectors, prePoint.getNextVectors());
    }

    public List<Vector> getNextVectors() {
        return nextVectors;
    }
}
