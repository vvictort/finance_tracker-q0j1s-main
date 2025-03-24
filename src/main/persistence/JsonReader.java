package persistence;

import model.Budget;
import model.ExpenseManager;
import model.GoalManager;
import org.json.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads budget from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Budget read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBudget(jsonObject);
    }

    // EFFECTS: reads source file as a string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses budget from JSON object and returns it
    private Budget parseBudget(JSONObject jsonObject) {
        double totalBudget = jsonObject.getDouble("totalBudget");
        Budget budget = new Budget(totalBudget);

        addGoals(budget.getGoalManager(), jsonObject);
        addExpenses(budget.getExpenseManager(), jsonObject);

        return budget;
    }

    // MODIFIES: goalManager
    // EFFECTS: parses goals from JSON object and adds them to the goal manager
    private void addGoals(GoalManager goalManager, JSONObject jsonObject) {
        if (!jsonObject.has("goals")) {
            return; // Avoids errors if "goals" key is missing
        }

        JSONArray jsonArray = jsonObject.getJSONArray("goals");
        for (Object json : jsonArray) {
            JSONObject nextGoal = (JSONObject) json;
            addGoal(goalManager, nextGoal);
        }
    }

    // MODIFIES: goalManager
    // EFFECTS: parses a goal from JSON object and adds it to the goal manager
    private void addGoal(GoalManager goalManager, JSONObject jsonObject) {
        int goalValue = jsonObject.getInt("goalValue");
        String type = jsonObject.getString("type");
        boolean completed = jsonObject.getBoolean("completed");

        goalManager.addGoal(goalValue, type, completed);
    }

    // MODIFIES: expenseManager
    // EFFECTS: parses expenses from JSON object and adds them to the expense manager
    private void addExpenses(ExpenseManager expenseManager, JSONObject jsonObject) {
        if (!jsonObject.has("expenses")) {
            return; // Avoids errors if "expenses" key is missing
        }

        JSONArray jsonArray = jsonObject.getJSONArray("expenses");
        for (Object json : jsonArray) {
            JSONObject nextExpense = (JSONObject) json;
            addExpense(expenseManager, nextExpense);
        }
    }

    // MODIFIES: expenseManager
    // EFFECTS: parses an expense from JSON object and adds it to the expense manager
    private void addExpense(ExpenseManager expenseManager, JSONObject jsonObject) {
        double amount = jsonObject.getDouble("amount");
        String category = jsonObject.getString("category");
        String date = jsonObject.getString("date");

        expenseManager.addExpense(amount, category, date);
    }
}
