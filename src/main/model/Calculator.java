package model;

import java.util.ArrayList;

public class Calculator {

    // EFFECTS: simple method that returns the addition of all logged numbers
    // used money shold have (-) thus no minus calculator is needed
    public Integer addInteger(ArrayList<Integer> loggedNum) {
        Integer sum = 0;
        for (Integer i : loggedNum) {
            sum += i;
        }
        return sum;
    }
    
    //REQUIRES: 
    //MODIFIES:
    //EFFECTS: create a method to calculate

}
