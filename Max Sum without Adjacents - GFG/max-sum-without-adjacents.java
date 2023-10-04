//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int i,int[]nums,int []dp){
        if(i==0){
            return nums[i];
        }
        if(i<0){return 0;}
        if(dp[i]!=-1){
            return dp[i];
        }
        int take = nums[i] + solve(i-2,nums,dp);
        int nottake = solve(i-1,nums,dp);
        
        return dp[i]=Math.max(take,nottake);
    }
    int findMaxSum(int nums[], int n) {
        // n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        // for(int i=1;i<nums.length;i++){
        //     int pick = 0;
        //     pick = pick + nums[i];
        //     if(i>1){
        //         pick+=dp[i-2];
        //     }
        //     int notpick = dp[i-1];

        //     dp[i]=Math.max(pick,notpick);



        // }
        return solve(n-1,nums,dp);
       //return dp[n-1];
    }
}