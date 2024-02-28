import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class: AddressBook
 * @author natepaprocki
 * @version 1.0
 * Course: CSE 274 - Spring 2024
 * Written: March 3, 2024
 * 
 * Purpose: This class runs the address book, including reading contacts from a file,
 * 			printing contacts, sorting the contacts, and printing again.
 */

public class AddressBook {
	
	/**
	 * This method reads contacts from a .txt file
	 * 
	 * @param addressBook LinkedList that stores Address objects.
	 */

	public static void readFile(LinkedList<Address> addressBook) {

		try {

			Scanner input = new Scanner(new File("addresses.txt"));

			while (input.hasNextLine()) {

				String lastName = input.nextLine();
				String firstName = input.nextLine();
				String streetAddress = input.nextLine();

				int zipcode = Integer.parseInt(input.nextLine());

				String phoneNumber = input.nextLine();

				Address newAddress = new Address(firstName, lastName, zipcode, streetAddress, phoneNumber);

				addressBook.insertLast(newAddress);

			}

		} catch (FileNotFoundException e) {
			System.out.println("\nFile not found!\n" + e.getMessage());

			System.exit(0);
		}

	}
	
	/**
	 * Main method
	 * 
	 * @param args Command line argument, not used
	 */

	public static void main(String[] args) {

		LinkedList<Address> addressBook = new LinkedList<Address>();
		readFile(addressBook);

		System.out.println("*** Unsorted List: ***");
		System.out.println(addressBook.toString());
		
		addressBook.sort();
		System.out.println("*** Sorted List: ***");
		System.out.println(addressBook.toString());

	}

}
