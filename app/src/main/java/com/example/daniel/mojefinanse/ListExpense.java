package com.example.daniel.mojefinanse;

import java.util.ArrayList;
import java.util.List;

public class ListExpense {

   private List<Expense> expenses_List = new ArrayList<>();

    public void addExpenseToList(Expense expense){
        expenses_List.add(expense);
    }

    public List<Expense> getExpenses_List() {
        return expenses_List;
    }
}
