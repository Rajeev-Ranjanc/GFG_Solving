//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int nums[], int n, int k) {
        
        // code here
        int i = 0;
        int j = 0;
        int ans = 0;
        int zeros = 0;

        while (j < nums.length) {

            if (nums[j] == 0) {
                zeros++;
            }

            while (zeros > k) {

                if (nums[i] == 0) {
                    zeros--;
                }
                i++;
            }
            
            ans = Math.max(ans, j - i + 1);

            j++;
        }
        return ans;
    }
}