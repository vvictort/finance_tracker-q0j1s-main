package user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.Budget;
import persistence.JsonReader;
import persistence.JsonWriter;

public class BudgetApp {
    // main interface of user

    private static final String JSON_STORE = "./data/budget.json";

    private Scanner input;
    private Budget budget;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // initialize
    public BudgetApp() {
        input = new Scanner(System.in);
        budget = new Budget(5000); // Default budget of 5000
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        // runTracker(); remove to run Jframe
    }

    // what user needs
    private void runTracker() {
        boolean keepGoing = true;
        String command;

        while (keepGoing) {
            displayInstructions();
            command = input.next().toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                // processInstructions(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // EFFECTS: get user input/instruction
    private void displayInstructions() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add expenses");
        System.out.println("\tr -> Remove expenses");
        System.out.println("\tp -> Print expenses");
        System.out.println("\to -> Add goals");
        System.out.println("\tg -> Remove goals");
        System.out.println("\ti -> Print goals");
        System.out.println("\ts -> Save tracker to file");
        System.out.println("\tl -> Load tracker from file");
        System.out.println("\tq -> Quit");
    }

    // // EFFECTS: action depending on inputs
    // private void processInstructions(String input) {
    // switch (input) {
    // case "a":
    // addExpense();
    // break;
    // case "r":
    // removeExpense();
    // break;
    // case "p":
    // printExpense();
    // break;
    // case "o":
    // addGoal();
    // break;
    // case "g":
    // removeGoal();
    // break;
    // case "i":
    // printGoal();
    // break;
    // case "s":
    // saveTracker();
    // break;
    // case "l":
    // loadTracker();
    // break;
    // default:
    // System.out.println("Invalid input");
    // }
    // }

    // methods

    // EFFECTS: function for each output
    public void addExpense(Double amounnt, String category, String date) {
        budget.addExpense(amounnt, category, date);
        // System.out.println("Enter expense amount: ");
        // double amount = input.nextDouble();
        // input.nextLine(); // Consume newline

        // System.out.println("Enter expense category: ");
        // String category = input.nextLine();

        // System.out.println("Enter date (YYYY-MM-DD): ");
        // String date = input.nextLine();

        // budget.addExpense(amount, category, date);
        System.out.println("Expense added!");
    }

    public void removeExpense(Double amount, String category) {
        budget.removeExpense(amount, category);
        System.out.println("Expense removed!");
        // System.out.println("Enter amount to remove: ");
        // double amount = input.nextDouble();
        // input.nextLine(); // Consume newline

        // System.out.println("Enter category of expense: ");
        // String category = input.nextLine();

        // budget.removeExpense(amount, category);
    }

    public String printExpense() {
        return budget.printBudgetOverview();
    }

    public void addGoal() {
        System.out.println("Enter goal amount: ");
        int amount = input.nextInt();
        input.nextLine(); // Consume newline

        System.out.println("Enter goal type: ");
        String type = input.nextLine();

        budget.addGoal(amount, type);
        System.out.println("Goal added!");
    }

    public void removeGoal() {
        System.out.println("Enter goal value to remove: ");
        int goalValue = input.nextInt();
        budget.removeGoal(goalValue);
    }

    public void printGoal() {
        budget.checkGoalProgress();
    }

    public void saveTracker() {
        try {
            jsonWriter.open();
            jsonWriter.write(budget);
            jsonWriter.close();
            System.out.println("Saved budget to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    public void loadTracker() {
        try {
            budget = jsonReader.read();
            System.out.println("Loaded budget from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read file: " + JSON_STORE);
        }
    }
}
