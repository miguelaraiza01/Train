package Main;
import java.util.*;
public class TrainProjectStudents
{
}
class Person
{
    //attributes
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	//constructor
	public Person(String firstName, String lastName, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email; 
		
	}
	//set the first name
	public void setFirstName(String newName) {
		this.firstName = newName;
	}
	//set the last name
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}
	//set the phone number
	public void setPhone(String newPhone) {
		this.phone = newPhone;
	}
	//set the email
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	//retrieve the first name
	public String getFirst() {
		return firstName;
	}
	//retrieve the last name
	public String getLast() {
		return lastName;
	}
	// retrieve the phone number
	public String getPhone() {
		return phone;
	}
	//retrieve the email
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		String s = "";
		s = "First Name: " + firstName;
		s = s + "\nLast Name: " + lastName;
		s = s + "\nPhone Number: " + phone;
		s = s + "\nEmail: " + email;
		
		return s;
	}
	//compares two passengers to see if they have the same name
	public boolean equals(Object o) {
		if(o instanceof Person) {
			Person name = (Person)o;
			return this.firstName.equals(name.firstName);
		}
		return false;
	}
	
	
 }
class Passenger extends Person  
{
    //attributes  
	public int seatNumber;
	public String Class;
	//constructor
    public Passenger(String firstName, String lastName, String phone, String email, int seatNumber, String Class) {
    	super(firstName, lastName, phone, email);
    	this.seatNumber = seatNumber;
    	this.Class = Class;
    	
    }
  //set the seat number
    public void setSeatNumber(int newSeatNumber) {
    	this.seatNumber = newSeatNumber;
    }
    // set class
    public void setClass(String newClass) {
    	this.Class = newClass;
    }
    //get Class
    public String obtainClass() {
    	return Class;
    }
    // get the seat number
    public int getSeatNumber() {
    	return seatNumber;
    }
    
    public String toString() {
    	String s = "";
    	s = "First Name: " + getFirst();
		s = s + "\nLast Name: " + getLast();
		s = s + "\nPhone Number: " + getPhone();
		s = s + "\nEmail: " + getEmail();
    	s = s + "\nSeat Number: " + seatNumber;
    	s = s + "\nClass: " + Class;
    
    	return s;
    }
    
}
interface list
{
	public boolean add(Object o); 
	public Object search(Object o);
	public boolean delete(Object o);
	public void printLast();
	
	
}
class Train  implements list    
{ 
   //attributes
	public static int count = 0;
	public Passenger[] train;
	public int trainNumber;
	//constructer
	public Train() {
		train = new Passenger[5];
	}
	//array of passengers
	public Passenger[] getTrain() {
		return train;
	}
	//get the train number
	public int getTrainNumber() {
		return trainNumber;
	}
	
	//prints passengers info
	public String toString() {
		String s ="";
		for(int i = 0; i < train.length; i++) {
			s = train[i].toString();
		}
	return s;
	}
	// number of passengers
	public static int getCount() {
		return count;
	}
	
	
	
	//adds passengers
	public boolean add(Object o) { 
		boolean b = o instanceof Passenger;
		if(!b)
			return false;
			Passenger people = (Passenger)o;
		
		for(int i = 0; i < train.length; i++) {
				train[i] = people;	
				 count++;	
		}
		
	return true;
	}
	
	
	//searches for passenger
	public Object search(Object o) {
		boolean b = o instanceof String;
		if(!b)
			return null;
		String name = (String)o;
		for(int i = 0; i < train.length; i++) {
			if(train[i] != null && train[i].getLast().equalsIgnoreCase(name))
			{ return train[i];}
		}
		return null;
	}
	//deletes passenger
	public boolean delete(Object o) {
		boolean b = o instanceof String;
		if(!b)
			return false;
		String name = (String)o;
		for(int i = 0; i < train.length; i++) {
			if(train[i] != null && train[i].getLast().equalsIgnoreCase(name)){ 
				train[i] = null;
				count--;
			}
			return true;
		}
		return false;
	}
	//prints last names
	public void printLast() {
		for(int i = 0; i < train.length; i++) {
			System.out.println(train[i].getLast());
		}
	}
	
}
 /*once you implemet the above classes uncommnet the driver and test your program*/       
class Driver
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      Train myTrain = new Train();
      //creating the passengers
      Passenger p1 = new Passenger("Alex", "Mano","123-456-7893","Mano@gmail.com", 12, "First class");
      Passenger p2 = new Passenger("Mary", "Trump","123-456-4894","mary@sierracollege.edu", 23, "Coach class");
      Passenger p3 = new Passenger("Al", "Busta","123-456-7890","AlB@csus.edu", 34, "Business class");
      Passenger p4 = new Passenger("Jose", "Rodrigues","123-222-7890", "Jose*gmail.com",22, "First class");
      Passenger p5 = new Passenger("Joe", "Rodrigues","123-222-7890","joe@yahoo.com", 25, "First class");
      
      //adding the passengers to the array
      myTrain.add(p1);
      myTrain.add(p2);
      myTrain.add(p3);
      myTrain.add(p4);
      myTrain.add(p5);
      
       //listing out he passengers
      System.out.println("\nHere is the list of the passengers in this train");
      System.out.println(myTrain);
      
      System.out.println("Testing the printLast method to display the last names");
      myTrain.printLast();
      System.out.println("\nTesting the static method getCount");
      System.out.println("This train has " + myTrain.getCount() + " Passengers\n");
      
      System.out.println("Testing the search method\n");
      System.out.print("Enter the last name of the passenger: ");
      //searching for passenger
      String last = kb.nextLine();
      Passenger p = (Passenger)myTrain.search(last);
      if(p == null)
         System.out.println("Passenger not found");
      else
        System.out.println("Here is the info for the passenger: "+p);   
      //deleting passenger
      System.out.println("\nTesting the delete method");
      System.out.print("Enter the last name of the passenger: ");
      last = kb.nextLine();
      boolean delete = myTrain.delete(last);
      if(delete)
         System.out.println("Passenger  "+ last+ " has been removed from the list");
      else
        System.out.println("Passenger not found"); 
        //updated list
      System.out.println("\nHere is the updated list");
      System.out.println(myTrain); 
      
      System.out.println("This train has " + Train.getCount() + " passengers");
      

      }
  }    
 