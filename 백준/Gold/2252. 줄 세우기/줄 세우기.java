import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] person=new int[N];
        List<Integer>[] list = new List[N];
        for(int i=0; i<N; i++) list[i]=new ArrayList<>();
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int small=Integer.parseInt(st.nextToken())-1;
            int big=Integer.parseInt(st.nextToken())-1;

            list[small].add(big);
            person[big]++;
        }
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=0; i<N; i++) if(person[i]==0) q.add(i);

//        System.out.println("person: "+Arrays.toString(person));
        while(!q.isEmpty()){
            int cur=q.poll();
            sb.append(cur+1).append(" ");
            for(int i=0; i<list[cur].size(); i++){
                if(person[list[cur].get(i)]==1) {
                    q.add(list[cur].get(i));
                    person[list[cur].get(i)]--;
                }
                else person[list[cur].get(i)]--;
            }
        }
        System.out.println(sb);
        br.close();
    }
}