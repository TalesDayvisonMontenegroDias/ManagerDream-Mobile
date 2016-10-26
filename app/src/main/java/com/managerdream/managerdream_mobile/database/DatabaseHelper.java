package com.managerdream.managerdream_mobile.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Home on 25/10/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "managerDream.db";
    private static final int DATABASE_VERSION = 1;
    private static final String USER_TABLE_NAME = "user_managerDream_table";
    private static final String USER_ID_TABLE = "user_id_table";
    private static final String USER_CREDIT_TABLE = "user_credit_table";

    private static final String COST_TABLE_NAME = "cost_managerDream_table";
    private static final String COST_ID_TABLE = "cost_id_table";
    private static final String COST_DESCRIPTION_TABLE = "cost_description_table";
    private static final String COST_PRICE_TABLE = "cost_price_table";
    private static final String COST_PAYMENTDAY_TABLE = "cost_paymentDay_table";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + USER_TABLE_NAME + " (("+USER_ID_TABLE+") INTEGER PRIMARY KEY AUTOINCREMENT)," +
                                                       " (("+USER_CREDIT_TABLE+") INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_CREDIT_TABLE);
        onCreate(db);
    }

    public boolean insertData(String credit){
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put(USER_CREDIT_TABLE, credit);

       long result = db.insert(USER_TABLE_NAME,null,contentValues);
       if(result == -1)
          return false;
       else
          return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ USER_TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String ID, String credit){
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put(USER_ID_TABLE, ID);
       contentValues.put(USER_CREDIT_TABLE,credit);

       db.update(USER_TABLE_NAME,contentValues,""+USER_ID_TABLE +" = ?",new String[]{ID});
       return true;
    }

    public Integer deleteData(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(USER_TABLE_NAME,""+USER_ID_TABLE +" = ?",new String[]{ID});
    }
}