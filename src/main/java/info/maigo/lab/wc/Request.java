package info.maigo.lab.wc;

import java.util.*;

abstract class Request {

    protected final String baseurl;
    protected String encoding = "UTF-8";
    private final Properties headers = new Properties();

    Request(String baseurl) {
        this.baseurl = baseurl;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getBaseURL() {
        return baseurl;
    }

    public Properties getHeaders() {
        return headers;
    }

    public void setHeaders(Properties headers) {
        this.headers.putAll(headers);
    }

    public void setHeader(String key, String value) {
        headers.setProperty(key, value);
    }

    public String removeHeader(String key) {
        return (String) headers.remove(key);
    }
}
