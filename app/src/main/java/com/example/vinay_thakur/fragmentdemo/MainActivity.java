package com.example.vinay_thakur.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ListFragmentDemo.ListClicked {

    DataContract.View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    public String onlistclicked(int pos, String Value) {
        Log.d("Clicked Here", "" + pos + Value);
        ListDetailsFragmentDemo listDetailsFragmentDemo = (ListDetailsFragmentDemo) this.getFragmentManager().findFragmentById(R.id.listDetailFragment);
        listDetailsFragmentDemo.init(Value);
        return "";
    }

}
