//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
         // code here
        Map<Character, Integer> m = new HashMap<>();
        //putting characters in to map
        for (int i = 0; i < pat.length(); i++) {
            char key = pat.charAt(i);
            int freq = 0;
            if (m.containsKey(key))
                freq = m.get(key);
            freq++;
            m.put(key, freq);
        }

        //iterate over maps
//       for(Map.Entry<Character , Integer> it : m.entrySet()){
//           System.out.println(it.getKey() + "->"+it.getValue());
//       }

        int k = pat.length();
        int count = m.size();
        int ans = 0;
        int i = 0, j = 0;
        while (j < txt.length()) {

            if (m.containsKey(txt.charAt(j))) {
                m.put(txt.charAt(j), m.get(txt.charAt(j)) - 1);
                if (m.get(txt.charAt(j)) == 0) {
                    count--;
                }
            }

            if (j - i + 1 < k) {

                j++;

            } else if (j - i + 1 == k) {
                if (count == 0) {
                    ans++;
                }
                if (m.containsKey(txt.charAt(i))) {
                    m.put(txt.charAt(i), m.get(txt.charAt(i)) + 1);
                    if (m.get(txt.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}