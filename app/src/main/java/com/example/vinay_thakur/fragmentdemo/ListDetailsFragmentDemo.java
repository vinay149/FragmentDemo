package com.example.vinay_thakur.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by vinay_thakur on 7/14/2018.
 */

public class ListDetailsFragmentDemo extends Fragment implements ListFragmentDemo.ListClicked{

    TextView textView;
    int postion;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("checkhere","details");
    }
    String  pos1="";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
      View v=inflater.inflate(R.layout.details_item,container,false);
        textView=(TextView)v.findViewById(R.id.textView);
        updateit(pos1);
      return v;
    }
    void updateit(String s)
    {
        pos1=s;
        Log.d("checkhere",s);
        textView.setText(s);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onlistclicked(int pos) {
        Log.d("checkhere","clicked"+pos);
        postion=pos;
    }
}
