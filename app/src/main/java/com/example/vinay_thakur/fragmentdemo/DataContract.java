package com.example.vinay_thakur.fragmentdemo;

/**
 * Created by vinay_thakur on 7/15/2018.
 */

public class DataContract  {

    interface View
    {
        String updatetext(String s);
        String getdata();

    }
    interface Model
    {
        String getData();
    }
    interface Presenter
    {
        String onlistclicked(String text);
    }

}
