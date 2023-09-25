//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]arr = new int[n][m];
            
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    arr[i][j] = sc.nextInt ();

    		System.out.println (new Sol().maxOnes (arr, n, m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int maxOnes (int Mat[][], int N, int M)
    {
        int ans = -1;
        int ind=-1;
        for(int i=0;i<N;i++){
            int ct=0;
            int lo=0;int hi=M-1;
            while(hi>=lo){
                int mid = lo+(hi-lo)/2;
                if(Mat[i][mid] < 1){
                    lo=mid+1;
                }
                else{
                    hi=mid-1;
                }
            }
            ct=M-lo+1;
            if(ct>ans){
                ans=ct;
                ind=i;
            }
            
        }
        return ind;
    }
    
}