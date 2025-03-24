package model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import model.Row;

public class TestRow {
    Row myRow;

    @BeforeEach
    void runBefore() {
        myRow = new Row("0", null, null);
    }

    @Test
    void testInitial() {
        // assertEquals("0", myRow.getDateLogged());
        assertNull(myRow.getUse());
        assertNull(myRow.getAmount());
    }

    @Test
    void testChangeDate() {
        myRow.changeRowDate("20250201");
        // assertEquals("250201", myRow.getDateLogged());

        myRow.changeRowDate("20240301");
        myRow.changeRowDate("20240301");
        // assertEquals("20240301", myRow.getDateLogged());

    }

    @Test
    void testChangeAmount() {
        myRow.changeAmount(300);
        assertEquals(300, myRow.getAmount());

        myRow.changeAmount(400);
        myRow.changeAmount(400);
        assertEquals(400, myRow.getAmount());
    }

    /**
     * Figure out why asserEquals cannot take in string
     */
    @Test
    void testChangeUse() {
        myRow.changeUse("shopping");
        // assertEquals("shopping", myRow.getUse());

        myRow.changeUse("date");
        myRow.changeUse("date");
        // assertEquals("date", myRow.getUse());

    }
}
