import java.io.*;
import java.util.*;

public class Main {
	static int[] di= {0, -1, 0, 1};
	static int[] dj= {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(br.readLine());
		
		int[][] map=new int[N][N];
		boolean[][] visited=new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String line=br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=line.charAt(j)-'0';
			}
		}
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		ArrayDeque<int[]> q=new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				if(map[i][j]==0) {
					visited[i][j]=true;
					continue;
				}
				if(map[i][j]==1 && !visited[i][j]) {
					//System.out.println("여기 시작 "+i+" "+j);
					int count=0;
					visited[i][j]=true;
					q.offer(new int[] {i, j});
					while(!q.isEmpty()) {
						count++;
						int[] ij=q.poll();
						for(int k=0; k<4; k++) {
							int x=ij[0]+di[k];
							int y=ij[1]+dj[k];
							if(0<=x && x<N && 0<=y && y<N && !visited[x][y] && map[x][y]==1) {
								visited[x][y]=true;
								q.offer(new int[] {x, y});
								//System.out.println("이거 넣었어 "+x+" "+y);
							}
						}
					}
					pq.offer(count);
				}
			}
		}
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
		System.out.println(sb);
		br.close();
	}
}