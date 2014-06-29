package com.example.sikhi_calender3;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class Broadcast_receiver extends BroadcastReceiver{
	private Intent mNotificationIntent;
	private PendingIntent mContentIntent;
	private String tickertext;
	private String  contenttitle;
	private String  contenttext;

	
	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		
		Log.i("broadcast", "received");
		DataBase_Handler db = new DataBase_Handler(context);
        db.add_event(new Event("Prakash Utsav", "Guru NaNakDev Ji Brithday", "Gursikhi Event", 29, 6)); 
        
        Event event=db.get_event();
        tickertext=event.EVENTTEXT;
        contenttitle=event.EVENTTITLE;
        contenttext=event.EVENTCONTENT;
        Log.i("Values", "set"); 
        
		int id= event.getID();
		db.setstatus(id);
		mNotificationIntent = new Intent(context, MainActivity3.class);
		mContentIntent = PendingIntent.getActivity(context, 0,
				mNotificationIntent, Intent.FLAG_ACTIVITY_NEW_TASK);
		
		Notification.Builder notificationBuilder = new Notification.Builder(
				context).setTicker(tickertext)
				.setSmallIcon(android.R.drawable.stat_sys_warning)
				.setAutoCancel(true).setContentTitle(contenttitle)
				.setContentText(contenttext).setContentIntent(mContentIntent);
			

		// Pass the Notification to the NotificationManager:
		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(2,
				notificationBuilder.build());
		
		
	}
	
	

}