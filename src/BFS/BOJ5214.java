package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5214 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list[] = new ArrayList[N + M + 1];
        for (int i = 0; i <= N + M; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = N + 1; i <= N + M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int num = Integer.parseInt(st.nextToken());

                list[i].add(num);
                list[num].add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[N + M + 1];

        queue.offer(1);
        visited[1] = 1;

        int result = 0;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            if (curNode == N) break;

            for (int nextNode : list[curNode]) {
                if (visited[nextNode] == 0) {
                    if (N > curNode) {
                        visited[nextNode] = visited[curNode] + 1;
                    } else {
                        visited[nextNode] = visited[curNode];
                    }
                    queue.offer(nextNode);
                }
            }
        }

        if (visited[N] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(visited[N]);
        }
    }
}
