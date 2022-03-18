package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class land {
    int des;
    int weight;
    land (int des, int weight) {
        this.des = des;
        this.weight = weight;
    }
}

public class BOJ1939 {
    private static ArrayList<ArrayList<land>> list = new ArrayList<>();;
    private static int start, end;
    private static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int max = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.get(A).add(new land(B, C));
            list.get(B).add(new land(A, C));

            max = Math.max(max, C);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int left = 0; int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            visited = new boolean[N + 1];

            if (BFS(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    public static boolean BFS (int num) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            if (curNode == end) {
                return true;
            }

            for (land nextLand : list.get(curNode)) {
                if (!visited[nextLand.des] && num <= nextLand.weight) {
                    visited[nextLand.des] = true;
                    queue.offer(nextLand.des);
                }
            }
        }
        return false;
    }
}
