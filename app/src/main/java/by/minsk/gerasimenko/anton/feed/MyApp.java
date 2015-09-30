package by.minsk.gerasimenko.anton.feed;

import android.app.Application;

import by.minsk.gerasimenko.anton.feed.DB.DBManager;

/**
 * Created by gerasimenko on 30.09.2015.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DBManager.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBManager.getInstance().release();
    }
}
