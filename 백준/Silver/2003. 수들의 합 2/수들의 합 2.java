import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        long M=Long.parseLong(st.nextToken());

        long[] arr=new long[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i]=Long.parseLong(st.nextToken());

        int count=0;
        int start=0;
        int end=0;
        long sum=0;
        while(true){
            if(sum<M) {
                if(end==N) break;
                sum+=arr[end];
                end++;
            } else if (sum>M){
                sum-=arr[start];
                start++;
            } else {
//                System.out.println("이때: "+start+" "+(end-1));
                count++;
                sum-=arr[start];
                start++;
            }
        }
        System.out.println(count);
        br.close();
    }
}