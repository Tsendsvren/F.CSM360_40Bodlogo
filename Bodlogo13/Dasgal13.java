package Bodlogo13;

import java.io.*;

class Result {
    public static String highestValuePalindrome(String s, int n, int k) {
        char[] chars = s.toCharArray();
        boolean[] changed = new boolean[n];
        int l = 0, r = n - 1;

        while (l < r) {
            if (chars[l] != chars[r]) {
                char max = (char) Math.max(chars[l], chars[r]);
                chars[l] = max;
                chars[r] = max;
                changed[l] = true;
                k--;
            }
            l++;
            r--;
        }

        if (k < 0)
            return "-1";

        l = 0;
        r = n - 1;
        while (l <= r) {
            if (l == r) {
                if (k > 0 && chars[l] != '9') {
                    chars[l] = '9';
                    k--;
                }
            } else {
                if (chars[l] != '9') {
                    if (changed[l] && k >= 1) {
                        chars[l] = chars[r] = '9';
                        k--;
                    } else if (!changed[l] && k >= 2) {
                        chars[l] = chars[r] = '9';
                        k -= 2;
                    }
                }
            }
            l++;
            r--;
        }

        return new String(chars);
    }

}

public class Dasgal13 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
