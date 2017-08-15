package info.maigo.lab.wc;

import java.net.*;
import java.util.*;

public class GetRequest extends Request {

    private final List<Parameter> params = new ArrayList<Parameter>();

    public GetRequest(String baseurl) {
        super(baseurl);
    }

    public void add(String key, String value) {
        params.add(new Parameter(key, value));
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
        for (Parameter p: params) {
            if (encoding != null) {
                buf.append(URLEncoder.encode(p.name, encoding));
                buf.append(keyValueSeparator);
                buf.append(URLEncoder.encode(p.value, encoding));
            } else {
                buf.append(p.name);
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

    private static class Parameter {
        String name;
        String value;
        Parameter(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }
}

