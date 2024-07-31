import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int vertex;
        Node link;

        Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    static int N;
    static int[] parents;
    static Node[] g;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        g = new Node[N];
        visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            g[a] = new Node(b, g[a]);
            g[b] = new Node(a, g[b]);
        }
        parents = new int[N];
        dfs(0);
        for (int i = 1; i < N; i++) sb.append(parents[i] + 1).append("\n");
        System.out.println(sb);
        br.close();
    }

    static void dfs(int i) {
        visited[i] = true;
        for (Node j = g[i]; j != null; j = j.link) {
            if (!visited[j.vertex]) {
                parents[j.vertex] = i;
                //System.out.println((j.vertex+1)+"의 부모는 "+(i+1));
                dfs(j.vertex);
            }
        }
    }
}