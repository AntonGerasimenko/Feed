package by.minsk.gerasimenko.anton.feed.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gerasimenko on 01.10.2015.
 */
public class NewsFragm extends Fragment {

    public static final String TAG = "NewFragm";

    private FragmentsManage manager;

    public static NewsFragm newInstance(FragmentsManage manager){

        assert (manager!=null);

        NewsFragm instance = new NewsFragm();
        instance.manager = manager;

        return instance;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
