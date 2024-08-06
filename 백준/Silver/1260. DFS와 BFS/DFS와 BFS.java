import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int V=Integer.parseInt(st.nextToken());
		
		graph=new int[N+1][N+1];
		visited=new boolean[N+1];
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int from=Integer.parseInt(st.nextToken());
			int  to =Integer.parseInt(st.nextToken());
			graph[from][to]=graph[to][from]=1;
		}
		dfs(V);
		System.out.println();
		visited=new boolean[N+1];
		bfs(V);
	}
	static void dfs(int start) {
		visited[start]=true;
		System.out.print(start+" ");
		for(int j=1; j<=N; j++) {
			if(graph[start][j]!=0 && !visited[j]) {
				dfs(j);
			}
		}
	}
	static void bfs(int start) {
		ArrayDeque<Integer> queue=new ArrayDeque<>();
		visited[start]=true;
		queue.offer(start);
		while(!queue.isEmpty()) {
			start=queue.poll();
			System.out.print(start+" ");
			for(int j=1; j<=N; j++) {
				if(graph[start][j]!=0 && !visited[j]) {
					visited[j]=true;
					queue.offer(j);
				}
			}
		}
	}
}