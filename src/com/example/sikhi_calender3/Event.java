package com.example.sikhi_calender3;



public class Event {

	 
	public int EVENTDATE;
	public int EVENTMONTH ;
	 public String EVENTTITLE ;
	 public String EVENTCONTENT ;
	 public	String EVENTTEXT ;
	 public String EVENTSTATUS;
	 public int ID ;
	 public int EVENTTYPE;
     public int EVENTYEAR;
	 public Event(){}
	 public Event(String title,String content,String tickertext,int month,int date,int eventtype,int year){
		 EVENTDATE=date; 
		 EVENTMONTH=month;
		 EVENTTITLE=title;
		 EVENTCONTENT=content;
		 EVENTTEXT=tickertext; 
		 EVENTSTATUS=String.valueOf(0);
		 EVENTTYPE=eventtype;
		 EVENTYEAR=year;
		 
		
	 }
	 public Event(int id,String title,String content,String tickertext,int month,int date,int year){
		 EVENTDATE=date; 
		 EVENTMONTH=month;
		 EVENTTITLE=title;
		 EVENTCONTENT=content;
		 EVENTTEXT=tickertext; 
		 EVENTSTATUS=String.valueOf(0);
		 ID=id; 
		 EVENTYEAR=year;
		
	 }
	 
	 
     public int getID( ){
    	 return this.ID;
     }
     public int getdate( ){
    	 return this.EVENTDATE;
     }
 
     public int getmonth( ){
    	 return this.EVENTMONTH;
     }	
     public int getyear( ){
    	 return this.EVENTYEAR;
     }	
 
}
