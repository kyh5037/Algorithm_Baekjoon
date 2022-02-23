package UnionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {

    private static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            if (num == 0) {
                Union(node1, node2);
            } else {
                boolean check = Same(node1, node2);
                sb.append(check ? "YES" : "NO").append('\n');
            }
        }

        System.out.println(sb);
    }

    public static void Union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);
        if (node1 != node2) {
            if (node1 < node2) {
                parent[node2] = node1;
            } else {
                parent[node1] = node2;
            }
        }
    }

    public static int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public static boolean Same(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);
        return node1 == node2 ? true : false;
    }
}
