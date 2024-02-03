//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        /*
        there  would be 2 brute force approach for this for this problem 
        1st one is by simply if we calculate the number of occurences of the problem
        and return it another one can be by the XOR operator. we will declare a variable 
        and will intilise by the 0 and calculate XOR of its so the number which will even no 
        of time will be zero
        
        */
        //XOR operation
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = ans ^ arr[i];
        }
        return ans;
        
    }
}