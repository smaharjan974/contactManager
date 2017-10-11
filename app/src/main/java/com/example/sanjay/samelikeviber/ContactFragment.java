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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by SANJAY on 10/5/2017.
 */

public class ContactFragment extends Fragment {
    private static Context context;
    private static MyAdapter ad;
    static List<Model> lst;
    List<Model> arraylist = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_fragment, container, false);
        ListView list = (ListView) view.findViewById(R.id.lstview);
        lst = new ArrayList<Model>();
        context = getContext();
        //Log.d("asdfasdf","created"+name+"");
        lst.add(new Model(R.drawable.img2, "Sanjay Maharjan", "9849805388", "Mahalaxmistha"));
        lst.add(new Model(R.drawable.img1, "Binu Maharjan", "9801892050", "Sundhara Laliptur"));
        lst.add(new Model(R.drawable.img3, "Krishna Maharjan", "9841721208", "Mahalaxmistha"));
        lst.add(new Model(R.drawable.img5, "Pritam Maharjan", "9860124388", "Thecho"));
        lst.add(new Model(R.drawable.img4, "Sanjay Maharjan", "9849805388", "Mahalaxmistha"));
        lst.add(new Model(R.drawable.img4, "Sanjay Maharjan", "9849805388", "Mahalaxmistha"));
        lst.add(new Model(R.drawable.img2, "Sanjay Maharjan", "9849805388", "Mahalaxmistha"));
        lst.add(new Model(R.drawable.img3, "Sanjay Maharjan", "9849805388", "Mahalaxmistha"));
        lst.add(new Model(R.drawable.img3, "Sanjay Maharjan", "9849805388", "Mahalaxmistha"));

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        ad = new MyAdapter(((Activity)getContext()), lst,fragmentTransaction);

        list.setAdapter(ad);
        ad.notifyDataSetChanged();

//        SharedPreferences mPrefs ;
//        mPrefs = context.getSharedPreferences("nnn",MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = mPrefs.getString("MyObject",null);
//        Log.d("abcdd","new "+json);
//        Model m = gson.fromJson(json, Model.class);
//        String name = m.getTxtname();
//        String phone = m.getTxtphone();
//        String add = m.getTxtlocation();
//        Log.d("abbb",""+name+"");
//        lst.add(new Model(0,name,phone,add));

       //for arraylist to getdata from shared pprefereneces

        SharedPreferences shared;
        //ArrayList<Model> arrPackage = new ArrayList<Model>();
        shared = context.getSharedPreferences("App_settings", MODE_PRIVATE);
        if(shared!=null){
            Gson gson = new Gson();
            String json = shared.getString("MyObject", null);
            Type type = new TypeToken<ArrayList<Model>>(){}.getType();
            ArrayList<Model> m = gson.fromJson(json,type);

            for(int i = 0;i<m.size();i++){
               lst.add(new Model(0,m.get(i).getTxtname(),m.get(i).getTxtphone(),m.get(i).getTxtlocation()));
            }
            Log.d("modell","adsa   "+m+"");
            Log.d("abbbbbccccddddd", "newww   " + json);
        }

        return view;
    }

    public static Fragment create(String nam, String ph, String add) {
        Log.d("asdfasdfsadf", nam);
       // ad.notifyDataSetChanged();
        lst.add(new Model(0, nam, ph, add));

        // get Saved Data for single object using sharedpreferences
//        SharedPreferences mPrefs ;
//        mPrefs = context.getSharedPreferences("nnn",MODE_PRIVATE);
//        Gson gson = new Gson();
//        String json = mPrefs.getString("MyObject",null);
//        Log.d("abcdd","new "+json);
//        Model m = gson.fromJson(json, Model.class);
//        String name = m.getTxtname();
//        String phone = m.getTxtphone();
//        String adds = m.getTxtlocation();
//        Log.d("abbb",""+name+"");
//        lst.add(new Model(0,name,phone,adds));

//        SharedPreferences shared;
//        ArrayList<Model> arrPackage = new ArrayList<Model>();
//        shared = context.getSharedPreferences("App_settings", MODE_PRIVATE);
//        // add values for your ArrayList any where...
//        Gson gson = new Gson();
//        String json = shared.getString("MyObject", null);
////        Type type = new TypeToken<ArrayList<Model>>() {}.getType();
////        ArrayList<ArrayObject> arrayList = gson.fromJson(json, type);
//       ArrayList<Model> m = gson.fromJson(json,arrPackage.getClass());
//
//        for(int i = 0;i<m.size();i++){
//           // arrPackage.add(new Model(R.drawable.img2,m.get(i).getTxtname(),m.get(i).getTxtphone(),m.get(i).getTxtlocation()));
//            lst.add(new Model(R.drawable.img2,m.get(i).getTxtname(),m.get(i).getTxtphone(),m.get(i).getTxtlocation()));
//        }
//        Log.d("modell","adsa   "+m+"");
//        Log.d("abbbbbccccddddd", "newww   " + json);


        return new ContactFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity a;

        if (context instanceof Activity){
            a=(Activity) context;
        }
    }
}


