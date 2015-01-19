package com.energyeye.salesperson.dbComponents;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private String sql_create;

    public DBHelper(Context context, int version, String db, String sql_create) {
	super(context, db, null, version);
	this.sql_create = sql_create;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
	db.execSQL(this.sql_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

}
