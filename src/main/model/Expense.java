package model;

public class Expense {
    // Expense class takes care of rows of each table (expense such as amount, date, category)

    private double amount;
    private String category;
    private String date;

    // initialize
    public Expense(double amount, String category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // EFFECTS: returns expense amount
    public double getAmount() {
        return amount;
    }

    // EFFECTS: returns category
    public String getCategory() {
        return category;
    }

    // EFFECTS: returns date of expense (string)
    public String getDate() {
        return date;
    }

    // EFFECTS: prints expense with amoount, category, and date 
    @Override
    public String toString() {
        return "Expense{amount=" + amount + ", category='" + category + "', date='" + date + "'}";
    }
}
