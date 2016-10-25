package com.managerdream.managerdream_mobile.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Home on 25/10/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "managerDream.db";
    public static final String USER_TABLE_NAME = "user_managerDream_table";
    public static final String USER_ID_TABLE = "user_id_table";
    public static final String USER_CREDIT_TABLE = "user_credit_table";

    public static final String COST_TABLE_NAME = "cost_managerDream_table";
    public static final String COST_ID_TABLE = "cost_id_table";
    public static final String COST_DESCRIPTION_TABLE = "cost_description_table";
    public static final String COST_PRICE_TABLE = "cost_price_table";
    public static final String COST_PAYMENTDAY_TABLE = "cost_paymentDay_table";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
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
}