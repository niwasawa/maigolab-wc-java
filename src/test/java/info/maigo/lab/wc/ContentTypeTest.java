package info.maigo.lab.wc;

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
}
