import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(), " ");
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		boolean[] know=new boolean[N+1];
		
		ArrayList<Integer>[] arr=new ArrayList[M+1];
		for(int i=1; i<=M; i++) arr[i]=new ArrayList<>();
		st=new StringTokenizer(br.readLine(), " ");
		int knowPerson=Integer.parseInt(st.nextToken());
		for(int i=0; i<knowPerson; i++) know[Integer.parseInt(st.nextToken())]=true;
		
		parent=new int[N+1];
		for(int i=1; i<N; i++) parent[i]=i;
		
		for(int i=1; i<=M; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int numP=Integer.parseInt(st.nextToken());
			
			if(numP<=1) {
				arr[i].add(Integer.parseInt(st.nextToken()));
				continue;
			}
			int[] person=new int[numP];
			for(int j=0; j<numP;  j++) person[j]=Integer.parseInt(st.nextToken());
			
			for(int j=1; j<numP; j++) {
				int a=person[j-1];
				int b=person[j];
				
				if(find(a)!=find(b)) union(a,b);
				arr[i].add(a);
				arr[i].add(b);
			}
		}
		boolean[] visited=new boolean[N+1];
		for(int i=1; i<=N; i++) {
			if(know[i] && !visited[i]) {
				for(int j=1; j<=N; j++) {
					if(find(j)==find(i)) {
						know[j]=true;
						visited[j]=true;
					}
				}
			}
		}
		int result=0;
		for(int i=1; i<=M; i++) {
			boolean flag=false;
			for(int person: arr[i]) {
				if(know[person]) {
					flag=true;
					break;
				}
			}
			if(!flag) result++;
		}
		System.out.println(result);
	}
	static int find(int x) {
		if(parent[x]==x) return x;
		parent[x]=find(parent[x]);
		return parent[x];
	}
	static void union(int a, int b) {
		parent[find(b)]=a;
	}
}