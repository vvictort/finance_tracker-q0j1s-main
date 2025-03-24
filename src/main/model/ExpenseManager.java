package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExpenseManager {
    private List<Expense> listOfExpense; // Store list of expenses

    public ExpenseManager() {
        listOfExpense = new ArrayList<>();
    }

    public void addExpense(double amount, String category, String date) {
        Expense expense = new Expense(amount, category, date);
        listOfExpense.add(expense);
        System.out.println("Expense added successfully.");
    }

    public void removeExpense(double amount, String category) {
        Iterator<Expense> iterator = listOfExpense.iterator();
        while (iterator.hasNext()) {
            Expense expense = iterator.next();
            if (expense.getAmount() == amount && expense.getCategory().equalsIgnoreCase(category)) {
                iterator.remove();
                System.out.println("Removed expense successfully.");
                return;
            }
        }
        System.out.println("Expense not found.");
    }

    public String printExpenses() {
        if (listOfExpense.isEmpty()) {
            return "No expenses recorded.";
        }

        StringBuilder ans = new StringBuilder();
        int count = 1;
        for (Expense expense : listOfExpense) {
            String oneExpense = expense.toString();
            ans.append("Expense #").append(count).append(": ").append(oneExpense).append("\n");
            count++;
        }

        return "\n=== Expenses ===\n" + ans.toString();
    }

    public double getTotalExpenses() {
        double total = 0;
        for (Expense expense : listOfExpense) {
            total += expense.getAmount();
        }
        return total;
    }

    public List<Expense> getExpenses() {
        return listOfExpense;
    }
}
