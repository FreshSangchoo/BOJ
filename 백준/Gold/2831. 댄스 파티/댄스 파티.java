import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> mt, ms, wt, ws;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        mt = new ArrayList<>();
        ms = new ArrayList<>();
        wt = new ArrayList<>();
        ws = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int person = Integer.parseInt(st.nextToken());
            if (person > 0) mt.add(person);
            else ms.add(-1 * person);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int person = Integer.parseInt(st.nextToken());
            if (person > 0) wt.add(person);
            else ws.add(-1 * person);
        }
        Collections.sort(mt);
        Collections.sort(ms);
        Collections.sort(wt);
        Collections.sort(ws);

        int count = 0;
        int t = 0;
        int s = 0;

        if (mt.size() > 0 && ws.size() > 0) {
            while (true) {
                if (t == mt.size() || s == ws.size()) break;
                if (mt.get(t) < ws.get(s)) {
                    t++;
                    s++;
                    count++;
                } else s++;
            }
            t = 0;
            s = 0;
        }
        if(wt.size() > 0 && ms.size() > 0){
            while (true) {
                if (t == wt.size() || s == ms.size()) break;
                if (wt.get(t) < ms.get(s)) {
                    t++;
                    s++;
                    count++;
                } else s++;
            }
        }

        System.out.println(count);
        br.close();
    }
}