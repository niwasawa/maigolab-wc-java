package info.maigo.lab.wc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseTest {

    @Test
    public void test() {
        {
            Map<String, List<String>> fields = new HashMap<String, List<String>>() {
                {
                    put("X-Foo", Arrays.asList("foo", "bar", "baz"));
                }
            };
            Headers h = new Headers(fields);
            ContentType ct = new ContentType("text/plain");
            Body b = new Body(ct, "utf-8", new byte[0]);
            Response res = new Response(200, "OK", h, b);
            assertEquals("foo,bar,baz", res.getHeader("X-Foo"));
            assertEquals(new String[]{"foo","bar","baz"}, res.getHeaders("X-Foo"));
        }
    }
}

