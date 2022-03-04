package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N + M; i++) {
            String str = br.readLine();

            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                list.add(str);
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');

        for (String str : list) {
            sb.append(str).append('\n');
        }
        System.out.println(sb);
    }
}
