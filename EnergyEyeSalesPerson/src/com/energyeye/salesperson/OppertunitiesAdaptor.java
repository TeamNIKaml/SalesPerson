package com.energyeye.salesperson;

import java.util.ArrayList;
import java.util.TreeSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



@SuppressLint("InflateParams")
public class OppertunitiesAdaptor extends BaseAdapter {

	
	private static final int TYPE_ITEM = 0;
	private static final int TYPE_SEPARATOR = 1;
	private Context context;
	private ArrayList<String> title = new ArrayList<String>();
	private ArrayList<String> endDate = new ArrayList<String>();
	private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();
	private ArrayList<String> status = new ArrayList<String>();
	
	
	public void addStatus(String item) {
		status.add(item);
		notifyDataSetChanged();
	}
	
	
	public void addendDate(String item) {
		endDate.add(item);
		notifyDataSetChanged();
	}
	
	
	
	public void addTitle(String item) {
		title.add(item);
		notifyDataSetChanged();
	}

	public void addSectionHeaderItem(String item) {
		title.add(item);
		endDate.add("");
		sectionHeader.add(title.size() - 1);
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
		// TODO Auto-generated method stub
		//return countries[index];
		if(title.get(index) != null)
		Log.e("gget item", title.get(index)+"#"+endDate.get(index));
		else
			Log.e("gget item", "Null");
		return title.get(index)+"#"+endDate.get(index)+"#"+status.get(index);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		//return countries[position].hashCode();
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		 LayoutInflater mInflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		ViewHolder holder = null;
		int rowType = getItemViewType(position);
		
		
		if (convertView == null) {
			holder = new ViewHolder();
			
				convertView = mInflater.inflate(R.layout.my_oppertunities,null);
				holder.titleTextView = (TextView) convertView.findViewById(R.id.myOppertunity_title);
				holder.statusTextView = (TextView) convertView.findViewById(R.id.myOppertunity_status);
				holder.dateTextView = (TextView) convertView.findViewById(R.id.myOppertunity_date);
				
				
			
				
				
			
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.titleTextView.setText(title.get(position));
		holder.dateTextView.setText(endDate.get(position));
		holder.statusTextView.setText(status.get(position));

		return convertView;
	}
	
	public static class ViewHolder {
		public TextView titleTextView,statusTextView,dateTextView;
	}

}