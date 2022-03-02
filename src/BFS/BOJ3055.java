package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class forest {
    int x;
    int y;
    forest(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ3055 {

    private static int R, C;
    private static char[][] map;
    private static Queue<forest> hQueue;
    private static Queue<forest> wQueue;
    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static boolean[][] hVisited;
    private static boolean[][] wVisited;
    private static int result = 1;
    private static int Dx, Dy;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        hQueue = new LinkedList<>();
        wQueue = new LinkedList<>();
        hVisited = new boolean[R][C];
        wVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char word = str.charAt(j);

                map[i][j] = word;
                if (word == '*') {
                    wQueue.offer(new forest(i, j));
                } else if (word == 'S') {
                    hQueue.offer(new forest(i, j));
                } else if (word == 'D') {
                    Dx = i; Dy = j;
                }
            }
        }

        BFS();
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    public static void BFS() {
        while (true) {
            int wSize = wQueue.size();
            for (int i = 0; i < wSize; i++) {
                forest curForest = wQueue.poll();

                for (int j = 0; j < 4; j++) {
                    int next_x = curForest.x + dirX[j];
                    int next_y = curForest.y + dirY[j];

                    if (next_x >= 0 && next_y >= 0 && next_x < R && next_y < C && !wVisited[next_x][next_y] && map[next_x][next_y] == '.') {
                        wVisited[next_x][next_y] = true;
                        map[next_x][next_y] = '*';
                        wQueue.offer(new forest(next_x, next_y));
                    }
                }
            }

            int hSize = hQueue.size();
            if (hSize == 0){
                result = -1;
                break;
            }
            for (int i = 0; i < hSize; i++) {
                forest curForest = hQueue.poll();

                for (int j = 0; j < 4; j++) {
                    int next_x = curForest.x + dirX[j];
                    int next_y = curForest.y + dirY[j];

                    if (Dx == next_x && Dy == next_y) return;

                    if (next_x >= 0 && next_y >= 0 && next_x < R && next_y < C && !hVisited[next_x][next_y] && map[next_x][next_y] == '.') {
                        hVisited[next_x][next_y] = true;
                        hQueue.offer(new forest(next_x, next_y));
                    }
                }
            }
            result++;
        }
    }
}
