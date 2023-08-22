//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public static class meeting {
        int start;
        int end;
        int pos;
        
        public meeting(int start,int end,int pos){
            this.start=start;
            this.end=end;
            this.pos=pos;
        }
    }
    public static class MeetComparator implements Comparator<meeting>{
        public int compare(meeting m1,meeting m2){
            if(m1.end == m2.end){
                return m1.pos-m2.pos;
            }
            return m1.end - m2.end;
        }
    }
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<meeting>list = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            list.add(new meeting(start[i],end[i],i+1));
        }
        MeetComparator cm = new MeetComparator();
        Collections.sort(list,cm);
        
        int ct=0;
        int res=list.get(0).end;
        for(int i=1;i<start.length;i++){
            if(list.get(i).start > res ){
                ct++;
                res=list.get(i).end;
            }
        }
        
        return ct+1;
        
        
    }
}
