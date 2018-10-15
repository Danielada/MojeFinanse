package com.example.daniel.mojefinanse;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.example.daniel.mojefinanse.MyDatabaseHelper;
import java.util.ArrayList;
import java.util.List;

public class ExpenseActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_category);
        SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, R.array.category_expense, android.R.layout.simple_spinner_item);

//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onIte
            mSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)+ "is selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
*/

        Button dodajWydatek = findViewById(R.id.add_expense);
        dodajWydatek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name;
                int amount;
                String category;

                Expense expense = new Expense();

                EditText nameEditText = findViewById(R.id.expense_name);
                name = nameEditText.getText().toString();
                expense.setName(name);

                EditText amountEditText = findViewById(R.id.amount);
                amount = Integer.parseInt(amountEditText.getText().toString());
                expense.setAmount(amount);

                EditText categoryEditText = findViewById(R.id.category);
                category = categoryEditText.getText().toString();
                expense.setCategory_expense(category);

                ListExpense listExpense = new ListExpense();
                listExpense.addExpenseToList(expense);

                MyDatabaseHelper db = new MyDatabaseHelper(getApplicationContext());

                ExpenseRepository expenseRepository = new ExpenseRepository();
                expenseRepository.insertData(getApplicationContext(), expense);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);

            }
/*
            private Cursor takeExpense(){
                MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getApplicationContext());
                SQLiteDatabase database = myDatabaseHelper.getReadableDatabase();
                Cursor cursor = database.query(MyDatabaseHelper.tableName, new String[]{"id", MyDatabaseHelper.COL_1, MyDatabaseHelper.COL_2, MyDatabaseHelper.COL_3}, null, null, null, null, null);
               startManagingCursor(cursor);
                return cursor;
            }


            private void showExpense(Cursor cursor) {
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
                TextView textView = (TextView)findViewById(R.id.wyswietl);
                textView.setText(stringBuilder);
            }
*/


// fdgsdfhgsfh
        });

    }

}
