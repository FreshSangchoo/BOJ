import java.io.*;
import java.util.*;

public class Main {
    static int N, E;
    static int[][] g;
    static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        g=new int[E][3];
        for(int i=0; i<E; i++){
            st=new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());

            g[i]=new int[]{from, to, weight};
        }
        Arrays.sort(g, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        make();
        int cnt=0;
        int result=0;

        for(int[] edge: g){
            if(union(edge[0], edge[1])){
                result+=edge[2];
                if(++cnt==N-1) break;
            }
        }
        System.out.println(result);
        br.close();
    }
    static void make(){
        p=new int[N];
        for(int i=0; i<N; i++) p[i]=i;
    }
    static int find(int a){
        if(p[a]==a) return a;
        return p[a]=find(p[a]);
    }
    static boolean union(int a, int b){
        int aRoot=find(a);
        int bRoot=find(b);
        if(aRoot==bRoot) return false;
        p[bRoot]=aRoot;
        return true;
    }
}