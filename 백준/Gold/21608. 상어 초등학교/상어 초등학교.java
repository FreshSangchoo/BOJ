import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] school; // 자리배치
    static int[][] favorite; // 좋아하는 학생 목록
    static int[] di = { 1, 0, -1, 0 };
    static int[] dj = { 0, 1, 0, -1 };
    static int[] scoreTable = {0, 1, 10, 100, 1000};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        school = new int[N][N];
        favorite = new int[N*N][4];

        int[] seq = new int[N*N];

        // 입력
        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            seq[i] = student;

            for (int j = 0; j < 4; j++) {
                favorite[student - 1][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 자리배치
        for(int i=0; i<N*N; i++){
            int[] loc = condition1(seq[i]);

            school[loc[0]][loc[1]] = seq[i];
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(school[i]));
        // }

        // 만족도 점수 계산
        int score = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int count = 0;

                for(int d=0; d<4; d++){
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    if(0<=ni&&ni<N && 0<=nj&&nj<N){
                        for(int k=0; k<4; k++){
                            if(school[ni][nj] == favorite[school[i][j] - 1][k]){
                                count++;
                                break;
                            }
                        }
                    }
                }

                score += scoreTable[count];
            }
        }

        System.out.println(score);
    }

    static int[] condition1(int stuNum) {
        int maxCount = 0;

        // 가장 많은 값 후보에 넣기
        ArrayDeque<int[]> candidate = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (school[i][j] != 0) continue; // 채워진 칸은 제외

                int count = 0;

                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    if (0 <= ni && ni < N && 0 <= nj && nj < N) {
                        for (int k = 0; k < 4; k++) {
                            if (school[ni][nj] == favorite[stuNum - 1][k]) { // 인접한 칸에 좋아하는 학생이 앉았다면
                                count++;
                                break;
                            }
                        }
                    }
                }

                if(maxCount < count){
                    maxCount = count;
                    candidate.clear();
                    candidate.offer(new int[]{i, j});
                } else if (maxCount == count) {
                    candidate.offer(new int[]{i, j});
                }
            }
        }

        if (candidate.size() != 1) { // 만약 1을 만족하는 조건이 여러개라면
            return condition2(candidate); // 2번 조건 실행
        } else { // 1을 만족 하는 조건이 하나라면
            return candidate.poll();
        }
    }
    static int[] condition2(ArrayDeque<int[]> q) {
        int max = -1;
        int maxR = 0;
        int maxC = 0;

        while(!q.isEmpty()){
            int[] curLoc = q.poll();
            int count = 0;

            for(int d=0; d<4; d++){
                int ni = curLoc[0] + di[d];
                int nj = curLoc[1] + dj[d];

                if (0 <= ni && ni < N && 0 <= nj && nj < N && school[ni][nj] == 0) { // 인접한 칸이 비어있다면
                    count++;
                }
            }

            // maxR, maxC는 가장 처음에(행번호가 작고, 열번호가 작은) 넣은 자리가 들어감
            // = 자동으로 3번조건 만족
            if(count > max){ 
                max = count;
                maxR = curLoc[0];
                maxC = curLoc[1];
            }
        }

        return new int[] { maxR, maxC };
    }
}
