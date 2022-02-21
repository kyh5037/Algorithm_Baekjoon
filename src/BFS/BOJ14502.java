package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class virus {
    int x;
    int y;
    virus (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ14502 {

    private static int N, M;
    private static int[][] map;
    public static int[] dirX = {-1, 0, 1, 0};
    public static int[] dirY = {0, 1, 0, -1};
    public static int result = Integer.MIN_VALUE;
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

        makeCombo(0);
        System.out.println(result);
    }

    public static void makeCombo(int count) {
        if (count == 3) {
            BFS();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeCombo(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void BFS() {
        Queue<virus> queue = new LinkedList<>();
        int[][] copy_map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy_map[i][j] = map[i][j];
                if (map[i][j] == 2) {
                    queue.offer(new virus(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            virus curVirus = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = curVirus.x + dirX[i];
                int next_y = curVirus.y + dirY[i];

                if (next_x >=0 && next_y >= 0 && next_x < N && next_y < M && copy_map[next_x][next_y] == 0) {
                    copy_map[next_x][next_y] = 2;
                    queue.offer(new virus(next_x, next_y));
                }
            }
        }

        int clear = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copy_map[i][j] == 0) clear++;
            }
        }

        result = Integer.max(result, clear);
    }
}
