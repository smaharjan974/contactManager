package com.example.sanjay.samelikeviber;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;

public class Viber extends AppCompatActivity implements AddContactFragment.TextClicked,MyAdapter.AdapterCallback{
    TabLayout tab;
    String namess;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viber);


        tab = (TabLayout)findViewById(R.id.tablayout);
        tab.addTab(tab.newTab().setText("Contact").setIcon(R.drawable.ic_contact_phone_black_24dp));
        tab.addTab(tab.newTab().setText("Add").setIcon(R.drawable.ic_person_add_black_24dp));
        tab.addTab(tab.newTab().setText("Message").setIcon(R.drawable.ic_message_black_24dp));


        FragmentManager fm = getSupportFragmentManager();
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(new PagesAdapter(fm,tab.getTabCount()));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.search:
               Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show();
               startActivity(new Intent(this,Search.class));
               break;
           case R.id.publicacc:
               //startActivity(new Intent(Viber.this,Search.class));
               Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show();
               break;
       }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void sendText(String text, String s, String sa) {
        Log.d("asdfsa",text);
        //ContactFragment frag = (ContactFragment) getSupportFragmentManager().findFragmentById(R.id.contactfrag);
        //frag.updateText("fgfdh");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = ContactFragment.create(text, s,sa);
        fragmentTransaction.add(R.id.contactfrag, fragment);
        fragmentTransaction.commit();


        viewPager.setCurrentItem(0);
    }

    @Override
    public void onMethodCallback(String ph) {
        Log.d("ABCC", "onMethodCallback: "+ph);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = MessageFragment.create(ph);
        fragmentTransaction.add(R.id.msgfrg, fragment);
        fragmentTransaction.commit();
    }

//    @Override
//    public void getPhone(String phone) {
//        Log.d("abcdd","ad"+phone);
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        Fragment fragment = MessageFragment.create(phone);
//        ft.add(R.id.contactfrag,fragment);
//        ft.commit();
//    }

    public class PagesAdapter extends FragmentPagerAdapter {
        int nooffrags;

        public PagesAdapter(FragmentManager fm, int tabCount) {
            super(fm);
            this.nooffrags=tabCount;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    ContactFragment cf = new ContactFragment();
                    return cf;
                case 1:
                    return new AddContactFragment();
                case 2:
                    return new MessageFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {

            return nooffrags;
        }
    }
}
