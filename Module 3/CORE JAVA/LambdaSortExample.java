import java.util.*;

public class LambdaSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("John");
        names.add("Aman");
        names.add("Bella");

        System.out.println("Before sorting:");
        names.forEach(System.out::println);

        // Sort using lambda expression
        Collections.sort(names, (s1, s2) -> s1.compareToIgnoreCase(s2));

        System.out.println("\nAfter sorting:");
        names.forEach(System.out::println);
    }
}
