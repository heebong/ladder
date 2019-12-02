package ladder.application;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-11-30
 */
public class Utils {
    public static <T> List<T> findDuplicate(List<T> targetList, List<T> sourceList) {
        return targetList.stream()
            .flatMap(target -> sourceList.stream()
                .filter(source -> source.equals(target)))
            .collect(Collectors.toList());
    }
}
