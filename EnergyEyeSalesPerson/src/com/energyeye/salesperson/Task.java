package com.energyeye.salesperson;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;



public class Task extends Activity {
	
	private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    	
        super.onCreate(savedInstanceState);
       setContentView(R.layout.task);
       listView = (ListView)findViewById(R.id.myTask);
        
       TaskAdapter taskAdaptor = new TaskAdapter(this);
        
        for (int i = 1; i < 30; i++) {
			taskAdaptor.addTitle("TaskTitle #" + i);
			taskAdaptor.addendDate("Date #" + i);
			if (i % 4 == 0) {
				taskAdaptor.addSectionHeaderItem("Section #" + i/4);
			}
		}
        
       
        taskAdaptor.notifyDataSetChanged();
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

        
        
      // listView.setAdapter(taskAdaptor);
        //listView = new ListView(this);
        listView.setAdapter(taskAdaptor);
       //setListAdapter(taskAdaptor);
    }
    
    private void Test(Object item)
    {
    	if(item == null)
    		Toast.makeText(this,"item null",Toast.LENGTH_LONG).show();
    	else
    		Toast.makeText(this,item.toString(),Toast.LENGTH_LONG).show();
    }
}
