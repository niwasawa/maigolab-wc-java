package info.maigo.lab.wc;

import java.util.Properties;

/**
 * MIME ContentType.
 */
public class ContentType {

    private String primaryType = null;
    private String subType = null;
    private Properties parameters = new Properties();

    /**
     * Constructor.
     * 
     * @param s the Content-Type string. (ex. "text/html; charset=utf-8", "image/gif", or etc.)
     */
    ContentType(String s) {
        String[] ss = s.split(";");
        if (ss != null) {
            // type
            if (ss.length >= 1) {
                String[] type = ss[0].trim().split("/");
                if (type != null) {
                    if (type.length >= 1) {
                        primaryType = type[0];
                    }
                    if (type.length >= 2) {
                        subType = type[1];
                    }
                }
            }
            // parameters
            for (int i = 1; i < ss.length; i++) {
                String[] kv = ss[i].trim().split("=");
                if (kv != null && kv.length == 2) {
                    parameters.setProperty(kv[0], kv[1]);
                }
            }
        }
    }

    public String getPrimaryType() {
        return primaryType;
    }

    public String getSubType() {
        return subType;
    }

    public String getParameter(String attribute) {
        return parameters.getProperty(attribute);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Primary Type: " + getPrimaryType() + "\n");
        sb.append("Sub Type: " + getSubType() + "\n");
        sb.append("Parameters: [" + "\n");
        for (String attribute: parameters.stringPropertyNames()) {
            String value = parameters.getProperty(attribute);
            sb.append("  " + attribute + "=" + value + "\n");
        }
        sb.append("]");
        return sb.toString();
    }
}
