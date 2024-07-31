import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] di = {0, -1, 0, 1};
        int[] dj = {1, 0, -1, 0};
        char[][] painting = new char[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                painting[i][j] = line.charAt(j);
            }
        }
        int noblind = 0;
        int rgblind = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                noblind++;
                q.offer(new int[]{i, j});
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    char curColor = painting[cur[0]][cur[1]];

                    for (int k = 0; k < 4; k++) {
                        int ni = cur[0] + di[k];
                        int nj = cur[1] + dj[k];
                        if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && painting[ni][nj] == curColor) {
                            q.offer(new int[]{ni, nj});
                            // System.out.println("이거 넣음 " + ni + " " + nj + " " + painting[ni][nj]);
                            visited[ni][nj] = true;
                        }
                    }
                }

            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                rgblind++;
                q.offer(new int[]{i, j});
                // System.out.println("이거 넣음 " + i + " " + j + " " + painting[i][j]);
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    char curColor = painting[cur[0]][cur[1]];
                    if (curColor == 'R' || curColor == 'G') {
                        for (int k = 0; k < 4; k++) {
                            int ni = cur[0] + di[k];
                            int nj = cur[1] + dj[k];
                            if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && (painting[ni][nj] == 'R' || painting[ni][nj] == 'G')) {
                                q.offer(new int[]{ni, nj});
                                visited[ni][nj] = true;
                            }
                        }
                    } else {
                        for (int k = 0; k < 4; k++) {
                            int ni = cur[0] + di[k];
                            int nj = cur[1] + dj[k];
                            if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && painting[ni][nj] == 'B') {
                                q.offer(new int[]{ni, nj});
                                visited[ni][nj] = true;
                            }
                        }
                    }
                }

            }
        }
        System.out.println(noblind + " " + rgblind);
        br.close();
    }
}