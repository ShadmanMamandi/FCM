package main;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Created by fatemeh on 1/11/2017.
 */
public class POST2FCM {

    public static void post(String apikey, Content content){

        try {

            URL url = new URL("https://fcm.googleapis.com/fcm/send");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "key=" + apikey);
            connection.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());

            mapper.writeValue(wr, content);

            //send the request
            wr.flush();

            wr.close();

            //get the response
            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);

            in.close();

            //print result
            System.out.println(response.toString());
        }catch (MalformedURLException e){
            e.printStackTrace();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
