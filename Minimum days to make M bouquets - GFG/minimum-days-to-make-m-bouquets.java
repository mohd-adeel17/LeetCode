//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static boolean search(int []arr , int M , int K,int mid){
        int buk=0;
        int ct=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<= mid){
                ct++;
            }
            else {
                buk+=ct/K;
                ct=0;
            }
        }
        buk+=ct/K;
        if (buk >= M){
            return true;
        }
        return false;
    }
    public static int solve(int M, int K, int[] bloomDay) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (bloomDay.length < M*K){
            return -1;
        }
        for(int i=0;i<bloomDay.length;i++){
            min = Math.min(bloomDay[i],min);
            max = Math.max(bloomDay[i],max);
        }

        int lo = min;int hi = max;
        int ans = 0;
        while (hi>=lo){
            int mid= lo+(hi-lo)/2;
            boolean s = search (bloomDay,M,K,mid);
            if(s==true){
                ans = mid;
                hi=mid-1;
            } 
            else{
                lo = mid+1;
            }
        }
        if(ans != 0){
            return ans;
        }
        return -1;
    }
}