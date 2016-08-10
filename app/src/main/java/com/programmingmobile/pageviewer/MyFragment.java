package com.programmingmobile.pageviewer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

public class MyFragment extends Fragment {
	public static final String FRAGMENT = "EXTRA_MESSAGE";
	public static final String txt = "EXTRA_MESSAGE";
	public static final String imag = "EXTRA_MESSAGE";
	
	
	public static final MyFragment newInstance(String message,String img,String text)
	{
		MyFragment f = new MyFragment();
		Bundle bdl = new Bundle();
		
	    final String[] stringa = {message,img,text};
	   
		bdl.putStringArray(FRAGMENT, stringa);

	    
	    f.setArguments(bdl);
	    return f;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {
		
		Bundle bundle=getArguments();
		String[] fragment = bundle.getStringArray(FRAGMENT);
		View v = inflater.inflate(R.layout.myfragment_layout, container, false);
		TextView messageTextView = (TextView)v.findViewById(R.id.textView);
		ImageView imageView = (ImageView)v.findViewById(R.id.image);
		int imageresource = getResources().getIdentifier(fragment[1], "drawable", getActivity().getPackageName());        
	    imageView.setImageResource(imageresource);
		messageTextView.setText(fragment[2]);
		//Log.i("debug","imag ="+ fragment[1]);


		
        return v;
    }
	
}
