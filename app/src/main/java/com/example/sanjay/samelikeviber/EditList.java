package com.example.sanjay.samelikeviber;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


/**
 * Created by SANJAY on 10/10/2017.
 */

public class EditList extends AppCompatActivity {

    TextView txtname, txtphone, txtadd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_list);

//        ActionBar actionBar = getActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        txtname = (TextView)findViewById(R.id.txtname);
        txtphone = (TextView)findViewById(R.id.txtphone);
        txtadd = (TextView)findViewById(R.id.txtaddr);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String address = getIntent().getStringExtra("location");

        Log.d("nammeeee","asd"+name+"");
        txtname.setText(name);
        txtphone.setText(phone);
        txtadd.setText(address);

        setTitle(name);

    }
}
