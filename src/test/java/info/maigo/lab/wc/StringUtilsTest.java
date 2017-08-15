package info.maigo.lab.wc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StringUtilsTest {

    @Test
    public void test() {
        {
            List<String> elements = Arrays.asList("foo", "bar", "baz");
            assertEquals("foo bar baz", StringUtils.join(" ", elements));
        }
    }
}

