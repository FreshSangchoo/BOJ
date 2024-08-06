import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			st=new StringTokenizer(br.readLine(), " ");
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			
			for(int i=0; i<M; i++) {
				st=new StringTokenizer(br.readLine(), " ");
				//int a=Integer.parseInt(st.nextToken());
				//int b=Integer.parseInt(st.nextToken());
			}
			System.out.println(N-1);
		}
		br.close();
	}
}