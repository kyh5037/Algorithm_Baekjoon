package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {
    int x;
    int y;
    int z;
    tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class BOJ7569 {

    private static int[][][] map;
    private static Queue<tomato> queue = new LinkedList<>();
    private static int dirX[] = {-1, 0, 1, 0, 0, 0};
    private static int dirY[] = {0, 1, 0, -1, 0, 0};
    private static int dirZ[] = {0, 0, 0, 0, 1, -1};
    private static int M, N, H;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[k][i][j] = num;
                    if (num == 1) {
                        queue.offer(new tomato(i, j, k));
                    }
                }
            }
        }

        BFS();
        int max = 0;
        boolean check = true;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    max = Math.max(max, map[k][i][j]);
                    if (map[k][i][j] == 0) {
                        check = false;
                        break;
                    }
                }
            }
        }

        System.out.println(check ? max - 1 : -1);
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            tomato curTomato = queue.poll();

            for (int i = 0; i < 6; i++) {
                int next_x = curTomato.x + dirX[i];
                int next_y = curTomato.y + dirY[i];
                int next_z = curTomato.z + dirZ[i];

                if (next_x >= 0 && next_y >= 0 && next_z >= 0 && next_x < N && next_y < M && next_z < H) {
                    if (map[next_z][next_x][next_y] == 0) {
                        map[next_z][next_x][next_y] = map[curTomato.z][curTomato.x][curTomato.y] + 1;
                        queue.offer(new tomato(next_x, next_y, next_z));
                    }
                }
            }
        }
    }
}
