package by.minsk.gerasimenko.anton.feed.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.Logic.Convert;
import by.minsk.gerasimenko.anton.feed.Logic.ProgressListener;
import by.minsk.gerasimenko.anton.feed.Network.Connect;
import by.minsk.gerasimenko.anton.feed.R;
import by.minsk.gerasimenko.anton.feed.models.FuncConnect;
import by.minsk.gerasimenko.anton.feed.models.News;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class NewsFragm extends Fragment implements ProgressListener {

    public static final String TAG = "NewFragm";

    private FragmentsManage manager;
    private News news;
    private ImageLoader imageLoader = ImageLoader.getInstance();

    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .build();

    private  TextView title;
    private  TextView textNews;
    private  TextView date;
    private ImageView image;
    private ProgressBar progressBar;

    public static NewsFragm newInstance(News news){
        assert (news != null);

        NewsFragm instance = new NewsFragm();
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
        image = (ImageView) view.findViewById(R.id.imageView2);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar2);

        imageLoader.init(ImageLoaderConfiguration.createDefault(getActivity()));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        Log.d("Fragments_Load", "NewsFragm");
        manager = (FragmentsManage) getActivity();
        if (savedInstanceState!= null) {
            news = (News)savedInstanceState.getSerializable("news");
        }

        manager.setTitleActionBar(TAG);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {

        if (news != null) {
            if (news.isNeedLoad()) {

                progressBar.setVisibility(View.VISIBLE);
                loadHtml();
            } else showNews(news);
        }
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putSerializable("news", news);
        super.onSaveInstanceState(outState);
    }

    private void loadHtml() {

        int idNews = news.get_id();
        Connect connect = new Connect();
        FuncConnect type = FuncConnect.CURR_NEWS;
        type.setId(idNews);
        connect.latestNews(type, this);
    }

    @Override
    public void fin(List<News> newsList) {

        if (newsList != null && !newsList.isEmpty()) {

            this.news =  newsList.get(0);

            String htmlText = news.getHtmlNews();
            if (htmlText!= null && !htmlText.equals("")) {
                showNews(news);
            } else {
                progressBar.setVisibility(View.GONE);

                Toast.makeText(getActivity(),R.string.err2,Toast.LENGTH_LONG).show();
            }
        }
    }

    private void showNews(News news) {

        String htmltext = news.getHtmlNews();

        textNews.setText(Html.fromHtml(htmltext));
        textNews.setMovementMethod(new ScrollingMovementMethod());

        imageLoader.displayImage(news.getUrlImage(), image, options);
        progressBar.setVisibility(View.GONE);

        title.setText(news.getTitle());
        date.setText(Convert.date(news.getDate()));
    }

}
