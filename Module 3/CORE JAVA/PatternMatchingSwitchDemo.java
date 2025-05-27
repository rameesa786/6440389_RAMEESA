public class PatternMatchingSwitchDemo {
    public static void main(String[] args) {
        Object input = 123;

        String result = switch (input) {
            case String s -> "It's a string: " + s;
            case Integer i -> "It's an integer: " + i;
            case Double d -> "It's a double: " + d;
            default -> "Unknown type";
        };

        System.out.println(result);
    }
}
