package ladder.application;

import java.util.List;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
public class PointFactory {
    public static Point getPoint(Position position, Point prePoint, VectorSelectStrategy selectStrategy) {
        List<Vector> vectors = position.getNextVectors(prePoint);
        return new Point(selectStrategy.select(vectors));
    }

    public static Point getStartPoint(VectorSelectStrategy selectStrategy) {
        return getPoint(Position.START, null, selectStrategy);
    }

    public static Point getMiddlePoint(Point prePoint, VectorSelectStrategy selectStrategy) {
        return getPoint(Position.MIDDLE, prePoint, selectStrategy);
    }

    public static Point getEndPoint(Point prePoint, VectorSelectStrategy selectStrategy) {
        return getPoint(Position.END, prePoint, selectStrategy);
    }
}
