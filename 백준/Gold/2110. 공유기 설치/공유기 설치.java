import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static long[] home;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        home=new long[N];
        for(int i=0; i<N; i++) home[i]=Long.parseLong(br.readLine());

        Arrays.sort(home);

        long left=1;
        long right=home[N-1]-home[0]+1;
        while(left+1<right){
            long mid=(left+right)/2;
            if(check(mid)) right=mid;
            else left=mid;
        }
        System.out.println(left);
        br.close();
    }
    static boolean check(long mid){
        int count=1;
        long cur=home[0];

        for(int i=1; i<home.length; i++){
            long next=home[i];

            if(next - cur >=mid){
                count++;
                cur=next;
            }
        }
        return count<C;
    }
}