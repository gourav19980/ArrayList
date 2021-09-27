package challenge_arrayList;

import java.util.Scanner;

public class Main {
	private static Scanner sc=new Scanner(System.in);
	private static MobilePhone mobilePhone=new MobilePhone("0003 335 4485");

	public static void main(String[] args) {
		
		boolean quit=false;
		startPhone();
		printActions();
		while(!quit) {
			System.out.println("\n Enter action:(6 to show available actions)");
			int action=sc.nextInt();
			sc.nextLine();
			switch(action) {
			case 0:
				System.out.println("\n Shutting down....");
				quit=true;
				break;
			case 1:
				mobilePhone.printContacts();
				break;
			case 2:
				addNewContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;
			case 5:
				queryContact();
				break;
			case 6:
				printActions();
				break;
			}
		}
		
	}
	
	private static void addNewContact() {
		System.out.println("Enter new contact name");
		String name=sc.nextLine();
		System.out.println("Enter phone Number");
		String phone=sc.nextLine();
		Contacts newContact=Contacts.createContact(name, phone);
		if(mobilePhone.addNewContact(newContact)) {
			System.out.println("New Contact added :"+name+" , phone ="+phone);
		}else {
			System.out.println("Cannot add, "+name+" already on file.");
		}
	}
	
	private static void updateContact() {
		System.out.println("Enter Existing contact name ");
		String name=sc.nextLine();
		Contacts exisitingContactRecord=mobilePhone.queryContact(name);
		if(exisitingContactRecord==null) {
			System.out.println("Contact not found.");
			return;
		}
		System.out.println("Enter new Contact name ");
		String newName=sc.nextLine();
		System.out.println("Enter new Contact phone Number: ");
		String newNumber=sc.nextLine();
		Contacts newContact=Contacts.createContact(newName, newNumber);
		if(mobilePhone.updateContact(exisitingContactRecord, newContact)) {
			System.out.println("Successfully updated record");
		}
		else {
			System.out.println("Error updating record");
		}
	}
	
	
	private static void removeContact() {
		System.out.println("Enter Existing contact name ");
		String name=sc.nextLine();
		Contacts exisitingContactRecord=mobilePhone.queryContact(name);
		if(exisitingContactRecord==null) {
			System.out.println("Contact not found.");
			return;
		}
		if (mobilePhone.removeContact(exisitingContactRecord)){
			System.out.println("Successfully deleted contact");
		}
		else {
			System.out.println("Error deleting contact");
		}
	}
	
	private static void queryContact() {
		System.out.println("Enter Existing contact name ");
		String name=sc.nextLine();
		Contacts exisitingContactRecord=mobilePhone.queryContact(name);
		if(exisitingContactRecord==null) {
			System.out.println("Contact not found.");
			return;
		}
		System.out.println("Name: "+exisitingContactRecord.getName()+" phone Number is "+exisitingContactRecord.getPhoneNumber());
	}
	
	private static void startPhone() {
		System.out.println("Starting phone...");
	}
	private static void printActions() {
		System.out.println("\n Available actions:\npress.");
		System.out.println("0 - to shutdown \n"+"1 - to print contacts. \n"+"2 - to add a new contact\n"+"3 - to update an existing contact\n"+
							"4- to remove an existing contact\n"+"5- query if an existing contact exists\n"+"6- to print a list of available actions.");
		System.out.println("Choose your action: ");
	}

}
