package persistence;

import model.Budget;
import model.Expense;
import model.ExpenseManager;
import model.Goal;
import model.GoalManager;
import org.json.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a writer that writes budget data to a JSON file
public class JsonWriter {
    private static final int INDENTATION = 4; // Pretty-print JSON
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs a writer to write to the given destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens the writer; throws FileNotFoundException if file cannot be
    // opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of budget to file
    public void write(Budget budget) {
        JSONObject json = convertBudgetToJson(budget);
        writer.print(json.toString(INDENTATION)); // Pretty-print JSON
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // EFFECTS: Converts the Budget object into a JSON object
    private JSONObject convertBudgetToJson(Budget budget) {
        JSONObject json = new JSONObject();
        json.put("totalBudget", budget.getTotalBudget());
        json.put("expenses", convertExpensesToJson(budget.getExpenseManager()));
        json.put("goals", convertGoalsToJson(budget.getGoalManager()));

        return json;
    }

    // EFFECTS: Converts all expenses from ExpenseManager into a JSON array
    private JSONArray convertExpensesToJson(ExpenseManager expenseManager) {
        JSONArray jsonArray = new JSONArray();

        for (Expense expense : expenseManager.getExpenses()) {
            JSONObject expenseJson = new JSONObject();
            expenseJson.put("amount", expense.getAmount());
            expenseJson.put("category", expense.getCategory());
            expenseJson.put("date", expense.getDate());
            jsonArray.put(expenseJson);
        }

        return jsonArray;
    }

    // EFFECTS: Converts all goals from GoalManager into a JSON array
    private JSONArray convertGoalsToJson(GoalManager goalManager) {
        JSONArray jsonArray = new JSONArray();

        for (Goal goal : goalManager.getListOfGoals()) {
            JSONObject goalJson = new JSONObject();
            goalJson.put("goalValue", goal.getGoalAmount());
            goalJson.put("type", goal.getGoalType());
            goalJson.put("completed", goal.isCompleted());
            jsonArray.put(goalJson);
        }

        return jsonArray;
    }
}
