package ladder.presentation.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-02
 */
public class ItemConverter {
    public static List<String> toItems(String input) {
        return Arrays.stream(input.split(",")).map(String::trim).collect(Collectors.toList());
    }
}
