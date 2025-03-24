package user;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Budget;
import persistence.JsonReader;
import persistence.JsonWriter;

public class BudgetApp {
    // main interface of user

    private static final String JSON_STORE = "./data/budget.json";

    private Budget budget;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // initialize
    public BudgetApp() {
        budget = new Budget(5000); // Default budget of 5000
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: function for each output
    public void addExpense(Double amounnt, String category, String date) {
        budget.addExpense(amounnt, category, date);
        System.out.println("Expense added!");
    }

    public void removeExpense(Double amount, String category) {
        budget.removeExpense(amount, category);
        System.out.println("Expense removed!");
    }

    public String printExpense() {
        return budget.printBudgetOverview();
    }

    public void addGoal(int amount, String type) {
        budget.addGoal(amount, type);
        System.out.println("Goal added!");
    }

    public void removeGoal(int goalValue) {
        budget.removeGoal(goalValue);
        System.out.println("Goal removed!");
    }

    public String printGoal() {
        return budget.checkGoalProgress();
    }

    public void saveTracker() {
        try {
            jsonWriter.open();
            jsonWriter.write(budget);
            jsonWriter.close();
            System.out.println("Saved budget to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    public void loadTracker() {
        try {
            budget = jsonReader.read();
            System.out.println("Loaded budget from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read file: " + JSON_STORE);
        }
    }
}
