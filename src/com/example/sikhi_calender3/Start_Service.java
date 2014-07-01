package com.example.sikhi_calender3;



import java.sql.Date;

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
	private Intent mNotificationReceiverIntent, mServiceReceiverIntent;
    private PendingIntent mNotificationReceiverPendingIntent,mServiceReceiverPendingIntent;
   
	

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
		   mNotificationReceiverIntent = new Intent (getApplicationContext(),Broadcast_receiver.class); 
			mNotificationReceiverPendingIntent = PendingIntent.getBroadcast(
					this.getApplicationContext(), 0, mNotificationReceiverIntent, 0);
			mServiceReceiverIntent= new Intent(getApplicationContext(), Start_Service.class);	 
			mServiceReceiverPendingIntent =PendingIntent.getService(getApplicationContext(), 0, mServiceReceiverIntent, 0);
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
		
		
		 Event event=db1.get_event();
		 int date= event.getdate();
		 Log.i("Event date", String.valueOf(date));
		int month = event.getmonth();
		 Log.i("Event month", String.valueOf(month));
		 Date time= new Date(2014,month,date);
		 long millisec =time.getTime();
		 Log.i("Event sec", String.valueOf(millisec));
			
				mAlarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000L,
						 mNotificationReceiverPendingIntent);
				Toast.makeText(getApplicationContext(), " Alarm Set",
						Toast.LENGTH_LONG).show();
			
				mAlarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000L,
						mServiceReceiverPendingIntent );
		
		
		Log.i("Alarm","Set");
		
		return START_NOT_STICKY;
		
		
		
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
