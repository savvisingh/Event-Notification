package com.example.sikhi_calender3;


import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AboutUs extends Fragment implements OnClickListener{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	    	
	    	View  view = inflater.inflate(R.layout.about_us, container, false);
	    	
	    	ImageView fb = (ImageView)view.findViewById(R.id.fb);
			ImageView git = (ImageView) view.findViewById(R.id.git);
			ImageView dp_fb = (ImageView) view.findViewById(R.id.developer_fb);
			
			fb.setOnClickListener(this);
			git.setOnClickListener(this);
			dp_fb.setOnClickListener(this);
	    	   return view;         
         
}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.fb :
			Intent fbIntent =
	          new Intent("android.intent.action.VIEW",
	            Uri.parse("https://www.facebook.com/mdgiitr"));
	          startActivity(fbIntent);
			break;
		case R.id.git :
			Intent gitIntent =
	          new Intent("android.intent.action.VIEW",
	            Uri.parse("https://github.com/sdsmdg"));
	          startActivity(gitIntent);			
			break;
		case R.id.developer_fb :
			Intent db_fbIntent =
	          new Intent("android.intent.action.VIEW",
	            Uri.parse("https://www.facebook.com/savvi.singh"));
	          startActivity(db_fbIntent);			
			break;
		
		}
	}
}