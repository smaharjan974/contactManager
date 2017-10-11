package com.example.sanjay.samelikeviber;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * Created by SANJAY on 10/5/2017.
 */

public class MessageFragment extends Fragment {

    static String ph;
    static EditText txtto;
    EditText txtmsg;
    Button btnsend;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.message_fragment,container,false);

        txtto = (EditText) view.findViewById(R.id.txtphone);
        txtmsg = (EditText)view.findViewById(R.id.txtmsg);
        btnsend = (Button)view.findViewById(R.id.btnsend);

        //txtto.setText(ph);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String msgbody = txtmsg.getText().toString();
                final String phoneno = txtto.getText().toString();
                Log.d(TAG, "onCreateView:"+msgbody+phoneno);
                SmsManager smsManager = SmsManager.getDefault();
                try{
                     smsManager.sendTextMessage(phoneno,null,msgbody,null,null);
                    Toast.makeText(getContext(), "sendinggg....", Toast.LENGTH_SHORT).show();
                }catch(Exception ex){
                    Toast.makeText(getContext(), "Check Permission.......", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;

    }

    public static Fragment create(String phone) {
        Log.d(TAG, "sfasfasf: "+phone);
        Fragment fragment = new MessageFragment();
        ph = phone;
        Log.d(TAG, "create: "+ph);
        return fragment;
    }


}
