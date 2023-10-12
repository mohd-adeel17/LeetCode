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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String text1){
        StringBuilder sb = new StringBuilder(text1);
        
        String text2 = sb.reverse().toString();
        //System.out.println(text2);
        int m=text1.length();
        int n=text2.length();
        int dp[][]=new int [m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }

        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]= 1 + dp[i-1][j-1];
                }
                else{dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);}
            }
        }
        return text1.length() - dp[m][n];
    }
}