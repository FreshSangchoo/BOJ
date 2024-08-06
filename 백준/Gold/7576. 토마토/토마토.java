import java.io.*;
import java.util.*;

public class Main {
	static int[] di= {-1, 0, 1, 0};
	static int[] dj= {0, 1, 0, -1};
	static int M, N, days;
	static int[][] box;
	static ArrayDeque<int[]> tomato=new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		// 가로 N, 세로 M
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		box=new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				box[i][j]=Integer.parseInt(st.nextToken());
				if(box[i][j]==1) tomato.offer(new int[] {i, j, 0}); // 익은 토마토 큐에 넣기
			}
		}
		bfs();
		if(check()) System.out.println(days); // 다 익었으면 다익은 일 수 반환
		else System.out.println(-1); // 하나라도 안익은게 있으면 -1 반환
	}
	static void bfs() {// 안익은 토마토 익히기
		while(!tomato.isEmpty()) {
			int S=tomato.size();
			for(int s=0; s<S; s++) {
				int[] ij=tomato.poll(); // 익은 토마토 하나 위치 꺼내기
				int i=ij[0];
				int j=ij[1];
				days=ij[2];
				for(int d=0; d<4; d++) {
					int ni=i+di[d];
					int nj=j+dj[d];
					// 옆에 있는 토마토가 안익었으면 익히기
					if(0<=ni&&ni<N && 0<=nj&&nj<M && box[ni][nj]==0) {
						box[ni][nj]=1;
						tomato.offer(new int[] {ni,nj,days+1}); // 익은 토마토 큐에 넣기
					}
				}
			}
		}
	}
	static boolean check() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(box[i][j]==0) return false; // 하나라도 안익은게 있다면 false
			}
		}
		return true; // 다 익었으면 true
	}
	
}