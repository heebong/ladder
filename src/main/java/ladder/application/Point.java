package ladder.application;

import java.util.List;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
public class Point {
    private final Vector vector;

    public Point(Vector vector) {
        this.vector = vector;
    }

    public int climb(int index) {
        return vector.getNextIndex().apply(index);
    }

    public List<Vector> getNextVectors() {
        return vector.getNextVectors();
    }

    public Vector getVector() {
        return vector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return vector == point.vector;
    }

    @Override
    public int hashCode() {
        return vector != null ? vector.hashCode() : 0;
    }
}
