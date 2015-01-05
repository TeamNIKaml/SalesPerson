package com.energyeye.salesperson;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class PostLoginActivity extends TabActivity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post_login);
		TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);


        
        TabSpec taskTab = tabHost.newTabSpec("Task Tab");
        TabSpec oppertunitiesTab = tabHost.newTabSpec("Oppertunities Tab");
        TabSpec personalSettingTab = tabHost.newTabSpec("PersonalSetting tab");
        
      
       /* View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
        TextView title = (TextView) tabIndicator.findViewById(R.id.title);
        title.setText("Task");

        ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
        icon.setImageResource(R.drawable.task);
        */
        taskTab.setIndicator(addTabImage(R.drawable.task,"task"));
        oppertunitiesTab.setIndicator(addTabImage(R.drawable.oppertunities,"Opppertunities"));
        personalSettingTab.setIndicator(addTabImage(R.drawable.settings,"Personal Settings"));
        
        
        
        
        
       // taskTab.setIndicator("Task");
      
        taskTab.setContent(new Intent(this,Task.class));

       // oppertunitiesTab.setIndicator("Oppertunities");
        oppertunitiesTab.setContent(new Intent(this,Oppertunities.class));
        
      

        //personalSettingTab.setIndicator("PersonalSetting");
        personalSettingTab.setContent(new Intent(this,PersonalSetting.class));
        
        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(taskTab);
        tabHost.addTab(oppertunitiesTab);        
        tabHost.addTab(personalSettingTab);
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
