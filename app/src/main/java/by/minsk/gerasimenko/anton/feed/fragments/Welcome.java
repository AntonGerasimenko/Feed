package by.minsk.gerasimenko.anton.feed.fragments;



import android.support.v4.app.Fragment;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.minsk.gerasimenko.anton.feed.R;


/**
 * Created by gerasimenko on 01.10.2015.
 */
public class Welcome extends Fragment {

    public static final String TAG = "Welcome";

    private FragmentsManage manager;


    public static Welcome newInstance(FragmentsManage manager){

        assert (manager!=null);

        Welcome instance = new Welcome();
        instance.manager = manager;

        return instance;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.welcome,container,false);
        return view;
    }


}
