package by.minsk.gerasimenko.anton.feed.fragments;



import android.support.v4.app.Fragment;
import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import by.minsk.gerasimenko.anton.feed.Logic.ProgressListener;
import by.minsk.gerasimenko.anton.feed.Network.Connect;
import by.minsk.gerasimenko.anton.feed.R;
import by.minsk.gerasimenko.anton.feed.models.FuncConnect;
import by.minsk.gerasimenko.anton.feed.models.News;


/**
 * Created by gerasimenko on 01.10.2015.
 */
public class Welcome extends Fragment implements View.OnClickListener , ProgressListener {

    public static final String TAG = "Welcome";
    private FragmentsManage manager;
    private Button btnList;

    public static Welcome newInstance(FragmentsManage manager){

        assert (manager!=null);

        Welcome instance = new Welcome();
        instance.manager = manager;

        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.welcome,container,false);

        btnList = (Button) view.findViewById(R.id.btnList);
        btnList.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d("Fragments_Load", "Welcome");
        manager = (FragmentsManage) getActivity();
        if (savedInstanceState!= null) {

            if (savedInstanceState.getBoolean("visible")) {

                btnList.setVisibility(View.VISIBLE);
            } else btnList.setVisibility(View.GONE);
        }

        manager.setTitleActionBar(TAG);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnList:
               // btnList.setVisibility(View.GONE);
                Connect connect = new Connect();
                connect.latestNews(FuncConnect.ALL_NEWS,this);
                break;
        }
    }

    @Override
    public void fin(List<News> news) {
        Log.d("Fragments_Load","Welcome: "+news.size());
        manager.showList(news);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        if (View.GONE == btnList.getVisibility()) {
            outState.putBoolean("visible",false);
        } else outState.putBoolean("visible",true);

        super.onSaveInstanceState(outState);
    }
}
