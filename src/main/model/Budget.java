package model;

public class Budget {
    // Budget class to manage and show budget (expense)

    private ExpenseManager expenseManager;
    private GoalManager goalManager;
    private Double totalBudget; // Total allocated budget

    public Budget(double totalBudget) {
        this.expenseManager = new ExpenseManager();
        this.goalManager = new GoalManager();
        this.totalBudget = totalBudget;
    }

    public void addExpense(Double amount, String category, String date) {
        expenseManager.addExpense(amount, category, date);
    }

    public void removeExpense(double amount, String category) {
        expenseManager.removeExpense(amount, category);
    }

    public void addGoal(int goalValue, String type) {
        goalManager.addGoal(goalValue, type);
    }

    public void removeGoal(int goalValue) {
        goalManager.removeGoal(goalValue);
    }

    public double getTotalExpenses() {
        return expenseManager.getTotalExpenses();
    }

    public double getRemainingBudget() {
        return totalBudget - getTotalExpenses();
    }

    public String checkGoalProgress() {
        StringBuilder progress = new StringBuilder();
        progress.append("=== Goal Progress ===\n");
        progress.append(goalManager.printGoal()).append("\n");
        progress.append("Total Expenses: ").append(getTotalExpenses()).append("\n");
        progress.append("Remaining Budget: ").append(getRemainingBudget()).append("\n");
        return progress.toString();
    }

    public String printBudgetOverview() {
        StringBuilder overview = new StringBuilder();
        overview.append("=== Budget Overview ===\n");
        overview.append("Total Budget: ").append(totalBudget).append("\n");
        overview.append("Remaining Budget: ").append(getRemainingBudget()).append("\n\n");

        overview.append("Expenses:\n");
        overview.append(expenseManager.printExpenses()).append("\n");

        overview.append("Goals:\n");
        overview.append(goalManager.printGoal()).append("\n");

        return overview.toString();
    }

    public ExpenseManager getExpenseManager() {
        return expenseManager;
    }

    public GoalManager getGoalManager() {
        return goalManager;
    }

    public Double getTotalBudget() {
        return totalBudget;
    }
}
