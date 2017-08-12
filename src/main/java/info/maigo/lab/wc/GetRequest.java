package info.maigo.lab.wc;

import java.net.*;
import java.util.*;

public class GetRequest extends Request {

    private final Properties params = new Properties();

    public GetRequest(String baseurl) {
        super(baseurl);
    }

    public void set(Properties params) {
        this.params.putAll(params);
    }

    public void set(String key, String value) {
        params.setProperty(key, value);
    }

    public String remove(String key) {
        return (String) params.remove(key);
    }

    public String getURL() throws Exception {

        if (params.size() == 0) {
            return baseurl;
        }

        StringBuffer buf = new StringBuffer();
        buf.append(baseurl);
        if (!baseurl.endsWith("?") && params.size() > 0) {
            buf.append("?");
        }

        String qs = getParametersString('=', '&');
        buf.append(qs);

        return buf.toString();
    }

    private String getParametersString(char keyValueSeparator, char parameterSeparator) throws Exception {
        StringBuffer buf = new StringBuffer();
        for (String key : params.stringPropertyNames()) {
            String val = params.getProperty(key);
            buf.append(key);
            buf.append(keyValueSeparator);
            if (encoding != null) {
                buf.append(URLEncoder.encode(val, encoding));
            } else {
                buf.append(val);
            }
            buf.append(parameterSeparator);
        }
        if (buf.charAt(buf.length() - 1) == parameterSeparator) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }
}
