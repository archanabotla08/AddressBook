package com.blz.addressbook;

public class AddressBook {

	public String firstName;
	public String lastName;
	public String address;
	public String city;
	public String zip;
	public String phoneNumber;
	public String email;
	
	public AddressBook(String firstName,String lastName,String address,String city,String zip,String phoneNumber,String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	public void display() {
		System.out.println("First Name: " + firstName + "\n" +
							"Last Name: " + lastName + "\n" +
							"Address: " + address + "\n" +
							"City: " + city +"\n" +
							"Zip: " + zip +"\n"+
							"PhoneNumber: " + phoneNumber + "\n" +
							"Email: " + email );
	}
	public static void main(String[] args) {
		
		AddressBook ab = new AddressBook("Sweety", "Botla", "Somesh Colony Nanded", "Nanded", "431552", "9898787621", "abc@gmail.com");
		ab.display();
	}

}
