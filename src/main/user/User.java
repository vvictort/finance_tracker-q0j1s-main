package user;

import java.util.ArrayList;
import java.util.List;

import model.*;

public class User {
    private String id, password, name;
    private Goal goal;
    private ArrayList<Row> rows;

    List<Row> loggedInfo;

    // Effects: initialize user with id, and password, and inf rows
    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.goal = null;
        this.rows = new ArrayList<>();
    }

    // REQUIRES: date, use, amount
    // MODIFIES: this
    // EFFECTS: adds row
    public void addRow(String date, String use, Integer amount){
        rows.add(new Row(date, use, amount));
    }

    // REQUIRES: newName
    // MODIFIES: this
    // EFFECTS: changes name
    public void changeName(String newName) {
        name = newName;
    }

    // MODIFIES: this
    // EFFECTS: update goal
    public void changeGoal(Integer amount, String goalType){
        goal.updateGoal(goalType, amount);
    }

    // MODIFIES: this
    // EFFECTS: changes password
    public void changePassword(String PW) {
        password = PW;
    }

    // MODIFIES: this
    // EFFECTS: changes id
    public void changeID(String newID) {
        id = newID;
    }

    // MODIFIES:
    // EFFECTS: add into arraylist when user loggs a new input
    public void newInput(String date, String use, Integer amount) {
        Row newRow = new Row(date, use, amount);
        loggedInfo.add(newRow);
    }

    // EFFECTS: return user id
    // (for introduction/titles/ensure user can check own status)
    public String getUserId() {
        return id;
    }

    // EFFECTS: return user's name
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    // EFFECTS: return logged info (all rows)
    public List<Row> getloggedInfo() {
        return loggedInfo;
    }

    // REQUIRES: list of user's spending/earning
    // EFFECTS: return total money user has logged
    public Integer getCurrentTotal() {
        Integer amount = 0;
        for (int i = 0; i < loggedInfo.size(); i++) {
            amount += loggedInfo.get(i).getAmount();
        }
        return amount;
    }
}
