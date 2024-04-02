//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String s,String t)
    {
        if(s.length() != t.length()){
            return false;
        }
        // Your code here
        int[] mp1 = new int[256];
        int[] mp2 = new int[256];
        Arrays.fill(mp1, -1);
        Arrays.fill(mp2, -1);

        int n = s.length();
        for (int i = 0; i < n; i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (mp1[ch1] != -1 && mp1[ch1] != ch2 || mp2[ch2] != -1 && mp2[ch2] != ch1)
                return false;
            mp1[ch1] = ch2;
            mp2[ch2] = ch1;

        }
        return true;
        
    }
}