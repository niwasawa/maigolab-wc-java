package info.maigo.lab.wc;

import java.util.*;

abstract class Request {

    protected final String baseurl;
    protected String encoding = "UTF-8";
    private final List<KeyValue> headers = new ArrayList<KeyValue>();

    Request(String baseurl) {
        this.baseurl = baseurl;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getBaseURL() {
        return baseurl;
    }

    List<KeyValue> getHeaders() {
        return headers;
    }

    public void addHeader(String key, String value) {
        headers.add(new KeyValue(key, value));
    }
}

