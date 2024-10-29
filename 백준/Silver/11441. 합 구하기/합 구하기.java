import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++) sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            sb.append(sum[end]-sum[start-1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}