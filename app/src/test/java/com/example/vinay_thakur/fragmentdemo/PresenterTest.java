package com.example.vinay_thakur.fragmentdemo;

import android.util.Log;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by vinay_thakur on 7/15/2018.
 */
public class PresenterTest {
    public Data data;
    public Presenter presenter;
    public DataContract.View view;
    @Before
    public void setup()
    {
        data= Mockito.mock(Data.class);
        view=Mockito.mock(DataContract.View.class);
        presenter=new Presenter(view);
    }
    @Test
    public void checkTextData()
    {
       // Mockito.when(data.getData()).thenReturn("hhj");
        final String[] s1 = {""};
        Presenter presenter=new Presenter(new DataContract.View() {
            @Override
            public void updatetext(String s) {
               // Log.d("vinaytest",""+s);
             s1[0] =s;
            }
        });
        presenter.onlistclicked("hello");
        Assert.assertEquals(s1[0],"hello");
        //Mockito.verify(view,Mockito.times(1));
    }

}
