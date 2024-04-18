//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int x = Integer.parseInt(inputLine[1]);
		    
		    List<Integer> arr = new ArrayList<>();
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr.add(Integer.parseInt(inputLine[i]));
		    }
		    new Solution().sortABS(arr,n, x);
		    StringBuilder sb = new StringBuilder();
		    for(int y : arr)
		        sb.append(y+ " ");
		    System.out.println(sb.toString());
		    
		}
	}
}
// } Driver Code Ends

class Element {
    int value;
    int diff;
    int index;

    Element(int value, int diff, int index) {
        this.value = value;
        this.diff = diff;
        this.index = index;
    }
}


//User function Template for Java

class Solution
{
    //Function to sort the array according to difference with given number.
    static void sortABS(List<Integer> arr, int n, int k)  
    {
        // add your code here
        
        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            elements.add(new Element(arr.get(i), Math.abs(arr.get(i) - k), i));
        }

        Collections.sort(elements, (a, b) -> {
            if (a.diff == b.diff) {
                // Maintain the original order if absolute differences are equal
                return Integer.compare(a.index, b.index);
            }
            return Integer.compare(a.diff, b.diff);
        });

        for (int i = 0; i < n; i++) {
            arr.set(i, elements.get(i).value);
        }
    }
}
