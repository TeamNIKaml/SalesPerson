package com.energyeye.salesperson.fragments;

import java.util.ArrayList;
import java.util.List;

import com.energyeye.salesperson.R;
import com.energyeye.salesperson.properties.OppertunitiesDataSource;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddOppertunityDialog  extends DialogFragment {
	
	private OppertunitiesDataSource dataSource = OppertunitiesDataSource.getOppertunitiesDataSource();
	private EditText projectTitle,description,contact,designation,address1,address2,county,city;
	private EditText compcode,postcode,dayphone,email,eveningphone,other;	
    private Spinner property_type,module_type,country;
	private List<String> propertyTypeList,moduleTypeList,countryList;
	private ArrayAdapter<String> propertyTypeAdaptor,moduleTypeAdaptor,countryAdaptor;
	
	private LayoutInflater li;
	
	public AddOppertunityDialog(LayoutInflater li) {
		super();
		this.li = li;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		
		
		
  	View v =li.inflate(R.layout.activity_add_opertunities_old, null);	   ; 	
   	 
   	 initDialog(v);
   	setDialogData();
		
		return new AlertDialog.Builder(getActivity()).setView(v)
				// Set Dialog Icon
				//.setIcon(R.drawable.androidhappy)
				// Set Dialog Title
				//.setTitle("Alert DialogFragment")
				// Set Dialog Message
				//.setMessage("Alert DialogFragment Tutorial")
 
				// Positive button
				.setPositiveButton("Next", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						setOppertunityDataSource();
					}

					
				})
 
				// Negative Button
				.create();
	}
	
	
	
	private void setOppertunityDataSource() {
		// TODO Auto-generated method stub
		
		dataSource.setProjectTitle(projectTitle.getText().toString());
		dataSource.setProjectDescription(description.getText().toString());
		dataSource.setContactName(contact.getText().toString());
		dataSource.setDesignation(designation.getText().toString());
		dataSource.setAddress1(address1.getText().toString());
		dataSource.setAddress2(address2.getText().toString());
		dataSource.setCounty(county.getText().toString());
		dataSource.setCity(city.getText().toString());
		dataSource.setCompCode(compcode.getText().toString());
		dataSource.setPostCode(postcode.getText().toString());
		dataSource.setDayPhone(dayphone.getText().toString());
		 dataSource.setEmailId(email.getText().toString());
		 dataSource.setEveningPhone(eveningphone.getText().toString());
		 dataSource.setOther(other.getText().toString());
		 dataSource.setPropertyType(property_type.getSelectedItem().toString());
		 dataSource.setModuleType(module_type.getSelectedItem().toString());
		 dataSource.setCountry(country.getSelectedItem().toString());
		 
		 
		  
		
		
		
	}
	
	

	private void initDialog(View v) {
		// TODO Auto-generated method stub
		 projectTitle =(EditText) v.findViewById(R.id.projectTitle);
		  description =(EditText)v.findViewById(R.id.description);
		  contact =(EditText)v.findViewById(R.id.contact);
		  designation = (EditText)v.findViewById(R.id.designation); 
		  address1 = (EditText) v.findViewById(R.id.address1);
		  address2 = (EditText) v.findViewById(R.id.address2);
		  county = (EditText) v.findViewById(R.id.county);
		  city = (EditText) v.findViewById(R.id.city);
		  compcode = (EditText) v.findViewById(R.id.compcode);
		  postcode = (EditText) v.findViewById(R.id.postcode);
		  dayphone = (EditText) v.findViewById(R.id.dayphone);
		  email = (EditText) v.findViewById(R.id.emailOppertunities);
		  eveningphone = (EditText) v.findViewById(R.id.eveningphone);
		  other =	(EditText) v.findViewById(R.id.other);
		  property_type = (Spinner) v.findViewById(R.id.propertyspinner);
		  module_type = (Spinner) v.findViewById(R.id.modulespinner);
		  country = (Spinner) v.findViewById(R.id.countryspinner);		
		  propertyTypeList = new ArrayList<String>();
		  moduleTypeList = new ArrayList<String>();
		  countryList = new ArrayList<String>();
	}
	
	
	 private void setDialogData() {
			// TODO Auto-generated method stub
	    	 if(dataSource.getProjectTitle() != null)
	    	 {
			 projectTitle.setText(dataSource.getProjectTitle());
			  description.setText(dataSource.getDesignation());
			  contact.setText(dataSource.getContactName());
			  designation.setText(dataSource.getDesignation());
			  address1.setText(dataSource.getAddress1());
			  address2.setText(dataSource.getAddress2());
			  county.setText(dataSource.getCounty());
			  city.setText(dataSource.getCity());
			  compcode.setText(dataSource.getCompCode());
			  postcode.setText(dataSource.getPostCode());
			  dayphone.setText(dataSource.getDayPhone());
			  email.setText(dataSource.getEmailId());
			  eveningphone.setText(dataSource.getEveningPhone());
			  other.setText(dataSource.getOther());
			 propertyTypeList.add(dataSource.getPropertyType());
			  moduleTypeList.add(dataSource.getModuleType());
			  countryList.add(dataSource.getCountry());
			  propertyTypeAdaptor = new ArrayAdapter<String>(getActivity().getApplicationContext(),
					  R.layout.spinnertext, propertyTypeList);
			  moduleTypeAdaptor = new ArrayAdapter<String>(getActivity().getApplicationContext(),
			            R.layout.spinnertext, moduleTypeList);
			  countryAdaptor = new ArrayAdapter<String>(getActivity().getApplicationContext(),
					  R.layout.spinnertext, countryList);
			 property_type.setAdapter(propertyTypeAdaptor);
			  module_type.setAdapter(moduleTypeAdaptor);
			 country.setAdapter(countryAdaptor);
	    	 }
	    	 else
	    	 {
	    		 Log.e("Null set dailog", "#dsfsfsdfsdf");
	    	 }
			
		}
	
		
	
}
