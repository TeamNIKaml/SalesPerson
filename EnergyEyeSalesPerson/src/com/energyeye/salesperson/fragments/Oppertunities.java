package com.energyeye.salesperson.fragments;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.energyeye.salesperson.R;
import com.energyeye.salesperson.activityComponents.OppertunitiesAdaptorEList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;




@SuppressLint("InflateParams")
public class Oppertunities extends Fragment {
	
	private OppertunitiesAdaptorEList listAdapter;
	private ExpandableListView expListView;
	private List<String> projectTitle;
	private HashMap<String, List<String>> status;
	private HashMap<String, List<String>> date;
	private Button addOppertunitiesButton;
	private LayoutInflater li;
	
	

	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
		 
		 	 li = inflater;
	 
	        View oppertunityView = inflater.inflate(R.layout.oppertunities_frag, container, false);
	        init(oppertunityView);
	        setListner();
	        
	        
	         return oppertunityView;
}
	 
	 
	 private void setListner() {
		// TODO Auto-generated method stub
		 expListView.setOnGroupClickListener(new OnGroupClickListener() {

				@Override
				public boolean onGroupClick(ExpandableListView parent, View v,
						int groupPosition, long id) {
					// Toast.makeText(getApplicationContext(),
					// "Group Clicked " + listDataHeader.get(groupPosition),
					// Toast.LENGTH_SHORT).show();
					return false;
				}
			});

			// Listview Group expanded listener
			expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

				@Override
				public void onGroupExpand(int groupPosition) {
					Toast.makeText(getActivity().getApplicationContext(),
							projectTitle.get(groupPosition) + " Expanded",
							Toast.LENGTH_SHORT).show();
				}
			});

			// Listview Group collasped listener
			expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

				@Override
				public void onGroupCollapse(int groupPosition) {
					Toast.makeText(getActivity().getApplicationContext(),
							projectTitle.get(groupPosition) + " Collapsed",
							Toast.LENGTH_SHORT).show();

				}
			});

			// Listview on child click listener
			expListView.setOnChildClickListener(new OnChildClickListener() {

				@Override
				public boolean onChildClick(ExpandableListView parent, View v,
						int groupPosition, int childPosition, long id) {
					// TODO Auto-generated method stub
					Toast.makeText(
							getActivity().getApplicationContext(),
							projectTitle.get(groupPosition)
									+ " : "
									+ status.get(
											projectTitle.get(groupPosition)).get(
											childPosition), Toast.LENGTH_SHORT)
							.show();
					return false;
				}
			});
			
			addOppertunitiesButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					AddOppertunityDialog dialog = new AddOppertunityDialog(li);
					dialog.show(getChildFragmentManager(), "AddOppertunity");
					
					
				}
			});
	}


	private void init(View v) {
		 expListView = (ExpandableListView) v.findViewById(R.id.oppertunitiesList);			
		addOppertunitiesButton =(Button)v.findViewById(R.id.addButton);
		prepareListData();
			listAdapter = new OppertunitiesAdaptorEList(getActivity().getApplicationContext(), 
					projectTitle, status,date);
			expListView.setAdapter(listAdapter);
			
		
	}


	private void prepareListData() {
		projectTitle = new ArrayList<String>();
		status = new HashMap<String, List<String>>();
		date = new HashMap<String, List<String>>();

			// Adding child data
			projectTitle.add("Top 250");
			projectTitle.add("Now Showing");
			projectTitle.add("Coming Soon..");
			
			
			List<String> dateList = new ArrayList<String>();
			dateList.add("date1");
			dateList.add("date2");
			dateList.add("date3");
			dateList.add("date4");
			dateList.add("date5");
			dateList.add("date6");
			dateList.add("date7");

			// Adding child data
			List<String> top250 = new ArrayList<String>();
			top250.add("The Shawshank Redemption");
			top250.add("The Godfather");
			top250.add("The Godfather: Part II");
			top250.add("Pulp Fiction");
			top250.add("The Good, the Bad and the Ugly");
			top250.add("The Dark Knight");
			top250.add("12 Angry Men");

			List<String> nowShowing = new ArrayList<String>();
			nowShowing.add("The Conjuring");
			nowShowing.add("Despicable Me 2");
			nowShowing.add("Turbo");
			nowShowing.add("Grown Ups 2");
			nowShowing.add("Red 2");
			nowShowing.add("The Wolverine");
			nowShowing.add("X men");

			List<String> comingSoon = new ArrayList<String>();
			comingSoon.add("2 Guns");
			comingSoon.add("The Smurfs 2");
			comingSoon.add("The Spectacular Now");
			comingSoon.add("The Canyons");
			comingSoon.add("Europa Report");
			comingSoon.add("Avengers");
			comingSoon.add("Game of thrones 6");

			status.put(projectTitle.get(0), top250); // Header, Child data
			status.put(projectTitle.get(1), nowShowing);
			status.put(projectTitle.get(2), comingSoon);
			
			
			date.put(projectTitle.get(0), dateList); // Header, Child data
			date.put(projectTitle.get(1), dateList);
			date.put(projectTitle.get(2), dateList);
		}

	
	

	
	
	
    
}

