package ladder.application;

import ladder.application.exception.HeightException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-01
 */
public class Ladder {
    private static final int MIN_COUNT = 1;

    private final List<Line> ladder;

    public Ladder(int topCount, int height, VectorSelectStrategy selectStrategy) {
        validate(height);
        this.ladder = generateLadder(topCount, height, selectStrategy);
    }

    public Ladder(List<Line> ladder) {
        validate(ladder.size());
        this.ladder = ladder;
    }

    private void validate(int height) {
        if (height < MIN_COUNT) {
            throw new HeightException("높이는 1 이상이어야 합니다.");
        }
    }

    private List<Line> generateLadder(int topCount, int height, VectorSelectStrategy selectStrategy) {
        List<Line> ladder = new ArrayList<>();
        IntStream.range(0, height).forEach(index -> ladder.add(new Line(topCount, selectStrategy)));
        return ladder;
    }

    public int getTopCount() {
        return ladder.get(0).size();
    }

    public List<Integer> generateResult(List<Integer> topItems) {
        List<Integer> result = topItems;
        for (Line line : ladder) {
            result = line.climb(result);
        }
        return result;
    }

    public List<Line> getLadder() {
        return ladder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ladder ladder1 = (Ladder) o;

        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return ladder != null ? ladder.hashCode() : 0;
    }
}
