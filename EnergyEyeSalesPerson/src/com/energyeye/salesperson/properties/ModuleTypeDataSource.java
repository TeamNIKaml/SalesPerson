package com.energyeye.salesperson.properties;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ModuleTypeDataSource {

    private String name;
    private Context context;
    private String whereClause;
    private String[] whereArgs;
    private String[] projection;
    private String sortOrder;
    private static ModuleTypeDataSource dataSource;
    private List<ModuleTypeDataSource> moduleTypeList = new ArrayList<ModuleTypeDataSource>();

    public static ModuleTypeDataSource getModuleTypeDataSource() {
	if (dataSource == null)
	    dataSource = new ModuleTypeDataSource();
	return dataSource;
    }

    public List<ModuleTypeDataSource> getModuleTypeList() {
	return moduleTypeList;
    }

    public void setModuleTypeList(List<ModuleTypeDataSource> moduleTypeList) {
	this.moduleTypeList = moduleTypeList;
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

    public ContentValues moduleTypeToContentValues() {

	final ContentValues values = new ContentValues();
	values.put("name", getName());

	return values;
    }

    public ModuleTypeDataSource cursorToModuleType(Cursor cursor) {
	final ModuleTypeDataSource moduleTypeDataSource = new ModuleTypeDataSource();

	moduleTypeDataSource.setName(cursor.getString(1));

	return moduleTypeDataSource;

    }

}