package com.example.sikhi_calender3;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

 
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Expandable_List_View extends Fragment {
	 
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    Context appcontext;
    public Expandable_List_View(Context applcontext){
    	appcontext=applcontext;
    }
    
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
    	View view= inflater.inflate(R.layout.expandablelistview, container,false);
    	
    	 expListView = (ExpandableListView) view.findViewById(R.id.lvExp);
    	 
    	 prepareListData();
    	 
    	 listAdapter = new ExpandableListAdapter(appcontext, listDataHeader, listDataChild);
    	 
         // setting list adapter
         expListView.setAdapter(listAdapter);
  
         // Listview Group click listener
         expListView.setOnGroupClickListener(new OnGroupClickListener() {
        	 
        	
             @Override
             public boolean onGroupClick(ExpandableListView parent, View v,
                     int groupPosition, long id) {
            	 
                 return false;
             }
         });
  
         // Listview Group expanded listener
         expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
        	 int previousGroup = -1;
             @Override
             public void onGroupExpand(int groupPosition) {
            	 if(groupPosition != previousGroup)
                     expListView.collapseGroup(previousGroup);
                 previousGroup = groupPosition;
             }
         });
  
         // Listview Group collasped listener
         expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
  
             @Override
             public void onGroupCollapse(int groupPosition) {
                
             }
         });
  
         // Listview on child click listener
         expListView.setOnChildClickListener(new OnChildClickListener() {
  
             @Override
             public boolean onChildClick(ExpandableListView parent, View v,
                     int groupPosition, int childPosition, long id) {
                 // TODO Auto-generated method stub
            	 String[] event_string= listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).split("-");
            	 String event_id =event_string[0];
                Intent event =new Intent(appcontext, Display_event.class);
                event.putExtra("event_id", event_id);
                //appcontext.startActivity(event);
                 return false;
             }
                 }
                     );
         
         return view;
         }
 
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        DataBase_Handler db =new DataBase_Handler(appcontext);
        final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
       for (int i=0;i<12;i++)
       {
    	   listDataHeader.add(months[i]);   
       }
       
       for (int i=0;i<12;i++)
       {
    	   String month =months[i];
    	   List<String> month2 = db.get_events_for_child_list(i+1,2014);
    	   listDataChild.put(listDataHeader.get(i), month2);
    	   
    			   
       }
        // Adding child data
       
       
       
    }


	
}
