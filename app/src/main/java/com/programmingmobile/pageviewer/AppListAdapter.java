package com.programmingmobile.pageviewer;

import java.io.ByteArrayOutputStream;
import java.util.List;

import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AppListAdapter extends ArrayAdapter<App> {
    

    public AppListAdapter(Context context, int textViewResourceId, List<App> objects) {
        super(context, textViewResourceId, objects);
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        App item = getItem(position);
        
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item_layout, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.image);
            holder.titleTextView = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.titleTextView.setText(item.title);
        int imageresource = getContext().getResources().getIdentifier(item.thumbnail, "drawable", getContext().getPackageName());
        holder.imageView.setImageResource(imageresource);  
        
        return convertView;
    }
    
    
    /**
     * ViewHolder.
     */
    private class ViewHolder {
        
        public ImageView imageView;
        public TextView titleTextView;

        
    }

}
