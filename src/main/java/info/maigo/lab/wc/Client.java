package info.maigo.lab.wc;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Client {

    private Integer connectTimeout;
    private Integer readTimeout;
    
    public Client() {
    }
    
    public void setConnectTimeout(int timeout) {
        connectTimeout = timeout;
    }
    
    public void setReadTimeout(int timeout) {
        readTimeout = timeout;
    }

    public Response get(GetRequest req) {

        try {
            URL url = new URL(req.getURL());
            List<KeyValue> headers = req.getHeaders();
            
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            
            if(connectTimeout != null) {
                con.setConnectTimeout(connectTimeout);
            }
            if(readTimeout != null) {
                con.setReadTimeout(readTimeout);
            }

            con.setRequestMethod("GET");

            // http request headers
            for (KeyValue kv : headers) {
                con.addRequestProperty(kv.key, kv.value);
            }

            con.connect();

            int statusCode = con.getResponseCode();
            String statusMessage = con.getResponseMessage();

            Headers resHeaders = new Headers(con);

            InputStream is = con.getInputStream();
            Body body = new Body(con, is);
            is.close();

            return new Response(statusCode, statusMessage, resHeaders, body);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return getClass().getName() + " : " + super.toString();
    }
}
