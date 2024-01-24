//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long nums[], int size, int k)
    {int i = 0;
        int j = 0;
        int index = 0;
        long[] ans = new long[size - k + 1];
        Queue<Long> q = new LinkedList<>();
        while (j<size){

            //adding negative elements in the queue
            if(nums[j]<0){
                q.add(nums[j]);
            }
            if(j-i+1==k){
                if(q.isEmpty()){
                    ans[index] = 0;
                    index++;
                }
                else{
                    long number = q.peek();
                    ans[index] = number;
                    index++;
                    if(number==nums[i]){
                        q.remove();
                    }
                }
                i++;
            }
            j++;
        }
        return ans;

    }
}