package fr.tfr.DataFetcher;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.Properties;
import java.util.stream.Collectors;

public class DataFetcher {

    // URL to log in
    private final static String loginUrl = "https://chronodrive-prod.cloud-horoquartz.fr/webquartz/ux/login";
    // URL to fetch data
    private final static String dataUrl = "https://chronodrive-prod.cloud-horoquartz.fr/webquartz/eQuartz/HR_HEB.HQ";

    private final static String FORM_URL_ENCODED = "application/x-www-form-urlencoded";




    public static void fetchData() {

        Properties properties = new Properties();
        Properties headers = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            headers.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("headers.properties"));

            Connection.Response response = Jsoup.connect(loginUrl)
                    .headers(headers.entrySet().stream().collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())))
                    .requestBody("USERID=" + username + "&PASSWORD=" + password + "&Connexion=&LANGUE=fr&redirect=")
                    /*.data("USERID", username)
                    .data("PASSWORD", password)
                    .data("Connexion", "")
                    .data("LANGUE", "fr")
                    .data("redirect", "")*/
                    .method(Connection.Method.POST)
                    .execute();
            System.out.println("Request status code: " + response.statusCode());
            System.out.println("Cookie(s) returned " + response.cookies());
            System.out.println("Headers returned " + response.headers());
            //System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
