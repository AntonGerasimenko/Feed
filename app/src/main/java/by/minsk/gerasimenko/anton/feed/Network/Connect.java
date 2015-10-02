package by.minsk.gerasimenko.anton.feed.Network;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by gerasimenko on 02.10.2015.
 */
public class Connect {

    private final String urlTUTby = "http://news.tut.by/rss/index.rss";


    public void get() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection urlConnection = null;
                try {
                   /* URL url = new URL(urlTUTby);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());*/

                    Parser parser = new Parser();
                    parser.p(null);

                }/* catch (IOException e) {
                    e.printStackTrace();
                }*/ finally{
                    if (urlConnection!= null)  urlConnection.disconnect();
                }
            }
        }).start();
   }
}
