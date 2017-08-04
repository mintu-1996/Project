package com.example.mintu_1996.project;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Timer;
import java.util.TimerTask;

public class TheatreNearBy extends AppCompatActivity {
    ViewPager mViewPager;
    CustomPagerAdapter mCustomPagerAdapter;
    int[] mResources = {
            R.drawable.eight,
            R.drawable.nine,
            R.drawable.seven};
    String arr[]={"hffewy","hjrfggkjhh","sdfurifh","hffewy","hjrfggkjhh","sdfurifh"};
    int i=0;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theatre_near_by);
        lv=(ListView)findViewById(R.id.listview_items);
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,arr);
        lv.setAdapter(aa);
        mCustomPagerAdapter = new CustomPagerAdapter(this,mResources,mResources.length);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
        Timer time = new Timer();
        time.scheduleAtFixedRate(new MyTimer(),5000,3000);
    }
    public class MyTimer extends TimerTask {

        @Override
        public void run() {
            TheatreNearBy.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mViewPager.setCurrentItem(i);
                    if(i==mResources.length-1)
                        i=0;
                    else
                        i++;
                }
            });
        }
    }

}
