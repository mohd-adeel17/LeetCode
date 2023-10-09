//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{
    public int solve(int i,int coins[],int V,int dp [][]){
        if(i == 0){
            if(V % coins[0] == 0){
                return V/coins[0];
            }
            else{
                return (int)1e9;
            }
        }
        if(dp[i][V]!=-1){
            return dp[i][V];
        }
        
        int take = Integer.MAX_VALUE;
        if(coins [i] <= V){
            take = 1 + solve(i , coins, V-coins[i],dp);
        }
        int nottake = solve(i-1 , coins , V,dp);
        
        return dp[i][V]= Math.min(take,nottake);
    }

	public int minCoins(int coins[], int M, int V) 
	{ 
	    int dp [][]= new int [M][V+1];
	    for(int i=0;i<M;i++){
	        for(int j=0;j<=V;j++){
	            dp[i][j]=-1;
	        }
	    }
	    
	    int ans = solve(M-1,coins,V,dp);
	    if(ans >= (int)1e9){
	        return -1;
	    }
	    return ans;
	} 
}