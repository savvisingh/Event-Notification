package com.example.sikhi_calender3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBase_Handler extends SQLiteOpenHelper{
	final private static String NAME = "events_db";
	final private static Integer VERSION = 1;
	final static String TABLE_NAME = "Events";
	final static String EVENT_TITLE = "content_title";
	final static String EVENT_CONTENT = "content_text";
	final static String EVENT_TEXT = "ticker_text";
	final static String EVENT_MONTH = "event_month";
	final static String EVENT_DATE = "event_date";
	final static String EVENT_STATUS = "event_status";
	final static String _ID = "_id";
	final static String[] columns = { _ID,EVENT_TITLE,EVENT_CONTENT ,EVENT_TEXT,EVENT_STATUS,EVENT_MONTH, EVENT_DATE};
	
	final private static String CREATE_TB =

			"CREATE TABLE events (" + _ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ EVENT_TITLE + " TEXT NOT NULL," +EVENT_CONTENT+" TEXT NOT NULL,"+
					EVENT_TEXT+" TEXT NOT NULL,"+
					EVENT_MONTH+" INTEGER NOT NULL,"+ 
					EVENT_DATE +" INTEGER NOT NULL,"+EVENT_STATUS +" INTEGER)" ;
	
	public void add_event( Event e){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
        values.put(EVENT_TITLE,e.EVENTTITLE);
        values.put(EVENT_CONTENT,e.EVENTCONTENT);
        values.put(EVENT_TEXT,e.EVENTTEXT);
        values.put(EVENT_MONTH,e.EVENTMONTH);
        values.put(EVENT_DATE,e.EVENTDATE);
        values.put(EVENT_STATUS,e.EVENTSTATUS);
       
        db.insert(TABLE_NAME,null, values);
        db.close();
        Log.i("Database", "inserted");
	}
					
	public Event get_event( ){
		 SQLiteDatabase db = this.getReadableDatabase();
		 Cursor cursor = db.query(TABLE_NAME, columns,EVENT_STATUS + "=" + 0 ,  null , null, null, null);
		 Log.i("Database", "extracted in cursor");
		 Event e;
		 if(cursor.getCount()>0)
			 Log.i("Database", "Cursor intialized");
		 if (cursor != null)
	            cursor.moveToFirst();
		 
		  e = new Event(Integer.parseInt(cursor.getString(0)),
				             cursor.getString(1), 
				             cursor.getString(2), 
				             cursor.getString(3), 
				             Integer.parseInt(cursor.getString(4)),
				             Integer.parseInt(cursor.getString(5)));
		 Log.i("Database", "extracted in event object");
		 return e;
		 
	}
	public void setstatus(int i){
		SQLiteDatabase db = this.getWritableDatabase();
		
		 ContentValues values = new ContentValues();
	        values.put(EVENT_STATUS, 1);
	        
	    
	        db.update(TABLE_NAME, values,_ID + "=?",
	                new String[] { String.valueOf(i) });
	        
	 }

	public DataBase_Handler(Context context)
			 {
		super(context, NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase DB) {
		// TODO Auto-generated method stub
		DB.execSQL(CREATE_TB);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	

}
