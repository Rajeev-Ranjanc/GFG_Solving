//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    int transitionPoint(int arr[], int n) {
        // code here
        /*
        as this is the sorted array we can think about the binary search but we can do it in
        linear search too simply chechking is elements at index i s1 if yes then return i otherse go to the
        outside of the loop return -1
        */
        //brute force approach
        for(int i=0;i<n;i++){
            if(arr[i] == 1){
                return i;
            }
        }
        return -1;
    }
}