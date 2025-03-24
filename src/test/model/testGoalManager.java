package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testGoalManager {
    GoalManager goalManager;
    Goal thisGoal, goalTwo;
    ArrayList<Goal> goals;

    @BeforeEach
    void ini() {
        goalManager = new GoalManager();

        thisGoal = new Goal(200, "Saving", false);
        goalTwo = new Goal(300, "Trip money", false);
        goals = new ArrayList<>();
    }

    @Test
    void testIni() {
        assertEquals(new ArrayList<Goal>(), goalManager.getListOfGoals());
    }

    @Test
    void testAddGoal() {
        goalManager.addGoal(200, "Saving", false);
        assertEquals(1, goalManager.getListOfGoals().size());

        goalManager.addGoal(2000, "null");
        goalManager.addGoal(300, "null");
        assertEquals(3, goalManager.getListOfGoals().size());
    }

    @Test
    void testRemoveGoal() {
        goalManager.addGoal(200, "Savinig");
        goalManager.addGoal(300, "Trip money");
        assertEquals(2, goalManager.getListOfGoals().size());

        goalManager.removeGoal(1);
        assertEquals(1, goalManager.getListOfGoals().size());
    }
}
