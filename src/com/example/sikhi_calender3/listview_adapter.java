package com.example.sikhi_calender3;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class listview_adapter extends BaseAdapter implements OnClickListener{
     ArrayList <String> list;
     Context context;
     TextView tvtitle;
     ImageView img1;
     
	 listview_adapter ( Context context,ArrayList<String> list){
		this.list=list;
		 this.context=context;
		 
	 }
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position) ;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.i("entered","get view");
		// TODO Auto-generated method stub
		View listview=convertView;
		if (listview == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                listview= inflater.inflate(R.layout.listview_format, parent, false);
             }
		img1 =(ImageView) listview.findViewById(R.id.imageView1);
		tvtitle =(TextView) listview.findViewById(R.id.title);
		 String[] content = list.get(position).split("-");
         
         String Title= content[1];
		  String event_type_string =content[2];
         
         tvtitle.setText(Title);
         int _event_type= Integer.parseInt(event_type_string);
         
         switch ( _event_type ) {					
      case 1:
		       img1.setImageResource(R.drawable.khanda_blue);	break;
		case 2:
		       img1.setImageResource(R.drawable.khanda_black);	break;
		case 3:
		       img1.setImageResource(R.drawable.khanda_green);	break;
		case 4:
		       img1.setImageResource(R.drawable.khanda_red);	break;
		case 5:
		       img1.setImageResource(R.drawable.khanda_violet); break;
		case 6:
		       img1.setImageResource(R.drawable.khanda_light_blue); break;

		  
		}
		
		return listview;
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
	}

}
