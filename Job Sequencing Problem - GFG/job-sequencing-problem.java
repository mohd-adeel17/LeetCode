//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution

{
    
    // public class Arcomparator implements Comparator<Job>{
    //     public int compare(Job o1, Job o2){
    //         if(o1.profit == o2.profit){
    //             return o1.deadline - o2.deadline;
    //         }
    //         return o2.profit - o1.profit;
    //     }
    // }
    int[] JobScheduling(Job arr[], int n)
    {
        //Arcomparator cm = new Arcomparator();
        Arrays.sort(arr,(a,b)->(b.profit - a.profit));
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].deadline > max){
                max=arr[i].deadline;
            }
        }
        int []res = new int [max+1];
        for(int i=0;i<=max ; i++){
            res[i]=-1;
        }
        int jobd=0;
        int pr=0;
        
        for(int i=0;i<arr.length;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(res[j]==-1){
                    pr+=arr[i].profit;
                    jobd+=1;
                    res[j]=arr[i].id;
                    break;
                    
                }
            }
        }
        int ans[]={jobd,pr};
        return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/