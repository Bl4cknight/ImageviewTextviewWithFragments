package com.programmingmobile.pageviewer;

import java.util.ArrayList;


import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import 	android.content.Intent;

public class GridViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        GridView gridView = new GridView(getActivity());

        Configuration config = getResources().getConfiguration();

        //gridView.setColumnWidth(150);
        gridView.setNumColumns(gridView.AUTO_FIT);
        gridView.setSelector(R.drawable.selector);




        @SuppressWarnings("unchecked")
        ArrayList<App> list = (ArrayList<App>) getArguments().get("list");
        //gridView = (GridView) getActivity().findViewById(R.id.gridView);
        gridView.setAdapter(new AppListAdapter(getActivity(), R.layout.grid_item_layout, list));
        gridView.setDrawSelectorOnTop(true);
        
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	ArrayList<App> list = (ArrayList<App>) getArguments().get("list");
                App item = list.get(position);
                
                //Create intent
                Intent i = new Intent(parent.getContext(), PageViewActivity.class);
                i.putExtra("title", item.title);
                i.putExtra("image", item.image);
                i.putExtra("position", position);
                i.putExtra("list", list);
                	//Log.i("debug", item.title);
                //Start activity
                startActivity(i);
            }
        });

        return gridView;
    }

}
