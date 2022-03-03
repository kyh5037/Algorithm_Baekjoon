package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {

    private static int[][] map;
    private static int[] visited;
    private static int n;
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            map[num1][num2] = 1;
            map[num2][num1] = 1;
        }

        visited = new int[n+1];
        BFS(start, end);

        System.out.println(visited[end] == 0 ? -1 : visited[end]);
    }

    public static void BFS(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            if (curNode == end) return;

            for (int i = 1; i <= n; i++) {
                if (map[curNode][i] == 1 && visited[i] == 0) {
                    visited[i] = visited[curNode] + 1;
                    queue.offer(i);
                }
            }
        }
    }
}
