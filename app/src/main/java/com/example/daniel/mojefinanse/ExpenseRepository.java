package com.example.daniel.mojefinanse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ExpenseRepository {

    public Cursor takeExpense(Context context){
        MyDatabaseHelper myDatabaseHelper = MyDatabaseHelper.getInstance(context);
        SQLiteDatabase database = myDatabaseHelper.getReadableDatabase();
        Cursor cursor = database.query(MyDatabaseHelper.tableName, new String[]{"id", MyDatabaseHelper.COL_1, MyDatabaseHelper.COL_2, MyDatabaseHelper.COL_3}, null, null, null, null, null);
 //       startManagingCursor(cursor);
        return cursor;
    }


    public StringBuilder showExpense(Context context){
        MyDatabaseHelper myDatabaseHelper = MyDatabaseHelper.getInstance(context);
        SQLiteDatabase database = myDatabaseHelper.getReadableDatabase();
        Cursor cursor = database.query(MyDatabaseHelper.tableName, new String[]{"id", MyDatabaseHelper.COL_1, MyDatabaseHelper.COL_2, MyDatabaseHelper.COL_3}, null, null, null, null, null);

        StringBuilder stringBuilder = new StringBuilder("Wydatki: \n");
        while(cursor.moveToNext()){
            long id = cursor.getLong(0);
            String name = cursor.getString(1);
            String category = cursor.getString(2);
            int amount = cursor.getInt(3);

            stringBuilder.append(id + ":");
            stringBuilder.append(name + ":");
            stringBuilder.append(category + ":");
            stringBuilder.append(amount + "\n");
        }
        return stringBuilder;
    }
/*
    public void insertData(Context context, String name, String category, int amount){
        MyDatabaseHelper myDatabaseHelper = MyDatabaseHelper.getInstance(context);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.COL_1, name);
        contentValues.put(MyDatabaseHelper.COL_2, category);
        contentValues.put(MyDatabaseHelper.COL_3, amount);

        sqLiteDatabase.insert(MyDatabaseHelper.tableName, null, contentValues);
    }
*/


    public void insertData(Context context, Expense expense){
        MyDatabaseHelper myDatabaseHelper = MyDatabaseHelper.getInstance(context);
        SQLiteDatabase sqLiteDatabase = myDatabaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.COL_1, expense.getName());
        contentValues.put(MyDatabaseHelper.COL_2, expense.getCategory_expense());
        contentValues.put(MyDatabaseHelper.COL_3, expense.getAmount());

        sqLiteDatabase.insert(MyDatabaseHelper.tableName, null, contentValues);
    }



}
