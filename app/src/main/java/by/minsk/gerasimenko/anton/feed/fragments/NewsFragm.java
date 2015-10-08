package by.minsk.gerasimenko.anton.feed.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import by.minsk.gerasimenko.anton.feed.Logic.Convert;
import by.minsk.gerasimenko.anton.feed.R;
import by.minsk.gerasimenko.anton.feed.models.News;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class NewsFragm extends Fragment {

    public static final String TAG = "NewFragm";

    private FragmentsManage manager;
    private News news;


    private  TextView title;
    private  TextView textNews;
    private  TextView date;



    public static NewsFragm newInstance(FragmentsManage manager, News news){

        assert (manager!=null);
        assert (news != null);

        NewsFragm instance = new NewsFragm();
        instance.manager = manager;
        instance.news = news;

        return instance;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.news_container,container,false);

        title = (TextView) view.findViewById(R.id.title);
        textNews = (TextView) view.findViewById(R.id.textNews);
        date = (TextView) view.findViewById(R.id.date);


        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        if (savedInstanceState!= null) {

            news = (News)savedInstanceState.getSerializable("news");
        }

        title.setText(news.getTitle());
        date.setText(Convert.date(news.getDate()));

        String htmltext = news.getNewsText();
        textNews.setText(Html.fromHtml(htmltext));

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putSerializable("news",news);
        super.onSaveInstanceState(outState);
    }
}
