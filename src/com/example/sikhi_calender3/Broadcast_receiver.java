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
	private String tickertext="default";
	private String  contenttitle="NanakShahi Calender";
	private String  contenttext="default";
	Intent service_intent;
	
	@Override
	public void onReceive(Context context, Intent arg1) {
		// TODO Auto-generated method stub
		
		Log.i("broadcast", "received");
		DataBase_Handler db = new DataBase_Handler(context);
		
        
        int id=0, no_of_events=0 ;
        Event event=db.get_event();
        if(event!=null)
        {
        no_of_events=db.get_no_events_on_day(event.getdate(), event.getmonth());
		id= event.getID();
		}
      
        for(int i=0;i<no_of_events;i++){
        	
        	tickertext=event.EVENTTEXT;
            contenttext=event.EVENTTITLE;
            Log.i("Using Id",String.valueOf(id));
            db.setstatus(id);
            id++;
    		event=db.get_event();

        	
            mNotificationIntent = new Intent(context, MainActivity.class);
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
    		mNotificationManager.notify(id,
    				notificationBuilder.build());
    		
    		        }
        {service_intent=new Intent(context,Start_Service.class);	
        context.startService(service_intent);}
		
		
	}
	
	

}