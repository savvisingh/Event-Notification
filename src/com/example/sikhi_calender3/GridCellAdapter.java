package com.example.sikhi_calender3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

 public class GridCellAdapter extends BaseAdapter implements OnClickListener
            {
                private final Context _context;
                public int yyear ;
                private final List<String> list;
                private static final int DAY_OFFSET = 1;
                private final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                private final int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                private int daysInMonth;
                private int currentDayOfMonth;
                private int currentWeekDay;
                private Button gridcell;
                private TextView num_events_per_day;
                private ImageView img1,img2,img3;
                public DataBase_Handler db1 ;

                // Days in Current Month
                public GridCellAdapter(Context context, int month, int year){
                        super();
                        this._context = context;
                        this.list = new ArrayList<String>();
                        Calendar calendar = Calendar.getInstance();
                        setCurrentDayOfMonth(calendar.get(Calendar.DAY_OF_MONTH));
                        setCurrentWeekDay(calendar.get(Calendar.DAY_OF_WEEK));
                        this.yyear=year;
                         db1 = new DataBase_Handler(_context);
                        // Print Month
                        printMonth(month, year);

                        // Find Number of Events
                        
                    }
                private int getMonthIndex (String month){
                	for (int i=0;i<12;i++)
                	{
                		if (month==months[i])
                			return i+1;
                	}
                	 return 0;
                }
                private String getMonthAsString(int i){
                        return months[i];
                     
                    }

                private int getNumberOfDaysOfMonth(int i){
                        return daysOfMonth[i];
                    }

                public String getItem(int position){
                        return list.get(position);
                    }

                @Override
                public int getCount(){
                        return list.size();
                    }

                private void printMonth(int mm, int yy){
                        int trailingSpaces = 0;
                        int daysInPrevMonth = 0;
                        int prevMonth = 0;
                        int prevYear = 0;
                        int nextMonth = 0;
                        int nextYear = 0;
                        if (yy%4==0){
                            daysOfMonth[1]=29;
                        }
                        int currentMonth = mm - 1;
                        daysInMonth = getNumberOfDaysOfMonth(currentMonth);


                        // Gregorian Calendar : MINUS 1, set to FIRST OF MONTH
                        GregorianCalendar cal = new GregorianCalendar(yy, currentMonth, 1);
                        

                        if (currentMonth == 11){
                                prevMonth = currentMonth - 1;
                                daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                                nextMonth = 0;
                                prevYear = yy;
                                nextYear = yy + 1;
                            }
                        else if (currentMonth == 0){
                                prevMonth = 11;
                                prevYear = yy - 1;
                                nextYear = yy;
                                daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                                nextMonth = 1;
                            }
                        else{
                                prevMonth = currentMonth - 1;
                                nextMonth = currentMonth + 1;
                                nextYear = yy;
                                prevYear = yy;
                                daysInPrevMonth = getNumberOfDaysOfMonth(prevMonth);
                            }

                        int currentWeekDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
                        trailingSpaces = currentWeekDay;
                       
                       
                        // Trailing Month days
                        for (int i = 0; i < trailingSpaces; i++){
                                list.add(String.valueOf((daysInPrevMonth - trailingSpaces + DAY_OFFSET) + i)
                                		+ "-GREY" + "-" +String.valueOf(prevMonth) + "-" + prevYear);
                            }

                        // Current Month Days
                        for (int i = 1; i <= daysInMonth; i++){
                                if (i == getCurrentDayOfMonth())
                                        list.add(String.valueOf(i) + "-BLUE" + "-" + String.valueOf(currentMonth) + "-" + yy);
                                else
                                        list.add(String.valueOf(i) + "-WHITE" + "-" + String.valueOf(currentMonth) + "-" + yy);
                            }

                        // Leading Month days
                        for (int i = 0; i < list.size() % 7; i++){
                                list.add(String.valueOf(i + 1) + "-GREY" + "-" + String.valueOf(nextMonth) + "-" + nextYear);
                            }
                    }

               

                @Override
                public long getItemId(int position){
                        return position;
                    }

                @Override
                public View getView(int position, View convertView, ViewGroup parent){
                        View row = convertView;
                        if (row == null){
                           LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                row = inflater.inflate(R.layout.callender_grid_cell, parent, false);
                            }

                        // Get a reference to the Day gridcell
                        gridcell = (Button) row.findViewById(R.id.calendar_day_gridcell);
                        gridcell.setOnClickListener(this);
                        img1=(ImageView)row.findViewById(R.id.imageView1);
                        img2=(ImageView)row.findViewById(R.id.imageView2);
                        img3=(ImageView)row.findViewById(R.id.imageView3);

                        // ACCOUNT FOR SPACING

                        String[] day_color = list.get(position).split("-");
                        String theday = day_color[0];
                        String themonth = day_color[2];
                        String theyear = day_color[3];
                       
                       
                        Calendar calendar = Calendar.getInstance();
                         int CurrentMonth=calendar.get(Calendar.MONTH);
                       
                        // Set the Day GridCell
                        gridcell.setText(theday);
                        gridcell.setTag(theday + "-" + String.valueOf(Integer.parseInt(themonth)+1) + "-" + theyear);

                        if (day_color[1].equals("GREY"))
                                {
                                gridcell.setBackgroundResource(R.drawable.grid_selector);}
                        
                        if (day_color[1].equals("WHITE"))
                        { gridcell.setTextColor(Color.BLACK);
                        gridcell.setBackgroundResource(R.drawable.grid_selector);}
                        
                        if (day_color[1].equals("BLUE"))
                         {if (CurrentMonth==Integer.parseInt(day_color[2]))
                        	{gridcell.setTextColor(Color.BLACK);
                          gridcell.setBackgroundResource(R.drawable.current_date);}
                         else
                        	 gridcell.setBackgroundResource(R.drawable.grid_selector);
                         }
                                         
                        
                        List<Integer> list =new ArrayList <Integer>();
                        list=db1.Check_event(Integer.parseInt(theday), Integer.parseInt(themonth)+1,Integer.parseInt( theyear));
                       if(list.size()>0){
                    	   int no =list.size();
                         int i=0;
                    	int event_type_year=list.get(i);
                    	  
                    	 Log.i("THe no of events", String.valueOf(no));   
                    	   
                       switch (event_type_year  ) {					
                       case 1:
                       
   					       img1.setImageResource(R.drawable.khanda_violet);	break;
   					case 2:
   						
   					       img1.setImageResource(R.drawable.khanda_black);	break;
                       
   					case 3:
   					
   					       img1.setImageResource(R.drawable.khanda_green);	break;
   					case 4:
   						
   					       img1.setImageResource(R.drawable.khanda_red);	break;
   					case 5:
   						
   					       img1.setImageResource(R.drawable.khanda_blue); break;
   					case 6:
   						
   					       img1.setImageResource(R.drawable.khanda_brown); break;
					}
                       i++;
                       if(i<no){
                    	   event_type_year=list.get(i);
                           
                    	   switch ( event_type_year)  {					
                           case 1:
                        	  
       					       img2.setImageResource(R.drawable.khanda_violet);	break;
       					case 2:
       						
       					       img2.setImageResource(R.drawable.khanda_black);	break;
       					case 3:
       						
       					       img2.setImageResource(R.drawable.khanda_green);	break;
       					case 4:
       						
       					       {img2.setImageResource(R.drawable.khanda_red);	break;}
       					case 5:
       						
       					       img2.setImageResource(R.drawable.khanda_blue); break;
                    	  
       					case 6:
       						
       					       img2.setImageResource(R.drawable.khanda_brown); break;

       					  
       					}
                       }
                       i++;
                       if(i<no){
                    	   event_type_year=list.get(i);
                    	   switch (event_type_year ) {					
                    	   case 1:
                    		  
       					       img3.setImageResource(R.drawable.khanda_violet);	break;
       					case 2:
       						
       					       img3.setImageResource(R.drawable.khanda_black);	break;
       					case 3:
       						
       					       img3.setImageResource(R.drawable.khanda_green);	break;
       					case 4:
       					       img3.setImageResource(R.drawable.khanda_red);	break;
       					case 5:
       						
       					       img3.setImageResource(R.drawable.khanda_blue); break;
       					case 6:
       						
       					       img3.setImageResource(R.drawable.khanda_brown); break;
       					  
       					}
                       }
                       
                       }
                      
                        return row;
                    }
                @Override
                public void onClick(View view){
                	
                        String date_month_year = (String) view.getTag();
                        
                        String[] dmy = date_month_year.split("-");
                        int date= Integer.parseInt(dmy[0]);
                        int month= Integer.parseInt(dmy[1]);
                       int year =Integer.parseInt(dmy[2]);
                        
                        int no_of_events =db1.get_no_events_on_day(date, month,year);
                        Log.i("events in gridcell", String.valueOf(no_of_events));
                        if (no_of_events>0){
                        Intent events= new Intent(_context,no_of_events.class);
                        events.putExtra("selected_cell",date_month_year );
                        events.putExtra("no of events",String.valueOf(no_of_events) );
                        events.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                		_context.startActivity(events);
                        }
                    }

                public int getCurrentDayOfMonth(){
                        return currentDayOfMonth;
                    }

                private void setCurrentDayOfMonth(int currentDayOfMonth){
                        this.currentDayOfMonth = currentDayOfMonth;
                    }
                public void setCurrentWeekDay(int currentWeekDay){
                        this.currentWeekDay = currentWeekDay;
                    }
                public int getCurrentWeekDay(){
                        return currentWeekDay;
                    }
            }
