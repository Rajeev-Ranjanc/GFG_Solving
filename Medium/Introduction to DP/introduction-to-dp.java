//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static long topDown(int n) {
        // code here
        if(n<=1){

            return n;
        }

        long [] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
       
    }
    static long helper(int n , long[] a){
        
        a[0] = 0;
        a[1] = 1;
        
        long m = (long) 1e9 + 7;
        
        if(a[n] != -1){
            
            return a[n];
            
        }
        
        return a[n]  = (helper(n-1 ,a)  + helper(n-2 , a))%m;
    }

    static long bottomUp(int n) {
        // code here
        long m = (long) 1e9 + 7;
        if(n<=1){
            return n;
        }
        long[] a = new long[n+1];
        
        a[0] = 0;
        a[1] = 1;
        
        for(int i = 2;i<=n;i++){
            
            a[i] =(a[i-1] + a[i-2])%m;
            
        }
        return a[n];
        
        
    }
}
