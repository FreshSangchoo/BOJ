import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(i==j) graph[i][j] = 0;
                else graph[i][j] = 1_000_000_000;
            }
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());

            graph[from][to] = Math.min(graph[from][to], weight);
        }

        for(int k=0; k<V; k++){
            for(int i=0; i<V; i++){
                for(int j=0; j<V; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++) {
                if(graph[i][j]==1_000_000_000) sb.append(0).append(" ");
                else sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}