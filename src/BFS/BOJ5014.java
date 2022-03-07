package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {

    private static int F,S,G,U,D;
    private static int[] map;
    private static int[] dir = new int[2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[F + 1];

        dir[0] = U; dir[1] = -D;

        BFS();
    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[F + 1];

        queue.offer(S);
        visited[S] = true;
        map[S] = 0;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            if (curNode == G) {
                System.out.println(map[curNode]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nextNode = curNode + dir[i];

                if (nextNode > 0 && nextNode <= F && !visited[nextNode]) {
                    map[nextNode] = map[curNode] + 1;
                    visited[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }

        System.out.println("use the stairs");
    }
}
