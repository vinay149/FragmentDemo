package com.example.vinay_thakur.fragmentdemo;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vinay_thakur on 7/14/20 18.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    public interface OnItemClickedListener
    {
        public void onItemClicked(int position);
    }
    OnItemClickedListener listener;
    ArrayList<String> arrayList;
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView mTextView;
        LinearLayout mItemLayout;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView)v.findViewById(R.id.Title);
//            v.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Log.d("Clicked Here",""+getAdapterPosition());
//                }
//            });
        }
    }
    public CustomAdapter(ArrayList<String> arrayList, OnItemClickedListener listener) {
        this.listener=listener;
        this.arrayList=arrayList;
        Log.d("CountArrayListSize","Size: "+arrayList.size());
    }
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, final int position) {
         holder.mTextView.setText(arrayList.get(position));
         holder.mTextView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 listener.onItemClicked(position);
                 Log.d("Clicked Here",""+position);
             }
         });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
