package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1958 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int[][][] dp = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            char word1 = str1.charAt(i - 1);
            for (int j = 1; j <= str2.length(); j++) {
                char word2 = str2.charAt(j - 1);
                for (int k = 1; k <= str3.length(); k++) {
                    char word3 = str3.charAt(k - 1);

                    if (word1 == word2 && word1 == word3) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i][j][k - 1], dp[i][j - 1][k]), dp[i - 1][j][k]);
                    }
                }
            }
        }


        System.out.println(dp[str1.length()][str2.length()][str3.length()]);
    }
}
