//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix

class Solution {
    public static void solve(int i,int j,int[][] m, ArrayList<String>list,int [][]vis,int n,String s){
        
        if (i==n-1 && j==n-1 ){
            list.add(s);
            return;
        }
        if (j > 0 && m[i][j-1]==1 && vis[i][j-1]==-1){
            vis[i][j]=1;
            solve(i,j-1,m,list,vis,n,s+"L");
            vis[i][j]=-1;
        }
        if (j < n-1 && m[i][j+1]==1 && vis[i][j+1]==-1){
             vis[i][j]=1;
            solve(i,j+1,m,list,vis,n,s+"R");
            vis[i][j]=-1;
        }
        if (i > 0 && m[i-1][j]==1 && vis[i-1][j]==-1){
            vis[i][j]=1;
            solve(i-1,j,m,list,vis,n,s+"U");
            vis[i][j]=-1;
        }
        if (i < n-1 && m[i+1][j]==1 && vis[i+1][j]==-1){
             vis[i][j]=1;
            solve(i+1,j,m,list,vis,n,s+"D");
            vis[i][j]=-1;
        }



    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here

        ArrayList<String>list = new ArrayList<>();
        int vis[][]= new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=-1;
            }
        }
        if(m[0][0]==0 || m[n-1][n-1]==0){
            list.add("-1");
            return list;

        }
        solve(0,0,m,list,vis,n,"");
        return list;


    }
}