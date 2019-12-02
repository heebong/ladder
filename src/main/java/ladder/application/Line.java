package ladder.application;

import ladder.application.exception.TopCountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
public class Line {
    private int MIN_COUNT = 2;

    private List<Point> line;

    public Line(int topCount, VectorSelectStrategy selectStrategy) {
        validate(topCount);
        this.line = generateLine(topCount, selectStrategy);
    }

    public Line(List<Point> line) {
        validate(line.size());
        this.line = line;
    }

    private void validate(int topCount) {
        if (topCount < MIN_COUNT) {
            throw new TopCountException("입력은 2개 이상 해야합니다.");
        }
    }

    private List<Point> generateLine(int topCount, VectorSelectStrategy selectStrategy) {
        List<Point> line = new ArrayList<>();
        Point prePoint = PointFactory.getStartPoint(selectStrategy);
        for (int i = 0; i < topCount - 1; i++) {
            line.add(prePoint);
            prePoint = PointFactory.getMiddlePoint(prePoint, selectStrategy);
        }
        line.add(PointFactory.getEndPoint(line.get(line.size() - 1), selectStrategy));

        return line;
    }

    public List<Integer> climb(List<Integer> preResult) {
        List<Integer> result = new ArrayList<>();
        for (Integer preElement : preResult) {
            result.add(line.get(preElement).climb(preElement));
        }
        return result;
    }

    public int size() {
        return line.size();
    }

    public Point get(int index) {
        return line.get(index);
    }

    public List<Point> getLine() {
        return line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line1 = (Line) o;

        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return line != null ? line.hashCode() : 0;
    }
}
