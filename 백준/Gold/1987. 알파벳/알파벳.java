import java.io.*;
import java.util.*;

public class Main {
	static int[] di= {0, 1, 0, -1};
	static int[] dj= {1, 0, -1, 0};
	static int R, C, max=0;
	static char[][] board;
	static boolean[] a=new boolean[26];
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		board=new char[R][C];
		for(int i=0; i<R; i++) {
			String line=br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j]=line.charAt(j);
			}
		}
		dfs(0,0,0);
		System.out.println(max);
	}
	static void dfs(int i, int j, int cnt) {
		a[board[i][j]-'A']=true;
		cnt++;
		max=Math.max(max, cnt);
		for(int d=0; d<4; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni&&ni<R && 0<=nj&&nj<C && !a[board[ni][nj]-'A']) {
				dfs(ni, nj, cnt);
				a[board[ni][nj]-'A']=false;
			}
		}
	}
}