package Bodlogo14;

import java.io.*;
import java.util.*;

class Result {

    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char[] sub = s.substring(i, j).toCharArray();
                Arrays.sort(sub);
                String key = new String(sub);

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }

        for (int val : map.values()) {
            if (val > 1) {
                count += (val * (val - 1)) / 2;
            }
        }

        return count;
    }

}

public class Dasgal14 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
