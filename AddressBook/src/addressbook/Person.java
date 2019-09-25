/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

/**
 * 20/09/2019
 * @author Charlie Ansell
 */

/*
This class holds all details belonging to a Person 
*/
public class Person {
    String firstName="";
    String lastName="";
    String street="";
    String city="";        //create variable holders and initialise to default
    String county="";
    String postalCode="";
    String mNumber="";
    
    //create new Address object
    Address address = new Address();
    
    //default Person constructor 
    public Person(){
        firstName="";
        lastName="";
        address.setCity("");
        address.setCounty("");
        address.setMNumber("");
        address.setPostalCode("");
        address.setStreet("");
    }
    
        //Person constructor with arguments to create new Person with details included
	public Person (String firstName,String lastName, Address addr) {
            
                                 //ensure that the first character of first name and last name entered is capitalised 
		this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
                this.lastName =lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
                this.city=addr.getCity();
                this.county=addr.getCounty();
                this.mNumber=addr.getMNumber();  //get address details from adddress class
                this.postalCode=addr.getPostalCode();
                this.street=addr.getStreet();
	}
        
        //set name 
        public void setFirstName(String firstName){
            this.firstName=firstName;
        }
        //set last name
        public void setLastName(String lastName){
            this.lastName=lastName;
        }
        //get first name
        public String getFirstName(){
            return this.firstName;
        }
        //get last name
        public String getLastName(){
            return this.lastName;
        }
        //get fullname of Person
        public String fullName(){
            return firstName + " ".concat(lastName);
        }
        
        //override toString() to print Person details in readable format
        @Override
        public String toString(){
            return "\nfirstname: " + firstName + "\n"
                    + "Lastname: "  + lastName + "\n"
                    + "Street: " + street + "\n"
                    + "City: " + city + "\n"
                    + "County: " + county + "\n"
                    + "Postal code: " + postalCode + "\n"
                    + "Mobile Number: " + mNumber + "\n";
        }
}


