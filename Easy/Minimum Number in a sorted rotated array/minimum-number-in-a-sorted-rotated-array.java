//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");
            
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(st[i]);
              
            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }
    
}
// } Driver Code Ends


class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int nums[], int start, int end)
    {
        int ans = Integer.MAX_VALUE;
        // Your code here
        while(start<=end){
            
            int mid = start +(end - start)/2;
            
            //after applyig binary search only 1 element will present in the array
            // or there will only one element in the from start
            if(nums[start]<=nums[end]){
                ans = Math.min(ans , nums[start]);
                break;
            }
            
            //if middle element will greater than start elemnt then right part is the sorted array
            if(nums[start]<=nums[mid]){
                ans = Math.min(ans , nums[start]);
                //elimating left part of the array
                start = mid+1;
            }
            else{
                
                ans = Math.min(ans , nums[mid]);
                
                end = mid-1;
            }
            
        }
        return ans;
    }
}