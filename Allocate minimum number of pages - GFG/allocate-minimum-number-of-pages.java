//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    public static int solve(int []arr , int mid){
        int students = 1;
        int sum =0;
        for(int i=0;i<arr.length;i++){
            if(sum + arr[i] <= mid){
                sum+=arr[i];
            }
            else{
                students+=1;
                sum=arr[i];
            }
        }
        return students;
    }
    public static int findPages(int[]A,int N,int M)
    {
        if(N < M){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=A[i];
            if(A[i]>max){
                max=A[i];
            }
        }
        
        int lo=max;
        int hi=sum;
        
        while(hi>=lo){
            int mid=lo+(hi-lo)/2;
            int students = solve(A,mid);
            // if(students == M){
            //     return mid;
            // }
           if(students <= M){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return lo;
    }
};