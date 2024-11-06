import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int ans = 0;
    static int[] checked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        checked = new int[N];

        board(0);
        System.out.println(ans);

    }

    static void board(int cnt) {
        if (cnt == N) {
            ans++;
            return;
        }
        for (int i = 0; i < N; i++) {
            checked[cnt] = i;
            if (canPutDown(cnt)) board(cnt + 1);
        }
    }

    static boolean canPutDown(int col) {
        for (int i = 0; i < col; i++) {
            if (checked[col] == checked[i]) return false;
            else if (Math.abs(col - i) == Math.abs(checked[col] - checked[i])) return false;
        }
        return true;
    }
}