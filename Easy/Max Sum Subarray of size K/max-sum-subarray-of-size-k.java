//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        
        // code here
        
        //brute force method which exceeds time limit
        /*
        long max = Integer.MIN_VALUE;
        //brute force
        for (int i = 0; i <= Arr.size()-K; i++) {
            int sum = 0;
            for (int j = i; j < K+i; j++) {
                sum+=Arr.get(j);
            }
            max = Math.max(sum , max);
        }
        return  max;
        */
        //optimal way to do it with sliding window protocol
        //we can identify by the suarray ,maximum sum & K which can be window size
         int start = 0;
        int end = 0;
        long sum = 0L;
        long max = Long.MIN_VALUE;
        while (end < Arr.size()) {
            sum += Arr.get(end);
            if (end - start + 1 < K) {
                end++;
            } else if (end - start + 1 == K) {
                max= Math.max(sum , max);
                sum=sum-Arr.get(start);
                start++;
                end++;
            }

        }
        return max;
    }
}