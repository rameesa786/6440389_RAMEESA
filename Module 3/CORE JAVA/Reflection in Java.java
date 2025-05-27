//Example
import java.lang.reflect.Method;

public class ReflectionExample {

    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        try {
            // Load the ReflectionExample class at runtime
            Class<?> cls = Class.forName("ReflectionExample");

            // Create an instance of ReflectionExample
            Object obj = cls.getDeclaredConstructor().newInstance();

            // Get all declared methods of the class
            Method[] methods = cls.getDeclaredMethods();

            System.out.println("Methods in ReflectionExample:");
            for (Method method : methods) {
                System.out.println("- " + method.getName());
            }

            // Get the sayHello method that takes a String parameter
            Method method = cls.getDeclaredMethod("sayHello", String.class);

            // Invoke the sayHello method dynamically on the object with argument "Alice"
            method.invoke(obj, "Alice");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
