package ladder.view;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-02
 */
public class OutputView {
    private static final Map<Character, String> ladderSymbol;

    static {
        ladderSymbol = new LinkedHashMap<>();
        ladderSymbol.put('R', "|-----");
        ladderSymbol.put('S', "|     ");
        ladderSymbol.put('L', "|     ");
    }

    public static void outputLadder(List<String> ladderResponse, List<String> topItems, List<String> resultItems) {
        System.out.println("사다리 결과");
        System.out.println(String.join("   ", topItems));
        for (String response : ladderResponse) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < response.length(); i++) {
                stringBuilder.append(ladderSymbol.get(response.charAt(i)));
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println(String.join("    ", resultItems));
    }

    public static void outputReward(String response) {
        System.out.println("실행 결과");
        System.out.println(response);
    }

    public static void outputReward(Map<String, String> response) {
        System.out.println("실행 결과");
        for (Map.Entry<String, String> entry : response.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
