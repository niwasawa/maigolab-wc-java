package info.maigo.lab.wc;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

class Headers {

    private Map<String, List<String>> headerFields;
    private Properties headers;

    Headers(HttpURLConnection con) {
        this(con.getHeaderFields());
    }

    Headers(Map<String, List<String>> headerFields) {
        Properties p = new Properties();
        for (String key : headerFields.keySet()) {
            if (key != null) {
                List<String> vals = headerFields.get(key);
                p.setProperty(key, StringUtils.join(",", vals));
            }
        }
        this.headerFields = headerFields;
        this.headers = p;
    }

    Properties getHeaders() {
        return this.headers;
    }

    String get(String name) {
        return headers.getProperty(name);
    }
}

