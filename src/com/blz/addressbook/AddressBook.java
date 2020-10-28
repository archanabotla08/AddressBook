package com.blz.addressbook;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class AddressBook {
	
	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String zip;
	public String phoneNumber;
	public String email;
	
	public static List<AddressBook> addressBookList = new ArrayList<>();
	public AddressBook() {
		
	}
	public AddressBook(String firstName,String lastName,String address,String city,String zip,String phoneNumber,String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setAddressName(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getZip() {
		return zip;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	
	public  void display() {
		Iterator itr=addressBookList.iterator();//getting the Iterator  
		while(itr.hasNext()){//check if iterator has the elements  
			  AddressBook object_1=(AddressBook)itr.next();   
		System.out.println("\n"+ "First Name: " + object_1.firstName + "\n" +
							"Last Name: " + object_1.lastName + "\n" +
							"Address: " + object_1.address + "\n" +
							"City: " + object_1.city +"\n" +
							"Zip: " + object_1.zip +"\n"+
							"PhoneNumber: " + object_1.phoneNumber + "\n" +
							"Email: " + object_1.email );
		  } 
	}
	public void addPerson() {
		System.out.println("Enter person details : " + "\n");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first Name : ");
		setFirstName(sc.next());
		System.out.print("Enter last Name : ");
		setLastName(sc.next());
		System.out.print("Enter Address : ");
		setAddressName(sc.next());
		System.out.print("Enter City : ");
		setCity(sc.next());
		System.out.print("Enter Zip : ");
		setZip(sc.next());
		System.out.print("Enter PhoneNumber : ");
		setPhoneNumber(sc.next());
		System.out.print("Enter Email Id : ");
		setEmail(sc.next());
		
		AddressBook addPerson = new AddressBook(firstName, lastName, address, city,zip,phoneNumber,email);
		addressBookList.add(addPerson);
		System.out.print("Person is Added Successfully");
		display();
	}
	
	public void addressBookCRUDOperationChoice() {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("Menu Item: " + "\n" + "1: Add Person" + "\n" +"2: Display " +"\n"+"3: Exit");
		System.out.println("Enter the choice");
		choice = sc.nextInt();
		switch(choice) {
		case 1: 
			addPerson();
			break;
		case 2:
			display();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
	}
	public static void main(String[] args) {
		
		AddressBook object_1 = new AddressBook("Sweety", "Botla", "Somesh Colony Nanded", "Nanded", "431552", "9898787621", "abc@gmail.com");
		addressBookList.add(object_1);
		object_1.addressBookCRUDOperationChoice();
				
	}

}
