package com.example.sikhi_calender3;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class no_of_events  extends Activity{
    
	
	ArrayList <String> list;
	
	ListView events_listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.events_listview);
		
		events_listview=(ListView)findViewById(R.id.listView1);
		TextView date = (TextView)findViewById(R.id.textView1);
		list=new ArrayList<String>();
		ActionBar bar1 = getActionBar();
		 bar1.setBackgroundDrawable(new ColorDrawable(0xff6fb7ea));
		  bar1.setDisplayHomeAsUpEnabled(true);
		  bar1.setIcon(R.drawable.khanda_light_blue);
		  bar1.setDisplayShowTitleEnabled(true);
		  bar1.setTitle("Nanakshahi Calender");
		final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	      	 
		Bundle b=getIntent().getExtras();
		String D_M_Y =b.getString("selected_cell");
		String [] event =D_M_Y.split("-");
		int eventdate= Integer.parseInt(event[0]);
		int eventmonth= Integer.parseInt(event[1]);
		int eventyear= Integer.parseInt(event[2]);
		
		 date.setText(eventdate+" "+months[eventmonth-1]);
	       
		 
		DataBase_Handler db1 = new DataBase_Handler(getApplicationContext());
		  list=db1.get_events_for_list(eventdate, eventmonth,eventyear);
		listview_adapter adapter =new listview_adapter(getApplicationContext(),list);
		 events_listview.setAdapter(adapter);
		
	    
			
		
	

}
	}