import java.util.Stack;

class ReverseStackUsingRecursion{
     // Function to reverse the stack
    public static void reverseStack(Stack<Integer> stack) {
        // Base case: if the stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Remove the top element
        int topElement = stack.pop();

        // Recursively reverse the remaining stack
        reverseStack(stack);

        // Insert the top element at the bottom
        insertAtBottom(stack, topElement);
    }

    // Helper function to insert an element at the bottom of the stack
    private static void insertAtBottom(Stack<Integer> stack, int element) {
        // Base case: If the stack is empty, push the element
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        // Pop the top element
        int topElement = stack.pop();

        // Recursively insert the element at the bottom
        insertAtBottom(stack, element);

        // Push the popped element back to the stack
        stack.push(topElement);
    }

    // Function to print the stack (for testing purposes)
    public static void printStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int topElement = stack.pop();
        System.out.print(topElement + " ");

        printStack(stack);

        // Push the element back to restore the original stack
        stack.push(topElement);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Input stack: [1, 2, 3, 4]
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Original Stack:");
        printStack(stack);
        System.out.println();

        // Reverse the stack
        reverseStack(stack);

        System.out.println("Reversed Stack:");
        printStack(stack);
    }
}