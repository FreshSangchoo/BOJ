import java.io.*;
import java.util.*;

public class Main {
    static long M;
    static long[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        M=Long.parseLong(st.nextToken());
        long max=0;
        tree=new long[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            tree[i]=Long.parseLong(st.nextToken());
            max=Math.max(max,tree[i]);
        }
        Arrays.sort(tree);
        long left=0;
        long right=max+1;
        while(left<=right){
            long mid=(left+right)/2;
            if(check(mid)) left=mid+1;
            else right=mid-1;
        }
        System.out.println(left-1);
        br.close();
    }
    static boolean check(long value){
        long sum=0;
        for(int i=0;i<tree.length;i++) if(tree[i]>value) sum+=tree[i]-value;
        return sum>=M;
    }
}