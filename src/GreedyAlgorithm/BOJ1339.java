package GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1339 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] strArr = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder(str);
            strArr[i] = sb.reverse().toString();
        }

        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        Map<Character, Integer> map = new HashMap<>();
        for (int i = strArr[0].length() - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (i >= strArr[j].length()) break;

                char word = strArr[j].charAt(i);

                if (!map.containsKey(word)) {
                    map.put(word, (int) Math.pow(10, i));
                } else {
                    map.put(word, map.get(word) + (int) Math.pow(10, i));
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (char c : map.keySet()) {
            list.add(map.get(c));
        }

        Collections.sort(list, Collections.reverseOrder());
        int num = 9, result = 0;
        for (int i : list) {
            result += (i * num);
            num--;
        }

        System.out.println(result);
    }
}
