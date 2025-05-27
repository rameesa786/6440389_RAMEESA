import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a non-negative integer
        System.out.print("Enter a non-negative integer: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Invalid input! Number must be non-negative.");
            scanner.close();
            return;
        }

        long factorial = 1;

        // Calculate factorial using for loop
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        // Display the result
        System.out.println("Factorial of " + number + " is: " + factorial);

        scanner.close();
    }
}
