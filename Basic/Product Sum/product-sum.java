//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = new String[2];
            S = read.readLine().split(" "); 
            long a = Integer.parseInt(S[0]);
            long b = Integer.parseInt(S[1]);
            Solution ob = new Solution();

            System.out.println(ob.countDigits(a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
   static long countDigits(long a, long b){
        // code here
          long pro = (long) Math.abs(a*b);
        long c = 0;
        while(pro > 0){
            c++;
            pro = pro/10;
        }
        return c;
    }
}