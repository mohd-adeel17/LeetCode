//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    static int solve(int i,int W, int wt[], int val[],int [][]dp){
        
        if(i == wt.length-1 ){
            if(W >= wt[i] ){
                return val[i];
            }
            else{
                return 0;
            }
            
        }
        if(dp[i][W] != -1){
            return dp[i][W];
        }
        
        int take = Integer.MIN_VALUE;
        if(W >= wt[i]){
        take = val[i] + solve (i+1,W-wt[i],wt,val,dp);}
        
        int nottake = 0 + solve(i+1,W,wt,val,dp);
        
        return dp[i][W] = Math.max(take,nottake);
        
    }
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int dp[][]= new int [n][W+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<W+1;j++){
                dp[i][j]=-1;
            }
        }
        int x = solve(0, W, wt, val,dp);
        return x;
        
    } 
}


