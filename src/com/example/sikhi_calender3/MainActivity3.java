package com.example.sikhi_calender3;					
import android.R.color;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.view.Menu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.GestureDetector;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity3 extends Fragment implements OnClickListener
    {
	Intent service_intent;
    final int Sagrant=1, Masya=2 , PuranMashi=3 ,Gurpurab=4,Historical_days=5,Other_Events=6; 
    private Button selectedDayMonthYearButton;
    private Button currentMonth;
    private ImageView prevMonth;
    private ImageView nextMonth;
    private GridView calendarView;
    private GridCellAdapter adapter;
    private Calendar _calendar;
    private int month, year;
    private static final String dateTemplate = "MMMM yyyy";
    String flag ="abc";
    String date_month_year;
    private static final String tag = "SimpleCalendarViewActivity";
    private GestureLibrary mLibrary;
	private Context appcontext;  
	
    public  MainActivity3( Context context){
    	appcontext=context;
    }
	    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	    	
	    	View  view = inflater.inflate(R.layout.activity_main, container, false);
	    	
	    	            
            _calendar = Calendar.getInstance(Locale.getDefault());
            month = _calendar.get(Calendar.MONTH) + 1;
            year = _calendar.get(Calendar.YEAR);
           
            prevMonth = (ImageView) view.findViewById(R.id.prevMonth);
            prevMonth.setOnClickListener(this);
            
            currentMonth = (Button) view.findViewById(R.id.currentMonth);
            currentMonth.setText(DateFormat.format(dateTemplate, _calendar.getTime()));

            nextMonth = (ImageView) view.findViewById(R.id.nextMonth);
            nextMonth.setOnClickListener(this);
            
            calendarView = (GridView) view.findViewById(R.id.calendar);
           

     	  service_intent=new Intent(appcontext,Start_Service.class);		
			 
			appcontext.startService(service_intent);
           
            adapter = new GridCellAdapter(appcontext,  month, year);
            adapter.notifyDataSetChanged();
           
            calendarView.setAdapter(adapter);
            
           
            
           
           
             
             
            
             // speeds up the reaction time a little
            
             mLibrary = GestureLibraries.fromRawResource(appcontext, R.raw.gestures);
             
           
		// TODO Auto-generated method stub
		return view;
	}

	   
		
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                DataBase_Handler db1 = new DataBase_Handler(appcontext);
          	   if( db1.check_database())
          	   {
          		  
          		   
          	      db1.add_event(new Event("Jyoti Jot Diwas", "Guru AngadDev Ji shaheedi Purab", "martyr Gursikhi Event", 8, 18,Gurpurab));
         		  db1.add_event(new Event("Prakash Utsav", "Guru Ramdas Ji Birthday ", " Gursikhi Event", 8, 20,Sagrant));
                  db1.add_event(new Event("Prakash Utsav", "Guru Ramdas Sahib Ji Birthday", " Gursikhi Event", 8, 23,Gurpurab));
         	      db1.add_event(new Event("Prakash Utsav", "Guru HarKrishn Sahib Ji Birthday", " Gursikhi Event", 8, 30,Gurpurab));
         	      
          	   }
                

                   }

        
        private void setGridCellAdapterToDate(int month, int year){
                adapter = new GridCellAdapter(appcontext, month, year);
                _calendar.set(year, month - 1, _calendar.get(Calendar.DAY_OF_MONTH));
                currentMonth.setText(DateFormat.format(dateTemplate, _calendar.getTime()));
                adapter.notifyDataSetChanged();
                calendarView.setAdapter(adapter);
            }


		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (v == prevMonth){
				                    if (month <= 1){
				                        month = 12;
				                        year--;
				                    }
				                    else
				                        month--;
				                    setGridCellAdapterToDate(month, year);
				                }
				                if (v == nextMonth){
				                    if (month > 11){
				                        month = 1;
				                        year++;
				                    }
				                    else
				                        month++;
				                    setGridCellAdapterToDate(month, year);
			
		} }
    }

