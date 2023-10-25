import com.sun.net.httpserver.HttpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SampleBackend
{
    static int PORT = 8001;
    static String CONTEX = "/mock";
    //curl http://localhost:8000/mock
    static int RESPONSE_CODE = 404;


    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext(CONTEX, new SimpleHandler());
        server.setExecutor(null); // creates a default executor
        System.out.println("Creating HTTP server on port " + PORT + " of localhost");
        server.start();
    }

    private static class SimpleHandler implements HttpHandler
    {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            String response = "{\"Hello\":\"World\"}";
            // Set content length header
//            httpExchange.getResponseHeaders().set("Content-Type", "");
            httpExchange.getResponseHeaders().set("Content-Length", "0");
//            httpExchange.getResponseHeaders().set("Content-Length", response.length()+"");

            httpExchange.sendResponseHeaders(RESPONSE_CODE, 0);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }
}
