package String.KMPAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1701 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            String substr = str.substring(i);
            answer = Math.max(answer, fail(substr.toCharArray()));
        }

        System.out.println(answer);
    }

    public static int fail(char[] word) {

        int j = 0;
        int[] Pi = new int[word.length];
        int result = 0;
        for (int i = 1; i < word.length; i++) {
            while(j > 0 && word[i] != word[j]) {
                j = Pi[j - 1];
            }

            if (word[i] == word[j])
                result = Math.max(result, Pi[i] = ++j);
        }

        return result;
    }
}
