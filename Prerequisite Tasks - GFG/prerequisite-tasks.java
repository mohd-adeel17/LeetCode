//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new  ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int []indeg = new int [N];
        for(int i=0;i<N;i++){
            for(Integer val : adj.get(i)){
                indeg[val]++;
            }
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int ct=0;
        int j=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ct++;
            for(Integer val : adj.get(node)){
                indeg[val]--;
                if(indeg[val]==0){
                    q.add(val);
                }
            }
        }
        //System.out.println(Arrays.toString(ans));
        if(ct==N){
            return true;
        }
        return false;
    }
    
}