package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707 {

    private static ArrayList<ArrayList<Integer>> list;
    private static int[] color;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            color = new int[V + 1];
            list = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V + 1; i++) {
                list.add(new ArrayList<Integer>());
                color[i] = 0;
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                list.get(node1).add(node2);
                list.get(node2).add(node1);
            }

            boolean result = true;
            for (int i = 1; i < V + 1; i++) {
                if (color[i] == 0) {
                    if(!BFS(i)) {
                        result = false;
                        break;
                    }
                }
            }

            sb.append(result ? "YES" : "NO").append('\n');
        }

        System.out.println(sb);
    }

    public static boolean BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            for (int nextNode : list.get(curNode)) {
                if (color[nextNode] == color[curNode]) {
                    return false;
                }

                if (color[nextNode] == 0) {
                    color[nextNode] = color[curNode] * -1;
                    queue.offer(nextNode);
                }
            }
        }

        return true;
    }
}
