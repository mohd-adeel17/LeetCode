//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        int top=0;
        int bottom = matrix.length-1;
        int left=0;
        int right = matrix[0].length-1;
        int dir = 0;
        int flagt=0;
        int flagb=0;
        int flagl=0;
        int flagr=0;
        ArrayList<Integer>list = new ArrayList<>();
        while(top <= bottom && left <= right){
            if(dir==0){
                for(int i=left ;i<=right ;i++){
                    list.add(matrix[top][i]);
                     
                    
                }
                top++;
                flagt=1;
            }
            if(dir==1){
                for(int i=top ;i<=bottom ;i++){
                    list.add(matrix[i][right]);
                   
                    
                }
                right--;
                flagr=1; 
            }
            if(dir==2){
                for(int i=right ;i>=left ;i--){
                    list.add(matrix[bottom][i]);
                    
                }
                bottom--;
                flagb=1; 
                    
            }
            if(dir==3){
                for(int i=bottom ;i>=top ;i--){
                    list.add(matrix[i][left]);
                   
                }
                left++;
                flagl=1; 
            }
            dir = (dir+1)%4;
            
            if(flagt==1 && flagb==1 && flagr==1 && flagl==1){
                break;
            }
        }
        return list;
    }
}
