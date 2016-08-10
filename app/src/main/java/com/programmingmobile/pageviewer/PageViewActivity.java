package com.programmingmobile.pageviewer;


import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import 	android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class PageViewActivity extends FragmentActivity {
	MyPageAdapter pageAdapter;

	
	public String[] images={};
    
   public String[] testi = {};
    
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_view);
        
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        
        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("title");
        int position = extras.getInt("position");
        ArrayList<App> list = (ArrayList<App>) extras.get("list");
        images = new String[list.size()];
        testi = new String[list.size()];
        //Log.i("debug","value1 ="+ value1);
        int cnt=0;
        for(int i=0;i<list.size();i++){
            App item = list.get(i);
            images[cnt]=item.image;
            //Log.i("debug","imags ="+ imags[cnt]);
            testi[cnt]=item.title;
            cnt++;        	
        }
        
        
        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        
        ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
        pager.setCurrentItem(position);
        
    }
    
    private List<Fragment> getFragments(){
    	List<Fragment> fList = new ArrayList<Fragment>();
    	for(int i=0;i<images.length;i++){
    	fList.add(MyFragment.newInstance("Fragment_"+i,images[i],testi[i]));
    	}
    	return fList;
    }

    private class MyPageAdapter extends FragmentPagerAdapter {
    	private List<Fragment> fragments;

        public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }
        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }
     
        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}
