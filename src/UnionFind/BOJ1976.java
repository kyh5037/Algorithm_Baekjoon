package UnionFind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976 {

    public static int[] parent;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    Union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        boolean check = true;
        int num = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            int trip = find(Integer.parseInt(st.nextToken()));
            if (num != trip) {
                check = false;
                break;
            }
        }

        System.out.println(check ? "YES" : "NO");
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
}
