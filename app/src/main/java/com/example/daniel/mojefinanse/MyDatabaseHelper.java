package com.example.daniel.mojefinanse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static MyDatabaseHelper instance;

    private static final String DATABASE_NAME = "expenseDataBase";
    public static String tableName = "Expense";

    public static final String KEY_ID = "id";
    public static final String COL_1 = "name";
    public static final String COL_2 = "category";
    public static final String COL_3 = "amount";


    public static MyDatabaseHelper getInstance(Context context){
        if(instance == null) {
            instance = new MyDatabaseHelper(context, DATABASE_NAME, null, 9);
        }
        return instance;
    }


    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, null, 9);
    }

    public  MyDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 9);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("database", "onCreate start");
        recreateDB(db);
        Log.d("database", "onUpgrade finished");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("database", "onUpgrade start");
        recreateDB(db);
        Log.d("database", "onUpgrade finished");

    }

    private void recreateDB(SQLiteDatabase db){
        db.execSQL("drop table if exists Expense" );
        db.execSQL("CREATE TABLE " + tableName + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + COL_1 + " TEXT," + COL_2 + " TEXT, " + COL_3 + " INTEGER NOT NULL" + ")");

    }


}


