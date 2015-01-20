package com.energyeye.salesperson.properties;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class RoofTypeDataSource{

    private String name;
    private Context context;
    private String whereClause;
    private String[] whereArgs;
    private String[] projection;
    private String sortOrder;
    private static RoofTypeDataSource dataSource;
    private List<RoofTypeDataSource> roofTypeList = new ArrayList<RoofTypeDataSource>();

   

    public List<RoofTypeDataSource> getRoofTypeList() {
        return roofTypeList;
    }

    public void setRoofTypeList(List<RoofTypeDataSource> roofTypeList) {
        this.roofTypeList = roofTypeList;
    }

    public static RoofTypeDataSource getPropertyTypeDataSource() {
	if (dataSource == null)
	    dataSource = new RoofTypeDataSource();
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

    public ContentValues roofTypeToContentValues() {

	final ContentValues values = new ContentValues();
	values.put("name", getName());

	return values;
    }

    public RoofTypeDataSource cursorToRoofType(Cursor cursor) {
	final RoofTypeDataSource roofTypeDataSource = new RoofTypeDataSource();

	roofTypeDataSource.setName(cursor.getString(1));

	return roofTypeDataSource;

    }

}
