package com.energyeye.salesperson.activityComponents;

import com.energyeye.salesperson.fragments.Oppertunities;
import com.energyeye.salesperson.fragments.PersonalSetting;
import com.energyeye.salesperson.fragments.Task;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {
        case 0:
        	 return new Task();
            
        case 1:
              	return new Oppertunities();
        case 2:
               return new PersonalSetting();
        }
		return null;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3; //No of Tabs
	}


    }
