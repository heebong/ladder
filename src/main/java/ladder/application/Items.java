package ladder.application;

import ladder.application.exception.ResultItemsException;
import ladder.application.exception.TopCountException;
import ladder.application.exception.TopItemsException;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-01
 */
public class Items {
    private static final int MIN_NAME_LENGTH_COUNT = 1;
    private static final int MAX_NAME_LENGTH_COUNT = 5;
    private static final int MIN_NAME_COUNT = 2;
    private static final String ALL = "all";

    private final List<String> topItems;
    private List<String> resultItems;

    public Items(List<String> topItems) {
        topValidate(topItems);
        this.topItems = topItems;
    }

    public void addResultItems(List<String> resultItems) {
        resultValidate(resultItems);
        this.resultItems = resultItems;
    }

    private void topValidate(List<String> topItems) {
        validateNotAll(topItems);
        validateLength(topItems);
        validateDuplicate(topItems);
        validateCount(topItems);
    }

    private void resultValidate(List<String> resultItems) {
        validateLength(resultItems);
        validateSameCount(resultItems);
    }

    private void validateNotAll(List<String> topItems) {
        topItems.forEach(topItem -> {
            if (ALL.equals(topItem)) {
                throw new TopItemsException("all은 이름으로 사용할 수 없습니다.");
            }
        });
    }

    private void validateLength(List<String> items) {
        items.forEach(topItem -> {
            if (MIN_NAME_LENGTH_COUNT > topItem.length() || topItem.length() > MAX_NAME_LENGTH_COUNT) {
                throw new TopItemsException("이름은 5글자 이하여야 합니다.");
            }
        });
    }

    private void validateCount(List<String> topItems) {
        if (topItems.size() < MIN_NAME_COUNT) {
            throw new TopCountException("입력은 2개 이상 해야합니다.");
        }
    }

    private void validateSameCount(List<String> resultItem) {
        if (topItems.size() != resultItem.size()) {
            throw new ResultItemsException("입력하신 아이템의 수와 같아야 합니다.");
        }
    }

    private void validateDuplicate(List<String> topItems) {
        int duplicateSize = new HashSet<>(topItems).size();
        if (topItems.size() != duplicateSize) {
            throw new TopItemsException("중복되는 이름은 사용할 수 없습니다.");
        }
    }

    public List<String> getResultItems() {
        return resultItems;
    }

    public List<String> getTopItems() {
        return topItems;
    }

    public int size() {
        return topItems.size();
    }

    public String getTopItem(int index) {
        return topItems.get(index);
    }

    public String getResultItem(int index) {
        return resultItems.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Items items = (Items) o;

        return Objects.equals(topItems, items.topItems);
    }

    @Override
    public int hashCode() {
        return topItems != null ? topItems.hashCode() : 0;
    }
}
