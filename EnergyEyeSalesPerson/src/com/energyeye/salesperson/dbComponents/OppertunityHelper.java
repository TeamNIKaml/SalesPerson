package com.energyeye.salesperson.dbComponents;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.energyeye.salesperson.properties.Constants;
import com.energyeye.salesperson.properties.OppertunitiesDataSource;

public class OppertunityHelper implements IDBHelper{
	
	private OppertunitiesDataSource dataSource = OppertunitiesDataSource.getOppertunitiesDataSource();
	private DBHelper dbHelper;
	private List<OppertunitiesDataSource> oppertunitieslist = new ArrayList<OppertunitiesDataSource>();	
	
	@Override
	public boolean onCreate() {
		 dbHelper = new DBHelper(dataSource.getContext(), 1, Constants.DB_NAME, Constants.OPPERTUNITIES_CREATE_QUERY);
		  return true;
		
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		new DBTask().execute("insert");
		
		
	}

	@Override
	public void update(String whereClause, String[] whereArgs) {
		// TODO Auto-generated method stub
		dataSource.setWhereClause(whereClause);
		dataSource.setWhereArgs(whereArgs);
		new DBTask().execute("update");
	}

	@Override
	public void delete(String where, String[] args) {
		// TODO Auto-generated method stub
		dataSource.setWhereClause(where);
		dataSource.setWhereArgs(args);
		new DBTask().execute("delete");
		
	}

	@Override
	public void select(String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		dataSource.setWhereArgs(selectionArgs);
		dataSource.setWhereClause(selection);		
		new DBTask().execute("select"); 
		
	}
	
	private class DBTask extends AsyncTask<String,Integer,String>
	{

		@Override
		protected String doInBackground(String... operation) {
			// TODO Auto-generated method stub
			if(operation[0].equalsIgnoreCase("insert"))
			{
				onCreate();
				SQLiteDatabase database = dbHelper.getWritableDatabase();
				 database.insert(Constants.OPPERTUNITIES_TABLE_NAME, null, dataSource.oppertuniiesToContentValues());
				
			}
			else if (operation[0].equalsIgnoreCase("update")) {
				
				onCreate();
				 SQLiteDatabase database = dbHelper.getWritableDatabase();  
				 database.update(Constants.OPPERTUNITIES_TABLE_NAME, dataSource.oppertuniiesToContentValues(), dataSource.getWhereClause(), dataSource.getWhereArgs());
				
			}	
			else if (operation[0].equalsIgnoreCase("delete")) {
				onCreate();
				SQLiteDatabase dataBase=dbHelper.getWritableDatabase();
			     dataBase.delete(Constants.OPPERTUNITIES_TABLE_NAME, dataSource.getWhereClause(),dataSource.getWhereArgs());
				
			}
			else if (operation[0].equalsIgnoreCase("select")) {
				
				onCreate();
				 SQLiteDatabase database = dbHelper.getReadableDatabase();
				  Cursor cursor =database.query(Constants.OPPERTUNITIES_TABLE_NAME, dataSource.getProjection(),
						                        dataSource.getWhereClause(), dataSource.getWhereArgs(), null, null,dataSource.getSortOrder());
				  int count = cursor.getColumnCount();
				  Log.e("count", String.valueOf(count));
				  if(cursor.moveToFirst())
				  {
					  
					  do
					  {				  
						  oppertunitieslist.add(dataSource.cursorToOppertunitiesDataSource(cursor));
					  }while(cursor.moveToNext());
					  
				  }
				  
				  dataSource.setOppertunitieslist(oppertunitieslist);
				
				
			}
			
			else
			{
				Log.e("Invalid db task","invalid dsfsdfasdas");
			}
			
			return null;
		}
		
	}

	
	

}
