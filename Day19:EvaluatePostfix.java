import java.util.Stack;

class EvaluatePostfix {
    public int postfix(String[] nums) {
        Stack<Integer> stk = new Stack<>();

        for (String token : nums) {
            // Check if the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Ensure there are at least two operands in the stack
                if (stk.size() < 2) {
                    throw new IllegalArgumentException("Insufficient operands for the operation.");
                }

                // Pop the two operands
                int num2 = stk.pop(); // Note: num2 is popped first
                int num1 = stk.pop(); // then num1

                // Perform the operation based on the operator
                switch (token) {
                    case "+":
                        stk.push(num1 + num2);
                        break;
                    case "-":
                        stk.push(num1 - num2);
                        break;
                    case "*":
                        stk.push(num1 * num2);
                        break;
                    case "/":
                        if (num2 == 0) {
                            throw new ArithmeticException("Cannot divide by zero.");
                        }
                        // Integer division truncating towards zero
                        int result = (num1 / num2);
                        stk.push(result);
                        break;
                }
            } else {
                // The token is a number, so parse it and push onto the stack
                try {
                    int num = Integer.parseInt(token);
                    stk.push(num);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid number: " + token);
                }
            }
        }

        // The final result should be the only item left in the stack
        if (stk.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }

        return stk.pop(); // Return the result
    }

    public static void main(String[] args) {
        EvaluatePostfix o = new EvaluatePostfix();

        // Test cases
        System.out.println("Result: " + o.postfix("42".split("\\s+"))); // Single Operand
        System.out.println("Result: " + o.postfix("-5 3 +".split("\\s+"))); // Negative Numbers
        System.out.println("Result: " + o.postfix("10 3 /".split("\\s+"))); // Integer Division
        System.out.println("Result: " + o.postfix("2 3 + 4 *".split("\\s+"))); // Multiple Operations
        System.out.println("Result: " + o.postfix("1 2 + 3 *".split("\\s+"))); // Previous Example
        System.out.println("Result: " + o.postfix("-1 -2 +".split("\\s+"))); // Negative Addition
    }
}