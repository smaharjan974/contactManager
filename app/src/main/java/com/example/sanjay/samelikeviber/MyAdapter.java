package com.example.sanjay.samelikeviber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SANJAY on 10/5/2017.
 */

public class MyAdapter extends BaseAdapter {

    Context context;
    List<Model> list;
    FragmentTransaction ft;
    AdapterCallback mAdapterCallback;




    public MyAdapter(Context context, List<Model> list, FragmentTransaction fragmentTransaction) {
        this.context = context;
        this.list = list;
        this.ft=fragmentTransaction;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.sample_list,null);

        ImageView img = (ImageView)convertView.findViewById(R.id.img);
        final TextView txtname = (TextView)convertView.findViewById(R.id.txtname);
        final TextView txtphone = (TextView)convertView.findViewById(R.id.txtphone);
        final TextView txtlocation = (TextView)convertView.findViewById(R.id.location);
        RelativeLayout lst = (RelativeLayout)convertView.findViewById(R.id.lst);
        Button btncall = (Button)convertView.findViewById(R.id.btncall);
        Button btnmsg = (Button)convertView.findViewById(R.id.btnmsg);

        lst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtname.toString();
                String phone = txtphone.toString();
                String location = txtlocation.toString();
                Intent i  = new Intent(context,EditList.class);
                Log.d("asdf",""+name+"");
                i.putExtra("name",name);
                i.putExtra("phone",phone);
                i.putExtra("location",location);

                context.startActivity(i);

            }
        });



        final int p = position;

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"calling..... ",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+list.get(p).getTxtphone()));
                try{
                    context.startActivity(i);
                }catch(Exception ex){
                    Toast.makeText(context,"check permission ",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = txtphone.getText().toString();
                Log.d("clicked","asaddsd"+phone+"");
                Fragment fragment = MessageFragment.create(phone);
                ft.add(R.id.msgfrg, fragment);
                ft.addToBackStack(null);
                ft.commit();


            }
        });


        //img.setImageResource(list.get(position).getImg());
        txtname.setText(list.get(position).getTxtname());
        txtphone.setText(list.get(position).getTxtphone());
        txtlocation.setText(list.get(position).getTxtlocation());

        return convertView;
    }


    public static interface AdapterCallback {
        void onMethodCallback(String ph);
    }






}
