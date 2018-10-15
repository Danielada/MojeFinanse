package com.example.daniel.mojefinanse;

import android.database.Cursor;
import android.widget.TextView;

public class CalculateExpense {

    private int sumExpenses;

    private StringBuilder showExpense(Cursor cursor) {
        StringBuilder stringBuilder = new StringBuilder("Wydatki:  \n");

        while (cursor.moveToNext()) {
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

//        TextView textView = (TextView)findViewById(R.id.wyswietl);
//        textView.setText(stringBuilder);
    }


}
