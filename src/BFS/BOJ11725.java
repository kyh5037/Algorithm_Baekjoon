package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11725 {

    private static ArrayList<ArrayList<Integer>> list;
    private static int[] parents;
    private static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<ArrayList<Integer>>();
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        BFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        parents[start] = 1;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            for(int nextNode : list.get(curNode)) {
                if (parents[nextNode] == 0) {
                    parents[nextNode] = curNode;
                    queue.offer(nextNode);
                }
            }
        }
    }
}
