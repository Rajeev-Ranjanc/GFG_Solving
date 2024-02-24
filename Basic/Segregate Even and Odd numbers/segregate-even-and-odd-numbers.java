//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().segregateEvenOdd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    void segregateEvenOdd(int arr[], int n) {
        // code here
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int num : arr) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        Collections.sort(even);
        Collections.sort(odd);
//        System.out.println(even);
//        System.out.println(odd);
        //now fills into the origional array
//         for (int i = 0; i < even.size(); i++) {
//             arr[i] = even.get(i);
//         }
// //        System.out.println(odd);
//         for (int i = even.size(); i < n; i++) {
//             arr[i] = odd.getFirst();
//             odd.removeFirst();
//         }

int i = 0 , j = 0 , k = 0 ;
        while(i<even.size()){
            arr[k++] = even.get(i++);
        }

        while(j<odd.size()){
            arr[k++] = odd.get(j++);
        }
    }
}