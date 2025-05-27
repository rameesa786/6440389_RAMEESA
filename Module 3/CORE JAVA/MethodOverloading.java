public class MethodOverloading {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();

        System.out.println("Sum of 2 integers: " + mo.add(10, 20));
        System.out.println("Sum of 2 doubles: " + mo.add(10.5, 20.3));
        System.out.println("Sum of 3 integers: " + mo.add(5, 10, 15));
    }
}
