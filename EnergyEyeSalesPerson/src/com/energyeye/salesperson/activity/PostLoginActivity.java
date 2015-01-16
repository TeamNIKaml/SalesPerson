package com.energyeye.salesperson.activity;




import com.energyeye.salesperson.R;
import com.energyeye.salesperson.activityComponents.TabPagerAdapter;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class PostLoginActivity  extends FragmentActivity {
	private SharedPreferences pref;
	private Editor editor;
	private ViewPager Tab;
	private TabPagerAdapter TabAdapter;
	private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login);
        
      //  ActionBar actionBar1 = getActionBar();
		//actionBar1.hide();
        
        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        
        Tab = (ViewPager)findViewById(R.id.pager);
        Tab.setBackground(getResources().getDrawable(R.drawable.login_btn_bg));
        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                       
                    	actionBar = getActionBar();
                    	actionBar.setSelectedNavigationItem(position);                    }
                });
        Tab.setAdapter(TabAdapter);
        
        actionBar = getActionBar();
        //Enable Tabs on Action Bar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener(){

			@Override
			public void onTabReselected(android.app.ActionBar.Tab tab,
					FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			 public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
	          
	            Tab.setCurrentItem(tab.getPosition());
	        }

			@Override
			public void onTabUnselected(android.app.ActionBar.Tab tab,
					FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}};
			//Add New Tab
			//actionBar.setBackgroundDrawable(arg0)
			android.app.ActionBar.Tab task = actionBar.newTab();
			task.setIcon(R.drawable.task_normal);
			//task.set
			task.setTabListener(tabListener);
			
			
			android.app.ActionBar.Tab oppertunities = actionBar.newTab();
			oppertunities.setIcon(R.drawable.oppertunity_normal);
			oppertunities.setTabListener(tabListener);
			
			android.app.ActionBar.Tab settings = actionBar.newTab();
			settings.setIcon(R.drawable.profile_normal);
			settings.setTabListener(tabListener);
			
			
			actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_btn_bg));
			
			//actionBar.setCustomView(arg0);
			
			actionBar.addTab(task);
			actionBar.addTab(oppertunities);
			actionBar.addTab(settings);
			
		//	actionBar.addTab(actionBar.newTab().setText("Task").setTabListener(tabListener));
		//	actionBar.addTab(actionBar.newTab().setText("Oppertunities").setTabListener(tabListener));
		//	actionBar.addTab(actionBar.newTab().setText("Personal Settings").setTabListener(tabListener));

    }

    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.postlogin, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		writeSharedPreference();	
		  finish();
		
			return super.onOptionsItemSelected(item);
		
	}
	
	private void writeSharedPreference() {
		// TODO Auto-generated method stub
		
		pref = getApplicationContext().getSharedPreferences(
				"localdiskchildlocator", 0);
		editor = pref.edit();
		Log.e("writeToSharedPreferences Logout", "localdiskchildlocator");
		//editor.putString("userKey", user.getUserKey());
		//editor.putString("emailID", user.getEmailId());
		//editor.putString("password", user.getPassword());
		editor.putInt("loginstatus", 0);		
		editor.commit();	
		
	}



    
}
