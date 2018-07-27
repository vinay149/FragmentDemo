package com.example.vinay_thakur.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements ListFragmentDemo.ListClicked ,DataContract.View{

    Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new Presenter(this);
        FragmentManager fragmentManager=getFragmentManager();
        ListFragmentDemo listFragmentDemo=new ListFragmentDemo();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        ListDetailsFragmentDemo listDetailsFragmentDemo=new ListDetailsFragmentDemo();
        fragmentTransaction.add(R.id.listFragment,listFragmentDemo);
        fragmentTransaction.add(R.id.listDetailFragment,listDetailsFragmentDemo);
        fragmentTransaction.commit();
    }

    @Override
    public String onlistclicked(int pos) {
        presenter.onlistclicked("hello"+pos);
        return "";
        //listFragmentDemo.updateit("hello"+pos);
    }

    @Override
    public String updatetext( String data) {
       ListDetailsFragmentDemo listFragmentDemo=(ListDetailsFragmentDemo)getFragmentManager().findFragmentById(R.id.listDetailFragment);
        listFragmentDemo.updateit(data);
        Log.d("checkher","got it"+data);
        return "";
    }

    @Override
    public String getdata() {
        return null;
    }
    String data()
    {
       return "dd";
    }
}
