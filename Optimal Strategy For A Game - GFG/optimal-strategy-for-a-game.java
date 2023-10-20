//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}
// } Driver Code Ends




class solve
{
    //Function to find the maximum possible amount of money we can win.
    public static long solve(int[] nums, int left, int right,long dp[][]) {
        if (left > right) return 0;
        if (left == right) return nums[left];
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        long choice1 = nums[left] + Math.min(solve(nums,left+2,right,dp),solve(nums,left+1,right-1,dp));
        long choice2 = nums[right] + Math.min(solve(nums,left+1,right-1,dp),solve(nums,left,right-2,dp));

        return dp[left][right] = Math.max(choice1 , choice2);

    }
    static long countMaximum(int nums[], int n)
    {

        long dp[][]= new long [nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                dp[i][j] = -1;
            }
        }
        long jeet = solve(nums,0,nums.length-1,dp);
        return jeet;
    }
}
