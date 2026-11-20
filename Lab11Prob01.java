import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
* File: PAssign08.java
* Class: CSCI 1302
* Author: Asia Hayden, Jeremiah Calvert, Alexander Avendano
* Created on: 11/20/26
* Last Modified: 11/120/26
* Description: Binary IO
*/

public class Lab11Prob01 {

	public static void main(String[] args) {
		// Write binary file to console
		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"))) {
			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String address = input.readUTF();
				int zip = input.readInt();
				double salary = input.readDouble();

				System.out.printf("%d %s %s %d %,.2f%n", age,
						name, address, zip, salary);
				
				// Copies file to new file
				output.writeInt(age);
				output.writeUTF(name);
				output.writeUTF(address);
				output.writeInt(zip);
				output.writeDouble(salary);
			}
		} catch (EOFException e) {

		} catch (IOException e) {
			System.out.println("Error");

		}

	}

}
