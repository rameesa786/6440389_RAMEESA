import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        String choice;
        do {
            System.out.print("Enter Student ID (integer): ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            studentMap.put(id, name);

            System.out.print("Add another entry? (yes/no): ");
            choice = scanner.nextLine();

        } while (choice.equalsIgnoreCase("yes"));

        System.out.print("Enter Student ID to search: ");
        int searchId = scanner.nextInt();

        if (studentMap.containsKey(searchId)) {
            System.out.println("Student Name: " + studentMap.get(searchId));
        } else {
            System.out.println("Student ID not found.");
        }

        scanner.close();
    }
}
