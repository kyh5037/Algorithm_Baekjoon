package UnionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ4195 {

    private static int[] parent;
    private static int[] count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());

            parent = new int[F * 2];
            count = new int[F * 2];
            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
            }
            Arrays.fill(count, 1);

            Map<String, Integer> map = new HashMap<>();
            StringTokenizer st;
            int num = 0; int result = 0;
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String str1 = st.nextToken();
                String str2 = st.nextToken();

                if (!map.containsKey(str1)) {
                    map.put(str1, num++);
                }

                if (!map.containsKey(str2)) {
                    map.put(str2, num++);
                }

                result = Union(map.get(str1), map.get(str2));
                sb.append(result).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static int Union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);
        if (node1 != node2) {
            if (node1 < node2) {
                parent[node2] = node1;
                count[node1] += count[node2];

                return count[node1];
            } else {
                parent[node1] = node2;
                count[node2] += count[node1];

                return count[node2];
            }
        }

        return count[node1];
    }

    public static int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
}
