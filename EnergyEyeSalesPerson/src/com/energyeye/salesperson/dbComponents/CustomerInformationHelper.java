package com.energyeye.salesperson.dbComponents;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.energyeye.salesperson.properties.Constants;
import com.energyeye.salesperson.properties.CustomerInformationDataSource;

public class CustomerInformationHelper implements IDBHelper {

    private final CustomerInformationDataSource dataSource = CustomerInformationDataSource
	    .getCustomerInformationDataSource();

    private DBHelper dbHelper;

    private final List<CustomerInformationDataSource> customerInformationList = new ArrayList<CustomerInformationDataSource>();

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
		Constants.CUSTOMER_INFORMATION_CREATE_QUERY);
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
		database.insert(Constants.CUSTOMER_INFOEMATION_TABLE_NAME,
			null,
			dataSource.customerInformationListToContentValue());

	    } else if (operation[0].equalsIgnoreCase("update")) {

		onCreate();
		final SQLiteDatabase database = dbHelper.getWritableDatabase();
		database.update(Constants.CUSTOMER_INFOEMATION_TABLE_NAME,
			dataSource.customerInformationListToContentValue(),
			dataSource.getWhereClause(), dataSource.getWhereArgs());

	    } else if (operation[0].equalsIgnoreCase("delete")) {
		onCreate();
		final SQLiteDatabase dataBase = dbHelper.getWritableDatabase();
		dataBase.delete(Constants.CUSTOMER_INFOEMATION_TABLE_NAME,
			dataSource.getWhereClause(), dataSource.getWhereArgs());

	    } else if (operation[0].equalsIgnoreCase("select")) {

		onCreate();
		final SQLiteDatabase database = dbHelper.getReadableDatabase();
		final Cursor cursor = database.query(
			Constants.CUSTOMER_INFOEMATION_TABLE_NAME,
			dataSource.getProjection(),
			dataSource.getWhereClause(), dataSource.getWhereArgs(),
			null, null, dataSource.getSortOrder());
		final int count = cursor.getColumnCount();
		Log.e("count", String.valueOf(count));
		if (cursor.moveToFirst()) {

		    do {
			customerInformationList.add(dataSource
				.cursorToCustomerInformationList(cursor));
		    } while (cursor.moveToNext());

		}

		dataSource.setCustomerInformationList(customerInformationList);

	    }

	    else {
		Log.e("Invalid db task", "invalid dsfsdfasdas");
	    }

	    return null;
	}

    }

}
