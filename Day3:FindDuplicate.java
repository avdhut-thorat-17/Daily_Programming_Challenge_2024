import java.util.Arrays;

class FindDuplicate{
    // Brute force
    // time : O(n^2)
    // space : O(1)
    public int countFreq(int []arr,int n){
        for(int i=1;i<=n;i++){
            int freq = 0;
            for(int j=0;j<n;j++){
                if(arr[j] == i) freq++;
            }
            if(freq > 1){
                return i;
            }
        }
        return -1;
    }

    // slightly optimised
    // time : O(nlogn + n)
    // space : O(1);
    public int sort(int[] arr,int n){
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            if(arr[i] == arr[i+1]) return arr[i];
        }
        return -1;
    }

    // optimal way
    // time : O(n) 
    // space : O(1)
    public int findDup(int []arr,int n){
        for(int i=0;i<n;i++){
            int idx = Math.abs(arr[i]);
            if(arr[idx] < 0){
                return idx;
            }
            arr[idx] = -arr[idx];
        }
        return -1;
    }
    public static void main(String args[]){
        FindDuplicate obj = new FindDuplicate();
        int [] arr = {3,1,3,4,2};
        System.out.println("Dup is : " + obj.countFreq(arr,5));
        System.out.println("Dup is : " + obj.sort(arr,5));
        System.out.println("Dup is : " + obj.findDup(arr,5));
    }
}