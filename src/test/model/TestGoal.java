package model;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import model.Goal;

public class TestGoal {
    Goal myGoal;

    @BeforeEach
    void runBefore() {
        myGoal = new Goal(200, "Saving", false);
    }

    @Test
    void testUpdateGoal() {
        Integer i = 200;

        assertEquals(i, myGoal.getGoalAmount());
        assertEquals("Saving" ,myGoal.getGoalType());
        myGoal.updateGoal("Earning", 200);
        assertEquals("Earning", myGoal.getGoalType());

        i = 200;
        assertEquals(i, myGoal.getGoalAmount());
    }
    @Test
    void testToString(){
        assertEquals("{value=200, type='Saving', completed=false}", myGoal.toString());
    }

}
