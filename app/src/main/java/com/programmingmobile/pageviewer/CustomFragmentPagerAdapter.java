package com.programmingmobile.pageviewer;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.GridView;

/**
 * FragmentPagerAdapter.
 */
public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<PageItem> mList;
    
    public CustomFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mList = new ArrayList<PageItem>();
    }
    
    @Override
    public Fragment getItem(int position) {
        PageItem item = mList.get(position);
        GridViewFragment gridViewFragment = new GridViewFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("list", item.appList);
        gridViewFragment.setArguments(bundle);
        return gridViewFragment;
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position).title;
    }

    @Override
    public int getCount() {
        return mList.size();
    }
    

    public void addItem(PageItem item) {
        mList.add(item);
    }
    
}
