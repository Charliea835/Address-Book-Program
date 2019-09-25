/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import java.util.Comparator;

/**
 * 20/09/2019
 * @author Charlie Ansell
 */
public class LastNameComparator implements Comparator<String> {

    //variable to hold name
    private String name;

    //default constructor takes in user input variable
    public LastNameComparator(String name) {
        this.name = name;
    }

    @Override
    public int compare(String left, String right) {
        if (left.endsWith(name) && right.endsWith(name)) {
            return left.compareTo(right);
        } else if (left.endsWith(name)) {
            return -1; //right is greater than left so switch 
        } else if (right.endsWith(name)) {
            return 1; //left is greater than right so switch 
        }
        return left.compareTo(right); //if neither left or right contains the word then sort alphabetically 
    }
}
