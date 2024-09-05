import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());

        int[] cards=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) cards[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(cards);

        int M=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int find=Integer.parseInt(st.nextToken());

            int left=0;
            int right=N;

            while(left+1<right){
                int mid=(left+right)/2;
                if(cards[mid]>find) right=mid;
                else left=mid;
            }

            if(find==cards[left]) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

}