package by.minsk.gerasimenko.anton.feed.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import by.minsk.gerasimenko.anton.feed.R;
import by.minsk.gerasimenko.anton.feed.adapters.ShortListAdapt;
import by.minsk.gerasimenko.anton.feed.models.News;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class ShortList extends ListFragment {

    public static final String TAG = "ShortList";
    private FragmentsManage manager;

    private List<News> list;

    public static ShortList newInstance(FragmentsManage manager){

        assert (manager!=null);

        ShortList instance = new ShortList();
        instance.manager = manager;

        return instance;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        list = new ArrayList<>();
        list.add(News.empty());

        ListAdapter adapter = new ShortListAdapt(getActivity(), R.layout.item_short_list,list);

        setListAdapter(adapter);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        manager.showNews(list.get(position));
    }
}
