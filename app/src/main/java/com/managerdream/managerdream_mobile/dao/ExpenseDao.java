package com.managerdream.managerdream_mobile.dao;

import android.database.Cursor;

import com.managerdream.managerdream_mobile.entities.Expense;

/**
 * Created by Home on 28/10/2016.
 */

public class ExpenseDao implements IDao<Expense> {
    @Override
    public boolean insert(Expense expense) {
        return false;
    }

    @Override
    public boolean update(Expense expense) {
        return false;
    }

    @Override
    public Cursor search() {
        return null;
    }

    @Override
    public int delete(Expense expense) {
        return 0;
    }
}
