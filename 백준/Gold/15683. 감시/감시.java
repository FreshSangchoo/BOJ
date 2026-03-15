import java.io.*;
import java.util.*;

public class Main {
    static int[] di = { 0, 1, 0, -1 };
    static int[] dj = { 1, 0, -1, 0 };
    static int N, M;
    static int[][] office;
    static int[][] cctvs;
    static int cctvCount = 0;
    static int min = Integer.MAX_VALUE;
    static int[] cctvDir;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        ArrayDeque<int[]> cctvsCount = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());

                if (office[i][j] != 0 && office[i][j] != 6)
                    cctvsCount.offer(new int[] { office[i][j], i, j });
            }
        }

        cctvCount = cctvsCount.size();
        // 0: cctv 번호, 1: cctv i좌표, 2: cctv j좌표
        cctvs = new int[cctvCount][3];
        cctvDir = new int[cctvCount];
        int idx = 0;
        while (!cctvsCount.isEmpty()) {
            int[] cur = cctvsCount.poll();

            cctvs[idx][0] = cur[0];
            cctvs[idx][1] = cur[1];
            cctvs[idx][2] = cur[2];

            idx++;
        }

        dfs(0);

        System.out.println(min);
    }

    static void dfs(int cnt) {
        if (cnt == cctvCount) {
            // 사각지대 개수 세기
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (office[i][j] == 0)
                        count++;
                }
            }

            // System.out.println("다 돌렸으니 한번 보자!");
            // for (int i = 0; i < N; i++) {
            // System.out.println(Arrays.toString(office[i]));
            // }
            // System.out.println("사각지대 개수: " + count);

            min = min < count ? min : count;
            return;
        }
        // cnt번째 cctv 방향 정하기
        if (cctvs[cnt][0] == 1) { // 1번 cctv (우, 하, 좌, 상)
            for (int d = 0; d < 4; d++) {
                canSee(d, cctvs[cnt][1], cctvs[cnt][2]); // 바라보기
                dfs(cnt + 1); // 다음 cctv 방향 정하러 가기
                clear(d, cctvs[cnt][1], cctvs[cnt][2]); // 원상복구
            }
        } else if (cctvs[cnt][0] == 2) { // 2번 cctv (좌우, 상하)
            // 좌우
            canSee(2, cctvs[cnt][1], cctvs[cnt][2]); // 좌
            canSee(0, cctvs[cnt][1], cctvs[cnt][2]); // 우
            dfs(cnt + 1);
            clear(2, cctvs[cnt][1], cctvs[cnt][2]);
            clear(0, cctvs[cnt][1], cctvs[cnt][2]);

            // 상하
            canSee(3, cctvs[cnt][1], cctvs[cnt][2]);
            canSee(1, cctvs[cnt][1], cctvs[cnt][2]);
            dfs(cnt + 1);
            clear(3, cctvs[cnt][1], cctvs[cnt][2]);
            clear(1, cctvs[cnt][1], cctvs[cnt][2]);

        } else if (cctvs[cnt][0] == 3) { // 3번 cctv (상우, 우하, 하좌, 좌상)
            for (int d = 0; d < 4; d++) {
                canSee(d, cctvs[cnt][1], cctvs[cnt][2]);
                canSee((d + 1) % 4, cctvs[cnt][1], cctvs[cnt][2]);
                dfs(cnt + 1);
                clear(d, cctvs[cnt][1], cctvs[cnt][2]);
                clear((d + 1) % 4, cctvs[cnt][1], cctvs[cnt][2]);
            }
        } else if (cctvs[cnt][0] == 4) { // 4번 cctv (좌상우, 상우하, 우하좌, 하우상)
            for (int d = 0; d < 4; d++) {
                canSee(d, cctvs[cnt][1], cctvs[cnt][2]);
                canSee((d + 1) % 4, cctvs[cnt][1], cctvs[cnt][2]);
                canSee((d + 2) % 4, cctvs[cnt][1], cctvs[cnt][2]);
                dfs(cnt + 1);
                clear(d, cctvs[cnt][1], cctvs[cnt][2]);
                clear((d + 1) % 4, cctvs[cnt][1], cctvs[cnt][2]);
                clear((d + 2) % 4, cctvs[cnt][1], cctvs[cnt][2]);
            }
        } else { // 5번 cctv (상하좌우)
            canSee(0, cctvs[cnt][1], cctvs[cnt][2]);
            canSee(1, cctvs[cnt][1], cctvs[cnt][2]);
            canSee(2, cctvs[cnt][1], cctvs[cnt][2]);
            canSee(3, cctvs[cnt][1], cctvs[cnt][2]);
            dfs(cnt + 1);
            clear(0, cctvs[cnt][1], cctvs[cnt][2]);
            clear(1, cctvs[cnt][1], cctvs[cnt][2]);
            clear(2, cctvs[cnt][1], cctvs[cnt][2]);
            clear(3, cctvs[cnt][1], cctvs[cnt][2]);
        }
    }

    static void canSee(int dir, int i, int j) { // dir 방향 바라보기
        if (dir == 0) { // 오른쪽
            for (int c = j + 1; c < M; c++) {
                if (office[i][c] == 6)
                    break; // 벽만나면 끝
                if (office[i][c] > 0)
                    continue; // cctv 만나면 건너뛰기(통과)
                office[i][c]--;
            }
        } else if (dir == 1) { // 아래
            for (int r = i + 1; r < N; r++) {
                if (office[r][j] == 6)
                    break;
                if (office[r][j] > 0)
                    continue;
                office[r][j]--;
            }
        } else if (dir == 2) { // 왼쪽
            for (int c = j - 1; c >= 0; c--) {
                if (office[i][c] == 6)
                    break;
                if (office[i][c] > 0)
                    continue;
                office[i][c]--;
            }
        } else { // 위쪽
            for (int r = i - 1; r >= 0; r--) {
                if (office[r][j] == 6)
                    break;
                if (office[r][j] > 0)
                    continue;
                office[r][j]--;
            }
        }
    }

    static void clear(int dir, int i, int j) { // dir 방향 clear
        if (dir == 0) { // 오른쪽
            for (int c = j + 1; c < M; c++) {
                if (office[i][c] == 6)
                    break; // 벽만나면 끝
                if (office[i][c] > 0)
                    continue; // cctv 만나면 건너뛰기(통과)
                office[i][c]++;
            }
        } else if (dir == 1) { // 아래
            for (int r = i + 1; r < N; r++) {
                if (office[r][j] == 6)
                    break;
                if (office[r][j] > 0)
                    continue;
                office[r][j]++;
            }
        } else if (dir == 2) { // 왼쪽
            for (int c = j - 1; c >= 0; c--) {
                if (office[i][c] == 6)
                    break;
                if (office[i][c] > 0)
                    continue;
                office[i][c]++;
            }
        } else { // 위쪽
            for (int r = i - 1; r >= 0; r--) {
                if (office[r][j] == 6)
                    break;
                if (office[r][j] > 0)
                    continue;
                office[r][j]++;
            }
        }
    }
}