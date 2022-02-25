package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class RGB {
    int x;
    int y;
    char color;
    RGB(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

public class BOJ10026 {

    public static int N;
    public static int[] dirX = {-1, 0, 1, 0};
    public static int[] dirY = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        char[][] map1 = new char[N][N];
        char[][] map2 = new char[N][N];
        boolean[][] visited1 = new boolean[N][N];
        boolean[][] visited2 = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char word = str.charAt(j);
                map1[i][j] = word;
                map2[i][j] = word;
                if (word == 'R') {
                    map2[i][j] = 'G';
                }
            }
        }

        int result1 = 0, result2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited1[i][j]) {
                    BFS(i, j, map1[i][j], map1, visited1);
                    result1++;
                }
                if (!visited2[i][j]) {
                    BFS(i, j, map2[i][j], map2, visited2);
                    result2++;
                }
            }
        }

        System.out.println(result1 + " " + result2);
    }

    public static void BFS(int x, int y, char color, char[][] map, boolean[][] visited) {
        Queue<RGB> queue = new LinkedList<>();
        queue.offer(new RGB(x, y, color));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            RGB curRGB = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = curRGB.x + dirX[i];
                int next_y = curRGB.y + dirY[i];

                if (next_x >= 0 && next_y >= 0 && next_x < N && next_y < N) {
                    if (!visited[next_x][next_y] && curRGB.color == map[next_x][next_y]) {
                        visited[next_x][next_y] = true;
                        queue.offer(new RGB(next_x, next_y, map[next_x][next_y]));
                    }
                }
            }
        }
    }
}
