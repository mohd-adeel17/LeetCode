//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int solve (int i, int j, int Matrix[][],int [][]dp ){
        if(j<0 || j>=Matrix[0].length){
            return Integer.MIN_VALUE;
        }
        if(i==Matrix.length-1){
            return Matrix[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int s =Matrix[i][j]+solve(i+1,j,Matrix,dp);
        int t = Matrix[i][j]+solve(i+1,j-1,Matrix,dp);
        int u = Matrix[i][j]+solve(i+1,j+1,Matrix,dp);
        
        
        return dp[i][j] = Math.max(s,Math.max(t,u));

    }
    static int maximumPath(int N, int Matrix[][])
    {
        int m=Matrix.length;
        int n=Matrix[0].length;
        int dp[][]=new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
               }
           }

        int max = -1;
        for(int i=0;i<Matrix[0].length;i++){
            int ans =  solve (0, i, Matrix,dp);
            max = Math.max(ans,max);
        }
        return max;
    }
}