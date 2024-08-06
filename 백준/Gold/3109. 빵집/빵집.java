import java.io.*;
import java.util.*;

public class Main {
	static int[] di= {-1, 0, 1};
	static int R, C;
	static char[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		int ans=0;
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=line.charAt(j);
			}
		}
		for(int i=0; i<R; i++) if(check(i,0)) ans++;
		System.out.println(ans);
		
	}
	static boolean check(int x, int y) {
		map[x][y]='-';
		if(y==C-1) return true;
		if(x>0&&map[x-1][y+1]=='.') if(check(x-1,y+1)) return true;
		if(map[x][y+1]=='.') if(check(x, y+1)) return true;
		if(x+1<R && map[x+1][y+1]=='.') if(check(x+1,y+1)) return true;
		return false;
	}

}