package info.maigo.lab.wc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GetRequestTest {

    @Test
    public void test() throws Exception {
        GetRequest req = new GetRequest("http://localhost/");
        req.set("foo", "123");
        req.set("bar", "456");
        assertEquals("http://localhost/?bar=456&foo=123", req.getURL());
    }
}

