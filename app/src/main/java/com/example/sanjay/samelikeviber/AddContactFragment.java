package com.example.sanjay.samelikeviber;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.stetho.Stetho;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by SANJAY on 10/5/2017.
 */

public class AddContactFragment extends Fragment {
    String name;
    String phone;
    String address;
    TextClicked mCallback;


    ArrayList<Model> arrPackage = new ArrayList<Model>();


    public interface TextClicked{
        public void sendText(String text,String s,String sa);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_contact_fragment, container, false);
        final EditText editname = (EditText) view.findViewById(R.id.editname);
        final EditText editphone = (EditText) view.findViewById(R.id.editphone);
        final EditText editaddress = (EditText) view.findViewById(R.id.txtaddress);


        Button btnsave = (Button) view.findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editname.getText().toString();
                phone = editphone.getText().toString();
                address = editaddress.getText().toString();

                Log.i("afas",""+name+"");

               mCallback.sendText(name,phone,address);
                sharedsavedata(name,phone,address);

                    Toast.makeText(getContext(), "saved...", Toast.LENGTH_SHORT).show();



            }
        });
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (TextClicked) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement TextClicked");
        }
    }

    @Override
    public void onDetach() {
        mCallback = null; // => avoid leaking, thanks @Deepscorn
        super.onDetach();
    }


    //shared preferences
    public void sharedsavedata (String n,String p, String a ){


        //saved single object data using shared preferences

//        SharedPreferences mPrefs = getContext().getSharedPreferences("nnn",MODE_PRIVATE);
//        SharedPreferences.Editor prefsEditor = mPrefs.edit();
//        Gson gson = new Gson();
//        Model m = new Model(0,n,p,a);
//        String json = gson.toJson(m);
//        Log.d("abc",""+m.getTxtname()+m.getTxtphone()+"");
//        Log.d("abc",""+json+"");
//        prefsEditor.putString("MyObject", json);
//        prefsEditor.commit();


       //saved arraylist of object data using shared preferences
        SharedPreferences shared;

        shared = getContext().getSharedPreferences("App_settings", MODE_PRIVATE);
        // add values for your ArrayList any where...
        SharedPreferences.Editor editor = shared.edit();
        Gson gson = new Gson();
        arrPackage.add(new Model(R.drawable.img2,n,p,a));
        Log.d("arraysize",arrPackage.size()+"");

        String json = gson.toJson(arrPackage);
        Log.d("saveddata","saveddddddddd"+json);
        editor.putString("MyObject",json);
        editor.commit();



    }
}
