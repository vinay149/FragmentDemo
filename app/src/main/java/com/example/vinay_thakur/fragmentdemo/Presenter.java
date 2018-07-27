package com.example.vinay_thakur.fragmentdemo;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

/**
 * Created by vinay_thakur on 7/15/2018.
 */

public class Presenter implements DataContract.Presenter {


    DataContract.View view;
    DataContract.Model model;
    public Presenter(DataContract.View view)
    {
           this.view= view;
           model=new Data();
    }
    @Override
    public String onlistclicked(String text) {
        String data=text;
        return  view.updatetext(data);
    }
}
