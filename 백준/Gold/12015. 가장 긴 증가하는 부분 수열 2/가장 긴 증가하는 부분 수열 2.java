import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] lis = new int[N];
        lis[0] = arr[0];
        int max = 1;

        for (int i = 1; i < N; i++) {
            if (lis[max - 1] < arr[i]) {
                max++;
                lis[max - 1] = arr[i];
            } else {
                int left = 0;
                int right = max;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (lis[mid] < arr[i]) left = mid + 1;
                    else right = mid;
                }
                lis[left] = arr[i];
            }
        }

        System.out.println(max);
        br.close();
    }
}