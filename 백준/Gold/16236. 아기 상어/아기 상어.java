import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] eaten;
    static int[] di = {-1, 0, 0, 1};
    static int[] dj = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int starti = 0;
        int startj = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    starti = i;
                    startj = j;
                    map[i][j] = 0;
                }
            }
        }
        int time=0;
        int size=2;
        int eatenFish=0;
        eaten=new boolean[N][N];
        ArrayDeque<int[]> fish = new ArrayDeque<>();
        fish.offer(nextFish(starti, startj, size));
        while(!fish.isEmpty()) {
            int[] next=fish.poll();
            if(next[0]==-1) break;
            eaten[next[0]][next[1]]=true;
            eatenFish++;
            if(eatenFish==size) {
                eatenFish=0;
                size++;
            }
            time+=next[2];
            starti=next[0];
            startj=next[1];
//            System.out.println("냠냠 "+time+" 내 크기는 "+size+"야. 이만큼 먹었어: "+eatenFish);
            fish.offer(nextFish(starti, startj, size));
        }
        System.out.println(time);
        br.close();
    }

    // bfs로 다음 먹을 물고기 선정
    static int[] nextFish(int sharki, int sharkj, int size) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) return (10 * a[0] + a[1]) - (10 * b[0] + b[1]);
            else return a[2]-b[2];
        });
        visited = new boolean[N][N];
        int dis = 0;
        pq.offer(new int[]{sharki, sharkj, dis});
        visited[sharki][sharkj] = true;
        while (!pq.isEmpty()) {
            int[] near = pq.poll();
            if(!eaten[near[0]][near[1]] && map[near[0]][near[1]]!=0 && map[near[0]][near[1]] < size) {
//                System.out.println("이거 내보내! " + near[0] + " " + near[1]+" "+near[2]);
                return near;
            }
            for(int d=0; d<4; d++) {
                int ni = near[0] + di[d];
                int nj = near[1] + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<N && !visited[ni][nj] && map[ni][nj]<=size) {
                    pq.offer(new int[]{ni, nj, near[2]+1});
                    visited[ni][nj] = true;
                }
            }
        }
        return new int[]{-1, -1, -1};
    }
}
/*
// 크기별 물고기의 위치
        List<int[]>[] fish = new List[7];
        for (int i = 0; i < 7; i++) fish[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && map[i][j] != 9) fish[map[i][j]].add(new int[]{i, j});
            }
        }
        // 크기가 작은 물고기부터 가까운 순으로 저장 후 먹기
        int time = 0;
        int size = 2;
        int eatenFish = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) return (10 * a[0] + a[1]) - (10 * b[0] + b[1]);
            else return a[2]-b[2];
        });
        for (int i = 1; i < size; i++) {
            if (fish[i].size() > 0){
                int cnt = fish[i].size();
                for (int n = 0; n < cnt; n++) {
                    for (int j = 0; j < fish[i].size(); j++) {
                        int[] temp = fish[i].get(j);
                        int d = dist(temp[0], temp[1], starti, startj, size);
                        pq.add(new int[]{temp[0], temp[1], d, i, j});
                    }

                }
            }
        }
        while(!pq.isEmpty()){
            // 가장 가까운 물고기 먹기
            int[] near = pq.poll();
//            System.out.println("난 얘 먹으러 갈거야! " + near[0] + " " + near[1]);
            time += near[2];
//            System.out.println("현재 시간은? "+time+" "+near[2]);
            eatenFish++;
//            System.out.println("먹은 개수는? "+eatenFish);
            if(eatenFish == size){
                eatenFish=0;
                size++;
            }
            fish[near[3]].remove(near[4]);
            starti = near[0];
            startj = near[1];
//            System.out.println("지금 내 크기는? "+size);
            pq.clear();
            if(size>=7){
                for (int i = 1; i < 7; i++) {
                    if (fish[i].size() > 0) {
                        int cnt = fish[i].size();
                        for (int n = 0; n < cnt; n++) {
                            for (int j = 0; j < fish[i].size(); j++) {
                                int[] temp = fish[i].get(j);
                                int d = dist(temp[0], temp[1], starti, startj, size);
                                pq.add(new int[]{temp[0], temp[1], d, i, j});
                            }

                        }
                    }
                }
            } else{
                for (int i = 1; i < size; i++) {
                    if (fish[i].size() > 0) {
                        int cnt = fish[i].size();
                        for (int n = 0; n < cnt; n++) {
                            for (int j = 0; j < fish[i].size(); j++) {
                                int[] temp = fish[i].get(j);
                                int d = dist(temp[0], temp[1], starti, startj, size);
                                pq.add(new int[]{temp[0], temp[1], d, i, j});
                            }

                        }
                    }
                }
            }
        }
 */
    /*
    static int dist(int i, int j, int sharki, int sharkj, int size) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited = new boolean[N][N];
        int dis = 0;
        q.add(new int[]{sharki, sharkj, dis});
        visited[sharki][sharkj] = true;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == i && temp[1] == j) return temp[2];
            for (int d = 0; d < 4; d++) {
                int ni = temp[0] + di[d];
                int nj = temp[1] + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && map[ni][nj] <= size) {
                    q.add(new int[]{ni, nj, temp[2] + 1});
                    visited[ni][nj] = true;
                }
            }
        }
        return dis;
    }
     */