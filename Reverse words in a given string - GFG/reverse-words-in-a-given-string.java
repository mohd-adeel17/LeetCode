//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        String arr[]=S.split("\\.");
         //System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length/2;i++){
            String temp = arr[i];
            arr[i]=arr[arr.length -1 -i];
            arr[arr.length -1 -i]=temp;
        }
       
        String ans="";
        for(int i=0;i<arr.length-1;i++){
            ans+=arr[i]+".";
        }
        ans+=arr[arr.length-1];
        return ans;
    }
}