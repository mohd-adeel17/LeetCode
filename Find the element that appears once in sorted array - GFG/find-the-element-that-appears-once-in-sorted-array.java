//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        int lo=0;
        int hi=n-1;
        while(hi>=lo){
            int mid = lo+(hi-lo)/2;
            if(mid%2==1){
                if(mid >0 && arr[mid]==arr[mid-1]){
                    lo=mid+1;
                }
                else{
                    hi=mid-1;
                }
            }
            else{
                if(mid>0 && arr[mid]==arr[mid-1]){
                    hi=mid-1;
                }
                else{
                    lo=mid+1;
                }
            }
        }
        return arr[hi];
    }
}