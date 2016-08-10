package com.programmingmobile.pageviewer;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import 	android.app.ActionBar;
import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

/**
 * ViewPager Activity.
 */
public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_view);
        
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        
        
        final String [] thumbs ={
        		"@drawable/thumb_shot_0",
        		"@drawable/thumb_shot_1","@drawable/thumb_shot_2","@drawable/thumb_shot_3","@drawable/thumb_shot_4","@drawable/thumb_shot_5","@drawable/thumb_shot_6","@drawable/thumb_shot_7","@drawable/thumb_shot_8","@drawable/thumb_shot_9"
        };
        
        final String[] images = {
        		"@drawable/shot_0",
        		"@drawable/shot_1","@drawable/shot_2","@drawable/shot_3","@drawable/shot_4","@drawable/shot_5","@drawable/shot_6","@drawable/shot_7","@drawable/shot_8","@drawable/shot_9"
        };
        
        final String[] testi = {
        		"shot_0",
        		"shot_1","shot_2","shot_3","shot_4","shot_5","shot_6","shot_7","shot_8","shot_9"
        };


        CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(getSupportFragmentManager());


        ArrayList<App> appList = new ArrayList<App>();
        for (int i = 0; i < images.length; i++) {
            App item = new App();
            item.title = testi[i];
            item.image = images[i];
            item.thumbnail = thumbs[i];
            appList.add(item);
        }



        PageItem popular = new PageItem();
        popular.title = "App";
        popular.fragmentKind = PageItem.GRID;
        popular.appList = appList;
        adapter.addItem(popular);


        pager.setAdapter(adapter);
    }
}
