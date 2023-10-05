//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve (int i, int j, ArrayList<ArrayList<Integer>>grid, int ro, int col,int dp[][]){
        if(i==ro){
            return grid.get(i).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take = grid.get(i).get(j)+solve(i+1,j,grid,ro,col,dp);
        int nottake = grid.get(i).get(j)+solve(i+1,j+1,grid,ro,col,dp);
        
        return dp[i][j]= Math.min(take,nottake);

    }
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        int ro = grid.size();
        int col = grid.get(ro-1).size();
        int dp[][]= new int [ro][ro];
        for(int i=0;i<ro;i++){
            for(int j=0;j<ro;j++){
                dp[i][j]=-1;
            }
        }
        for(int j=0;j<ro;j++){
            dp[ro-1][j]=grid.get(ro-1).get(j);
        }
        
        for(int i=ro-2 ;i>=0;i--){
            for(int j=0;j<=i;j++){
                int take = grid.get(i).get(j)+dp[i+1][j];
                int nottake = grid.get(i).get(j)+dp[i+1][j+1];
        
                dp[i][j]= Math.min(take,nottake);
            }
        }
        return dp[0][0];
        // return solve(0,0,grid,ro-1,col,dp);
        // Code here
    }
}