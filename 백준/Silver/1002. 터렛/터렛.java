import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int dist = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

            if (r1 > r2) {
                int temp = r2;
                r2 = r1;
                r1 = temp;
            }

            if (dist == (r1 + r2) * (r1 + r2)) {
                sb.append(1).append("\n");
            } else if (dist > (r1 + r2) * (r1 + r2)) {
                sb.append(0).append("\n");
            } else if ((r2 - r1) * (r2 - r1) < dist && dist < (r1 + r2) * (r1 + r2)) {
                sb.append(2).append("\n");
            } else if (dist != 0 && dist == (r2 - r1) * (r2 - r1)) {
                sb.append(1).append("\n");
            } else if (0 < dist && dist < (r2 - r1) * (r2 - r1)) {
                sb.append(0).append("\n");
            } else if (dist == 0) {
                if (r1 != r2) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
