/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import java.util.Scanner;

/**
 * 20/09/2019
 * @author Charlie Ansell
 */

public class AddressBookMain {
    
    public static void main(String[] args) {
        
        //create addresses and people 
        AddressBook ad1 = new AddressBook();
        //bootsrapping default users into the system
        Address a1 = new Address("grove","Waterford","Waterford","x9123r","0987654321");
        Address a2 = new Address("grove","Waterford","Waterford","x9123r","0876534123");
        Address a3 = new Address("94 Killysorrell Rd"," Dromore","Down","Ert567","089776453");
        Address a4 = new Address("Drumdoit","Castlefin","Donegal","R654tr","0897789865");
        Address a5 = new Address("Moorfield","Newbridge","Kildare","Y654rt","086553423");
        
        Person p1 = new Person("John","Paul",a1);
        Person p2 = new Person("Jake","Paul",a2);
        Person p3 = new Person("Charles","Princeton",a3);
        Person p4 = new Person("Billy","Robinson",a4);
        Person p5 = new Person("Karen","Jacobs",a5);
        
        //add the users to the map
        ad1.addContact("John","Paul", p1);
        ad1.addContact("Jake","Paul", p2);
        ad1.addContact("Charles","Princeton", p3);
        ad1.addContact("Billy","Robinson", p4);
        ad1.addContact("Karen","Jacobs", p5);
        
        //import scanner
        Scanner scan = new Scanner (System.in);
       
        
        String firstName="";
        String lastName="";
        String key="";
        String street="";
        String city="";          //variables to hold data, initialised to blank
        String county="";
        String postalCode="";
        String mNumber="";
        
        //choices  initialised to 0
        int choice=0;
        int choice1=0;
        
      //do while loop to show the ddress book options while the choice is not equal to exit
      do{
      
        System.out.println("\n********************************************************************************");
        System.out.println("Welcome to the Address book. Please pick from the options below.\n");
        System.out.println("Edit, Remove, Look up users by their keys. Users Keys are their firstname with a space followed by their lastname, example, Billy Robinson\n");
        System.out.println("1.Add user \n2.Remove user \n3.Edit user \n4.List Contact \n5.Sort contacts \n6.Exit\n\n");
        
          System.out.print("Please enter a choice: ");
          
          //loop over input to check if an integer is entered, if a letter or anything else is entered the exception will raise and 
          //user will be asked to enter a number
          
          int reloop = 0;
        do {
         try {
              String input = scan.nextLine(); // Changed this line
              choice = Integer.parseInt(input); // Changed this line
              reloop ++; //only increments when an integer is entered, thus breaking the loop.
        } catch (Exception e) {
       System.out.print ("Please enter a number :");
  }} while(reloop == 0);
        switch (choice) {
        //switch choice 
            
            //case 1
            case 1:
                //Add user
                
                //use scanner take in details....
                
                System.out.println("\n*********************************");
                System.out.println("ADD NEW USER");
                System.out.println("*********************************");
                
                System.out.print("\nPlease enter firstname: ");
                firstName=scan.nextLine();
                
                System.out.print("Please enter lastname: ");
                lastName=scan.nextLine();
                
                System.out.print("Please enter street:");
                street=scan.nextLine();
                System.out.print("Please enter city: ");
                city=scan.nextLine();
                System.out.print("Please enter county: ");
                county=scan.nextLine();
                System.out.print("Please enter postal code: ");
                postalCode=scan.nextLine();
                System.out.print("Please enter Mobile number: ");
                mNumber=scan.nextLine();

                
                //create address and person objects
                
                Address address = new Address(street,city,county,postalCode,mNumber);
               
                Person person = new Person(firstName,lastName,address);
                
                ad1.addContact(firstName,lastName,person);
                break;
        
        
        
            case 2:
                //Remove user
                System.out.println("\n*********************************");
                System.out.println("REMOVE USER");
                System.out.println("*********************************");
                
                //get the user to enter in details
                System.out.print("\nPlease enter name of user to remove: ");
                key=scan.nextLine();
                
                //Give each word a capital letter
                key=capEachWord(key);
                
                //remove contact
                ad1.removeContact(key);
                    break;
            case 3:
                //Edit user
                System.out.println("\n*********************************");
                System.out.println("EDIT USER");
                System.out.println("*********************************");
                
                //get user to enter their details
                System.out.print("\nPlease enter the name of the user you wish to edit details: ");
                key = scan.nextLine();
                key=capEachWord(key);
                
                System.out.print("Please enter desired firstname: ");
                firstName=scan.nextLine();
                System.out.print("Please enter desired lastname: ");
                lastName=scan.nextLine();
                System.out.print("Please enter new street:");
                street=scan.nextLine();
                System.out.print("Please enter new city: ");
                city=scan.nextLine();
                System.out.print("Please enter new county: ");
                county=scan.nextLine();
                System.out.print("Please enter postal code: ");
                postalCode=scan.nextLine();
                System.out.print("Please enter Mobile number: ");
                mNumber=scan.nextLine();
                
                //create address and person object to feed data into
                Address address1 = new Address(street,city,county,postalCode,mNumber);
                Person person1 = new Person(firstName,lastName,address1);
                
                //edit user
                ad1.editUser(key,firstName,lastName,person1);
                break;

            case 4:
                //List contact
                System.out.println("\n*********************************");
                System.out.println("LIST CONTACT");
                System.out.println("*********************************");
                
                //get user to enter details
                System.out.print("\nEnter name of contact you wish to lookup: ");
                key=scan.nextLine();
                key=capEachWord(key); //cap each word entered
                
                System.out.println("\nUSERS DETAILS");
                System.out.print("\n*****************");
                ad1.listContact(key); //list contact details
                System.out.println("*****************");
                     break;
  
            case 5:
                    //Sort contacts
                    ad1.clearList(); //clear list initially to stop users being added to the list recursively when option 5 is chosen
                    
                    System.out.println("\nUSERS DETAILS");
                    System.out.print("\n*****************");
                    ad1.listAllContacts(); //list all contacts
                    System.out.println("*****************");
                    
                    //do loop until user selects 3 (exit)
                  do{
                    int reloop1=0;
                   
                    System.out.println("\nHow would you like to sort these contacts? \n1.First name \n2.Last name \n3.Exit\n");
                    System.out.print("\nPlease enter a choice: ");
                    
                    //do loop to check if letter was entered or not
                    do {

                     try {

                          String input = scan.nextLine(); 
                          choice1 = Integer.parseInt(input); 
                          reloop1 ++; 
                    } catch (Exception e) {
                   System.out.print ("Please enter a number :");
              }} while(reloop1 == 0);

                       //switch choice1 
                        switch (choice1) {
                            
                            //case 1 
                            case 1:
                                
                                //sort by first name
                                
                                System.out.print("\nPlease enter first name to sort by: ");
                                firstName=scan.nextLine();
                                firstName=firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase(); //make sure word is capped
                                System.out.println("\n******************************");
                                System.out.println("ALL USERS SORTED BY :" + firstName);
                                ad1.sortFirstName(firstName); //sort users 
                                System.out.println("\n******************************"); 
                                break;
                                
                            case 2:
                                
                                //sort by last name
                                //take user input, capitalise input, feed input into sorting method
                                
                                 System.out.print("\nPlease enter last name to sort by: ");
                                lastName=scan.nextLine();
                                lastName=lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
                                System.out.println("\n******************************");
                                System.out.println("ALL USERS SORTED BY :" + lastName);
                                ad1.sortLastName(lastName); //sort by last name 
                                System.out.println("\n******************************"); 
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid choice entered, please try again\n");
                                break;
                        } 
                  }while(choice1!=3);
       
            
            case 6:
               break;
             
            default:  //default case invalid option entered 
                System.out.println("\nInvalid choice entered, please try again\n");
                break;
        }
      
      }while(choice!=6);
      
    }
    
    //static method to call in psvm. Capitalise each word 
    public static String capEachWord(String source){
    String result = ""; //initialise result to be 0
    String[] splitString = source.split(" "); //split each word at every space and store in splitString array
    for(String target : splitString){ //iterate over elements in splitString array
        result += Character.toUpperCase(target.charAt(0)) //for each word, capitalise first character and append the rest of the word adding a space
                +target.substring(1) + " ";
    }
    return result.trim(); //return result trimmed so end space is trimmed off
}
}
