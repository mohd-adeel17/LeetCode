//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int arr[], int n) {
        int lo=0;int hi=n-1;
        int ans = Integer.MAX_VALUE;
        int ind = -1;
        while(hi>=lo){
            int mid = lo+(hi-lo)/2;
            if(arr[mid] >= arr[lo]){
                ans = Math.min(ans,arr[lo]);
                if(ans == arr[lo]){
                    ind = lo;
                }
                lo=mid+1;
                
            }
            else{
                ans = Math.min(ans,arr[mid]);
                if(ans == arr[mid]){
                    ind = mid;
                }
                hi=mid-1;
                
            }
        }
        return ind;
    }
}