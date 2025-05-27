import java.util.*;
import java.util.stream.Collectors;

// Define a record
record Person(String name, int age) {}

public class PersonRecordDemo {
    public static void main(String[] args) {
        // Creating instances
        List<Person> people = List.of(
            new Person("Alice", 22),
            new Person("Bob", 17),
            new Person("Charlie", 25),
            new Person("Daisy", 16)
        );

        // Print all persons
        System.out.println("All Persons:");
        people.forEach(System.out::println);

        // Filter adults (age >= 18) using streams
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 18)
                                    .collect(Collectors.toList());

        System.out.println("\nAdults (age >= 18):");
        adults.forEach(System.out::println);
    }
}
