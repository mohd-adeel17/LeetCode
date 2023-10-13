//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String text1,String text2,int m,int n)
    {
    //   int m=text1.length();
    //     int n=text2.length();
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

        // for(int i =0;i<=m;i++){
        //     for(int j=0;j<=n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // StringBuilder sb = new StringBuilder ();
        // int k = m;
        // int l = n;
        // while(k>0 && l>0){
        //     if(text1.charAt(k-1)==text2.charAt(l-1)){
        //             sb.append(text1.charAt(k-1));
        //             k=k-1;
        //             l=l-1;
        //         }
        //         else if(dp[k-1][l] > dp[k][l-1]){
        //             sb.append(text1.charAt(k-1));
        //             k=k-1;
        //         }
        //         else {
        //             sb.append(text2.charAt(l-1));
        //             l=l-1;
        //         }
        // }

        // while(k > 0){
        //     sb.append(text1.charAt(k-1));
        //     k=k-1;
        // }
        //  while(l > 0){
        //     sb.append(text2.charAt(l-1));
        //     l=l-1;
        // }
                
        // System.out.println(sb);
        // return sb.reverse().toString();
        return m+n-dp[m][n];
    }
}