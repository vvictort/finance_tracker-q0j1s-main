package model;

// import java.util.Calendar;
// add to another class??

public class Row {
    // row with colums whiich are amount date and use
    // each log will have:
    // the amount (+/-),
    // date logged (year/month/day),
    // and what the money was used for (food/grocery)
    Integer amount;
    String dateLogged;
    String use;

    // EFFECTS: initialize
    public Row(String date, String use, Integer amount) {
        this.amount = amount;
        this.dateLogged = date;
        this.use = use;
    }

    // REQUIRES: integer
    // MODIFIES: this
    // EFFECTS: allow user to edit logged information/row after submittion
    // edt date in row
    public void changeRowDate(String newDate) {
        dateLogged = newDate;
    }

    // MODIFIES: this
    // EFFECTS: allow user to edit logged information/row after submittion
    // edt amount in row
    public void changeAmount(Integer newAmount) {
        amount = newAmount;
    }

    // MODIFIES: this
    // EFFECTS: allow user to edit logged information/row after submittion
    // edt use in row
    public void changeUse(String newUse) {
        use = newUse;
    }

    // EFFECTS: return use
    public String getUse() {
        return use;
    }

    // EFEFCTS: return datelogged
    public String getDateLogged() {
        return dateLogged;
    }

    // EFFECTS: return amount logged
    public Integer getAmount() {
        return amount;
    }
    
}

// visual:
// Date amount use
// 14/2/2025 -40 hamburger