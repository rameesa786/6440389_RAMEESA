public class TypeCastingExample {
    public static void main(String[] args) {
        // Declare a double and cast it to int
        double doubleValue = 9.78;
        int intValue = (int) doubleValue; // Explicit casting

        // Declare an int and cast it to double
        int anotherInt = 15;
        double anotherDouble = anotherInt; // Implicit casting

        // Display the results
        System.out.println("Original double value: " + doubleValue);
        System.out.println("After casting to int: " + intValue);

        System.out.println("Original int value: " + anotherInt);
        System.out.println("After casting to double: " + anotherDouble);
    }
}
