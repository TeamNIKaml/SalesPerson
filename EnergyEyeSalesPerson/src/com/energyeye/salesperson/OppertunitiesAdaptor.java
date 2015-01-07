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
		return title.get(index)+"#"+endDate.get(index);
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
			switch (rowType) {
			case TYPE_ITEM:
				convertView = mInflater.inflate(android.R.layout.simple_list_item_2,null);
				holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
				holder.textView1 = (TextView) convertView.findViewById(android.R.id.text2);
				holder.textView.setTextColor(Color.BLACK);
				
				break;
			case TYPE_SEPARATOR:
				convertView = mInflater.inflate(android.R.layout.simple_list_item_1,null);
				convertView.setClickable(false);
				
				holder.textView = (TextView) convertView.findViewById(android.R.id.text1);
				holder.textView.setGravity(Gravity.CENTER);
				holder.textView.setTextColor(Color.BLUE);
				break;
			}
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.textView.setText(title.get(position));
		holder.textView1.setText(endDate.get(position));

		return convertView;
	}
	
	public static class ViewHolder {
		public TextView textView,textView1;
	}

}