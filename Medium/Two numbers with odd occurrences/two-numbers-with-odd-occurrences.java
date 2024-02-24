//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int Arr[], int N)
    {
        /*
        this questions is solved using hashmapms logoc simply we put all the elements of the array into 
        the  hashmaps and then iterate over the maps and count which key has value is equal to 1
        */
        // code here
         int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : Arr) {
            if (!map.containsKey(j)) {
                map.put(j, 1);
            } else {
                map.put(j, map.get(j) + 1);
            }
        }
//        System.out.println(map);
        int k = 0;

        for (Map.Entry<Integer, Integer> val : map.entrySet()) {
            if (val.getValue() % 2 != 0) {
                ans[k++] = val.getKey();
            }
        }
        if(ans[0] < ans[1]){
            int temp = ans[0];
            ans[0]= ans[1];
            ans[1] = temp;
        }
        
        return ans;
    }
}