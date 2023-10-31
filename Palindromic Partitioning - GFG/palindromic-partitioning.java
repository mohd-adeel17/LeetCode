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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static boolean check(int i,int j,String s){
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    public static int solve(int i,String s,int []dp){
        if(i == s.length()){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int cost=0;
        int maxi=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if (check(i,j,s)==true){
                cost = 1 + solve(j+1,s,dp);
                maxi = Math.min(maxi,cost);
            }
        }
        return dp[i]= maxi;
    }
    static int palindromicPartition(String str)
    {
        int dp[]= new int [str.length()];
        for(int i=0;i<str.length();i++){
            dp[i]=-1;
        }
        return solve(0,str,dp)-1;
    }
}