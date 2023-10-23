//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int max =0;
     public int solve(int i,int j,String s1,String s2,int dp[][]){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans =0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans = 1 + solve(i+1,j+1,s1,s2,dp);
        }
        
        solve(i+1,j,s1,s2,dp);
        solve(i,j+1,s1,s2,dp);
        max = Math.max(ans,max);
        return dp[i][j] = ans;
        
        
        
    }
    int longestCommonSubstr(String text1, String text2, int n, int m){
        // int m=text1.length();
        // int n=text2.length();
        int dp[][]=new int [n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        
        solve (0,0,text1,text2,dp);
        // for(int i=0;i<=n;i++){
        //     dp[i][0]=0;
        // }
        // for(int i=0;i<=m;i++){
        //     dp[0][i]=0;
        // }
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(text1.charAt(i-1)==text2.charAt(j-1)){
        //             dp[i][j]= 1 + dp[i-1][j-1];
        //             max = Math.max(max,dp[i][j]);
        //         }
        //         else{dp[i][j]= 0;}
        //     }
        // }
        
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         max = Math.max(max,dp[i][j]);
        //     }
        // }
        
        
        
        return max;
    }
}