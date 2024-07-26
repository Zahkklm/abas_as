import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;


public class App {
    public static void main(String[] args) {
        // GET request örneği

        try {
            URL url = new URI("https://dummyjson.com/users/add").toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("HTTP Get kodu " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("HTTP GET kodu " + response.toString());
            } else {
                System.out.println("GET gönderirken hata oluştu.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // GET request örneği


        try {
            URL url = new URI("https://dummyjson.com/users/" + 0).toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);

            String jsonInputString = "{\"firstName\": \"John\", \"lastName\": \"Doe\", \"age\": 30, \"email\": \"johndoe@example.com\"}";

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = con.getResponseCode();
            System.out.println("HTTP POST kodu " + responseCode);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;

                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("HTTP POST kodu " + response.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}