package info.maigo.lab.wc;

import java.util.Properties;

public class Response {

    private final int statusCode;
    private final String statusMessage;
    private final Headers headers;
    private final Body body;

    Response(int statusCode, String statusMessage, Headers headers, Body body) {
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

    public String getHeader(String name) {
        return headers.get(name);
    }

    public String[] getHeaders(String name) {
        return headers.gets(name);
    }

    public Properties getHeaders() {
        return headers.getHeaders();
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
        sb.append(headers);
        sb.append(LF);
        sb.append(body);
        return sb.toString();
    }
}
