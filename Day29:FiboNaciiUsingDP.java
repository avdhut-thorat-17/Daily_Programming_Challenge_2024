import java.util.ArrayList;

class FiboNacciUsingDP {
    static int FiboNacci(int n, ArrayList<Integer> memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo.get(n) != -1) {
            return memo.get(n);
        }
        memo.set(n, FiboNacci(n - 1, memo) + FiboNacci(n - 2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        int n = 5;
        
        // Initialize the memo ArrayList and fill it with -1
        ArrayList<Integer> memo = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            memo.add(-1);  // Use add() instead of set() to populate the ArrayList
        }
        
        // Call the Fibonacci function and print the result
        System.out.println(FiboNacci(n, memo));
    }
}