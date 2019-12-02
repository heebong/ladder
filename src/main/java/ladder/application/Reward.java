package ladder.application;

import ladder.application.exception.RewardNotMatchException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-01
 */
public class Reward {
    private final Map<String, String> reward;

    public Reward(Items items, Ladder ladder) {
        this.reward = generateReward(items, ladder);
    }

    private Map<String, String> generateReward(Items items, Ladder ladder) {
        Map<String, String> reward = new LinkedHashMap<>();
        int topCount = items.size();
        List<Integer> results = ladder.generateResult(IntStream.range(0, topCount).boxed().collect(Collectors.toList()));
        for (int i = 0; i < topCount; i++) {
            reward.put(items.getTopItem(i), items.getResultItem(results.get(i)));
        }
        return reward;
    }


    public Map<String, String> getAll() {
        return reward;
    }

    public String get(String key) {
        if (!reward.keySet().contains(key)) {
            throw new RewardNotMatchException();
        }
        return reward.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reward reward1 = (Reward) o;

        return Objects.equals(reward, reward1.reward);
    }

    @Override
    public int hashCode() {
        return reward != null ? reward.hashCode() : 0;
    }
}
