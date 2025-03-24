package model;

import java.util.ArrayList;

public class GoalManager {
    // goal managers has a list of goals so that user can keep track of progress
    // user can also see which goals are completed

    private ArrayList<Goal> listOfGoals;

    public GoalManager() {
        listOfGoals = new ArrayList<>();
    }

    // EFFECTS: adds goal to list
    // 1. with boolean not given
    public void addGoal(Integer goal, String type) {
        Goal oneGoal = new Goal(goal, type, false);
        listOfGoals.add(oneGoal);
    }

    // 2. boolean given
    public void addGoal(Integer goal, String type, Boolean hasAchieved) {
        Goal oneGoal = new Goal(goal, type, hasAchieved);
        listOfGoals.add(oneGoal);
    }

    // EFFECTS: removes goal from list
    public void removeGoal(int index) {
        try {
            listOfGoals.remove(index);
            System.out.println("Goal removed successfully.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index! Goal not found.");
        }
    }

    // EFFECTS: prints goal for interface
    public String printGoal() {
        if (listOfGoals.isEmpty()) {
            return "No goals recorded.";
        }

        StringBuilder ans = new StringBuilder();
        int count = 1;

        for (Goal goal : listOfGoals) {
            String oneGoal = goal.toString();
            ans.append("Goal #").append(count).append(": ").append(oneGoal).append("\n");
            count++;
        }

        return "\n=== Goals ===\n" + ans.toString();
    }

    // EFFECTS: return all the list of goals in arrayList
    public ArrayList<Goal> getListOfGoals() {
        return listOfGoals;
    }
}
