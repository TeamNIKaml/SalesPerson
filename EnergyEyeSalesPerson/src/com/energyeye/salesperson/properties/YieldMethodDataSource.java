package com.energyeye.salesperson.properties;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class YieldMethodDataSource {

    private String name;
    private Context context;
    private String whereClause;
    private String[] whereArgs;
    private String[] projection;
    private String sortOrder;
    private static YieldMethodDataSource dataSource;
    private  List<YieldMethodDataSource>  yieldMethodList = new ArrayList<YieldMethodDataSource>();

   

    public List<YieldMethodDataSource> getYieldMethodList() {
        return yieldMethodList;
    }

    public void setYieldMethodList(List<YieldMethodDataSource> yieldMethodList) {
        this.yieldMethodList = yieldMethodList;
    }

    public static YieldMethodDataSource getPropertyTypeDataSource() {
	if (dataSource == null)
	    dataSource = new YieldMethodDataSource();
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

    public ContentValues  yieldMethodToContentValues() {

	final ContentValues values = new ContentValues();
	values.put("name", getName());

	return values;
    }

    public YieldMethodDataSource cursorToYieldMethod(Cursor cursor) {
	final YieldMethodDataSource yieldMethodDataSource = new YieldMethodDataSource();

	yieldMethodDataSource.setName(cursor.getString(1));

	return yieldMethodDataSource;

    }

}
