//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int solve (int i,int W,int val[],int wt[],int [][]dp){
        if(i==0){
            if(W >= wt[0] ){
                return (val[i]) * (W/wt[i]);
            }
            return 0;
        }
        
        if(dp[i][W] != -1){
            return dp[i][W];
        }
        
        int take = 0;
        if(wt[i]<=W){
            take = val[i] + solve (i,W-wt[i],val,wt,dp);
        }
        int nottake = solve (i-1,W,val,wt,dp);
        
        return dp[i][W] = Math.max(take,nottake);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int dp [][]= new int [N][W+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<=W;j++){
                dp[i][j]=0;
            }
        }
        for(int k = 0;k<=W;k++){
            if(k >= wt[0] ){
                dp[0][k] = (int)(val[0]) * (k/wt[0]);
            }
            // dp[0][k] = 0;
        }
        
        for(int i=1;i<N;i++){
            for(int j=0;j<=W;j++){
                int take = 0;
                if(wt[i]<=j){
                take = val[i] + dp[i][j-wt[i]];
                }
                int nottake = dp[i-1][j];
                dp[i][j] = Math.max(take,nottake);
            }
        }
        // for(int i=0;i<N;i++){
        //     for(int j=0;j<=W;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        
        
        return dp[N-1][W];
        
        
        
      // return solve (N-1 , W, val,wt,dp);
    }
}