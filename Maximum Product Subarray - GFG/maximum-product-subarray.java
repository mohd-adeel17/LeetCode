//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long product=1;
        long max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(product==0){
                product=1;
            }
            product=product*arr[i];
            max=Math.max(product,max);
        }
        long product1=1;
        long max1 = Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            if(product1==0){
                product1=1;
            }
            product1=product1*arr[i];
            max1=Math.max(product1,max1);
        }
        return Math.max(max,max1);
    }
}