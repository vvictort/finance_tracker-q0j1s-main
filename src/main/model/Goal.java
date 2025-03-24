package model;

public class Goal {
    // goal type is cateogrial (choose between saving, earning)
    String goalType;
    Integer goalAmount;
    Boolean hasAchieved;

    public Goal(Integer amount, String type, Boolean hasAchieved) {
        this.goalType = type;
        this.goalAmount = amount;
        this.hasAchieved = hasAchieved;
    }

    // REQUIRES : goalType != null && goalAmount >= 0
    // MODIFIES: this
    // EFFECTS: insert new goal
    // after changing goal type will return saving/earning
    // after changing goal amount will return
    public void updateGoal(String newGoal, Integer newAmount) {
        goalType = newGoal;
        goalAmount = newAmount;
    }

    // EFFECTS: return goal amount
    public Integer getGoalAmount() {
        return goalAmount;
    }

    // EFFECTS: return goal type/category
    public String getGoalType() {
        return goalType;
    }

    // EFFECTS: return boolean (completed)
    public Boolean isCompleted() {
        return hasAchieved;
    }

    // EFFECTS: return string to print value
    @Override
    public String toString() {
        String s = "{value=" + goalAmount + ", type='" + goalType + "', completed=" + hasAchieved + "}";
        return s;
    }
}
