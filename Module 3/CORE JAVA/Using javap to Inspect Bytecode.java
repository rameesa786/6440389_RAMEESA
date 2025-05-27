// Create a class with a method and compile it, then run javap -c ClassName in terminal.

# Decompile a Class File

// Write a simple Java program, compile it, and open the .class file in a decompiler.

# Reflection in Java

import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
