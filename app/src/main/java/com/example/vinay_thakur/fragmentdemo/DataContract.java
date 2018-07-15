package com.example.vinay_thakur.fragmentdemo;

/**
 * Created by vinay_thakur on 7/15/2018.
 */

public class DataContract  {

    interface View
    {
        void updatetext(String s);

    }
    interface Model
    {
        String getData();
    }
    interface Presenter
    {
        void onlistclicked(String text);
    }

}
