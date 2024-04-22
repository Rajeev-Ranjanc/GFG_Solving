//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int A[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.minRow(N, M, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minRow(int n, int m, int a[][]) {
        // code here
         int ans = Integer.MAX_VALUE;
        int[] num = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int co = 0;
           for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1) {
                    co++;
                }
            }
            num[i] = co;
            ans = Math.min(ans, num[i]);
        }

//        System.out.println(Arrays.toString(num));
//        System.out.println(ans);
        for (int i = 0; i < num.length; i++) {
            if (num[i] == ans) {
                return i + 1;
            }
        }
        return 0;
    }
};