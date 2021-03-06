package com.example.sikhi_calender3;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Int4;
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
	final static String EVENT_TYPE="event_type";
	final static String EVENT_YEAR="event_year";
	
	final static String _ID = "_id";
	final static String[] columns = { _ID,EVENT_TITLE,EVENT_CONTENT ,EVENT_TEXT,EVENT_MONTH,
		                                EVENT_DATE,EVENT_STATUS,EVENT_TYPE,EVENT_YEAR};
	
	final private static String CREATE_TB =

			"CREATE TABLE events (" + _ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ EVENT_TITLE + " TEXT NOT NULL," +EVENT_CONTENT+" TEXT NOT NULL,"+
					EVENT_TEXT+" TEXT NOT NULL,"+
					EVENT_MONTH+" INTEGER NOT NULL,"+ 
					EVENT_DATE +" INTEGER NOT NULL,"+EVENT_STATUS
					+" INTEGER,"+EVENT_TYPE+" INTEGER,"+ EVENT_YEAR+" INTEGER NOT NULL)"
					;
	
	public void add_event( Event e){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
        values.put(EVENT_TITLE,e.EVENTTITLE);
        values.put(EVENT_CONTENT,e.EVENTCONTENT);
        values.put(EVENT_TEXT,e.EVENTTEXT);
        values.put(EVENT_MONTH,e.EVENTMONTH);
        values.put(EVENT_DATE,e.EVENTDATE);
        values.put(EVENT_STATUS,e.EVENTSTATUS);
        values.put(EVENT_TYPE,e.EVENTTYPE);
        values.put(EVENT_YEAR,e.EVENTYEAR);
        
        db.insert(TABLE_NAME,null, values);
        db.close();
        Log.i("Database", "inserted");
	}
					
	public Event get_event( ){
		
		 SQLiteDatabase db = this.getReadableDatabase();
		 Cursor cursor = db.query(TABLE_NAME, columns,EVENT_STATUS + "=?"  , 
				 new String[] {String.valueOf(0)} , null, null, null);
		
		 Event e;
		 if(cursor.getCount()>0)
			 
		 if (cursor != null)
		 {       cursor.moveToFirst();
		 
		  e = new Event(Integer.parseInt(cursor.getString(0)),
				             cursor.getString(1), 
				             cursor.getString(2), 
				             cursor.getString(3), 
				             Integer.parseInt(cursor.getString(4)),
				             Integer.parseInt(cursor.getString(5)),
				             Integer.parseInt(cursor.getString(8))
				             );
		 Log.i("Database", "extracted in event object");
		 db.close();
		 return e;}
		
		 return new Event();
		 
	}
	
	public int get_no_events_on_day (int day,int month,int year){
		
		
		int no=0;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, columns, EVENT_DATE+ "=?"  , 
				new String[] {String.valueOf(day)} , null, null, null);
		cursor.moveToFirst();
		
		if(cursor.getCount()>0){
			for (int i=0;i<cursor.getCount();i++){
			if(Integer.parseInt(cursor.getString(4))==month)
			{
				 if (Integer.parseInt(cursor.getString(8))==year)
				no++;
				if(cursor.isLast())
				{db.close();
				
					return no;}
				cursor.moveToNext();
			}
			else{cursor.moveToNext();}
		};
		   }
		 db.close();
		
		return no;
	}
	public Boolean check_database(){
		 SQLiteDatabase db = this.getReadableDatabase();
		 Cursor cursor = db.query(TABLE_NAME, columns,null , null , null, null, null);
		 if (cursor.getCount()>0)
		 {db.close();
		 return false;}
		 db.close();
		 return true;
	}
	public List<Integer> Check_event(int date ,int month,int year){
		
		List<Integer> list =new ArrayList <Integer>();
		 SQLiteDatabase db = this.getReadableDatabase();
		 Cursor cursor = db.query(TABLE_NAME, columns, EVENT_DATE+ "=?"  , 
				 new String[] {String.valueOf(date)} , null, null, null);
		 if (cursor.getCount()>0)
		 { cursor.moveToFirst();
		
		  int GURPURAB =4;
		  for (int i=0;i<cursor.getCount();i++)
			  
		  {if(Integer.parseInt(cursor.getString(4))==month)
		 
		   
			  if (Integer.parseInt(cursor.getString(8))==year)
						 
		  { 
			  if (list.contains(Integer.parseInt(cursor.getString(7))))
				  continue;
			  else{ list.add(Integer.parseInt(cursor.getString(7)));}
			 
		  }
		  if(cursor.isLast())
		  {db.close();
			  return list;
		  }
		  else{
     cursor.moveToNext();}
		  
		 }
		 }
		 db.close();
		 return list;
	}
	
	public String get_event_content(String event_id){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, columns, _ID + "=?"  ,  
				new String[] {event_id} , null, null, null);
		String content=null;
		if (cursor.getCount()>0)
			cursor.moveToFirst();
			{content= cursor.getString(2);
			}
		return content;
		
	}
	public List<String> get_events_for_child_list (int month ,int year){
		ArrayList<String> list =new ArrayList<String>();
		SQLiteDatabase db = this.getReadableDatabase();
		 Cursor cursor = db.query(TABLE_NAME, columns, EVENT_MONTH+ "=?"  , 
				 new String[] {String.valueOf(month)} , null, null, null);
		 if (cursor.getCount()>0)
		 { cursor.moveToFirst();
		  for (int i=0;i<cursor.getCount();i++)
		  {
			  
			  list.add(cursor.getString(5)+"-"+cursor.getString(1)+"-"+cursor.getString(8));
			  if(cursor.isLast())
				  return list;
			  else cursor.moveToNext();
	   }
		
		 }
		 return list;
		 
	}
	public ArrayList<String> get_events_for_list (int date,int month,int year){
		
		ArrayList<String> list =new ArrayList<String>();
		SQLiteDatabase db = this.getReadableDatabase();
		 Cursor cursor = db.query(TABLE_NAME, columns, EVENT_DATE+ "=?"  , 
				 new String[] {String.valueOf(date)} , null, null, null);
		 if (cursor.getCount()>0)
		 { cursor.moveToFirst();
		  for (int i=0;i<cursor.getCount();i++)
		  {if(Integer.parseInt(cursor.getString(4))==month){
			  if (Integer.parseInt(cursor.getString(8))==year
					 )
			  list.add(cursor.getString(0)+"-"+cursor.getString(1)+"-"+cursor.getString(7));
			  if(cursor.isLast())
				  return list;
			   cursor.moveToNext();
	   }
		  else{ cursor.moveToNext(); }
		  }
		     } return list;
		 }
	
	
	
	
	public ArrayList<String> get (int date,int month){
		ArrayList<String> list =new ArrayList<String>();
		SQLiteDatabase db = this.getReadableDatabase();
		 Cursor cursor = db.query(TABLE_NAME, columns, EVENT_DATE+ "=?"  ,  
				 new String[] {String.valueOf(date)} , null, null, null);
		 if (cursor.getCount()>0)
		 { cursor.moveToFirst();
		  for (int i=0;i<cursor.getCount();i++)
		  {if(Integer.parseInt(cursor.getString(4))==month){
			  list.add(cursor.getString(1));
			  if(cursor.isLast())
				  return list;
			   cursor.moveToNext();
	   }
		  else{ cursor.moveToNext(); }
		  }
		     } return list;
		 }
	public void setstatus(int i){
		SQLiteDatabase db = this.getWritableDatabase();
		
		 ContentValues values = new ContentValues();
	        values.put(EVENT_STATUS, String.valueOf(1));
	        
	    
	        db.update(TABLE_NAME, values,_ID + "=?",
	                new String[] { String.valueOf(i) });
	        Log.i("Status ", "Updated");
	        db.close();
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
