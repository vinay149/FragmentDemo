package com.example.vinay_thakur.fragmentdemo;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

/**
 * Created by vinay_thakur on 7/14/2018.
 */
public class ListFragmentDemo extends Fragment {


    ListClicked listClicked;
    int pos;
    ArrayList<String> arrayList=new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList.add("Ttitle1");
        arrayList.add("Ttitle1");
        arrayList.add("Ttitle1");
        arrayList.add("Ttitle1");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.list_fragment,container,false);
        final ListView listView=(ListView)v.findViewById(R.id.TitleList);
        final CustomAdapter customAdapter=new CustomAdapter(getActivity().getApplicationContext(),arrayList);
        listView.post(new Runnable() {
            public void run() {
                listView.setAdapter(customAdapter);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listClicked.onlistclicked(i);

//                FragmentManager fragmentManager=getActivity().getFragmentManager();
//                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                ListDetailsFragmentDemo listDetailsFragmentDemo=new ListDetailsFragmentDemo();
//                fragmentTransaction.replace(R.id.listDetailFragment,listDetailsFragmentDemo);
//                fragmentTransaction.commit();
            }
        });
        return v;
    }





    interface ListClicked
    {
        String onlistclicked(int pos);
    }
    @Override
    public void onStart() {
        super.onStart();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listClicked = (ListClicked)getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }


}
