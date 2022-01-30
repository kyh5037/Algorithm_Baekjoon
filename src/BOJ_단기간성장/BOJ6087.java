package BOJ_단기간성장;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class laser {
    int x;
    int y;
    int dir;
    int count;
    laser (int x, int y, int dir, int count) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.count = count;
    }
}

public class BOJ6087 {
    static laser start, end;
    static char[][] map;
    static int[][] visited;
    static int min = Integer.MAX_VALUE;
    static int W, H;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'C') {
                    if (start == null) {
                        start = new laser(i, j, -1, 0);
                    } else {
                        end = new laser(i, j, -1, 0);
                    }
                }
            }
        }

        bfs();

        System.out.println(min);
    }

    public static void bfs() {
        Queue<laser> queue = new LinkedList<>();
        visited = new int[H][W];

        queue.offer(start);
        visited[start.x][start.y] = 1;

        while (!queue.isEmpty()) {
            laser curLaser = queue.poll();

            if (curLaser.x == end.x && curLaser.y == end.y) {
                min = Math.min(min, curLaser.count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curLaser.x + dirX[i];
                int nextY = curLaser.y + dirY[i];

                if (nextX < 0 || nextX >= H || nextY < 0 || nextY >= W || map[nextX][nextY] == '*')
                    continue;

                int nextCount = curLaser.count;
                if (curLaser.dir != -1 && curLaser.dir != i) {
                    nextCount += 1;
                }

                if (visited[nextX][nextY] == 0 || visited[nextX][nextY] >= nextCount) {
                    visited[nextX][nextY] = nextCount;
                    queue.offer(new laser(nextX, nextY, i, nextCount));
                }
            }
        }
    }
}
