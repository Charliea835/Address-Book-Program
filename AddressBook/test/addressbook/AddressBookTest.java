/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

//include libraries
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 20/09/2019
 * @author Charlie Ansell
 */
public class AddressBookTest {
    
    //instantiate objects
    AddressBook ad1 = new AddressBook();
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    public AddressBookTest() {
    }
    
    
    @Before
    public void setUp() {
        
        //bootsrapping default users into the system
        //create default addresses for users
        Address a1 = new Address("grove","Waterford","Waterford","x9123r","0987654321");
        Address a2 = new Address("grove","Waterford","Waterford","x9123r","0876534123");
        Address a3 = new Address("94 Killysorrell Rd"," Dromore","Down","Ert567","089776453");
        Address a4 = new Address("Drumdoit","Castlefin","Donegal","R654tr","0897789865");
        Address a5 = new Address("Moorfield","Newbridge","Kildare","Y654rt","086553423");
        
        //create 5 people to add 
        Person p1 = new Person("John","Paul",a1);
        Person p2 = new Person("Jake","Paul",a2);
        Person p3 = new Person("Charles","Princeton",a3);
        Person p4 = new Person("Billy","Robinson",a4);
        Person p5 = new Person("Karen","Jacobs",a5);
        
        //add each of them to the map
        ad1.addContact("John","Paul", p1);
        ad1.addContact("Jake","Paul", p2);
        ad1.addContact("Charles","Princeton", p3);
        ad1.addContact("Billy","Robinson", p4);
        ad1.addContact("Karen","Jacobs", p5);
        
    }
    
    //addContact works, all expected output correct
    @Test
    public void addContact(){
        
        //create new address and peron object and feed in data
        Address a1 = new Address("grove","Waterford","Waterford","x9123r","0987654321");
        Person p1 = new Person("Charlie","Ansell",a1);
        
        //set the output to a new printstream outContact
        System.setOut(new PrintStream(outContent));
        
        //call method with arguments
        ad1.addContact("Charlie","Ansell", p1);
        
        //assert expected answer to actual
        assertEquals("\nUser: Charlie Ansell Successfully added\n".trim(), outContent.toString().trim());
        
        outContent.reset(); //flush outContents stream to allow new text to enter
        
        ad1.addContact("Charlie","Ansell", p1);
        assertEquals("\nCannot add user. User already exists. Try adding distinct name to diffentiate between users with the same name".trim(), outContent.toString().trim());
    }
    
    @Test
    public void edit(){
        
        // create address and person. Add the person to the map
        Address a1 = new Address("grove","Waterford","Waterford","x9123r","0987654321");
        Person p1 = new Person("new","user",a1);
        
        //set a new printStream object to set printed data to be caught by printstream (for string comparison)
        System.setOut(new PrintStream(outContent));
        
        //edit user 
        ad1.editUser("Jake Paul", "new", "user", p1);
        
        //True, because user Jake Paul exists in map
        assertEquals("User Modified successfully".trim(), outContent.toString().trim());
        
        outContent.reset(); //flush outContents stream to allow new text to enter
        
        //User cannot be editted because user does not exist. Test passes
        ad1.editUser("Random User", "new", "user", p1);
        assertEquals("\nCannot edit user. User does not exist".trim(), outContent.toString().trim());
        
    }
    
    //testing the remove method
    @Test
    public void remove(){
       
        //set printStream 
        System.setOut(new PrintStream(outContent));
        
        //Jake Paul can be removed so test is true
        ad1.removeContact("Jake Paul");
        assertEquals("\nUser deleted succesfully".trim(), outContent.toString().trim());
        
        outContent.reset(); //flush outContents stream to allow new text to enter
        
        //map does not contain user Random User so cannot remove them
        ad1.removeContact("Random User");
        assertEquals("\nCannot remove user. User does not exist.".trim(), outContent.toString().trim());
        
    }
    
    //test list users method
    @Test
    public void listUsers(){
       
        //set printstream
        System.setOut(new PrintStream(outContent));
        
        //create arraylist to hold contacts
        List <String>list = new ArrayList();
        ad1.listAllContacts(); //call listAllContacts
        
        //create names list to hold all full names (list returned from ad1.getFullNames(); )
        List <String>names = ad1.getFullNames();
        
        //add desired output to list to compare against real output
        list.addAll(Arrays.asList("Jake Paul", "Billy Robinson", "Karen Jacobs", "Charles Princeton", "John Paul"));
        
        //test passes on this
        assertEquals(list,names);   
    }
    
    //list contact
    @Test
    public void listContact(){
        
        //create addresses and people
        Address a2 = new Address("grove","Waterford","Waterford","x9123r","0876534123");
        Person p2 = new Person("Jake","Paul",a2);
        Person p3 = ad1.contacts.get("Jake Paul");
        
        
        ad1.listContact("jake Paul"); //call list contact method from AddressBook class
        
        //set printStream
        System.setOut(new PrintStream(outContent));
        
        //test case returns true because p3.toString is equal to Jake pauls address. ad1.getContents passes
        assertEquals(p3.toString(),p2.toString());
        
        //user ABC is not in map
        ad1.listContact("ABC");
        assertEquals("\nCannot list user as they do not exist".trim(),outContent.toString().trim());
        
        
}
    //sort first method test
    @Test
    public void sortFirst(){
        //have to call listAllContacts to populates names list
        ad1.listAllContacts();
        
        //then we can sort first name by Jake
        ad1.sortFirstName("Jake");
        
        //create list to hold sorted names by jake
        List sorted = ad1.getSortedFirstNames();
        
        //create another list to hold expected output
        List sortedList = new ArrayList();
        
        sortedList.addAll(Arrays.asList("Jake Paul", "Billy Robinson", "Charles Princeton", "John Paul", "Karen Jacobs"));
        
        assertEquals(sortedList,sorted); //compare sortedList to actual list. test passes so getSortedNames works 
    }
    
    //sort by last name test
    @Test
    public void sortLast(){
        
        //again need to list all contacts
        ad1.listAllContacts();
        
        //sort last name by Robinson
        ad1.sortLastName("Robinson");
        
        //list to hold sorted names 
        List sorted = ad1.getSortedLastNames();
        
        //create list to hold expected output to compare
        List sortedList = new ArrayList();
        
        sortedList.addAll(Arrays.asList("Billy Robinson", "Charles Princeton", "Jake Paul", "John Paul", "Karen Jacobs")); //expected output
        
        assertEquals(sortedList,sorted); //compare sortedList to sorted list. test passes
    }
}
