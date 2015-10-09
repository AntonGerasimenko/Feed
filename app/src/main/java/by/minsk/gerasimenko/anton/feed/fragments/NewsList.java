package by.minsk.gerasimenko.anton.feed.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.DB.DBService;
import by.minsk.gerasimenko.anton.feed.Network.Connect;
import by.minsk.gerasimenko.anton.feed.R;
import by.minsk.gerasimenko.anton.feed.Logic.adapters.NewsListAdapt;
import by.minsk.gerasimenko.anton.feed.models.FuncConnect;
import by.minsk.gerasimenko.anton.feed.models.News;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class NewsList extends ListFragment {

    public static final String TAG = "ShortList";
    private FragmentsManage manager;

    private List<News> list;

    public static NewsList newInstance(FragmentsManage manager){

        assert (manager!=null);

        NewsList instance = new NewsList();
        instance.manager = manager;

        return instance;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        manager = (FragmentsManage) getActivity();
        list = DBService.getAll();

        ListAdapter adapter = new NewsListAdapt(getActivity(), R.layout.item_short_list,list);

        setListAdapter(adapter);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        News news = list.get(position);


        manager.showNews(news);

    }
}
