package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9663 {
    private static int N;
    private static int result = 0;
    private static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        BackTracking(0);
        System.out.println(result);
    }

    public static void BackTracking(int row) {
        if (row == N) {
            result++;
        } else {
            for (int i = 0; i < N; i++) {
                arr[row] = i;
                if (isPossible(row)) {
                    BackTracking(row + 1);
                }
            }
        }
    }

    public static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) return false;
            if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) return false;
        }

        return true;
    }
}
