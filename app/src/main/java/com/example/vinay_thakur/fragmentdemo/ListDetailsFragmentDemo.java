package com.example.vinay_thakur.fragmentdemo;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by vinay_thakur on 7/14/2018.
 */

@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
public class ListDetailsFragmentDemo extends Fragment implements DataContract.View, CustomAdapter.OnItemClickedListener {

    ImageView imageView;
    TextView textView;
    Presenter presenter;
    private StorageReference mStorageRef;

    int postion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("checkhere", "details");
    }

    String pos1 = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.details_item, container, false);
        textView = (TextView) v.findViewById(R.id.DateOfBirth);
        imageView = (ImageView) v.findViewById(R.id.imageView);
        presenter = new Presenter(this);
        new DownloadTask().execute();
        return v;
    }

    String data;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public class DownloadTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mStorageRef = FirebaseStorage.getInstance().getReference();
            mStorageRef = mStorageRef.child("profile.jpg");
            // Log.d("URL:",""+pathReference);

            mStorageRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    imageView.setImageURI(uri);
                    URL url = null;
                    try {
                        url = new URL(uri.toString());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    Bitmap bmp = null;
                    try {
                        bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageView.setImageBitmap(bmp);
                    Log.d("URL:here", "" + uri + "" + url);
                }

            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d("URL:here", "failed");
                }
            });
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    @Override
    public String updatetext(String s) {
        Log.d("helloee", s);
        textView.setText(s);
        data = s;
        return s;
    }

    @Override
    public void init(String value) {

        presenter.onlistclicked(value);
    }

    @Override
    public void onItemClicked(int position) {
        textView.setText(position + "");
    }
}
