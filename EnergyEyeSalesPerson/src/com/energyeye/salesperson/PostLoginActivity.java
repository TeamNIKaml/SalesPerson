package com.energyeye.salesperson;


import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class PostLoginActivity extends TabActivity  {
	
	private SharedPreferences pref;
	private Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_login);
		
		pref = getApplicationContext().getSharedPreferences(
				"localdiskchildlocator", 0);
		editor = pref.edit();
		
		
		TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);


        
        TabSpec taskTab = tabHost.newTabSpec("Task Tab");
        TabSpec oppertunitiesTab = tabHost.newTabSpec("Oppertunities Tab");
        TabSpec personalSettingTab = tabHost.newTabSpec("PersonalSetting tab");
        
      
     
        taskTab.setIndicator(addTabImage(R.drawable.task,"task"));
        oppertunitiesTab.setIndicator(addTabImage(R.drawable.oppertunities,"Opppertunities"));
        personalSettingTab.setIndicator(addTabImage(R.drawable.settings,"Personal Settings"));      
        
        
        
    
      
        taskTab.setContent(new Intent(this,Task.class));

      
        oppertunitiesTab.setContent(new Intent(this,Oppertunities.class));
        
      

       
        personalSettingTab.setContent(new Intent(this,PersonalSetting.class));
        
        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(taskTab);
        tabHost.addTab(oppertunitiesTab);        
        tabHost.addTab(personalSettingTab);
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.postlogin, menu);
		return super.onCreateOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Log.e("Logoutdszfs","Logoutfcsdafs");
		editor.putInt("loginstatus", 5);
		editor.putString("userKey","");
		editor.putString("emailID", "");
		editor.putString("password", "");
		editor.commit();
		//finishFromChild(getParent());
		finish();
		return super.onOptionsItemSelected(item);
	}


	private View addTabImage(int imageid,String label)
	{
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
        TextView title = (TextView) tabIndicator.findViewById(R.id.title);
        title.setText(label);

        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
        icon.setImageResource(imageid);
        return tabIndicator;
		
	}
	
	
	
}
