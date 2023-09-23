//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG
{
    static double medianOfArrays(int n, int m, int a[], int b[])
    {
        int med = (n+m);
        int ind2 = med/2;
        int ind1 = ind2-1;
        int ind1el=-1;
        int ind2el=-1;

        int i=0;
        int j=0;
        int ct=0;
        while(i<n && j<m){
            if(a[i] < b[j]){
                if(ct==ind1){ind1el = a[i];}
                if(ct==ind2){ind2el = a[i];}
                i++;
                ct++;
            }
            else{
                if(ct==ind1){ind1el = b[j];}
                if(ct==ind2){ind2el = b[j];}
                j++;
                ct++;
            }
        }

        while(i<n ){
            if(ct==ind1){ind1el = a[i];}
            if(ct==ind2){ind2el = a[i];}
            i++;
            ct++;
        }
        while( j<m){
            if(ct==ind1){ind1el = b[j];}
            if(ct==ind2){ind2el = b[j];}
            j++;
            ct++;
        }
        if(med%2==0){
            return (double)(ind1el + ind2el)/2.0;
        }
        return ind2el;

    }
}