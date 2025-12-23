import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestApiClient {

    public static void main(String[] args) {
        try {
            // API URL
            String apiUrl = "https://jsonplaceholder.typicode.com/users/1";
            URL url = new URL(apiUrl);

            // Create HTTP connection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Read response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            String json = response.toString();

            // Manual JSON parsing (simple)
            String name = json.split("\"name\":\"")[1].split("\"")[0];
            String username = json.split("\"username\":\"")[1].split("\"")[0];
            String email = json.split("\"email\":\"")[1].split("\"")[0];
            String city = json.split("\"city\":\"")[1].split("\"")[0];

            // Structured output
            System.out.println("📌 USER DETAILS");
            System.out.println("Name     : " + name);
            System.out.println("Username : " + username);
            System.out.println("Email    : " + email);
            System.out.println("City     : " + city);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
