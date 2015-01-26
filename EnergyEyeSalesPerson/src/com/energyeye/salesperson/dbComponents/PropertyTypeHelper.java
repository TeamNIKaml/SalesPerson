package com.energyeye.salesperson.dbComponents;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.energyeye.salesperson.properties.Constants;
import com.energyeye.salesperson.properties.PropertyTypeDataSource;

public class PropertyTypeHelper implements IDBHelper {

    private final PropertyTypeDataSource dataSource = PropertyTypeDataSource
	    .getPropertyTypeDataSource();
    private DBHelper dbHelper;

    private final List<PropertyTypeDataSource> propertyList = new ArrayList<PropertyTypeDataSource>();

    @Override
    public void delete(String where, String[] args) {
	// TODO Auto-generated method stub
	dataSource.setWhereClause(where);
	dataSource.setWhereArgs(args);
	new DBTask().execute("delete");

    }

    @Override
    public void insert() {
	// TODO Auto-generated method stub
	new DBTask().execute("insert");

    }

    @Override
    public boolean onCreate() {
	dbHelper = new DBHelper(dataSource.getContext(), 1, Constants.DB_NAME,
		Constants.PROPERTY_TYPE_CREATE_QUERY);
	return true;

    }

    @Override
    public void select(String[] projection, String selection,
	    String[] selectionArgs, String sortOrder) {
	// TODO Auto-generated method stub
	dataSource.setWhereArgs(selectionArgs);
	dataSource.setWhereClause(selection);
	new DBTask().execute("select");

    }

    @Override
    public void update(String whereClause, String[] whereArgs) {
	// TODO Auto-generated method stub
	dataSource.setWhereClause(whereClause);
	dataSource.setWhereArgs(whereArgs);
	new DBTask().execute("update");
    }

    private class DBTask extends AsyncTask<String, Integer, String> {

	@Override
	protected String doInBackground(String... operation) {
	    // TODO Auto-generated method stub
	    if (operation[0].equalsIgnoreCase("insert")) {
		onCreate();
		final SQLiteDatabase database = dbHelper.getWritableDatabase();
		database.insert(Constants.PROPERTY_TYPE_TABLE_NAME, null,
			dataSource.propertyTypeToContentValues());

	    } else if (operation[0].equalsIgnoreCase("update")) {

		onCreate();
		final SQLiteDatabase database = dbHelper.getWritableDatabase();
		database.update(Constants.PROPERTY_TYPE_TABLE_NAME,
			dataSource.propertyTypeToContentValues(),
			dataSource.getWhereClause(), dataSource.getWhereArgs());

	    } else if (operation[0].equalsIgnoreCase("delete")) {
		onCreate();
		final SQLiteDatabase dataBase = dbHelper.getWritableDatabase();
		dataBase.delete(Constants.PROPERTY_TYPE_TABLE_NAME,
			dataSource.getWhereClause(), dataSource.getWhereArgs());

	    } else if (operation[0].equalsIgnoreCase("select")) {

		onCreate();
		final SQLiteDatabase database = dbHelper.getReadableDatabase();
		final Cursor cursor = database.query(
			Constants.PROPERTY_TYPE_TABLE_NAME,
			dataSource.getProjection(),
			dataSource.getWhereClause(), dataSource.getWhereArgs(),
			null, null, dataSource.getSortOrder());
		final int count = cursor.getColumnCount();
		Log.e("count", String.valueOf(count));
		if (cursor.moveToFirst()) {

		    do {
			propertyList.add(dataSource
				.cursorToPropertyType(cursor));
		    } while (cursor.moveToNext());

		}

		dataSource.setPropertyTypeList(propertyList);

	    }

	    else {
		Log.e("Invalid db task", "invalid dsfsdfasdas");
	    }
	    
	    dbHelper.close();

	    return null;
	}

    }

}
