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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int solve(int []arr , long mid){
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
    static long minTime(int[] arr,int n,int k){

        long max = Integer.MIN_VALUE;
        long sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(arr[i]>max){
                max=arr[i];
            }
        }

        long lo=max;
        long hi=sum;

        while(hi>=lo){
            long mid=lo+(hi-lo)/2;
            int students = solve(arr,mid);
            // if(students == M){
            //     return mid;
            // }
            if(students <= k){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return lo;
    }
}


