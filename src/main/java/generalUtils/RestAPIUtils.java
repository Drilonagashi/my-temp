package generalUtils;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestAPIUtils {

    public static JSONArray getResponseArray(String url, final String authorization) throws ClientProtocolException, IOException {
        StringBuffer result = new StringBuffer();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet(url);

        addHeader(getRequest, authorization);

        CloseableHttpResponse response = client.execute(getRequest);
        int responseCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code: " + responseCode);
        try {
            if (responseCode == 200)

            {
                System.out.println("Get Response is Successfull");
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                    System.out.println(result.toString());
                }
            }

            return (JSONArray) new JSONParser().parse(result.toString());

        } catch (Exception ex) {
            result.append("Get Response Failed");
            return new JSONArray();
        }

    }

    public static JSONObject getResponseObject(String url, final String authorization) throws ClientProtocolException, IOException {
        StringBuffer result = new StringBuffer();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet getRequest = new HttpGet(url);

        addHeader(getRequest, authorization);

        CloseableHttpResponse response = client.execute(getRequest);
        int responseCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code: " + responseCode);
        try {
            if (responseCode == 200)

            {
                System.out.println("Get Response is Successfull");
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                    System.out.println(result.toString());
                }
            }

            return (JSONObject) new JSONParser().parse(result.toString());

        } catch (Exception ex) {
            result.append("Get Response Failed");
            return new JSONObject();
        }

    }

    public static JSONObject postCall(String url, JSONObject jsonObject, final String authorization) throws ClientProtocolException, IOException {
        StringBuffer result = new StringBuffer();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost postRequest = new HttpPost(url);

        addHeader(postRequest, authorization);

        StringEntity entity = new StringEntity(jsonObject.toString());
        postRequest.setEntity(entity);
        CloseableHttpResponse response = client.execute(postRequest);
        int responseCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code: " + responseCode);
        try {
            if (responseCode == 201 || responseCode == 200) {
                System.out.println("Get Response is Successfull");
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                    System.out.println(result.toString());
                }
            }
            return (JSONObject) new JSONParser().parse(result.toString());

        } catch (Exception ex) {
            result.append("Get Response Failed");
            return new JSONObject();
        }
    }

    public static JSONObject postCall(String url, org.json.simple.JSONObject array, final String authorization) throws ClientProtocolException, IOException {
        StringBuffer result = new StringBuffer();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost postRequest = new HttpPost(url);

        addHeader(postRequest, authorization);

        StringEntity entity = new StringEntity(array.toString());
        postRequest.setEntity(entity);
        CloseableHttpResponse response = client.execute(postRequest);
        int responseCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code: " + responseCode);
        try {
            if (responseCode == 201) {
                System.out.println("Get Response is Successfull");
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                    System.out.println(result.toString());
                }
            }
            return (JSONObject) new JSONParser().parse(result.toString());

        } catch (Exception ex) {
            result.append("Get Response Failed");
            return new JSONObject();
        }
    }

    public static JSONObject fileUploadPostCall(String url, String fileName, final String authorization) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost postRequest = new HttpPost(url);
        postRequest.addHeader("Authorization", authorization);

        MultipartEntity entity = new MultipartEntity();
        entity.addPart("importCsvFile", new FileBody(new File(fileName)));
        postRequest.setEntity(entity);

        CloseableHttpResponse response = client.execute(postRequest);
        StringBuffer result = new StringBuffer();
        try {
            System.out.println("Get Response is Successfull");
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                result.append(line);
                System.out.println(result.toString());
            }
            return (JSONObject) new JSONParser().parse(result.toString());

        } catch (Exception ex) {
            result.append("Get Response Failed");
            return new JSONObject();
        }
    }

    public static JSONObject putCall(String url, JSONObject jsonObject, final String authorization) throws ClientProtocolException, IOException {
        StringBuffer result = new StringBuffer();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut putRequest = new HttpPut(url);

        addHeader(putRequest, authorization);

        StringEntity entity = new StringEntity(jsonObject.toString());
        putRequest.setEntity(entity);
        CloseableHttpResponse response = client.execute(putRequest);
        int responseCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code: " + responseCode);
        try {
            if (responseCode == 200 || responseCode == 201) {
                System.out.println("Put Response is Successfull");
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                    System.out.println(result.toString());
                }
            }
            return (JSONObject) new JSONParser().parse(result.toString());

        } catch (Exception ex) {
            result.append("Put Response Failed");
            return new JSONObject();
        }
    }

    private static HttpPost addHeader(HttpPost header, final String auth) {
        header.addHeader("Authorization", auth);
        return header;
    }

    private static HttpGet addHeader(HttpGet header, final String auth) {
        header.addHeader("Authorization", auth);
        return header;
    }

    private static HttpPut addHeader(HttpPut header, final String auth) {
        header.addHeader("Authorization", auth);
        return header;
    }
}