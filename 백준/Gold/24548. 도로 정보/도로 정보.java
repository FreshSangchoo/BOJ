import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // T: 나무, G: 잔디, F: 울타리, P: 사람
        String str = br.readLine();

        int[][] arr = new int[N + 1][4];

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            char next = str.charAt(i - 1);

            if (next == 'T') {
                arr[i][0] = arr[i - 1][0] + 1;
                arr[i][0] %= 3;
                arr[i][1] = arr[i - 1][1];
                arr[i][2] = arr[i - 1][2];
                arr[i][3] = arr[i - 1][3];
            } else if (next == 'G') {
                arr[i][1] = arr[i - 1][1] + 1;
                arr[i][1] %= 3;
                arr[i][0] = arr[i - 1][0];
                arr[i][2] = arr[i - 1][2];
                arr[i][3] = arr[i - 1][3];
            } else if (next == 'F') {
                arr[i][2] = arr[i - 1][2] + 1;
                arr[i][2] %= 3;
                arr[i][0] = arr[i - 1][0];
                arr[i][1] = arr[i - 1][1];
                arr[i][3] = arr[i - 1][3];
            } else {
                arr[i][3] = arr[i - 1][3] + 1;
                arr[i][3] %= 3;
                arr[i][0] = arr[i - 1][0];
                arr[i][1] = arr[i - 1][1];
                arr[i][2] = arr[i - 1][2];
            }

            String hash = Integer.toString(1000 * arr[i][0] + 100 * arr[i][1] + 10 * arr[i][2] + arr[i][3]);

            if (hm.containsKey(hash)) {
                int cur = hm.get(hash);
                hm.replace(hash, cur + 1);
            } else {
                hm.put(hash, 1);
            }

        }

        int answer = 0;

        for (String key : hm.keySet()) {
            int count = hm.get(key);
            // System.out.println("key: " + key + ", value: " + count);

            if (key.charAt(0) == '0') {
                answer += count + count * (count - 1) / 2;
            } else {
                answer += count * (count - 1) / 2;
            }
        }

        System.out.println(answer);

    }
}