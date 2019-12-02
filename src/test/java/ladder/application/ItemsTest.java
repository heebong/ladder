package ladder.application;

import ladder.application.exception.ResultItemsException;
import ladder.application.exception.TopCountException;
import ladder.application.exception.TopItemsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-01
 */
class ItemsTest {
    private Items defaultItems;

    @BeforeEach
    void setUp() {
        List<String> topItems = Arrays.asList("hi", "my", "name", "is");
        defaultItems = new Items(topItems);
    }

    @Test
    void constructor() {
        List<String> topItems = Arrays.asList("hi", "my", "name", "is");
        Items items = new Items(topItems);
        assertEquals(items, new Items(topItems));
    }

    @Test
    void constructor_name_length_exception() {
        List<String> topItems = Arrays.asList("my", "hihihi");
        assertThrows(TopItemsException.class, () -> new Items(topItems));
    }

    @Test
    void constructor_count_exception() {
        List<String> topItems = Arrays.asList("my");
        assertThrows(TopCountException.class, () -> new Items(topItems));
    }

    @Test
    void constructor_duplicate_exception() {
        List<String> topItems = Arrays.asList("my", "hi", "my");
        assertThrows(TopItemsException.class, () -> new Items(topItems));
    }

    @Test
    void constructor_all_exception() {
        List<String> topItems = Arrays.asList("my", "hi", "all");
        assertThrows(TopItemsException.class, () -> new Items(topItems));
    }

    @Test
    void addResultItems() {
        List<String> resultItems = Arrays.asList("0", "x", "0", "x");
        defaultItems.addResultItems(resultItems);
        assertEquals(defaultItems.getResultItems(), resultItems);
    }

    @Test
    void addResultItems_count_exception() {
        assertThrows(ResultItemsException.class, () -> defaultItems.addResultItems(Arrays.asList("0", "x")));
    }
}