import info.maigo.lab.wc.Client;
import info.maigo.lab.wc.GetRequest;
import info.maigo.lab.wc.Response;

public class AppTest {

    public static void main(String[] args) throws Exception {
        final String appid = "<YOUR APPLICATION ID>"; 
        testDownloadJSON(appid);
        testDownloadXML(appid);
        testDownloadPNG(appid);
    }
    
    public static void testDownloadJSON(String appid) {
        
        // request
        GetRequest req = new GetRequest("https://map.yahooapis.jp/search/local/V1/localSearch");
        req.setHeader("User-Agent", "Yahoo AppID: " + appid);
        req.set("query", "ラーメン");
        req.set("output", "json");
        req.set("results", "1");

        // client
        Client c = new Client();

        // response
        Response res = c.get(req);
        System.out.println("============================================================");
        System.out.println("StatusCode: " + res.getStatusCode());
        System.out.println("StatusMessage: " + res.getStatusMessage());
        System.out.println("Headers: " + res.getHeaders());
        System.out.println("ContentType: " + res.getContentType());
        System.out.println("Body: " + res.getBodyString());
    }
    
    public static void testDownloadXML(String appid) {
        
        // request
        GetRequest req = new GetRequest("https://map.yahooapis.jp/search/local/V1/localSearch");
        req.setHeader("User-Agent", "Yahoo AppID: " + appid);
        req.set("query", "ラーメン");
        req.set("output", "xml");
        req.set("results", "1");

        // client
        Client c = new Client();

        // response
        Response res = c.get(req);
        System.out.println("============================================================");
        System.out.println("StatusCode: " + res.getStatusCode());
        System.out.println("StatusMessage: " + res.getStatusMessage());
        System.out.println("Headers: " + res.getHeaders());
        System.out.println("ContentType: " + res.getContentType());
        System.out.println("Body: " + res.getBodyString());
    }
    
    public static void testDownloadPNG(String appid) {
        
        // request
        GetRequest req = new GetRequest("https://map.yahooapis.jp/map/V1/static");
        req.setHeader("User-Agent", "Yahoo AppID: " + appid);
        req.set("lat", "35.185556");
        req.set("lon", "136.899061");
        req.set("z", "18");

        // client
        Client c = new Client();

        // response
        Response res = c.get(req);
        System.out.println("============================================================");
        System.out.println("StatusCode: " + res.getStatusCode());
        System.out.println("StatusMessage: " + res.getStatusMessage());
        System.out.println("Headers: " + res.getHeaders());
        System.out.println("ContentType: " + res.getContentType());
        //System.out.println("Body: " + res.getBody());
        System.out.println("Body: " + res.getBodyString());
    }
}
