import java.util.*;

class Solution {
    int[] di={0, 1, 0, -1};
    int[] dj={1, 0, -1, 0};
    int n=0, m=0;
    boolean[][] canAccess;
    boolean[][] visited;
    char[][] stor;
    public int solution(String[] storage, String[] requests) {
        n=storage.length;
        m=storage[0].length();
        stor = new char[n][m];
        for(int i=0 ;i<n; i++){
            for(int j=0; j<m; j++){
                stor[i][j] = storage[i].charAt(j);
            }
        }
        
        canAccess = new boolean[n][m];
        // 접근 가능 초기화
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1) canAccess[i][j] = true;
            }
        }
        
        int allItems = n*m;
        
        for(int i=0 ; i<requests.length; i++){
            updateAccess();
            if(requests[i].length() == 1){
                int removed = fork(requests[i]);
                allItems -= removed;
            } else {
                int removed = crane(requests[i].charAt(0));
                allItems -= removed;
            }
            
            
            for(int a=0; a<n; a++){
                for(int b=0; b<m; b++){
                    System.out.print(stor[a][b]);
                }
                System.out.println("");
            }
            System.out.println("");
        }

        return allItems;
    }
    public void updateAccess(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        canAccess = new boolean[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(stor[i][j] == '.'){
                        q.offer(new int[]{i,j});
                        visited[i][j] = true;
                        canAccess[i][j] = true;
                    }
                }   
            }
        }
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            
            for(int d=0; d<4; d++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(0<=ni&&ni<n && 0<=nj&&nj<m && !canAccess[ni][nj] && stor[ni][nj] == '.' && !visited[ni][nj]) {
                    q.offer(new int[]{ni, nj});
                    visited[ni][nj] = true;
                    canAccess[ni][nj] = true;
                }
            }
        }
    }
    public int fork(String request){
        int removeItem = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(stor[i][j] == request.charAt(0)){
                    if(i == 0 || i == n-1 || j == 0 || j == m-1) {
                        removeItem++;
                        stor[i][j] = '.';
                        continue;
                    }
                    for(int d=0; d<4; d++){
                        int ni = i + di[d];
                        int nj = j + dj[d];
                        if(0<=ni&&ni<n && 0<=nj&&nj<m && stor[ni][nj] == '.' && canAccess[ni][nj]){
                            removeItem++;
                            stor[i][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
        
        return removeItem;
    }
    public int crane(char request){
        int removeItem = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(stor[i][j] == request){
                    removeItem++;
                    stor[i][j] = '.';
                }
            }
        }
        
        return removeItem;
    }
}