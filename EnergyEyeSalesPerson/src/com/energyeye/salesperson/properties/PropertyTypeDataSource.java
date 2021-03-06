package com.energyeye.salesperson.properties;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class PropertyTypeDataSource {

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "name :"+getName();
    }

    private String name;
    private Context context;
    private String whereClause;
    private String[] whereArgs;
    private String[] projection;
    private String sortOrder;
    private static PropertyTypeDataSource dataSource;
    private List<PropertyTypeDataSource> propertyTypeList = new ArrayList<PropertyTypeDataSource>();

    public static PropertyTypeDataSource getPropertyTypeDataSource() {
	if (dataSource == null)
	    dataSource = new PropertyTypeDataSource();
	return dataSource;
    }

   

    public List<PropertyTypeDataSource> getPropertyTypeList() {
        return propertyTypeList;
    }
    
    public void setPropertyTypeList(List<PropertyTypeDataSource> propertyTypeList)
    {
	this.propertyTypeList = propertyTypeList;
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

    public ContentValues propertyTypeToContentValues() {

	final ContentValues values = new ContentValues();
	values.put("name", getName());

	return values;
    }

    public PropertyTypeDataSource cursorToPropertyType(Cursor cursor) {
	final PropertyTypeDataSource propertyTypeDataSource = new PropertyTypeDataSource();

	propertyTypeDataSource.setName(cursor.getString(1));

	return propertyTypeDataSource;

    }

}
