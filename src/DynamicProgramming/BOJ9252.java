package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        StringBuilder sb = new StringBuilder();
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
        sb.append(dp[str1.length()][str2.length()]).append('\n');

        int length1 = str1.length(); int length2 = str2.length();
        Stack<Character> stack = new Stack<>();
        while (length1 != 0 && length2 != 0) {
            if (dp[length1][length2] == dp[length1 - 1][length2]) {
                length1--;
            } else if (dp[length1][length2] == dp[length1][length2 - 1]) {
                length2--;
            } else {
                stack.push(str1.charAt(length1 - 1));
                length1--;
                length2--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.append('\n');
        System.out.println(sb);
    }
}
