//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            boolean ans = new Solution().arraySortedOrNot(arr, n);
            System.out.println(ans ? 1 : 0);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        // code here
        // return helper(arr , n, 0);
        for(int i=0;i<n-1;i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
            
        }
        return true;
    }
    //recursive approach to solve this 
    // boolean helper(int[] nums , int n , int index){
    //     if(index == n-1){
    //         return true;
    //     }
        
    //     return nums[index] <= nums[index+1] && helper(nums , n , index +1);
    // }
}