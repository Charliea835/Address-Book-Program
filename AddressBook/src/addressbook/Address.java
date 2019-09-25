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
  Address class stores all data for an address
*/


public class Address {
    private String street="";
    private String city="";      //iniialise all variables to blank (default)
    private String county="";
    private String postalCode="";
    private String mNumber="";
    
    //default Address constructor 
    public Address(){
        street = "";
        city = "";
        county = "";
        postalCode="";
    }
    
    //address constructor with arguments
    public Address(String street, String city, String county, String postalCode, String mNumber){
        this.street=street;
        this.city=city;
        this.county=county;
        this.postalCode=postalCode;
        this.mNumber=mNumber;
    }
    
    //set street
    public void setStreet(String street){
        this.street=street;
    }
    
    //set city
    public void setCity(String city){
        this.city=city;
    }
    
    //set county 
    public void setCounty(String county){
        this.county=county;
    }
    
    //set postal code 
    public void setPostalCode(String postalCode){
        this.postalCode=postalCode;
    }
    
    //set mobile number 
    public void setMNumber(String mNumber){
        this.mNumber=mNumber;
    }
    
    //get street
    public String getStreet(){
        
        //ensure that first character of street is uppercase and the rest lowercase
        String streetUpper=this.street.substring(0,1).toUpperCase() + this.street.substring(1).toLowerCase();;
        return streetUpper;
    }
    
    //get city
    public String getCity(){
        
        //ensure that first character of city is uppercase and the rest lowercase
        String cityUpper=this.city.substring(0,1).toUpperCase() + this.city.substring(1).toLowerCase();;
        return cityUpper;
    }
    
    //get county
    public String getCounty(){
        
        //ensure that first character of county is uppercase and the rest lowercase
        String countyUpper=this.street.substring(0,1).toUpperCase() + this.street.substring(1).toLowerCase();;
        return countyUpper;
    }
    
    //get postal code
    public String getPostalCode(){

       //ensure that first character of postal code is uppercase and the rest lowercase
        String postalUpper=this.postalCode.toUpperCase();
        return postalUpper;
    }
    
    //get mobile number 
     public String getMNumber(){
        
        //ensure that first character of mobile number is uppercase and the rest lowercase
        String numberUpper=this.mNumber.toUpperCase();
        return numberUpper;
    }
    
}
