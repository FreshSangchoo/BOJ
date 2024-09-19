import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] province;
    static long maxBudget;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        province=new long[N];

        st=new StringTokenizer(br.readLine());
        long sumProvince=0;
        long maxProvince=0;
        for(int i=0; i<N; i++) {
            province[i]=Long.parseLong(st.nextToken());
            sumProvince+=province[i];
            maxProvince=Math.max(maxProvince,province[i]);
        }
        maxBudget=Long.parseLong(br.readLine());

        if(sumProvince<=maxBudget) System.out.println(maxProvince);
        else{
            long left=0;
            long right=maxBudget+1;
            while(left+1<right){
                long mid=(left+right)/2;
                if(onBudget(mid)) left=mid;
                else right=mid;
            }
            System.out.println(left);
        }
        br.close();
    }
    static boolean onBudget(long budget){
        long sum=0;
        for(int i=0; i<N; i++){
            if(province[i]<=budget) sum+=province[i];
            else sum+=budget;
        }
        return sum<=maxBudget;
    }
}