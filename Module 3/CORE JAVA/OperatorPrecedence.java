public class OperatorPrecedence {
    public static void main(String[] args) {
        // Demonstrate operator precedence
        int result1 = 10 + 5 * 2;       // Multiplication has higher precedence
        int result2 = (10 + 5) * 2;     // Parentheses alter precedence
        int result3 = 100 / 10 + 5;     // Division before addition
        int result4 = 100 / (10 + 5);   // Parentheses first

        // Display results
        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(10 + 5) * 2 = " + result2);
        System.out.println("100 / 10 + 5 = " + result3);
        System.out.println("100 / (10 + 5) = " + result4);
    }
}
