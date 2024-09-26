import java.util.List;
import java.util.ArrayList;
class PrimeFactorization{
    public void factors(List<Integer>fact,int n){
        int f = 2;
        while(n != 1){
            if(n % f == 0){
                fact.add(f);
                n = n/f;
            }else{
                f++;
            }
        }
    }
    public void factorsOptimised(List<Integer> fact, int n) {
        // Check for the number of 2's in the factorization
        while (n % 2 == 0) {
            fact.add(2);
            n /= 2;
        }

        // Check for odd factors from 3 up to sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                fact.add(i);
                n /= i;
            }
        }

        // If n is still greater than 1, it must be a prime number
        if (n > 1) {
            fact.add(n);
        }
    }

    public static void main(String[] args){
        List<Integer>fact = new ArrayList<>();
        PrimeFactorization o = new PrimeFactorization();
        o.factors(fact,123456);
        for(int i=0;i<fact.size();i++){
            System.out.println(fact.get(i) + "\n");
        }
    }
}