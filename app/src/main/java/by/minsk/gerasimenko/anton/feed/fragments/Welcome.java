package by.minsk.gerasimenko.anton.feed.fragments;



import android.support.v4.app.Fragment;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import by.minsk.gerasimenko.anton.feed.Network.Connect;
import by.minsk.gerasimenko.anton.feed.R;


/**
 * Created by gerasimenko on 01.10.2015.
 */
public class Welcome extends Fragment implements View.OnClickListener {

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

        Button btn = (Button) view.findViewById(R.id.button);
        btn.setOnClickListener(this);

        Button btnList = (Button) view.findViewById(R.id.btnList);
        btnList.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Connect connect = new Connect();
                connect.get();
                break;
            case R.id.btnList:
                manager.showList();
        }
    }
}
