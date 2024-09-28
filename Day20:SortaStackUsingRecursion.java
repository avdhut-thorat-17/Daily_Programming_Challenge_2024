import java.util.Stack;

public class sortStackUsingRecursion {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case: If stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Remove the top element
        int topElement = stack.pop();

        // Recursively sort the remaining stack
        sortStack(stack);

        // Insert the top element back in sorted order
        insertInSortedOrder(stack, topElement);
    }

    // Helper function to insert an element in a sorted stack
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // Base case: If the stack is empty or the top element is smaller than the element to be inserted
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Remove the top element
        int topElement = stack.pop();

        // Recursively insert the element in sorted order
        insertInSortedOrder(stack, element);

        // Push the popped element back
        stack.push(topElement);
    }

    // Function to print the stack
    public static void printStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int topElement = stack.pop();
        System.out.print(topElement + " ");

        printStack(stack);

        // Push the popped element back
        stack.push(topElement);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Input stack: [3, 1, 4, 2]
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack:");
        printStack(stack);
        System.out.println();

        // Sort the stack
        sortStack(stack);

        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}