package com.energyeye.salesperson.activityComponents;

import java.util.ArrayList;

import com.energyeye.salesperson.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



@SuppressLint("InflateParams")
public class OppertunitiesAdaptor extends BaseAdapter {

	
	
	private Context context;
	private ArrayList<String> title = new ArrayList<String>();
	private ArrayList<String> endDate = new ArrayList<String>();
	private ArrayList<String> status = new ArrayList<String>();
	private TextView titleTextView,statusTextView,dateTextView;
	
	
	public void addStatus(String item) {
		Log.e("addStatus", "addStatus");
		status.add(item);
		notifyDataSetChanged();
	}
	
	
	public void addendDate(String item) {
		Log.e("addendDate", "addendDate");

		endDate.add(item);
		notifyDataSetChanged();
	}
	
	
	
	public void addTitle(String item) {
		
		Log.e("addTitle", "addTitle");
		title.add(item);
		notifyDataSetChanged();
	}

	
	
	public OppertunitiesAdaptor(Context ctx) {
		context = ctx;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		//return countries.length;
		return title.size();
	}

	@Override
	public Object getItem(int index) {
		
		if(title.get(index) != null)
		Log.e("gget item", title.get(index)+"#"+endDate.get(index));
		else
			Log.e("gget item", "Null");
		return title.get(index)+"#"+endDate.get(index)+"#"+status.get(index);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		 LayoutInflater mInflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		
		
		
		if (convertView == null) {
		
			
				convertView = mInflater.inflate(R.layout.list_item_oppertunities,null);
				//titleTextView = (TextView) convertView.findViewById(R.id.myOppertunity_title);
				statusTextView = (TextView) convertView.findViewById(R.id.myOppertunity_status);
				dateTextView = (TextView) convertView.findViewById(R.id.myOppertunity_date);
		} 
				
		if(title.get(position)!= null)
		{
			titleTextView.setText(title.get(position));
			dateTextView.setText(endDate.get(position));
			statusTextView.setText(status.get(position));
		}
		return convertView;
	}
	
	
}