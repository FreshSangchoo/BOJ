import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cards;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cards[i]=Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int find=Integer.parseInt(st.nextToken());
            int count=right(find)-left(find);

            sb.append(count).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
    static int left(int find){
        int left = 0;
        int right = N-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (find<=cards[mid]) right = mid-1;
            else left = mid + 1;
        }
        return left;
    }
    static int right(int find){
        int left = 0;
        int right = N-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (find<cards[mid]) right = mid-1;
            else left = mid + 1;
        }
        return left;
    }
}