package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1026 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] first = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(first, Collections.reverseOrder());

        int[] second = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            second[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(second);

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += (first[i] * second[i]);
        }

        System.out.println(result);
    }
}
