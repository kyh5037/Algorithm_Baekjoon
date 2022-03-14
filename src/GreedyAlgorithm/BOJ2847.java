package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2847 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = arr[N-1];
        int result = 0;
        for (int i = N-2; i >=0; i--) {
            if (num <= arr[i]) {
                int temp = arr[i];
                arr[i] = num - 1;
                result += temp - arr[i];
            }
            num = arr[i];
        }

        System.out.println(result);
    }
}
