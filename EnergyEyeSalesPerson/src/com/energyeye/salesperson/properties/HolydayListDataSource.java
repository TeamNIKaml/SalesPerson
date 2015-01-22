package com.energyeye.salesperson.properties;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class HolydayListDataSource {

    private String name;
    private Context context;
    private String whereClause;
    private String[] whereArgs;
    private String[] projection;
    private String sortOrder;
    private static HolydayListDataSource dataSource;
    private List<HolydayListDataSource> holydayList = new ArrayList<HolydayListDataSource>();

   



    public List<HolydayListDataSource> getHolydayList() {
        return holydayList;
    }



    public void setHolydayList(List<HolydayListDataSource> holydayList) {
        this.holydayList = holydayList;
    }



    public static HolydayListDataSource getHolydayListDataSource() {
	if (dataSource == null)
	    dataSource = new HolydayListDataSource();
	return dataSource;
    }

  

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Context getContext() {
	return context;
    }

    public void setContext(Context context) {
	this.context = context;
    }

    public String getWhereClause() {
	return whereClause;
    }

    public void setWhereClause(String whereClause) {
	this.whereClause = whereClause;
    }

    public String[] getWhereArgs() {
	return whereArgs;
    }

    public void setWhereArgs(String[] whereArgs) {
	this.whereArgs = whereArgs;
    }

    public String[] getProjection() {
	return projection;
    }

    public void setProjection(String[] projection) {
	this.projection = projection;
    }

    public String getSortOrder() {
	return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
	this.sortOrder = sortOrder;
    }

    public ContentValues holidayToContentValues() {

	final ContentValues values = new ContentValues();
	values.put("name", getName());

	return values;
    }

    public HolydayListDataSource cursorToHoliday(Cursor cursor) {
	final HolydayListDataSource holydayListDataSource = new HolydayListDataSource();

	holydayListDataSource.setName(cursor.getString(1));

	return holydayListDataSource;

    }

}
