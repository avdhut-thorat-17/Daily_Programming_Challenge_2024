import java.util.HashMap;
import java.util.Map;

public class CoinChange {

    // Helper function that uses memoization to store intermediate results
    public int coinChangeRecursiveMemo(int[] coins, int amount, Map<Integer, Integer> memo) {
        // Base cases
        if (amount == 0) return 0;  // If amount is 0, no coins are needed
        if (amount < 0) return Integer.MAX_VALUE;  // If amount becomes negative, return a large value (invalid)

        // Check if the result for this amount is already computed (memoized)
        if (memo.containsKey(amount)) {
            return memo.get(amount);  // If result exists in memo, return the stored result
        }

        int minCoins = Integer.MAX_VALUE;
        
        // Try every coin to reduce the amount
        for (int coin : coins) {
            int result = coinChangeRecursiveMemo(coins, amount - coin, memo);
            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);  // Take the minimum of all possible combinations
            }
        }
        
        // Store the result for the current amount in the memoization table
        memo.put(amount, minCoins);
        
        return minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();  // Memoization table to store intermediate results
        int result = coinChangeRecursiveMemo(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;  // If no valid result found, return -1
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        
        // Example 1
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println(cc.coinChange(coins1, amount1));  // Output: 3
        
        // Example 2
        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println(cc.coinChange(coins2, amount2));  // Output: -1
        
        // Example 3
        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println(cc.coinChange(coins3, amount3));  // Output: 0
    }
}