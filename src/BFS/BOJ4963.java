package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class island {
    int x;
    int y;
    island (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ4963 {

    public static int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int w, h;
    public static int[][] graph;
    public static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            graph = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j] == 1 && !visited[i][j]) {
                        BFS(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }

    public static void BFS(int x, int y) {
        Queue<island> queue = new LinkedList<>();
        queue.offer(new island(x, y));

        while (!queue.isEmpty()) {
            island curLand = queue.poll();

            for (int i = 0; i < 8; i++) {
                int next_x = curLand.x + dirX[i];
                int next_y = curLand.y + dirY[i];

                if (next_x >= 0 && next_y >= 0 && next_x < h && next_y < w && !visited[next_x][next_y] && graph[next_x][next_y] == 1) {
                    visited[next_x][next_y] = true;
                    queue.offer(new island(next_x, next_y));
                }
            }
        }

    }
}
