package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1302 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                   return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });

        String result = list.get(0).getKey();
        System.out.println(result);
    }
}
