package info.maigo.lab.wc;

import java.net.*;
import java.util.*;

public class GetRequest extends Request {

    private final List<KeyValue> params = new ArrayList<KeyValue>();

    public GetRequest(String baseurl) {
        super(baseurl);
    }

    public void add(String key, String value) {
        params.add(new KeyValue(key, value));
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
        for (KeyValue p: params) {
            if (encoding != null) {
                buf.append(URLEncoder.encode(p.key, encoding));
                buf.append(keyValueSeparator);
                buf.append(URLEncoder.encode(p.value, encoding));
            } else {
                buf.append(p.key);
                buf.append(keyValueSeparator);
                buf.append(p.value);
            }
            buf.append(parameterSeparator);
        }
        if (buf.charAt(buf.length() - 1) == parameterSeparator) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }
}

