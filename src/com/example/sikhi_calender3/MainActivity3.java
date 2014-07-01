package com.example.sikhi_calender3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity3 extends Activity {
   Intent service_intent;
	Button start_notifying,stop_notfying;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity3);
		
		start_notifying=(Button) findViewById(R.id.start_notifying);
	    stop_notfying=(Button) findViewById(R.id.stop_notifying);
	    
	    DataBase_Handler db1 = new DataBase_Handler(getApplicationContext());
	   if( db1.check_database())
	   {
		   db1.add_event(new Event("Jyoti Jot Diwas", "Guru AngadDev Ji shaheedi Purab", "martyr Gursikhi Event", 8, 1));
	        db1.add_event(new Event("Prakash Utsav", "Guru AngadDev Ji Birthday", " Gursikhi Event", 8, 2));
	   }
		 start_notifying.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					service_intent=new Intent(getApplicationContext(),Start_Service.class);		
					 
					startService(service_intent);
				
					
					}
			});
		 stop_notfying.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(service_intent!=null)
				stopService(service_intent);
				
			}
		});
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity3, menu);
		return true;
	}

}
