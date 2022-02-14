package String.KMPAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] word = str.toCharArray();

        int j = 0;
        int[] Pi = new int[word.length];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < word.length; i++) {
            while (j > 0 && word[i] != word[j]) {
                j = Pi[j - 1];
            }

            if (word[i] == word[j]) Pi[i] = ++j;
        }

        int result = L - Pi[L - 1];
        System.out.println(result);
    }
}
