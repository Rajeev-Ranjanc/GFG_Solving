//{ Driver Code Starts
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
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
       ArrayList<Integer> ans = new ArrayList<>();
        int minr = 0;
        int minc = 0;
        int maxr = matrix.length - 1;
        int maxc = matrix[0].length - 1;

        //or we can do minc <= maxc it will also work
        //&& minc <= maxc
        while (minr <= maxr) {

            //first condition
            //here constant will maxr -> this will add all elements of first row at first call
            for (int i = minc; i <= maxc; i++) {
                ans.add(matrix[minr][i]);
            }
            minr++;

            //second condition -> for the right column
            //constant will be maxc -> clear it by making diagram
            if (minr > maxr || minc > maxc) break; // to avoid adding the last only elements by two times
            //or we can do this by if we calculate the total no of elements in matrix and check a condition at
            //the very first time while entering the first loop that while list.size does not equal to total no of elements
            for (int i = minr; i <= maxr; i++) {
                ans.add(matrix[i][maxc]);
            }
            maxc--;

            //third condition -> constant will be maximum row
            //for the bottom row from right to left all verify by diagram
            if (minr > maxr || minc > maxc) break;
            for (int i = maxc; i >= minc; i--) {
                ans.add(matrix[maxr][i]);
            }
            maxr--;

            //last condition will be for the left most column for that column will be constant
            //while loop will max row to min row from bottom to up

            for (int i = maxr; i >= minr; i--) {
                ans.add(matrix[i][minc]);
            }
            minc++;

        }

        return ans;
    }
}
