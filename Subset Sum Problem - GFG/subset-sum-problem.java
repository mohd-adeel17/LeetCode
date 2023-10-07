//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    static Boolean sol (int i , int sum ,int arr[],Boolean [][]dp){
        if(sum==0){
            return true;
        }
        if(i==arr.length-1){
            if(arr[i]==sum){
                return true;
            }
            else{
                return false;
            }
        }
        if(dp[i][sum]!= null ){
            return dp[i][sum];
        }
        Boolean take = false;
        if(arr[i]<=sum){
            take = sol (i+1,  sum - arr[i], arr,dp);
        }
        Boolean nottake = sol (i+1,  sum , arr,dp);

        return dp[i][sum] = take ||  nottake;

    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        Boolean dp[][]= new Boolean [N][sum+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]=false;
            }
        }
        
        for(int k=0;k<N;k++){
            dp[k][0] = true;
        }
        
        if(arr[arr.length-1]<=sum)dp[arr.length-1][arr[arr.length-1]]=true;
        
        for(int i=N-2 ;i>=0;i--){
            for(int j = 0 ; j <= sum ; j++){
                
                Boolean take = false;
                if(arr[i]<=j){
                    take = dp[i+1][j - arr[i]];
                }
           
                
                Boolean nottake = dp[i+1][j] ;

              dp[i][j] = take ||  nottake;
            }
        }
        
        

        return dp[0][sum];
        
        
    }
}