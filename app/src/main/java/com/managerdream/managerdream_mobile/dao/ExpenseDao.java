package com.managerdream.managerdream_mobile.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.managerdream.managerdream_mobile.entities.Expense;
import com.managerdream.managerdream_mobile.entities.User;

/**
 * Created by Home on 28/10/2016.
 */

public class ExpenseDao extends SQLiteOpenHelper implements IDao<Expense> {
    public static final String DATABASE_NAME = "ManagerDreamExpense.db";
    public static final String TABLE_NAME = "expense_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "PRICE";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "CATEGORY";



    public ExpenseDao(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" ("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT" +
                                                    ","+COL_2+" INTEGER" +
                                                    ","+COL_3+" TEXT" +
                                                    ","+COL_4 +" TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    @Override
    public boolean insert(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,expense.getPrice());
        contentValues.put(COL_3,expense.getDescription());
        contentValues.put(COL_4,expense.getCategory());



        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    @Override
    public boolean update(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,expense.getId());
        contentValues.put(COL_2,expense.getPrice());
        contentValues.put(COL_3,expense.getDescription());
        contentValues.put(COL_4, expense.getCategory());

        String idToString = Integer.toString(expense.getId());
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { idToString });
        return true;
    }

    @Override
    public Cursor search() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    @Override
    public int delete(Expense expense) {
        SQLiteDatabase db = this.getWritableDatabase();

        String idToString = Integer.toString(expense.getId());
        return db.delete(TABLE_NAME, "ID = ?",new String[] {idToString});
    }
}
