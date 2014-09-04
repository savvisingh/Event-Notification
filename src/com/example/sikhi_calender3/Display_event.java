package com.example.sikhi_calender3;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class Display_event extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_display);
		ActionBar bar1 = getActionBar();
		 bar1.setBackgroundDrawable(new ColorDrawable(0xff6fb7ea));
		  bar1.setDisplayHomeAsUpEnabled(true);
		  bar1.setIcon(R.drawable.khanda_light_blue);
		  bar1.setDisplayShowTitleEnabled(true);
			 
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
}
