package com.example.vinay_thakur.fragmentdemo;
import android.widget.TextView;

import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest{

    @InjectMocks
    Presenter presenter=new Presenter(new MainActivity());

    @Mock
    DataContract.View view;
    @Mock
    TextView textView;

    @Test
    public void checkTextData()
    {
       //  when(view.updatetext("hello")).thenReturn("hello");
         ListDetailsFragmentDemo listDetailsFragmentDemo= new ListDetailsFragmentDemo();
         //listDetailsFragmentDemo.updatetext("heelo");
         when(view.updatetext("hello")).thenReturn("Hello");
         Assert.assertEquals(presenter.onlistclicked("hello"),"Hello");
    }
}
