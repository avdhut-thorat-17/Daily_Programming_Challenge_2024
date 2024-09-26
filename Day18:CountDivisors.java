import java.util.Scanner;

public class CountDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer N: ");
        int N = scanner.nextInt();
        System.out.println("Total number of divisors of " + N + " is: " + countDivisors(N));
    }

    public static int countDivisors(int N) {
        int count = 0;
        int sqrtN = (int) Math.sqrt(N);
        
        for (int i = 1; i <= sqrtN; i++) {
            if (N % i == 0) {
                count++; // Count i as a divisor
                if (i != N / i) {
                    count++; // Count N/i as a divisor if it's different
                }
            }
        }
        
        return count;
    }
}