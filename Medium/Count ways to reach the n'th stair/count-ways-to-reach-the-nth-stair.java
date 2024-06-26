//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    static int mod = 1000000007;
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        
        // your code here
        //this is of Dp and first question to be solve while learning the Dp
        // if(n==1){
        //     return 1;
        // }
        int[] dp = new int[n+1];
        dp[0] = 1;//non of way to go first stair
        dp[1] = 1;
        // dp[2] = 2;
        for(int i=2;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2])%mod;
        }
        return dp[n];
    }
}

