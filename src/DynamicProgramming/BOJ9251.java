package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            char word1 = str1.charAt(i - 1);
            for (int j = 1; j <= str2.length(); j++) {
                char word2 = str2.charAt(j - 1);

                if (word1 == word2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}
