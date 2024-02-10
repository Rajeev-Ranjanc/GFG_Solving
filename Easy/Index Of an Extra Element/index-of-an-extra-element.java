//{ Driver Code Starts
import java.util.*;
class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(a, b, n));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int a[], int b[], int n) {
        // add code here.
        /*
        bute force we can think that if we will iteratte the array up to n-1 or a.length-1 and check which 
        element is not equal in both of the array if not then retun i otherwise go to outside of the loop and 
        simply returns the n-1;
        */
        for(int i=0;i<a.length-1;i++){
            if(a[i]!=b[i]){
                return i;
            }
        }
        return n-1;
    }
}