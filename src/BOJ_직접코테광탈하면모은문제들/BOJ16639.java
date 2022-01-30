package BOJ_직접코테광탈하면모은문제들;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ16639 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[][] maxArr = new int[N][N];
        int[][] minArr = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(maxArr[i], Integer.MIN_VALUE);
            Arrays.fill(minArr[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                maxArr[i][i] = minArr[i][i] = str.charAt(i) - '0';
            }
        }

        for (int j = 2; j < N; j += 2) {
            for (int i = 0; i < N - j; i += 2) {
                for (int k = 2; k <= j; k += 2) {
                    int[] temp = new int[4];

                    temp[0] = calc(minArr[i][i + k - 2], minArr[i + k][i + j], str.charAt(i + k - 1));
                    temp[1] = calc(minArr[i][i + k - 2], maxArr[i + k][i + j], str.charAt(i + k - 1));
                    temp[2] = calc(maxArr[i][i + k - 2], minArr[i + k][i + j], str.charAt(i + k - 1));
                    temp[3] = calc(maxArr[i][i + k - 2], maxArr[i + k][i + j], str.charAt(i + k - 1));

                    Arrays.sort(temp);

                    minArr[i][i + j] = Math.min(minArr[i][i + j], temp[0]);
                    maxArr[i][i + j] = Math.max(maxArr[i][i + j], temp[3]);
                }
            }
        }

        System.out.println(maxArr[0][N - 1]);
    }

    public static int calc(int num1, int num2, int op) {
        if (op == '+')
            return num1 + num2;
        else if (op == '-')
            return num1 - num2;
        else
            return num1 * num2;
    }
}
