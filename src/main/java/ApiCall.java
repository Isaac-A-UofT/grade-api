import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiCall {
    public static void main(String[] args) {
        try {
            // API URL
            String apiUrl = "http://apilayer.net/api/check?access_key=0041b4f9e5a2e416ddfcfee097d980b5&email=kaviraj.gaire@mail.utoronto.ca";
            URL url = new URL(apiUrl);

            // Call API
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Response: " + response.toString());

            // Close the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}