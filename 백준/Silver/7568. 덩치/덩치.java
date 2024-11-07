import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[N][2];

        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            info[i][0] = weight;
            info[i][1] = height;
        }

        for(int i=0; i<N; i++){
            int rank = 1;
            for(int j=0; j<N; j++){
                if(i==j) continue;
                if(info[i][0] < info[j][0] && info[i][1] < info[j][1]) rank++;
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

}