package com.example.sikhi_calender3;					
import android.R.color;
import android.os.Bundle;
import android.app.Activity;
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
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends Activity implements OnGesturePerformedListener
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
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                GestureOverlayView gestureOverlayView = new GestureOverlayView(this);
                View inflate = getLayoutInflater().inflate(
                        R.layout.activity_main, null);
                gestureOverlayView.addView(inflate);
                gestureOverlayView.addOnGesturePerformedListener(this);
                gestureOverlayView.setGestureColor(Color.TRANSPARENT);
                gestureOverlayView.setUncertainGestureColor(Color.TRANSPARENT);
                // speeds up the reaction time a little
                gestureOverlayView.setFadeOffset(0);
                gestureOverlayView.setHapticFeedbackEnabled(true);
                mLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
                if (!mLibrary.load()) {
                    finish();
                }

                setContentView(gestureOverlayView);
               
                _calendar = Calendar.getInstance(Locale.getDefault());
                month = _calendar.get(Calendar.MONTH) + 1;
                year = _calendar.get(Calendar.YEAR);
               
                currentMonth = (Button) this.findViewById(R.id.currentMonth);
                currentMonth.setText(DateFormat.format(dateTemplate, _calendar.getTime()));

                calendarView = (GridView) this.findViewById(R.id.calendar);
                DataBase_Handler db1 = new DataBase_Handler(getApplicationContext());
         	   if( db1.check_database())
         	   {
         		  db1.add_event(new Event("Jyoti Jot Diwas", "Guru AngadDev Ji shaheedi Purab", "martyr Gursikhi Event", 7, 12,Masya));
         		  db1.add_event(new Event("Prakash Utsav", "Guru Ramdas Ji Birthday ", " Gursikhi Event", 7, 12,Gurpurab));
                  db1.add_event(new Event("Prakash Utsav", "Guru Ramdas Sahib Ji Birthday", " Gursikhi Event", 7, 12,PuranMashi));
         	      db1.add_event(new Event("Prakash Utsav", "Guru HarKrishn Sahib Ji Birthday", " Gursikhi Event", 7, 23,Gurpurab));
         	     db1.add_event(new Event("Jyoti Jot Diwas", "Guru AngadDev Ji shaheedi Purab", "martyr Gursikhi Event", 8, 18,Gurpurab));
        		  db1.add_event(new Event("Prakash Utsav", "Guru Ramdas Ji Birthday ", " Gursikhi Event", 8, 20,Sagrant));
                 db1.add_event(new Event("Prakash Utsav", "Guru Ramdas Sahib Ji Birthday", " Gursikhi Event", 8, 24,Gurpurab));
        	      db1.add_event(new Event("Prakash Utsav", "Guru HarKrishn Sahib Ji Birthday", " Gursikhi Event", 8, 6,Gurpurab));
         	   }

         	  service_intent=new Intent(getApplicationContext(),Start_Service.class);		
				 
				startService(service_intent);
               
                adapter = new GridCellAdapter(getApplicationContext(),  month, year);
                adapter.notifyDataSetChanged();
                calendarView.setAdapter(adapter);
                
        }

        
        private void setGridCellAdapterToDate(int month, int year){
                adapter = new GridCellAdapter(getApplicationContext(), month, year);
                _calendar.set(year, month - 1, _calendar.get(Calendar.DAY_OF_MONTH));
                currentMonth.setText(DateFormat.format(dateTemplate, _calendar.getTime()));
                adapter.notifyDataSetChanged();
                calendarView.setAdapter(adapter);
            }

        
         
		@Override
		 public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
	        ArrayList<Prediction> predictions = mLibrary.recognize(gesture);
	        for (Prediction prediction : predictions) {
	            if (prediction.name.equals("next")) {

	                if (month > 11) {
	                    month = 1;
	                    year++;
	                } else {
	                    month++;
	                }
	                Log.d(tag, "Setting Next Month in GridCellAdapter: "
	                        + "Month: " + month + " Year: " + year);
	                setGridCellAdapterToDate(month, year);
	                return;
	            } else {
	                if (prediction.name.equals("previous")) {

	                    if (month <= 1) {
	                        month = 12;
	                        year--;
	                    } else {
	                        month--;
	                    }
	                    Log.d(tag, "Setting Prev Month in GridCellAdapter: "
	                            + "Month: " + month + " Year: " + year);
	                    setGridCellAdapterToDate(month, year);
	                    return;
	                }
	            }

	        }

	    }

	

}

