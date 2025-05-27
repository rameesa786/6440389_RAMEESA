import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String input;
        do {
            System.out.print("Enter student name (or type 'exit' to stop): ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("exit")) {
                studentNames.add(input);
            }
        } while (!input.equalsIgnoreCase("exit"));

        System.out.println("Student names entered:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
