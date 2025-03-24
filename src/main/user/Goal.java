package user;

public class Goal {
    // goal type is cateogrial (choose between saving, earning)
    String goalType;
    Integer goalAmount;

    public void main(String[] args) {
        goalType = null;
        goalAmount = 0;
    }

    // REQUIRES : goalType != null && goalAmount >= 0
    // MODIFIES: this
    // EFFECTS: insert new goal
    // after changing goal type will return saving/earning
    // after changing goal amount will return 
    public void updateGoal(String newGoal, Integer newAmount){
        goalType = newGoal;
        goalAmount = newAmount;
    }

    public Integer getGoalAmount(){
        return goalAmount;
    }
    public String getGoalType(){
        return goalType;
    }
}
