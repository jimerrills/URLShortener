package co.jamiemerrills.urlshortener.url;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLManager {

    public static String shortenURL(String url) {

        try {
            URL api = new URL("http://tinyurl.com/api-create.php?url=" + url); //Create a new URL object with the API URL + the URL to shorten

            HttpURLConnection con = (HttpURLConnection) api.openConnection(); //Open a connection to the URL

            con.setRequestMethod("GET"); //Set the request method to GET
            con.setDoInput(true); 

            int responseCode = con.getResponseCode(); //Get the response code from the URL

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                return response.toString();
            }
            
            else {
                return null;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }



    }
    
}
