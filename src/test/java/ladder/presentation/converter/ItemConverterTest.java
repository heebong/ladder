package ladder.presentation.converter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author heebg
 * @version 1.0
 * @date 2019-12-02
 */
class ItemConverterTest {
    @Test
    void toItems() {
        String input = "hi, hello, my, name";
        List<String> request = ItemConverter.toItems(input);
        assertEquals(request, Arrays.asList("hi", "hello", "my", "name"));
    }
}