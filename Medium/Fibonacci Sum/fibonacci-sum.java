//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static long fibSum(long N){
        //code here
       if(N== 0 || N == 1){
           return N;
       }
        // long[] arr = new long[N+1];
        
       long a = 0;
       long b = 1;
       
       
       long md = (long)1e9 + 7;
       
       long ans = a +b;
       
       
        long f = 0;
        for(int i=2;i<=N;i++){
            
            f = (a+b)%md;
            ans+=f;
            a = b;
            b = f;
        }
        
        return ans%md;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());
           
            Solution ob = new Solution();
            System.out.println(ob.fibSum(N));
        }
    }
}
// } Driver Code Ends