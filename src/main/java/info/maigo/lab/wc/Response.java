package info.maigo.lab.wc;

import java.util.Properties;

public class Response {

    private final int statusCode;
    private final String statusMessage;
    private final Properties headers;
    private final Body body;

    Response(int statusCode, String statusMessage, Properties headers, Body body) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.headers = headers;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public Properties getHeaders() {
        return headers;
    }

    public ContentType getContentType() {
        return body.getContentType();
    }

    public String getBodyString() {
        return body.getString();
    }

    public byte[] getBody() {
        return body.getBytes();
    }

    public String toString() {
        final String LF = "\r\n";
        StringBuilder sb = new StringBuilder();
        sb.append(statusCode + " " + statusMessage + LF);
        for (String key : headers.stringPropertyNames()) {
            sb.append(key + ": " + headers.getProperty(key) + LF);
        }
        sb.append(LF);
        sb.append(body);
        return sb.toString();
    }
}
