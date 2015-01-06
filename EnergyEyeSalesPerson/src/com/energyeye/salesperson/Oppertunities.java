package com.energyeye.salesperson;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;



@SuppressLint("InflateParams")
public class Oppertunities extends Activity
{
	private ListView listView;
	private Button addButton;
	private View v ;
	private LayoutInflater li;
	
	 @Override
		@Deprecated
		protected Dialog onCreateDialog(int id) {
			// TODO Auto-generated method stub
	    	Dialog dlg = null;
	    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    	
	    	 li = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    	 v =li.inflate(R.layout.activity_add_opertunities, null);	   ; 	
	    	 
	    	
	    	dlg = builder.setView(v)
	    			.setPositiveButton("Next", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							
						}
					})
	    			.create();
			return dlg;
		}
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
           setContentView(R.layout.oppertunities);
           
           
           addButton =(Button)findViewById(R.id.addOppertuniites);
           addButton.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(102);
				
			}
		});
           
           
           
           listView = (ListView)findViewById(R.id.myOppertunities);
           OppertunitiesAdaptor oppertunitiesAdaptor = new OppertunitiesAdaptor(this);
           
           for (int i = 1; i < 30; i++) {
   			oppertunitiesAdaptor.addTitle("MyOppertunitiesTitle #" + i);
   			oppertunitiesAdaptor.addendDate("Date #" + i);
   			if (i % 4 == 0) {
   				oppertunitiesAdaptor.addSectionHeaderItem("Section #" + i/4);
   			}
   		}
           
          
           oppertunitiesAdaptor.notifyDataSetChanged();
           listView.setOnItemClickListener(new OnItemClickListener(){


           

           	@Override
           	public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {

           	   // TextView textview1 = (TextView) v.findViewById(R.id.listitem1);
           	   // TextView textview2 = (TextView) v.findViewById(R.id.text2);
           		
           		Test(listView.getItemAtPosition(pos).toString());
           		
           		

           	    //Log.v("textview1",textview1.getText().toString().trim());
           	    //Log.v("textview2",textview2.getText().toString().trim());

           	}



           	});

           
           
         // listView.setAdapter(oppertunitiesAdaptor);
           //listView = new ListView(this);
           listView.setAdapter(oppertunitiesAdaptor);
          //setListAdapter(oppertunitiesAdaptor);
       }
       
       private void Test(Object item)
       {
       	if(item == null)
       		Toast.makeText(this,"item null",Toast.LENGTH_LONG).show();
       	else
       		Toast.makeText(this,item.toString(),Toast.LENGTH_LONG).show();
       }
    
}

