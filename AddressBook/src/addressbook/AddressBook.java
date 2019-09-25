/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

//import libraries needed
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.List;

/**
 * 20/09/2019
 * @author Charlie Ansell
 */

/*
The AddressBook class holds all the methods to do with performing logical operations on an address book such as, sorting, searching, adding users.
*/
public class AddressBook {
    
    //map to store Person details, key string value Person
    public Map<String,Person> contacts = new ConcurrentHashMap<String,Person>();
    
    //Lists to hold sets of data 
    List<String> fullName = new ArrayList<String>();
    List<String> sortedFirstName = new ArrayList<String>();
    List<String> sortedLastName = new ArrayList<String>();
    
    //Add contact to Map 
    public void addContact(String firstName,String lastName,Person p) {
       //take in arguments to use for calculatons...
       
       //Generate key by concatenating the users first name with last name
       String key = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase() + " ".concat(lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase());
    if(hasContact(key)){  //if the key already exists...
        System.out.println("\nCannot add user. User already exists. Try adding distinct name to diffentiate between users with the same name");
    }
    else{ //else if key does not exist...
       this.contacts.put(key,p);
       System.out.println("\nUser: " + key + " Successfully added");
    }
    }
    
    //edit user with arguments  required
    public void editUser(String oldKey,String firstName, String lastName, Person p){
        //Generate key for new user by concatenating the users first name with last name
        String key = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase() + " ".concat(lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase());
        if(hasContact(oldKey)){ //if the user you want to edit exists..
           
            //remove them, add new user with new details.......give new details, safer to remove then re add with maps than just edit users keys. 
            this.contacts.remove(oldKey);
            this.contacts.put(key,p); //put new key into map 
       
            System.out.println("User Modified successfully");
            
        }
        else{ //if the old user does not exist..
             System.out.println("\nCannot edit user. User does not exist");
        }
       
    }

    //remove contact 
    public void removeContact(String key) {
        if(hasContact(key)){ //if user is in map...
            this.contacts.remove(key); //remove user
            System.out.println("\nUser deleted succesfully");
    }
    else{ //if user is not in the map
         System.out.println("\nCannot remove user. User does not exist.");
    }
  }
    
    //clear the fullName list
    public void clearList(){
        this.fullName.clear();
    }

    //check if the key exists
    public boolean hasContact(String key) {
        return this.contacts.containsKey(key);
    }
    
    //list all the contacts in the list
    public void listAllContacts(){

        //iterate over the map entry set so we can get the keys and values 
        for (Map.Entry<String,Person> entry : contacts.entrySet()) {
         //add the full name of users to the full name list
         fullName.add(entry.getValue().fullName());
}
        //iterate over full name list
        for (String contents : fullName) {  

           //print its contents             
           System.out.println("\n" + contents); 		
      }
    }
    
    //list contact by key
    public void listContact(String key){
        if(hasContact(key)){ //if key exists
        System.out.println(contacts.get(key)); //print the value to that key. (will call the toString from Person))
        
        }
        else{ //if key does not exist
            System.out.println("\nCannot list user as they do not exist");
        }
}
    //sort contacts by first name
    public void sortFirstName(String input){ 
        //sort list of full names by user input. Takes comparater class to sort by
         
       Collections.sort(fullName, new FirstNameComparator(input)); 
       
       //iterate through fullName list 
       for(int i = 0;i<fullName.size();i++){
           
           //print each name 
           System.out.println("\n" + fullName.get(i));
          
           //add each name to sorted list, to compare with in Junit tests
           sortedFirstName.add(fullName.get(i)); 
           
       }  
 }
    //return sortedFirstName list 
    public List<String> getSortedFirstNames(){
        return this.sortedFirstName;
    }
    
    //return getSortedLastName list 
    public List<String> getSortedLastNames(){
        return this.sortedLastName;
    }
    
    //return list fullName
    public List<String> getFullNames(){
        return this.fullName;
    }
    //sort by lastName
    public void sortLastName(String input){
        
     //sort fullName list on last name. Uses LastNameComparator class to sort by user input
     Collections.sort(fullName, new LastNameComparator(input)); 
       
       //iterate through fullName list
       for(int i = 0;i<fullName.size();i++){
           //print all sorted names 
           System.out.println("\n" + fullName.get(i));
           
           //add each name to sortedLastName list for Junit 
           this.sortedLastName.add(fullName.get(i));   
       }  
   }  
}
    

  

  


