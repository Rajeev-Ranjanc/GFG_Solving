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
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for(long num : ans){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Long> factorialNumbers(long N){
        // code here
          ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        long i = 2;
        while (true) {

            long fa = fact(i);
            if (fa > N) {
                break;
            }
            list.add(fa);
            i++;
        }
        return list;
    }

    private static long fact(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);

    }
}