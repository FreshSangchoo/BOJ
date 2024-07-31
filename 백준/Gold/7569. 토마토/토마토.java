import java.io.*;
import java.util.*;

public class Main {
	static int M, N, H;
	static int[][][] boxes;
	static int[] di = { 0, -1, 0, 1, 0, 0 };
	static int[] dj = { 1, 0, -1, 0, 0, 0 };
	static int[] dk = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		boxes = new int[N][M][H];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					boxes[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int days = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					if (boxes[i][j][k] == 1) {
						q.offer(new int[] { i, j, k, 0 });

					}
				}
			}
		}
		while (!q.isEmpty()) {
			int[] ijk = q.poll();
			for (int d = 0; d < 6; d++) {
				int ni = ijk[0] + di[d];
				int nj = ijk[1] + dj[d];
				int nk = ijk[2] + dk[d];
				days=ijk[3];
				if (0 <= ni && ni < N && 0 <= nj && nj < M && 0 <= nk && nk < H && boxes[ni][nj][nk] == 0) {
					boxes[ni][nj][nk] = 1;
					q.offer(new int[] { ni, nj, nk, days+1 });
				}
			}
		}
		int answer=0;
		label: for(int i=0; i<N; i++) for(int j=0; j<M; j++) for(int k=0; k<H; k++) {
			if(boxes[i][j][k]==0) {
				answer=-1;
				break label;
			}
		}
		if(answer==-1) System.out.println(answer);
		else System.out.println(days);
		br.close();
	}
}