import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. N(수의 개수), M(나누기 할 수) 입력받기
        int N = Integer.parseInt(st.nextToken());   // 수의 개수
        int M = Integer.parseInt(st.nextToken());   // 나누기 할 수
        long result = 0;                            // M으로 나누어떨어지는 (i,j) 쌍의 개수
        long[] S = new long[N + 1];                 // 합배열
        long[] cnt = new long[M];                   // 같은 나머지의 인덱스를 카운트하는 배열

        // 2. N개의 수 입력받으면서 누적합을 M으로 나눈 나머지를 배열 S에 저장한다.
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            S[i] = (S[i - 1] + Integer.parseInt(st.nextToken())) % M;
            // 0~i까지의 합을 M으로 나눈 나머지가 0인 경우의 수 카운팅
            if(S[i] == 0) {
                result++;
            }
            // 나머지가 같은 인덱스의 수 카운팅
            cnt[(int) S[i]]++;
        }

        // 3. S[j] % M == S[i-1] % M 을 만족하는 (i,j)의 수를 결과값에 더한다.
        // 즉, cnt[i](i가 나머지인 인덱스의 수)에서 2가지를 뽑는 경우의 수 카운팅한다.
        for(int i=0; i<M; i++) {
            if(cnt[i] > 1) {
                result += (cnt[i]* (cnt[i]-1) / 2);
            }
        }
        System.out.println(result);


        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long[] mod = new long[M];

        st = new StringTokenizer(br.readLine());
        arr[0] = Long.parseLong(st.nextToken());
        for (int i = 1; i < N; i++) arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());

        int count = 0;
        for (int i = 0; i < N; i++) {
            int modM = (int) (arr[i] % M);

            if (modM == 0) count++;
            mod[modM]++;
        }
        for (int i = 0; i < M; i++) if (mod[i] > 1) count += (mod[i] * (mod[i] - 1) / 2);
        System.out.println(count);
        br.close();

         */
/*
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        arr[0] = Long.parseLong(st.nextToken()) % M;
        for (int i = 1; i < N; i++) arr[i] = (arr[i - 1] + Long.parseLong(st.nextToken())) % M;


        int[] mod = new int[M];
        for (int i = 0; i < N; i++) mod[(int) arr[i]]++;
        //System.out.println(Arrays.toString(mod));
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if (i == 0) cnt += mod[i];
            cnt += mod[i] * (mod[i] - 1) / 2;
        }

        System.out.println(cnt);
        br.close();
 */
    }
}