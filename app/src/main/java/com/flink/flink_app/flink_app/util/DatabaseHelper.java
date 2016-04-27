package com.flink.flink_app.flink_app.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ligorio on 07/03/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;

    //Database Name
    private static final String DATABASE_NAME = "flink_database";

    //Tables Name
    private static final  String GOAL_TABLE = "goals";

    //Query statements
    private static final String CREATE_TABLE_GOAL= "CREATE TABLE "+ GOAL_TABLE +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "title TEXT NOT NULL, "+
            "date DATE NOT NULL, "+
            "cost REAL NOT NULL, "+
            "period TEXT NOT NULL" +
            "image BLOB);";


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
