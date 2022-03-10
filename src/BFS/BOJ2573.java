package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class ice {
    int x;
    int y;
    ice (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ2573 {

    private static int[][] map;
    private static int N, M;
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static int[][] iceMap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        visited = new boolean[N][M];
        iceMap = new int[N][M];
        while (true) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visited[i][j] = false;
                    iceMap[i][j] = 0;
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        BFS(i, j);
                        count++;
                    }
                }
            }

            if (count > 1) {
                break;
            } else if (count == 0) {
                result = 0;
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {
                        for (int k = 0; k < 4; k++) {
                            int melt_x = i + dirX[k];
                            int melt_y = j + dirY[k];

                            if (melt_x >= 0 && melt_y >= 0 && melt_x < N && melt_y < M && map[melt_x][melt_y] < 1) {
                                iceMap[i][j]++;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] -= iceMap[i][j];
                    if (map[i][j] < 0) {
                        map[i][j] = 0;
                    }
                }
            }

            result++;
        }

        System.out.println(result);
    }

    public static void BFS(int x, int y) {
        Queue<ice> queue = new LinkedList<>();
        queue.offer(new ice(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            ice curIce = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = curIce.x + dirX[i];
                int next_y = curIce.y + dirY[i];

                if(next_x >= 0 && next_y >= 0 && next_x < N && next_y < M && !visited[next_x][next_y] && map[next_x][next_y] > 0) {
                    visited[next_x][next_y] = true;
                    queue.offer(new ice(next_x, next_y));
                }
            }
        }
    }
}
