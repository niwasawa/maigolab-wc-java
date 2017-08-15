package info.maigo.lab.wc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

class Body {

    private final ContentType contentType;
    private final String charset;
    private final byte[] body;

    Body(ContentType contentType, String charset, byte[] body) {
        this.contentType = contentType;
        this.charset = charset;
        this.body = body;
    }
    
    Body(HttpURLConnection con, InputStream in) throws IOException {
        contentType = getContentType(con);
        charset = getCharset(contentType);
        body = getBody(in);
    }
    
    ContentType getContentType() {
        return contentType;
    }

    String getString() {
        try {
            return new String(body, charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    byte[] getBytes() {
        return body;
    }

    private static ContentType getContentType(HttpURLConnection con) {
        String ct = con.getContentType();
        if (ct != null) {
            return new ContentType(ct);
        }
        return null;
    }

    private static String getCharset(ContentType ct) {
        if (ct != null) {
            String cs = ct.getParameter("charset");
            if (cs != null) {
                return cs;
            }
        }
        return "UTF-8"; // default charset;
    }

    private static byte[] getBody(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        copy(in, out);
        return out.toByteArray();
    }

    private static void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buff = new byte[1024];
        int len = in.read(buff);
        while (len != -1) {
            out.write(buff, 0, len);
            len = in.read(buff);
        }
    }

}
