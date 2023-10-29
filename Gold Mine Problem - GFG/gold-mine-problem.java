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
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int solve(int i,int j,int[][] grid,int[][]vis,int[][]dp){
        if(i<0 || j < 0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0 ){
            return 0;
        }
        int downright = 0;
        int upright = 0;
        int right = 0;
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = grid[i][j];
        if(i<grid.length-1 && j<grid[0].length-1 && grid[i+1][j+1]!=0 && vis[i+1][j+1]==0){
            vis[i][j]=1;
            downright = solve(i+1,j+1,grid,vis,dp);
            vis[i][j]=0;
        }
        if(i>0 && j<grid[0].length-1 && grid[i-1][j+1]!=0 && vis[i-1][j+1]==0){
            vis[i][j]=1;
            upright = solve(i-1,j+1,grid,vis,dp);
            vis[i][j]=0;
        }
        if(j<grid[0].length-1 && grid[i][j+1]!=0 && vis[i][j+1]==0){
            vis[i][j]=1;
            right = solve(i,j+1,grid,vis,dp);
            vis[i][j]=0;
        }
        
       // System.out.println(Math.max(up,Math.max(left,Math.max(down,right))));
        return dp[i][j]= ans+ Math.max(right,Math.max(upright,downright));
    }
    public static int maxGold(int n, int m, int grid[][])
    {
        int maxi = Integer.MIN_VALUE;
        int vis[][]= new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                vis[i][j]=0;
            }
        }
        int dp[][]= new int [grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] != 0){
                    maxi=Math.max(maxi,solve(i,j,grid,vis,dp));
                }
            }
        }
        if(maxi == -2147483648){
            return 0;
        }
        return maxi;
    }
}