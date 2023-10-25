import java.io.*;
import java.net.Socket;

public class SampleHTTPClient
{

//    private static final String TOKEN = "Bearer eyJ4NXQiOiJNell4TW1Ga09HWXdNV0kwWldObU5EY3hOR1l3WW1NNFpUQTNNV0kyTkRBelpHUXpOR00wWkdSbE5qSmtPREZrWkRSaU9URmtNV0ZoTXpVMlpHVmxOZyIsImtpZCI6Ik16WXhNbUZrT0dZd01XSTBaV05tTkRjeE5HWXdZbU00WlRBM01XSTJOREF6WkdRek5HTTBaR1JsTmpKa09ERmtaRFJpT1RGa01XRmhNelUyWkdWbE5nX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhZG1pbiIsImF1dCI6IkFQUExJQ0FUSU9OIiwiYXVkIjoiV1RlNmgxSHNMbWpWY1lxblhqNDRFM2JCN2tVYSIsIm5iZiI6MTY5NjQ3NzQxNSwiYXpwIjoiV1RlNmgxSHNMbWpWY1lxblhqNDRFM2JCN2tVYSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9sb2NhbGhvc3Q6OTQ0NFwvb2F1dGgyXC90b2tlbiIsImV4cCI6MTY5NjQ4MTAxNSwiaWF0IjoxNjk2NDc3NDE1LCJqdGkiOiIwZTRlODdkYS1lMDYyLTQzMDYtYWIyNS1iYjMxY2Q3MTUwOTMifQ.RbEQqQighyQzp3oGEuc2OFZ2Prwsz4_fLhPfcGPPWCGxvLCUTQ273yHj6uxvS-WCOJVpjANrqSIYdhsZeDUFoG--iyqBZkmpZ6oEaoHfQ8PTKc_vOjj0NIciYc7meNzBzuXXxHzWfp8EH3GXEJXgWdWotU7l_bqN-DZaeRf4XMghhrPRD6aN0SCDiSTwLX6pPhZ8AlKJc275VTHx2UVw-xPa4wyvZiFKxXXFHSmtRJW2upOgtyjwWRKWvWRs3YwUChW_K7cXBNN3ZJEyPXJ00QeF6UVuaQpV-tlDYH80jSiKcqAnjXSxZ-5kTfvEWBSs7HjFxOeiEs_y0ayF3J5lIQ";
//    private static final String TOKEN = "Bearer " + "eyJ4NXQiOiJNell4TW1Ga09HWXdNV0kwWldObU5EY3hOR1l3WW1NNFpUQTNNV0kyTkRBelpHUXpOR00wWkdSbE5qSmtPREZrWkRSaU9URmtNV0ZoTXpVMlpHVmxOZyIsImtpZCI6Ik16WXhNbUZrT0dZd01XSTBaV05tTkRjeE5HWXdZbU00WlRBM01XSTJOREF6WkdRek5HTTBaR1JsTmpKa09ERmtaRFJpT1RGa01XRmhNelUyWkdWbE5nX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhZG1pbiIsImF1dCI6IkFQUExJQ0FUSU9OIiwiYXVkIjoiV1RlNmgxSHNMbWpWY1lxblhqNDRFM2JCN2tVYSIsIm5iZiI6MTY5NjQ4MTY0MiwiYXpwIjoiV1RlNmgxSHNMbWpWY1lxblhqNDRFM2JCN2tVYSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9sb2NhbGhvc3Q6OTQ0NFwvb2F1dGgyXC90b2tlbiIsImV4cCI6MTY5NjQ4NTI0MiwiaWF0IjoxNjk2NDgxNjQyLCJqdGkiOiJlODFkMjcyNy03YzU5LTQwYjMtYTBiOC1jNThkM2EyY2ZjODEifQ.IkmOVyXH5uZ4XtE_1cG7-Z7NRJPgVlsByxDLqak7A3SW9HqCSutEKFLzNk7S5SrDJAymchTOFRCVPCvdDUHugeQN-wgAsOb8Dcl0Hg6J0m7wrJXhDmbF5lCtYsX_jSd80vleHjJnBBoMKLYQLOhIjrdN7lL674JuHv-zxs4wBjqn93x2qU9A9CkFi9oMAO4KnWEatAeEu31JNpis7WAEt6w4qLwG8b878uOWUYvleb10y3mtOcL4KTRKb2D9-16zeo6QGXNnFyofUhCT7YrA3qG--QoD0hEnqS-s_DHwyAANeC-nvAusfcHeCyds6Jgc0ah3AatEUc3dsbDslApQ9A";
//    private static final String GET_URL = "https://localhost:8281/api/1.0.0";


//    private static final String TOKEN = "Bearer eyJ4NXQiOiJNell4TW1Ga09HWXdNV0kwWldObU5EY3hOR1l3WW1NNFpUQTNNV0kyTkRBelpHUXpOR00wWkdSbE5qSmtPREZrWkRSaU9URmtNV0ZoTXpVMlpHVmxOZyIsImtpZCI6Ik16WXhNbUZrT0dZd01XSTBaV05tTkRjeE5HWXdZbU00WlRBM01XSTJOREF6WkdRek5HTTBaR1JsTmpKa09ERmtaRFJpT1RGa01XRmhNelUyWkdWbE5nX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhZG1pbiIsImF1dCI6IkFQUExJQ0FUSU9OIiwiYXVkIjoiV1RlNmgxSHNMbWpWY1lxblhqNDRFM2JCN2tVYSIsIm5iZiI6MTY5ODA0MzQ5NCwiYXpwIjoiV1RlNmgxSHNMbWpWY1lxblhqNDRFM2JCN2tVYSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9sb2NhbGhvc3Q6OTQ0NFwvb2F1dGgyXC90b2tlbiIsImV4cCI6MTY5ODA0NzA5NCwiaWF0IjoxNjk4MDQzNDk0LCJqdGkiOiIyNWYwMzhiNS1kYTY1LTQzN2QtOTVjOC0xZjk2M2ZiMDdlNjcifQ.ZyIFnXDL01hW_tEtSlmMgN4bMF_hyBcw7VjKNGIekdZztpgiC9wt8HVTn-RktCQnLfqoU3KjdgLGb5bYN2je73W3nucbbmZoRZduw7d-m-zK6wKfJq8zR_jnZCapGFwPLgkg4UDiIPpjH-tsEzt3SNFrCAJOfGU3JBK4nrrMSuo1pi-TcQt9SHFWqGHMTaWYJfjoKKz6aUkrU6YrDIS-fvH54vrXwNp7I7MF0AEzQvN8wAdfoZ870G11a0DypM3LGJ1yKBIveKhZRkVHtokS4z_XgXjJ1C7i5l5DMRmBji65OhOQSFN01mboelm34YDWG7YEHe9bEqTL4_Dz9tKD5Q";
//    private static final String GET_URL = "http://localhost:8281/timeout/1.0.0";


    private static final String TOKEN = "Bearer eyJ4NXQiOiJNell4TW1Ga09HWXdNV0kwWldObU5EY3hOR1l3WW1NNFpUQTNNV0kyTkRBelpHUXpOR00wWkdSbE5qSmtPREZrWkRSaU9URmtNV0ZoTXpVMlpHVmxOZyIsImtpZCI6Ik16WXhNbUZrT0dZd01XSTBaV05tTkRjeE5HWXdZbU00WlRBM01XSTJOREF6WkdRek5HTTBaR1JsTmpKa09ERmtaRFJpT1RGa01XRmhNelUyWkdWbE5nX1JTMjU2IiwiYWxnIjoiUlMyNTYifQ.eyJzdWIiOiJhZG1pbiIsImF1dCI6IkFQUExJQ0FUSU9OIiwiYXVkIjoiaElaRmUxNDBTdXlESkhvd0o2ZUpyOWlQcl9vYSIsIm5iZiI6MTY5ODA0Mzc3MCwiYXpwIjoiaElaRmUxNDBTdXlESkhvd0o2ZUpyOWlQcl9vYSIsInNjb3BlIjoiZGVmYXVsdCIsImlzcyI6Imh0dHBzOlwvXC9sb2NhbGhvc3Q6OTQ0M1wvb2F1dGgyXC90b2tlbiIsImV4cCI6MTY5ODA0NzM3MCwiaWF0IjoxNjk4MDQzNzcwLCJqdGkiOiIzOGZmNTQxYy0xMjA4LTRmMGEtODFlNS1mOWUxMTJkMzRiMjgifQ.uYhSoiguKWPpgLvnObQ_VJR5Gi7XMK0umMN65iZRBk2Ijyd775mwJT6DBVkWOKCeiwTQ8P1Ud-bACVgSR_4yRR2rk-dk-Z6MFFFCBmM2YrnFM_FfGaiAw5d1lIGJjOqL23fc9HxANOCSMyQ_vjke1YXMOpw5qsTSip9WSqXztLH2tf3uZZR6Ok5vMHIcVS64bHp7lbvGWjjTwdTZcNVNgXAvPaW0FpJ5RkU4Cw-ls6H3nrK-VFktBWp8T4Vkx6nu5ZpJBBnHWuQSs9d1CgYHglLi2RjJykWI1NcM2u6naG6rJ9ZrJE3X0X08PZTWUFkodQNOhW6Yyxn_uHmGAo0q2Q";
    private static final String GET_URL = "http://localhost:8281/timeout/1.0.0";




    public static void main(String[] args)
    {
        try(Socket socket = new Socket("localhost", 8280)) {
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            // Send an HTTP GET request
            writer.println("GET /timout/1.0.0 HTTP/1.1");
            writer.println("Host: localhost");
            writer.println("Authorization: " +TOKEN); // Blank line to indicate the end of headers
            writer.println();
            writer.println("Connection: keep-alive");
            Thread.sleep(5000);
//            socket.close();
            // Read and display the response
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the socket and streams
            socket.close();
            writer.close();
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



//    public static void main(String[] args) throws IOException, InterruptedException {
//        get(GET_URL);
//    }

//    public static CompletableFuture<String> get(String uri) {
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(uri))
//                .header("Authorization", TOKEN)
//                .build();
//
//
//        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body);
//    }
//
//    private static void sendHttpGETRequest() throws IOException, InterruptedException {
//        URL obj = new URL(GET_URL);
//        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
//        httpURLConnection.setRequestMethod("GET");
//        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
//        httpURLConnection.setRequestProperty("Authorization", TOKEN);
//
//        Thread.sleep(1000);
//        httpURLConnection.disconnect();
//        httpURLConnection.getInputStream().close();
//
//        int responseCode = httpURLConnection.getResponseCode();
//        System.out.println("GET Response Code :: " + responseCode);
//        if (responseCode == HttpURLConnection.HTTP_OK) { // success
//            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in .readLine()) != null) {
//                response.append(inputLine);
//            } in .close();
//
//            // print result
//            System.out.println(response);
//        } else {
//            System.out.println("GET request not worked");
//        }
//
//        for (int i = 1; i <= 8; i++) {
//            System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " + httpURLConnection.getHeaderField(i));
//        }

//    }
}
