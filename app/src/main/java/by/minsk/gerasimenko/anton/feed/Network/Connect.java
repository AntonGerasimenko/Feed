package by.minsk.gerasimenko.anton.feed.Network;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gerasimenko on 02.10.2015.
 */
public class Connect {

    private final String urlTUTby = "http://news.tut.by/exports/android_v2.php";


    public void get() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                conn();

            }
        }).start();
   }


    private void connect() {

        StringBuilder sb = new StringBuilder();
      //  String http = "http://android.schoolportal.gr/Service.svc/SaveValues";
        HttpURLConnection urlConnection=null;
        try {
            URL url = new URL(urlTUTby);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Content-Type","application/json");

            urlConnection.setRequestProperty("Host", "android.schoolportal.gr");
            urlConnection.connect();

            //Create JSONObject here
            JSONObject jsonParam = new JSONObject();
            jsonParam.put("ID", "25");
            jsonParam.put("description", "Real");
            jsonParam.put("enable", "true");



            OutputStreamWriter out = new   OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jsonParam.toString());
            out.close();

            int HttpResult =urlConnection.getResponseCode();
            if(HttpResult ==HttpURLConnection.HTTP_OK){
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream(),"utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();

                System.out.println(""+sb.toString());

            }else{
                System.out.println(urlConnection.getResponseMessage());
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
        catch (IOException e) {

            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(urlConnection!=null)
                urlConnection.disconnect();
        }
    }


    private void conn() {


        HttpURLConnection urlConnection = null;
        OutputStream out = null;
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

            out = new BufferedOutputStream(urlConnection.getOutputStream());
            Generator g = new Generator();
            g.push(out);
            out.close();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Parser parser = new Parser();
            parser.parse(in);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (urlConnection!= null)  urlConnection.disconnect();

        }



    }
}
