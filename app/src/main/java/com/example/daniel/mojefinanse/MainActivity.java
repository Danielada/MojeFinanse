package com.example.daniel.mojefinanse;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.mojefinanse.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieChart = (PieChart) findViewById(R.id.pieChart);

        pieChart.getDescription().setEnabled(false);
        pieChart.setTransparentCircleRadius(62);

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(20, "Iran"));
        yValues.add(new PieEntry(44, "Zamach stanu"));
        yValues.add(new PieEntry(11, "USA"));
        yValues.add(new PieEntry(55, "Poland"));

        PieDataSet dataSet = new PieDataSet(yValues, "wykres");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData pieData = new PieData(dataSet);
        pieData.setValueTextSize(12);

        pieChart.setData(pieData);


        ExpenseRepository expenseRepository = new ExpenseRepository();
        StringBuilder stringBuilder = expenseRepository.showExpense(this);

        Toast.makeText(this, stringBuilder, Toast.LENGTH_SHORT).show();

        TextView textView = (TextView) findViewById(R.id.list_expense);
        textView.setText(stringBuilder);

        Button addExpense =  findViewById(R.id.add_expense);

        addExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(intent);

//      Test pierdolonego gita
            }
        });
    }

}
