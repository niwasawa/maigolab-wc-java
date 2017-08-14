package info.maigo.lab.wc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContentTypeTest {

    public static void main(String[] args) {
        String[] tests = {
            "text/plain",
            "text/html; charset=utf-8",
            "application/json; charset=utf-8",
            "application/xml",
            "application/xhtml+xml",
            "application/javascript",
            "image/gif",
            "application/vnd.ms-excel",
            "application/vnd.ms-excel; charset=Shift-JIS",
            "application/x-java-applet;jpi-version=1.4.2",
            "multipart/related;boundary=Boundary;type=text/xml",
        };
        for (String test: tests) {
            ContentType ct = new ContentType(test);
            System.out.println(ct.toString());
        }
    }

    @Test
    public void test() {

        {
            ContentType ct = new ContentType("text/plain");
            assertEquals("text", ct.getPrimaryType());
            assertEquals("plain", ct.getSubType());
        }
        {
            ContentType ct = new ContentType("text/html; charset=utf-8");
            assertEquals("text", ct.getPrimaryType());
            assertEquals("html", ct.getSubType());
            assertEquals("utf-8", ct.getParameter("charset"));
        }
        {
            ContentType ct = new ContentType("application/json; charset=utf-8");
            assertEquals("application", ct.getPrimaryType());
            assertEquals("json", ct.getSubType());
            assertEquals("utf-8", ct.getParameter("charset"));
        }
        {
            ContentType ct = new ContentType("application/xml");
            assertEquals("application", ct.getPrimaryType());
            assertEquals("xml", ct.getSubType());
        }
        {
            ContentType ct = new ContentType("application/xhtml+xml");
            assertEquals("application", ct.getPrimaryType());
            assertEquals("xhtml+xml", ct.getSubType());
        }
        {
            ContentType ct = new ContentType("application/javascript");
            assertEquals("application", ct.getPrimaryType());
            assertEquals("javascript", ct.getSubType());
        }
        {
            ContentType ct = new ContentType("image/gif");
            assertEquals("image", ct.getPrimaryType());
            assertEquals("gif", ct.getSubType());
        }
        {
            ContentType ct = new ContentType("application/vnd.ms-excel");
            assertEquals("application", ct.getPrimaryType());
            assertEquals("vnd.ms-excel", ct.getSubType());
        }
        {
            ContentType ct = new ContentType("application/vnd.ms-excel; charset=Shift-JIS");
            assertEquals("application", ct.getPrimaryType());
            assertEquals("vnd.ms-excel", ct.getSubType());
            assertEquals("Shift-JIS", ct.getParameter("charset"));
        }
        {
            ContentType ct = new ContentType("application/x-java-applet;jpi-version=1.4.2");
            assertEquals("application", ct.getPrimaryType());
            assertEquals("x-java-applet", ct.getSubType());
            assertEquals("1.4.2", ct.getParameter("jpi-version"));
        }
        {
            ContentType ct = new ContentType("multipart/related;boundary=Boundary;type=text/xml");
            assertEquals("multipart", ct.getPrimaryType());
            assertEquals("related", ct.getSubType());
            assertEquals("Boundary", ct.getParameter("boundary"));
            assertEquals("text/xml", ct.getParameter("type"));
        }
    }
}

