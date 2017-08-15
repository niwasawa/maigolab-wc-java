package info.maigo.lab.wc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GetRequestTest {

    @Test
    public void testParameters() throws Exception {
        GetRequest req = new GetRequest("http://localhost/");
        req.add("foo", "123");
        req.add("bar", "456");
        assertEquals("http://localhost/?foo=123&bar=456", req.getURL());
    }

    @Test
    public void testSameNameParameters() throws Exception {
        GetRequest req = new GetRequest("http://localhost/");
        req.add("foo", "123");
        req.add("foo", "456");
        assertEquals("http://localhost/?foo=123&foo=456", req.getURL());
    }
}

