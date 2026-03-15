import java.io.*;
import java.util.*;

public class Main {
    static int[] di = { 0, 1, 0, -1 };
    static int[] dj = { 1, 0, -1, 0 };
    static int N, M, K;
    static int[][] map;
    static int[][] pattern = new int[5][5];
    static int[][] warp;
    static int min = Integer.MAX_VALUE;
    static boolean[][][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 가로, M: 세로, K: 패턴 사용 횟수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 지도 입력
        map = new int[N][M];
        visited = new boolean[N][M][2][K + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // 0: 빈칸, 1: 벽, 2: 중간 거점지
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (map[N - 1][M - 1] == 1) {
            System.out.println(-1);
            return;
        }

        // 패턴 배열 입력
        int patternCount = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                pattern[i][j] = Integer.parseInt(st.nextToken());
                // 상, 하로 움직이는 경우는 일반 움직임과 같으니 굳이 횟수를 사용할 필요 없음
                if ((i == 1 || i == 3) && j == 2)
                    continue;
                // 좌, 우, 제자리도 마찬가지
                if (i == 2 && (j == 1 || j == 2 || j == 3))
                    continue;
                if (pattern[i][j] == 1)
                    patternCount++;
            }
        }

        warp = new int[patternCount][2];
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i == 1 || i == 3) && j == 2)
                    continue;
                if (i == 2 && (j == 1 || j == 2 || j == 3))
                    continue;
                if (pattern[i][j] == 1) {
                    warp[idx][0] = i - 2;
                    warp[idx][1] = j - 2;
                    idx++;
                }
            }
        }

        bfs(0, 0, 0, 0, K);

        if (min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }

    static void bfs(int i, int j, int cnt, int middleBase, int warpCount) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[i][j][middleBase][warpCount] = true;
        q.offer(new int[] { i, j, cnt, middleBase, warpCount }); // i, j 좌표, cnt: 이동 거리, middleBase 경유

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            // System.out.println("현재 위치: [" + cur[0] + ", " + cur[1] + "], 움직인 횟수: " +
            // cur[2] + ", 경유 횟수: " + cur[3] + ", 워프 횟수: " + cur[4]);
            // 도착지에 도착했다면
            if (cur[0] == N - 1 && cur[1] == M - 1) {
                // 중간에 경유를 했을때만
                if (cur[3] > 0) {
                    // 최단거리 업데이트
                    min = min < cur[2] ? min : cur[2];
                    continue;
                } else { // 중간에 경유를 못했다면
                    // 도착지 방문처리 취소하고 더 탐색하기
                }
            }

            // 도착지에 도착 못했는데 최단거리보다 많이 이동 했다면 건너뛰기;
            if (cur[2] > min)
                continue;

            // 상하좌우로 탐색
            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];

                if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] != 1) {
                    int visitBase = 0;
                    int tempMiddle = cur[3];
                    if (map[ni][nj] == 2)
                        tempMiddle++;
                    if (tempMiddle != 0)
                        visitBase = 1;
                    if (!visited[ni][nj][visitBase][cur[4]]) {
                        visited[ni][nj][visitBase][cur[4]] = true;
                        // System.out.println("다음 위치: [" + ni + ", " + nj + "]");
                        q.offer(new int[] { ni, nj, cur[2] + 1, tempMiddle, cur[4] });
                    }
                }
            }

            // 추가 패턴 이동 횟수가 남아있다면
            if (cur[4] != 0) {
                // warp 배열 탐색
                for (int d = 0; d < warp.length; d++) {
                    int ni = cur[0] + warp[d][0];
                    int nj = cur[1] + warp[d][1];

                    if (0 <= ni && ni < N && 0 <= nj && nj < M && map[ni][nj] != 1) {
                        int visitBase = 0;
                        int tempMiddle = cur[3];
                        if (map[ni][nj] == 2)
                            tempMiddle++;
                        if (tempMiddle != 0)
                            visitBase = 1;
                        if (!visited[ni][nj][visitBase][cur[4] - 1]) {
                            visited[ni][nj][visitBase][cur[4] - 1] = true;
                            q.offer(new int[] { ni, nj, cur[2] + 1, tempMiddle, cur[4] - 1 });
                        }
                    }
                }
            }
        }
    }
}