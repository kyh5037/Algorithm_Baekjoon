package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4796 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int result = 0;
            if (V / P == 0) {
                if (V >= L) {
                    result = L;
                } else {
                    result = V;
                }
            } else {
                int q = (V / P);
                int r = (V % P);

                if (r >= L) {
                    result = (q + 1) * L;
                } else {
                    result = (q * L) + r;
                }
            }

            sb.append("Case ").append(i).append(": ").append(result).append('\n');
            i++;
        }
        System.out.println(sb);
    }
}
