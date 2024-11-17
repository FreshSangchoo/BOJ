import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] stage = new int[N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            stage[i]=Integer.parseInt(st.nextToken());
        }

        int prev = stage[N-1];
        int ans=0;
        for(int i=N-2; i>=0; i--){
            if(stage[i]>=prev) {
                while(stage[i]>=prev) {
                    stage[i]--;
                    ans++;
                }
            }
            prev = stage[i];
        }
        System.out.println(ans);
        br.close();
    }

}