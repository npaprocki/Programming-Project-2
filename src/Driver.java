import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		LinkedList<Address> addressBook = new LinkedList<Address>();
		readFile(addressBook);
		System.out.println(addressBook.toString());

	}

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
			System.out.println("\nFile not found!");
			e.printStackTrace();
		}

	}

}
