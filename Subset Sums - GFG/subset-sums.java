//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java

class Solution{
    public void solve(int i,ArrayList<Integer> arr,ArrayList<Integer>list,int N,int sum){
        if(i==N){
            list.add(sum);
            return;
        }

        solve(i+1,arr,list,N, sum+arr.get(i));
        //sum-=arr.get(i);
        solve(i+1,arr,list,N,sum);



    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer>list = new ArrayList<>();
        solve(0,arr,list,N,0);
        return list;

    }
}