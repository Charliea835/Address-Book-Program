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

public class FirstNameComparator implements Comparator<String> {

    //variable to hold users input
    private String name;

    //constructor for class, takes users input
    public FirstNameComparator(String name) {
        this.name = name;
    }

    //override comparators compare 
    @Override
    public int compare(String left, String right) {
        
        //sort all strings based on if a string starts with user input, compare strings from left to right, give preference in list to strings that match comaprison
        if (left.startsWith(name) && right.startsWith(name)) {
            return left.compareTo(right); //equal strings, 
        } else if (left.startsWith(name)) {
            return -1; //right is greater than left so switch 
        } else if (right.startsWith(name)) {
            return 1; //left is greater than right so switch  
        }
        return left.compareTo(right); //otherwise comapare strings lexicographically
    }
}
