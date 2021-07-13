import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 
 */
public class ReverseStringII {


    /**
     * Given a string s and an integer k, 
     * reverse the first k characters for every 2k characters counting from the start of the string.
     * 
     * If there are fewer than k characters left, reverse all of them.
     * 
     * If there are less than 2k but greater than or equal to k characters, 
     * then reverse the first k characters and left the other as original.
     * 
     * Runtime: 1 ms, faster than 77.39% of Java online submissions.
     * Memory Usage: 39 MB, less than 60.02% of Java online submissions.
     * 
     * 60 / 60 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 39 MB
     * 
     * This implementation uses StringBuilders.
     */
    static String reverseStr0(String s, int k) {

        // **** initialization ****
        int len             = s.length();
        StringBuilder ans   = new StringBuilder();

        int i               = 0;
        int twoK            = 2 * k;

        // **** take care of complete 2 * k sub strings ****
        for ( ; i < len / twoK; i++) {

            // **** extract sub string ****
            String sub = s.substring(i * twoK, (i + 1) * twoK);

            // **** first k characters ****
            StringBuilder sb = new StringBuilder(sub.substring(0, k));

            // **** reverse first k characters ****
            sb.reverse();

            // **** append last k characters ****
            sb.append(sub.substring(k));

            // **** append to answer ****
            ans.append(sb);
        }

        // **** check if done ****
        if (i * twoK == len)
            return ans.toString();

        // **** if fewer than k characters left (reverse all of them) ****
        if (len - (i * twoK) < k) {

            // **** extract the sub string ****
            String sub = s.substring(i * twoK);

            // **** entire sub string ****
            StringBuilder sb = new StringBuilder(sub);

            // **** reverse all characters ****
            sb.reverse();

            // **** append to answer ****
            ans.append(sb);
        }

        // **** reverse the first k characters and leave the others unchanged ****
        else {

            // **** extract the sub string ****
            String sub = s.substring(i * twoK);

            // **** k first characters ****
            StringBuilder sb = new StringBuilder(sub.substring(0, k));

            // **** reverse all characters ****
            sb.reverse();

            // **** append remaining characters ****
            sb.append(sub.substring(k));

            // **** append to answer ****
            ans.append(sb);
        }

        // **** return answer ****
        return ans.toString();
    }


    /**
     * Given a string s and an integer k, 
     * reverse the first k characters for every 2k characters counting from the start of the string.
     * 
     * If there are fewer than k characters left, reverse all of them.
     * 
     * If there are less than 2k but greater than or equal to k characters, 
     * then reverse the first k characters and left the other as original.
     * 
     * Runtime: 1 ms, faster than 77.39% of Java online submissions.
     * Memory Usage: 39.1 MB, less than 48.59% of Java online submissions.
     * 
     * 60 / 60 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 39.1 MB
     * 
     * This implementation uses a char array.
     */
    static String reverseStr(String s, int k) {

        // **** initialization ****
        char[] ca = s.toCharArray();

        // **** loop once per block of 2 * k characters ****
        for (int i = 0; i < ca.length; i += 2 * k) {

            // **** compute range to reverse characters ****
            int begin   = i;
            int end     = Math.min(i + k - 1, ca.length - 1);

            // **** reverse characters ****
            while (begin < end) {
                char tmp    = ca[begin];
                ca[begin++] = ca[end];
                ca[end--]   = tmp;
            }
        }

        // **** return string of character array ****
        return String.valueOf(ca);
    }


    /**
     * Test scaffold.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read string `s` ****
        String s = br.readLine().trim();

        // **** read `k` ****
        int k = Integer.parseInt(br.readLine().trim());

        // **** close buffered reader ****
        br.close();
        
        // ???? ????
        System.out.println("main <<< s ==>" + s + "<==");
        System.out.println("main <<< k: " + k);

        // **** generate and display answer ****
        System.out.println("main <<< reverseStr0 ==>" + reverseStr0(s, k) + "<==");

        // **** generate and display answer ****
        System.out.println("main <<<  reverseStr ==>" + reverseStr(s, k) + "<==");
    }
}