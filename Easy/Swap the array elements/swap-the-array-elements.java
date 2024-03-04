//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] S = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            obj.swapElements(arr, n);
            for(int i = 0; i < n; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void swapElements(int[] arr, int n)
    {
        // Code here
         if(n<3){
            return;
        }
        for (int i = 0; i < arr.length-2; i++) {
            swap(arr,i,i+2);
        }
    }
     private void swap(int[] nums, int f, int s){
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }
}