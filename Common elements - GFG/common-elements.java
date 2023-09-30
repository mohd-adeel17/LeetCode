//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
  
        // Create a new LinkedHashSet
        Set<T> set = new LinkedHashSet<>();
  
        // Add the elements to set
        set.addAll(list);
  
        // Clear the list
        list.clear();
  
        // add the elements of set
        // with no duplicates to the list
        list.addAll(set);
  
        // return the list
        return list;
    }
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        ArrayList<Integer>list = new ArrayList<>();
        
        // for(int i=0;i<A.length;i++){
        //     int x = A[i];
        //     int flag=0;
        //     int lo =0;int hi=B.length-1;
        //     while(hi>=lo){
        //         int mid = lo+(hi-lo)/2;
        //         if(B[mid]==x){
        //             flag=1;
        //         }
        //         else if(B[mid]>x){
        //             lo=mid-1;
                    
        //         }
        //         else{
        //             hi=mid+1;
        //         }
        //     }
            
        //     int flag1=0;
        //     int lo1 =0;int hi1=C.length-1;
        //     while(hi1>=lo1){
        //         int mid = lo1+(hi1-lo1)/2;
        //         if(C[mid]==x){
        //             flag1=1;
        //         }
        //         else if(C[mid]>x){
        //             lo1=mid-1;
                    
        //         }
        //         else{
        //             hi1=mid+1;
        //         }
        //     }
            
        //     if(flag==1 && flag1==1){
        //         list.add(x);
        //     }
        //}
        
        int i=0;int j=0;int k=0;
        while(i<A.length && j<B.length && k<C.length){
            int max = Math.max(A[i],Math.max(B[j],C[k]));
            if(A[i]<max){i++;}
            if(B[j]<max){j++;}
            if(C[k]<max){k++;}
            
            if(i<A.length && j<B.length && k<C.length && A[i]==B[j] && B[j]==C[k]){
                list.add(A[i]);
                i++;
                j++;
                k++;
            }
        }
        ArrayList<Integer>
            newList = removeDuplicates(list);
        return newList;
    }
}