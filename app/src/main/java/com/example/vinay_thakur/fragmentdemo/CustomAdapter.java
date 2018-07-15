package com.example.vinay_thakur.fragmentdemo;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vinay_thakur on 7/14/20 18.
 */

public class CustomAdapter extends ArrayAdapter<ArrayList<String>> implements View.OnClickListener{
    ArrayList <String> arrayList;
    Context context;
     public CustomAdapter(Context context, ArrayList<String> arrayList)
     {
         super(context,R.layout.list_item);
         Log.d("checkher","main"+arrayList.size());
         this.context=context;
         this.arrayList=arrayList;
     }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public ArrayList<String> getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d("checkher",view+"");
        if(view==null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.list_item, null, true);
        }
        Log.d("checkher34",view+"");
        TextView textView=(TextView)view.findViewById(R.id.Title);
        textView.setText(arrayList.get(i));
        return view;
    }

    @Override
    public void onClick(View view) {
         Log.d("checkhere","click");
    }
}
