package info.maigo.lab.wc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeadersTest {

    @Test
    public void test() {
        {
            Map<String, List<String>> fields = new HashMap<String, List<String>>() {
                {
                    put("X-Foo", Arrays.asList("foo", "bar", "baz"));
                }
            };
            Headers h = new Headers(fields);
            assertEquals("foo,bar,baz", h.get("X-Foo"));
            assertEquals(new String[]{"foo","bar","baz"}, h.gets("X-Foo"));
        }
    }
}

