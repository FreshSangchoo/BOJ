import java.io.*;
import java.util.*;

public class Main {
    static int N, K, D;
    static Rule[] rules;

    static class Rule {
        int start, end, gap;

        public Rule(int start, int end, int gap) {
            this.start = start;
            this.end = end;
            this.gap = gap;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        rules = new Rule[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            rules[i] = new Rule(A, B, C);
        }
        System.out.println(find());
    }

    static int find() {
        int left = 0;
        int right = N;
        int minIndex = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (findCurrentAcorn(mid) < D) {
                left = mid+1;
            } else if (findCurrentAcorn(mid) >= D) {
                right = mid-1;
                minIndex=Math.min(minIndex, mid);
            }
        }
        return minIndex;
    }

    static long findCurrentAcorn(int mid) {
        long acornNum = 0;

        for (Rule rule : rules) {
            if (mid < rule.start) continue;
            int end = Math.min(rule.end, mid);
            acornNum += (end - rule.start) / rule.gap + 1;
        }
        return acornNum;
    }
}