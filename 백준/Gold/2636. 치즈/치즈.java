import java.io.*;
import java.util.*;

public class Main {
	static int[] di= {0, 1, 0, -1};
	static int[] dj= {1, 0, -1, 0};
	static int R, C, time;
	static int[][] pan;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		pan=new int[R][C];
		visited=new boolean[R][C];
		for(int i=0; i<R; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<C; j++) {
				pan[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int time=0;
		int cheese=0;
		while(!check()) {
			findHole_bfs(0, 0); // 구멍이 아닌 부분(공기) 99로 표시
			visitCheese(); // 공기와 닿아있는 치즈 방문처리 해주기
			cheese=count(); // 녹이기 전 치즈의 개수 세기
			meltingCheese(); // 방문처리 되어있는 치즈 공기로 바꿔주기
			time++; // 1시간 추가
			visited=new boolean[R][C]; // 방문배열 초기화
			findHole_bfs(0, 0); // 구멍이 아닌 부분(공기) 99로 표시
		}
		System.out.println(time);
		System.out.println(cheese);
	}
	static void findHole_bfs(int i, int j) {// 구멍이 아닌 부분(공기) 99로 표시
		ArrayDeque<int[]> q=new ArrayDeque<>();
		visited[i][j]=true;
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] ij=q.poll();
			pan[ij[0]][ij[1]]=99;
			for(int d=0; d<4; d++) {
				int ni=ij[0]+di[d];
				int nj=ij[1]+dj[d];
				if(0<=ni&&ni<R && 0<=nj&&nj<C && !visited[ni][nj] && pan[ni][nj]!=1) {
					visited[ni][nj]=true;
					q.offer(new int[] {ni, nj});
				}
			}
		}
	}
	static void visitCheese() {// 녹일 치즈 방문처리 해주기
		for(int i=0; i<R; i++) { 
			for(int j=0; j<C; j++) {
				if(pan[i][j]==1) {
					for(int d=0; d<4; d++) {
						int ni=i+di[d];
						int nj=j+dj[d];
						if(0<=ni&&ni<R && 0<=nj&&nj<C && !visited[i][j] && pan[ni][nj]==99) {
							visited[i][j]=true;
						}
					}
				}
			}
		}
	}
	static void meltingCheese() { // 방문처리된 치즈 녹이기
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(pan[i][j]==1 && visited[i][j]) pan[i][j]=99;
			}
		}
	}
	static boolean check() { // 치즈가 다 녹았는지 확인
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(pan[i][j]!=99) return false;
			}
		}
		return true;
	}
	static int count() {
		int count=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(pan[i][j]==1) count++;
			}
		}
		return count;
	}
}