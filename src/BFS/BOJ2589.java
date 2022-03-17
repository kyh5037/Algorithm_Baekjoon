package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class treasure {
    int x;
    int y;
    treasure(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ2589 {

    private static int[] dirX = {-1, 0, 1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static int[][] visited;
    private static char[][] map;
    private static int L, W;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[L][W];
        for (int i = 0; i < L; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int max = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] == 'L') {
                    visited = new int[L][W];
                    int temp = BFS(i , j);
                    max = Math.max(max, temp);
                }
            }
        }

        System.out.println(max - 1);
    }

    public static int BFS(int x, int y) {
        Queue<treasure> queue = new LinkedList<>();
        visited[x][y] = 1;
        queue.offer(new treasure(x, y));

        while (!queue.isEmpty()) {
            treasure curNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = curNode.x + dirX[i];
                int next_y = curNode.y + dirY[i];

                if (next_x >= 0 && next_y >= 0 && next_x < L && next_y < W && visited[next_x][next_y] == 0 && map[next_x][next_y] == 'L') {
                    visited[next_x][next_y] = visited[curNode.x][curNode.y] + 1;
                    queue.offer(new treasure(next_x, next_y));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < W; j++) {
                max = Math.max(max, visited[i][j]);
            }
        }

        return max;
    }
}
