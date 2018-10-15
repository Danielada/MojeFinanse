package com.example.daniel.mojefinanse;

import android.widget.Spinner;

import java.util.Date;

public class Expense {


    private String name;
    private int amount;
    private String category_expense;


    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public String getCategory_expense(){
        return category_expense;
    }

    public void setCategory_expense(String category_expense){
        this.category_expense = category_expense;
    }

}
