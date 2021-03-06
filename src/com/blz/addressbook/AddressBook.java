package com.blz.addressbook;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {

	public static List<PersonDetails> addressBookList = new ArrayList<>();
	public static List<AddressBookRecord> bookNameList = new ArrayList<>();
	public static Map<Integer, String> booksList = new HashMap<>();
	public static Map<String, String> personByCity = new HashMap<>();
	List<PersonDetails> sortWithPersonName = new ArrayList<PersonDetails>();
	List<PersonDetails> sortByCity = new ArrayList<PersonDetails>();
	boolean result;
	public long count;
	Scanner sc = new Scanner(System.in);

	public void display() {
		Iterator itr = addressBookList.iterator();
		if (addressBookList.isEmpty()) {
			System.out.println("No Enteries");
		} else {
			while (itr.hasNext()) {
				PersonDetails object_1 = (PersonDetails) itr.next();
				System.out.println("\n" + "First Name: " + object_1.firstName + "\n" + "Last Name: " + object_1.lastName
						+ "\n" + "Address: " + object_1.address + "\n" + "City: " + object_1.city + "\n" + "Zip: "
						+ object_1.zip + "\n" + "PhoneNumber: " + object_1.phoneNumber + "\n" + "Email: "
						+ object_1.email);
			}
		}
	}

	public void addPerson() {
		System.out.println("Enter person details : " + "\n");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first Name : ");
		String firstName = sc.next();
		System.out.print("Enter last Name : ");
		String lastName = sc.next();
		System.out.print("Enter Address : ");
		String address = sc.next();
		System.out.print("Enter City : ");
		String city = sc.next();
		System.out.print("Enter Zip : ");
		String zip = sc.next();
		System.out.print("Enter PhoneNumber : ");
		String phoneNumber = sc.next();
		System.out.print("Enter Email Id : ");
		String email = sc.next();

		PersonDetails addPerson = new PersonDetails(firstName, lastName, address, city, zip, phoneNumber, email);
		addressBookList.add(addPerson);
		System.out.print("Person is Added Successfully");
		display();
	}

	public void editPerson() {
		if (addressBookList.isEmpty()) {
			System.out.println("No Enteries in Address Book");
			addressBookCRUDOperationChoice();
		} else {

			for (PersonDetails i : addressBookList) {
				System.out.println(addressBookList.indexOf(i) + " : " + i.getFirstName());
			}

			System.out.println("Enter the firstName  and index to edit that person details : ");
			String editPerson = sc.next();
			int index = sc.nextInt();
			while (true) {
				System.out.println("Enter Choice to edit the details : " + "1: lastName " + "2: address " + "3: city "
						+ "4: zip " + "5: phoneNumber " + "6: email " + "7: exit");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter LastName: ");
					String lastName = sc.next();
					addressBookList.get(index).setLastName(lastName);
					display();
					break;
				case 2:
					System.out.println("Enter Address: ");
					String address = sc.next();
					addressBookList.get(index).setAddress(address);
					display();
					break;
				case 3:
					System.out.println("Enter City: ");
					String city = sc.next();
					addressBookList.get(index).setCity(city);
					break;
				case 4:
					System.out.println("Enter Zip: ");
					String zip = sc.next();
					addressBookList.get(index).setZip(zip);
					;
					break;
				case 5:
					System.out.println("Enter PhoneNumber: ");
					String phoneNumber = sc.next();
					addressBookList.get(index).setPhoneNumber(phoneNumber);
					break;
				case 6:
					System.out.println("Enter Email: ");
					String email = sc.next();
					addressBookList.get(index).setEmail(email);
					break;
				case 7:
					addressBookCRUDOperationChoice();
				default:
					System.out.println("InValid Choice !!!!");
					editPerson();
				}

			}

		}
	}

	public void deletePerson() {
		if (addressBookList.isEmpty()) {
			System.out.println("No Enteries in Address Book : Delete Invalid");
			addressBookCRUDOperationChoice();
		} else {
			for (PersonDetails i : addressBookList) {
				System.out.println(addressBookList.indexOf(i) + " : " + i.getFirstName());
			}
			System.out.println("Enter the firstName to delete that person details : ");
			String deletePerson = sc.next();
			for (int i = 0; i < addressBookList.size(); i++) {
				if (addressBookList.get(i).getFirstName().equals(deletePerson)) {
					addressBookList.remove(addressBookList.get(i));
				}
			}
			System.out.println("Deleted Successfully: " + " : " + deletePerson);
			addressBookCRUDOperationChoice();
		}

	}

	public void addMultiplePersons() {
		System.out.println("Enter the Number of Persons to add : ");
		int number = sc.nextInt();
		for (int i = 1; i <= number; i++) {
			addPerson();
		}
		System.out.println("Number of Persons " + number + " Add Successfully");
		addressBookCRUDOperationChoice();
	}

	public void addressBookCRUDOperationChoice() {

		int choice;
		System.out.println("Menu Item: " + "\n" + "1: Add Person" + "\n" + "2: Display " + "\n" + "3: Edit person"
				+ "\n" + "4: Delete Person" + "\n" + "5: Add Multiple Persons " + "\n" + "6: Add Address Book " + "\n"
				+ "7: Display Address Book Record " + "\n" + "8: Search By City " 
				+"\n"+"9: get Persons by city "+ "\n"+
				"10: Get Count Of Persons By City " + "\n"+
				"11: Sort the Adress Book person's Name Order" + "\n" +
				"12: Sort the Address Book of Persons By City"+"\n" +"13: Exit");
		while (true) {
			System.out.println("Enter the choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addPerson();
				break;
			case 2:
				display();
				break;
			case 3:
				editPerson();
			case 4:
				deletePerson();
			case 5:
				addMultiplePersons();
			case 6:
				addAddressBook();
			case 7:
				displayAddressBookRecord();
			case 8:
				searchByCityToAddressBook();
			case 9:
				getPersonByCityToAddressBook();
			case 10:
				getCountOfPersonsByCityToAddressBook();
			case 11:
				sortByAlphabeticalPersonNameToAddressBook();
			case 12:
				sortByCityToAddressBook();
			case 13:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}

		}
	}

	public void addAddressBook() {
		System.out.println("Enter the Address Book Id and Name : ");
		int id = sc.nextInt();
		String name = sc.next();
		AddressBookRecord books = new AddressBookRecord(id, name);

		if (bookNameList.isEmpty()) {
			System.out.println("check");
			bookNameList.add(books);
			booksList.put(id, name);
			System.out.println("Address Book Added Successfully: ");
			for (AddressBookRecord i : bookNameList) {
				System.out.println(i.bookName);
			}
		} else {
			for (int i = 0; i < bookNameList.size(); i++) {
				if (bookNameList.get(i).getBookName().equals(name)) {
					result = bookNameList.get(i).getBookName().equals(name);
					System.out.println("Address Book Already Exists");
					break;
				}
			}
			if (!result) {
				bookNameList.add(books);
				booksList.put(id, name);
				System.out.println("Address Book Added Successfully: ");
			}

		}

		addressBookCRUDOperationChoice();

	}

	public void displayAddressBookRecord() {
		for (Map.Entry m : booksList.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}
	public void searchByCityToAddressBook() {
		System.out.println("Enter the city to search");
		String city = sc.next();
		addressBookList.stream().filter(element -> element.getCity().equals(city)).forEach(i->System.out.println("Match Found : "+i.firstName));
		addressBookCRUDOperationChoice();
	}
	public void getPersonByCityToAddressBook() {
		System.out.println("Enter the city: ");
		String searchedCity = sc.next();
		addressBookList.stream().filter(element -> element.getCity().equals(searchedCity)).forEach(i-> personByCity.put(i.getFirstName(), searchedCity));
		for (Map.Entry m : personByCity.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}
		addressBookCRUDOperationChoice();
	}
	public void getCountOfPersonsByCityToAddressBook() {
		System.out.println("Enter the city to ");
		String city = sc.next();
		
	    count = addressBookList.stream().filter(element -> element.getCity().equals(city)).count();
		System.out.println("Number of Persons By City : " + count);
		addressBookCRUDOperationChoice();
	}
	public void sortByAlphabeticalPersonNameToAddressBook() {
		
		if(addressBookList.isEmpty()) {
			System.out.println("Address Book List is Empty Cannot Sort");
		}else {
			sortWithPersonName = addressBookList.stream().sorted(Comparator.comparing(PersonDetails::getFirstName)).collect(Collectors.toList());
			System.out.println("List Sorted Successfully" + sortWithPersonName );
		}
		addressBookCRUDOperationChoice();
	}
	public void sortByCityToAddressBook() {
		if(addressBookList.isEmpty()) {
			System.out.println("Address Book List is Empty Cannot Sort");
		}else {
			sortByCity = addressBookList.stream().sorted(Comparator.comparing(PersonDetails::getCity)).collect(Collectors.toList());
			System.out.println("List Sorted Successfully" + sortByCity );
		}
		addressBookCRUDOperationChoice();
	}
	public static void main(String[] args) {

		AddressBook object_1 = new AddressBook();
		object_1.addressBookCRUDOperationChoice();

	}

}
