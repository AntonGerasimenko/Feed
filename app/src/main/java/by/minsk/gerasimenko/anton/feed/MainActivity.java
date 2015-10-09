package by.minsk.gerasimenko.anton.feed;



import android.os.Bundle;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;


import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import by.minsk.gerasimenko.anton.feed.fragments.FragmentsManage;
import by.minsk.gerasimenko.anton.feed.fragments.NewsFragm;
import by.minsk.gerasimenko.anton.feed.fragments.NewsList;
import by.minsk.gerasimenko.anton.feed.fragments.Welcome;
import by.minsk.gerasimenko.anton.feed.models.News;

public  class MainActivity extends SherlockFragmentActivity implements FragmentsManage {

    private ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = getSupportActionBar();


       showWelcome();
    }

    @Override
    public void showWelcome(){

        bar.setTitle(R.string.welcome);

        Fragment welcome = Welcome.newInstance(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container, welcome, Welcome.TAG).commit();
    }

    @Override
    public void showList(){

        bar.setTitle(R.string.list_news);

        Fragment list = NewsList.newInstance(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, list, NewsList.TAG);
        ft.addToBackStack(NewsList.TAG).commit();
    }

    @Override
    public void showNews(News news) {
        bar.setTitle(R.string.current_news);
        Fragment fragment = NewsFragm.newInstance(this, news);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment, NewsFragm.TAG);
        ft.addToBackStack(NewsFragm.TAG).commit();
    }
}
