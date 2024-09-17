import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(br.readLine());
        long[] set = new long[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) set[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(set);

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return Long.compare(o1[1], o2[1]);
            else return Long.compare(o1[0], o2[0]);
        });
        long left = 0;
        long right = 0;
        int index = 0;
        for(int i=0; i<L; i++) pq.offer(new long[]{0, set[i]});
        while (index < L) {
            if (index == 0) left = 0;
            else left = set[index - 1];
            right = set[index];
//            System.out.println("지금: "+left+", "+right);
            if (right - left - 1 < 100) {
                for (int i = 1; i <= right - left - 1; i++) {
                    pq.offer(new long[]{-1 * (i * i) + (right - left) * i - 1, left + i});
//                    System.out.println("이거 넣었어: " + (-1 * (i * i) + (right - left) * i - 1)+", "+(left+i) );
                }
            } else {
                for (int i = 1; i <= 50; i++) {
                    pq.offer(new long[]{-1 * (i * i) + (right - left) * i - 1, left + i});
                    pq.offer(new long[]{-1 * (i * i) + (right - left) * i - 1, right - i});
//                    System.out.println("이거 넣었어: " + (-1 * (i * i) + (right - left) * i - 1)+", "+(left+i) );
//                    System.out.println("이거 넣었어: " + (-1 * (i * i) + (right - left) * i - 1)+", "+(right+i) );
                }
            }
            index++;
        }
        int size=pq.size();
        for (int i = 0; i < n; i++) {
            if(!pq.isEmpty()) sb.append(pq.poll()[1]).append(" ");
        }
        if(size<n){
            for(int i=1; i<=n-size; i++) sb.append(set[L-1]+i).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}