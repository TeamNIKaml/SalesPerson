package com.energyeye.salesperson.activity;

import java.util.ArrayList;
import java.util.List;

import com.energyeye.salesperson.R;
import com.energyeye.salesperson.dbComponents.CustomerInformationHelper;
import com.energyeye.salesperson.dbComponents.IDBHelper;
import com.energyeye.salesperson.dbComponents.OppertunityHelper;
import com.energyeye.salesperson.dbComponents.PropertyTypeHelper;
import com.energyeye.salesperson.properties.CustomerInformationDataSource;
import com.energyeye.salesperson.properties.OppertunitiesDataSource;
import com.energyeye.salesperson.properties.PropertyTypeDataSource;
import com.energyeye.salesperson.webservice.AddOppertunityService;
import com.energyeye.salesperson.webservice.CustomerInformationService;
import com.energyeye.salesperson.webservice.MyOppertunitiesService;
import com.energyeye.salesperson.webservice.TaskService;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class TestActivity extends Activity {

    private Button insert, update, delete, select;
    private EditText projectTitle, description, contact, designation, address1,
	    address2, county, city;
    private EditText compcode, postcode, dayphone, email, eveningphone, other;
    private Spinner property_type, module_type, country;
    private View v;
    private List<String> propertyTypeList, moduleTypeList, countryList;
    private ArrayAdapter<String> propertyTypeAdaptor, moduleTypeAdaptor,
	    countryAdaptor;
     private final IDBHelper helper = new PropertyTypeHelper();
     private final  PropertyTypeDataSource dataSource = PropertyTypeDataSource.
	     		getPropertyTypeDataSource();

  
  /*  @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
	// TODO Auto-generated method stub
	Dialog dlg = null;
	AlertDialog.Builder builder = new AlertDialog.Builder(this);

	LayoutInflater li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	v = li.inflate(R.layout.activity_add_opertunities_old, null);
	initDialog(v);
	setDialogData();

	dlg = builder.setView(v)
		.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

		    @Override
		    public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub

		    }
		}).create();
	return dlg;
    }

    private void setDialogData() {
	// TODO Auto-generated method stub
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

	propertyTypeAdaptor = new ArrayAdapter<String>(getApplicationContext(),
		R.layout.spinnertext);
	moduleTypeAdaptor = new ArrayAdapter<String>(getApplicationContext(),
		R.layout.spinnertext, moduleTypeList);
	countryAdaptor = new ArrayAdapter<String>(getApplicationContext(),
		R.layout.spinnertext, countryList);

	property_type.setAdapter(propertyTypeAdaptor);
	module_type.setAdapter(moduleTypeAdaptor);
	country.setAdapter(countryAdaptor);

    }

    private void initDialog(View v) {
	// TODO Auto-generated method stub
	projectTitle = (EditText) v.findViewById(R.id.projectTitle);
	description = (EditText) v.findViewById(R.id.description);
	contact = (EditText) v.findViewById(R.id.contact);
	designation = (EditText) v.findViewById(R.id.designation);
	address1 = (EditText) v.findViewById(R.id.address1);
	address2 = (EditText) v.findViewById(R.id.address2);
	county = (EditText) v.findViewById(R.id.county);
	city = (EditText) v.findViewById(R.id.city);
	compcode = (EditText) v.findViewById(R.id.compcode);
	postcode = (EditText) v.findViewById(R.id.postcode);
	dayphone = (EditText) v.findViewById(R.id.dayphone);
	email = (EditText) v.findViewById(R.id.emailOppertunities);
	eveningphone = (EditText) v.findViewById(R.id.eveningphone);
	other = (EditText) v.findViewById(R.id.other);
	property_type = (Spinner) v.findViewById(R.id.propertyspinner);
	module_type = (Spinner) v.findViewById(R.id.modulespinner);
	country = (Spinner) v.findViewById(R.id.countryspinner);
	propertyTypeList = new ArrayList<String>();
	moduleTypeList = new ArrayList<String>();
	countryList = new ArrayList<String>();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_test);
	// final ActionBar actionBar = getActionBar();
	// actionBar.hide();

	// final MyOppertunitiesService myService = new
	// MyOppertunitiesService(this);
	// myService.getMyOpperTunities();
	// final TaskService service = new TaskService(this);
	// service.getTask();
	//final AddOppertunityService addOppertunityService = new AddOppertunityService(this);
	//addOppertunityService.addOpperTunities();
	//final CustomerInformationService informationService = new CustomerInformationService(this);
	//informationService.addCutomerInformation();

	// Intent intent = new Intent(this,SignatureActivity.class);
	// startActivity(intent);

	
	  insert =(Button) findViewById(R.id.insert); update =(Button)
	  findViewById(R.id.update); delete =(Button)
	 findViewById(R.id.delete); select =(Button)
	  findViewById(R.id.select);
	 
	
	//  dataSource = OppertunitiesDataSource.getOppertunitiesDataSource();
	// dataSource.setContext(this); setOpppertunities("1");
	 
	 insert.setOnClickListener(new OnClickListener() {
	 
	  @Override public void onClick(View arg0) {
	      // TODO Auto-generated method stub
	      dataSource.setContext(getApplicationContext());
	      setPropertyType();
	     // setCustInfo();
	      helper.insert();
	 
	 }

	

	 });
	 
	 update.setOnClickListener(new OnClickListener() {
	     
	  
	  @Override public void onClick(View arg0) {
	      dataSource.setContext(getApplicationContext());// TODO Auto-generated  method stub
	      final String where ="_id = ?"; final String args[] =new
	  String[1]; args[0] = "1";
	 // dataSource.setProjectTitle("EnergyEye");
	//dataSource.setMpan("MPan updated");

	  helper.update(null, null);
	  
	  
	  } });
	 
	 delete.setOnClickListener(new OnClickListener() {
	     
	  
	  @Override public void onClick(View arg0) {
	      dataSource.setContext(getApplicationContext());
	      
	      final String where ="_id = ?"; final String args[] =new
			  String[1]; args[0] = "1";
	  helper.delete(null, null);
	  
	  } });
	  
	  select.setOnClickListener(new OnClickListener() {
	  
	 
	  
	  @Override public void onClick(View arg0) {
	      // TODO Auto-generated	  method stub
	      dataSource.setContext(getApplicationContext());
	  final List<PropertyTypeDataSource> propertyList;
	 
	  helper.select(null, null, null,null);
	//  dataSource.getCustomerInformationList() ;
	  propertyList =dataSource.getPropertyTypeList();
	 // printCustomerInfo(customerInfoList);
	  printPropertytypeList(propertyList);
	  
	  
	  }

	

	
	  
	  
	  });
	

    }
    
    
    
    private void setPropertyType() {
	    // TODO Auto-generated method stub
	    dataSource.setName("Name");
	}
    
    private void printPropertytypeList(
		List<PropertyTypeDataSource> propertyList) {
	    // TODO Auto-generated method stub
	int count =   propertyList.size();
	for(final PropertyTypeDataSource cDataSource :      propertyList)
	System.out.println("custinfolist"+String.valueOf(count--)+cDataSource);
	    
	}
    
    
  /*  private void setCustInfo() {
	    // TODO Auto-generated method stub
	
	dataSource.setMpan("MPan");
	dataSource.setSupplier("Supplier");
	dataSource.setDnoCompany("DnoCompany");
	dataSource.setElectricityRate("ElectricityRate");
	dataSource.setRoiMethod("Roi Method");
	dataSource.setMonitorInstallation("SetMonitorInstallation");
	dataSource.setShowCustomerContribution("ShowCustomerContribution");
	dataSource.setRoofType("RoofType");
	dataSource.setMeterReadinfForFit("MeterReadingType");
	dataSource.setYieldMethod("YieldMethod");
	dataSource.setProjectImplementationtype("ProjectImplementationType");
	dataSource.setOther("Other");
	    
	}*/
    
    
   /* private void printCustomerInfo(
		List<CustomerInformationDataSource> customerInfoList) {
	    // TODO Auto-generated method stub
	
	
	int count =   customerInfoList.size();
	for(final CustomerInformationDataSource cDataSource :      customerInfoList)
	System.out.println("custinfolist"+String.valueOf(count--)+cDataSource);
	    
	}*/

    /*
      private void printOppertunityList(List<OppertunitiesDataSource>
      oppertunitylist) { // TODO Auto-generated method stub int count =
      oppertunitylist.size(); for(OppertunitiesDataSource oppertunities :
      oppertunitylist) { Log.e("Oppertunities " +
      String.valueOf(count--),oppertunities.toString()); }
      
      
      
      
      }
      
      
      private void setOpppertunities(String i) { // TODO Auto-generated method
      stub
      
      dataSource.setProjectTitle("Project title"+i);
      dataSource.setProjectDescription("Project Description"+i);
      dataSource.setPropertyType("Propertytype"+i);
      dataSource.setModuleType("Module type"+i);
      dataSource.setCompCode("Compcode"+i);
      dataSource.setContactName("Contact Name"+i);
      dataSource.setDesignation("Designation"+i);
      dataSource.setAddress1("Address 1"+i);
      dataSource.setAddress2("Address 2+i"); dataSource.setCity("City"+i);
      dataSource.setCounty("County"+i); dataSource.setCountry("Country"+i);
      dataSource.setPostCode("Post Code"+i);
      dataSource.setEmailId("Email id"+i);
      dataSource.setDayPhone("Day phone"+i);
      dataSource.setEveningPhone("Evening phone"+i);
      dataSource.setOther("Other"+i); dataSource.setOther("Status"+i);
      
      }
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.test, menu);
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	final int id = item.getItemId();
	if (id == R.id.action_settings) {
	    return true;
	}
	return super.onOptionsItemSelected(item);
    }
}
