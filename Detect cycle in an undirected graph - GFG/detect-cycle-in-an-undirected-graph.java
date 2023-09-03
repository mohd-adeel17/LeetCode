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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair{
        int first;
        int second;

        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public boolean detectCycle(int node , ArrayList<ArrayList<Integer>> adj, int vis[] ){
        vis[node]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node,-1));

        while(!q.isEmpty()){
            int first = q.peek().first;
            int parent = q.peek().second;
            q.poll();

            for(Integer val : adj.get(first)){
                if(vis[val]==0){
                    vis[val]=1;
                    q.add(new Pair(val,first));
                }
                else if(val != parent){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis []= new int [V];

        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(detectCycle(i,adj,vis)==true){
                    return true;
                }

            }
        }
        return false;
    }
}