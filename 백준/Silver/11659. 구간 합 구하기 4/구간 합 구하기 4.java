import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[] num=new int[N+1];
		st=new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<N+1; i++) {
			num[i]=num[i-1]+Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			sb.append(num[b]-num[a-1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}