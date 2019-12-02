package ladder.presentation.converter;

import ladder.application.Ladder;
import ladder.application.Line;
import ladder.application.Point;
import ladder.application.Vector;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-02
 */
public class LadderConverter {
    private static Map<Vector, String> ladderSymbol;

    static {
        ladderSymbol = new LinkedHashMap<>();
        ladderSymbol.put(Vector.RIGHT, "R");
        ladderSymbol.put(Vector.STRAIGHT, "S");
        ladderSymbol.put(Vector.LEFT, "L");
    }

    public static List<String> toLadderResponse(Ladder ladder) {
        List<String> response = new ArrayList<>();

        for (Line line : ladder.getLadder()) {
            StringBuilder stringBuilder = new StringBuilder();
            generateLineResponse(line, stringBuilder);
            response.add(stringBuilder.toString());
        }
        return response;
    }

    private static void generateLineResponse(Line line, StringBuilder stringBuilder) {
        for (Point point : line.getLine()) {
            stringBuilder.append(ladderSymbol.get(point.getVector()));
        }
    }
}
