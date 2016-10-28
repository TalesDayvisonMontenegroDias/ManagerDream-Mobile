package com.managerdream.managerdream_mobile.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Home on 25/10/2016.
 */

public interface IDao <Entity>{
    public boolean insert(Entity entity);
    public boolean update(Entity entity);
    public Cursor search();
    public int delete(Entity entity);
}
