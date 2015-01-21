package com.energyeye.salesperson.properties;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ElectricalCompanyDataSource {

    private String name;
    private Context context;
    private String whereClause;
    private String[] whereArgs;
    private String[] projection;
    private String sortOrder;
    private static ElectricalCompanyDataSource dataSource;
    private List<ElectricalCompanyDataSource> electricalCompanyList = new ArrayList<ElectricalCompanyDataSource>();

    public List<ElectricalCompanyDataSource> getElectricalCompanyList() {
	return electricalCompanyList;
    }

    public void setElectricalCompanyList(
	    List<ElectricalCompanyDataSource> electricalCompanyList) {
	this.electricalCompanyList = electricalCompanyList;
    }

    public static ElectricalCompanyDataSource getElectricalCompanyDataSource() {
	if (dataSource == null)
	    dataSource = new ElectricalCompanyDataSource();
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

    public ContentValues ElectricalCompanyToContentValues() {

	final ContentValues values = new ContentValues();
	values.put("name", getName());

	return values;
    }

    public ElectricalCompanyDataSource cursorToElectricalCompany(Cursor cursor) {
	final ElectricalCompanyDataSource electricalCompanyDataSource = new ElectricalCompanyDataSource();

	electricalCompanyDataSource.setName(cursor.getString(1));

	return electricalCompanyDataSource;

    }

}
