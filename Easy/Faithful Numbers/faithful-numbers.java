//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.nthFaithfulNum(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static Long nthFaithfulNum(int N) {
       // code 
      long ans = 0l;
        int base = 7;
        int i = 0;

        while (N > 0) {
            int lastdigit = N & 1;
            ans += ((long) Math.pow(base, i)) * lastdigit;
            i++;
            N = N >> 1;
        }
        return ans;
    }
};