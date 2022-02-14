package String.KMPAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KMP_Example {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = br.readLine();

        int answer = KMP(str.toCharArray(), str2.toCharArray());
        System.out.println(answer);
    }

    public static int[] fail(char[] word) {

        int j = 0;
        int[] Pi = new int[word.length];

        for (int i = 1; i < word.length; i++) {
            while (j > 0 && word[i] != word[j]) {
                j = Pi[j - 1];
            }

            if (word[i] == word[j]) Pi[i] = ++j;
        }

        return Pi;
    }

    public static int KMP(char[] str, char[] failStr) {

        int result = 0; int j = 0;
        int[] Pi = fail(failStr);

        for (int i = 1; i < str.length; i++) {
            while (j > 0 && str[i] != failStr[j]) {
                j = Pi[j - 1];
            }

            if (str[i] == failStr[j]) {
                if (j == failStr.length - 1) {
                    j = Pi[j];
                    result++;
                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
