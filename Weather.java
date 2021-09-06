
import java.util.*;
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

//https://openweathermap.org/api
public class Weather extends JPanel
{
    public static final String KEY = "redacted";
    public static void main(String args[]) throws Exception
    {
        Scanner input = new Scanner(System.in);
        String city = input.nextLine();
        input.close();

        // create client
        var client = HttpClient.newHttpClient();

        // create request
        var request = HttpRequest.newBuilder()
        .uri(URI.create("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+KEY))
        .header("accept", "application/json")
        .build();

        // use client to send request
        var response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.body());

    }
}