//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair{
        int first ;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public void bfs (int row , int col , int vis[][] , char grid[][]){
        vis[row][col]=1;
        // Queue<Pair>q = new LinkedList<>();
        // q.add(new Pair(row , col));
        
        int m = grid.length;
        int n= grid[0].length;
        // while(!q.isEmpty()){
        //     int r = q.peek().first;
        //     int c = q.peek().second;
        //     q.remove();

            for(int i = -1 ;i<=1;i++){
                for(int j=-1 ;j<=1 ; j++){
                    int newrow = row + i;
                    int newcol = col + j;
                    if(newrow>=0 && newrow< m && newcol>=0 && newcol<n && vis[newrow][newcol]==0 && grid[newrow][newcol]=='1'){
                        vis[newrow][newcol]=1;
                        // q.add(new Pair(newrow,newcol));
                        bfs(newrow,newcol,vis,grid);
                    }
                }
            }
        
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        int vis[][]= new int [row][col];
        int ct=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    ct++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return ct;

    }
}