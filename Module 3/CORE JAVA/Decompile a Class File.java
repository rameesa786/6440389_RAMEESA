public class SimpleProgram {
    public void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        SimpleProgram sp = new SimpleProgram();
        sp.greet("World");
    }
}
