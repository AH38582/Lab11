import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob02 {

	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();

		// Write binary file to console
		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));) {

			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String address = input.readUTF();
				int zip = input.readInt();
				double salary = input.readDouble();

				people.add(new Person(age, name, address, zip, salary));

			}
		} catch (EOFException e) {
			Collections.sort(people);
			try (DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-salary-sorted.dat"))) {
				for (int i = 0; i < people.size(); i++) {
					System.out.print(people.get(i));

					// Copies file to new file
					output.writeInt(people.get(i).getAge());
					output.writeUTF(people.get(i).getName());
					output.writeUTF(people.get(i).getAddress());
					output.writeInt(people.get(i).getZip());
					output.writeDouble(people.get(i).getSalary());
				}
			} catch (EOFException f) {

			} catch (IOException f) {

			}
		} catch (IOException e) {
			System.out.println("Error");

		}

	}

}
