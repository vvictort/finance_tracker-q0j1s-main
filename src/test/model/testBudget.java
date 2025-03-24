package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testBudget {
    Budget myBudget;

    @BeforeEach
    void ini() {
        myBudget = new Budget(200);
    }

    @Test
    void testAddExpense() {
        assertEquals(200, myBudget.getRemainingBudget());

        myBudget.addExpense(100.0, "Food", "2004-01-07");
        assertEquals(100, myBudget.getTotalExpenses());
        assertEquals(100, myBudget.getRemainingBudget());

        myBudget.addExpense(50.0, "shopping", "jan");
        myBudget.addExpense(50.0, "Drinks", "Jan");
        assertEquals(0, myBudget.getRemainingBudget());
        assertEquals(200, myBudget.getTotalExpenses());
    }

    @Test
    void testRemoveExpense() {
        myBudget.removeExpense(0, "check");
        assertEquals(200, myBudget.getRemainingBudget());

        myBudget.addExpense(200.0, "used all my money", "Jan");
        myBudget.removeExpense(200, "used all my money");
        assertEquals(200.0, myBudget.getRemainingBudget());
    }

}
