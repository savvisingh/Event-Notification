package com.example.sikhi_calender3;



import java.sql.Date;
import java.util.Currency;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class Start_Service extends Service{
	private AlarmManager mAlarmManager;
	private Intent mNotificationReceiverIntent;
    private PendingIntent mNotificationReceiverPendingIntent;
   
	

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		   mNotificationReceiverIntent = new Intent (getApplicationContext(),Broadcast_receiver.class); 
			
			
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i("service","Off");
		super.onDestroy();
		if(mNotificationReceiverPendingIntent!=null)
		{mAlarmManager.cancel(mNotificationReceiverPendingIntent);}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		
		
		
		DataBase_Handler db1 = new DataBase_Handler(getApplicationContext());
		
		
		
		 long eventmillisec,currentmillisec;
		 Event event=db1.get_event();
		 int date= event.getdate();
  		 int month = event.getmonth();
  		 int year =event.getyear();
  		 int yy= year -1900;
		 Date time= new Date(yy, month-1,date);
		 eventmillisec =time.getTime();
		 currentmillisec =System.currentTimeMillis();
		 int id=event.getID();
		 Log.i("Using yy",String.valueOf(yy));
		
		  while (eventmillisec<currentmillisec)
		{  
			 
			 db1.setstatus(id);
			 event=db1.get_event();
			 id=event.getID();
		    date= event.getdate();
   		  month = event.getmonth();
   		 year =event.getyear();
 		  yy= year -1900;
		  time= new Date(yy, month-1,date);
		 eventmillisec =time.getTime();
		 currentmillisec =System.currentTimeMillis();
		 	
		};
		 Log.i("Using Id",String.valueOf(id));
		Log.i("event date",String.valueOf(date));
		int no=db1.get_no_events_on_day(date, month,year);
		Log.i("no of events",String.valueOf(no));
		
		mNotificationReceiverPendingIntent = PendingIntent.getBroadcast(
	   this.getApplicationContext(),1, mNotificationReceiverIntent, PendingIntent.FLAG_UPDATE_CURRENT);
				mAlarmManager.set(AlarmManager.RTC_WAKEUP,eventmillisec -3*60*60*1000 ,
						 mNotificationReceiverPendingIntent);
				Log.i("Alarm","Set");
				
				
			
		
		
		
		
		
		return START_NOT_STICKY;
		
		
		
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
