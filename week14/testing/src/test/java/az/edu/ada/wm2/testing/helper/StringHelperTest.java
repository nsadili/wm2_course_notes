package az.edu.ada.wm2.testing.helper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringHelperTest {

    @Test
    @DisplayName("test reverse() method return value")
    void testReverse() {
        String word = "test";
        String expectedRes = "tset";

        String actualRes = StringHelper.reverse(word);

        assertEquals(expectedRes, actualRes);
    }

    @Test
    void testReverseExceptions() {
        assertThrows(NullPointerException.class, () -> StringHelper.reverse(null));

        assertThrows(IllegalArgumentException.class, () -> StringHelper.reverse("  "));
    }
}