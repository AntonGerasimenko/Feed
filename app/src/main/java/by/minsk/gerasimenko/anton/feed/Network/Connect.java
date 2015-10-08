package by.minsk.gerasimenko.anton.feed.Network;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import by.minsk.gerasimenko.anton.feed.DB.DBService;
import by.minsk.gerasimenko.anton.feed.models.NewsPOJO;

/**
 * Created by gerasimenko on 02.10.2015.
 */
public class Connect {

    private final String urlTUTby = "http://news.tut.by/exports/android_v2.php";


    public void get() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                List<NewsPOJO> newes = conn();
                newes = extractDownloadNews(newes);

                DBService.put(newes);
            }
        }).start();
   }

    private List<NewsPOJO> conn() {
        HttpURLConnection urlConnection = null;
        List<NewsPOJO> response = null;

        try {
            URL url = new URL(urlTUTby);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            Generator g = new Generator();
            g.push(out);
            out.close();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Parser parser = new Parser();
            response =  parser.parse(in);

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (urlConnection!= null)  urlConnection.disconnect();
        }
        return response;
    }

    private List<NewsPOJO> extractDownloadNews(List<NewsPOJO> input) {
        List<NewsPOJO> out = new ArrayList<>();
        Set<Integer> ids = DBService.getDownloadedId();

        for(NewsPOJO newsPOJO:input) {

            int id = newsPOJO.getId();
            if (!ids.contains(id)) {
                out.add(newsPOJO);
            }
        }
        return out;
    }

}
