package com.example.sikhi_calender3;



import java.util.ArrayList;
import java.util.List;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class MainActivity extends Activity {
       String[] menu;
       String[] menutitles={"Calender View","List View"};
       Integer[] menuIcons={ R.drawable.khanda_light_blue,R.drawable.khanda_light_blue};
       DrawerLayout dLayout;
       ListView dList;
       private List<List_item> rowItems;
       List_View_adapter list_adapter;
       private ActionBarDrawerToggle mDrawerToggle;
       private CharSequence mDrawerTitle;
  	 private CharSequence mTitle;
      
  @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
@Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sikhi_main_xml);
        
    mTitle = getTitle();
    mDrawerTitle="Drawer";
          dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
          dList = (ListView) findViewById(R.id.left_drawer);
          rowItems = new ArrayList<List_item>();
 		 

    	  for (int i = 0; i < menutitles.length; i++) {
    	   List_item items = new List_item(menutitles[i], menuIcons[i]);
    	   rowItems.add(items);
    	  }
    	  list_adapter = new List_View_adapter(getApplicationContext(), rowItems);
          dList.setAdapter(list_adapter);
      dList.setSelector(android.R.color.holo_blue_dark);
     
      
      
      mDrawerToggle = new ActionBarDrawerToggle(this, dLayout,
			    R.drawable.ic_drawer, R.string.app_name,R.string.app_name) {
			       
				
				public void onDrawerClosed(View view) {
					
			         getActionBar().setTitle(mTitle);
			         // calling onPrepareOptionsMenu() to show action bar icons
			         invalidateOptionsMenu();
			       }

			        
					
					public void onDrawerOpened(View drawerView) {
						
			              getActionBar().setTitle(mDrawerTitle);
			               // calling onPrepareOptionsMenu() to hide action bar icons
			              invalidateOptionsMenu();
			         }
			  };
			  dLayout.setDrawerListener(mDrawerToggle);
			 
			  getActionBar().setIcon(R.drawable.khanda_light_blue);
			  getActionBar().setDisplayHomeAsUpEnabled(true);
			  getActionBar().setDisplayShowTitleEnabled(true);
			 
			  if (savedInstanceState == null) {
				  updatedisplay(0);
			}
		      
      
      dList.setOnItemClickListener(new OnItemClickListener(){
           	 
		@Override
        public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
         updatedisplay(position);
         
        }
          });
  }
  
  @SuppressLint("NewApi")
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public void updatedisplay(int position){
	  Fragment detail= null;
	  dLayout.closeDrawers();
	 
	  switch ( position) {
	case 0:
		  detail = new MainActivity3(this);
		  break;
	case 1:
		 detail= new Expandable_List_View(this);
		break;

	default:
		break;
	}
	  
     
     
        FragmentManager fragmentManager = getFragmentManager();
      fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
  }
  
  
  
  
  
  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
      super.onPostCreate(savedInstanceState);
      // Sync the toggle state after onRestoreInstanceState has occurred.
      mDrawerToggle.syncState();
  }
  
  @TargetApi(Build.VERSION_CODES.HONEYCOMB)
@Override
  public void setTitle(CharSequence title) {
      mTitle = title;
     getActionBar().setTitle(mTitle);
  }
  
  @Override
  public void onConfigurationChanged(Configuration newConfig) {
      super.onConfigurationChanged(newConfig);
      mDrawerToggle.onConfigurationChanged(newConfig);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
       // Pass the event to ActionBarDrawerToggle, if it returns
       // true, then it has handled the app icon touch event
       if (mDrawerToggle.onOptionsItemSelected(item)) {
           return true;
       }
       // Handle your other action bar items...

       return super.onOptionsItemSelected(item);
  }

  
  
}