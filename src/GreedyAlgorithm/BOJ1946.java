package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            Map<Integer, Integer> map = new TreeMap<>();
            int N = Integer.parseInt(br.readLine());
            int result = 0;

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                map.put(doc, interview);
            }

            int min = Integer.MAX_VALUE;
            for (int i : map.keySet()) {
                if (min > map.get(i)) {
                    min = map.get(i);
                    result++;
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
