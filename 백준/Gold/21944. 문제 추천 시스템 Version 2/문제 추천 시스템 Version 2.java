import java.io.*;
import java.util.*;

public class Main {
    // 문제번호 P, 난이도 L, 알고리즘 분류 G
    static HashMap<Integer, int[]> problems = new HashMap<>(); // (문제번호, {난이도, 알고리즘 분류})
    static TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> algomap = new TreeMap<>(); // 알고리즘 분류별 - 난이도 - 문제번호
    static TreeMap<Integer, TreeSet<Integer>> levelmap = new TreeMap<>(); // 난이도별 - 문제번호

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            addProblem(P, L, G);
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) { // 알고리즘 분류가 G인 문제 중 가장 어려운 문제 번호
                    int find = algomap.get(G).lastEntry().getValue().last();
                    System.out.println(find);
                } else {
                    int find = algomap.get(G).firstEntry().getValue().first();
                    System.out.println(find);
                }
            } else if (command.equals("recommend2")) { // 난이도별 문제번호 출력(알고리즘 분류 상관 X)
                int x = Integer.parseInt(st.nextToken());

                if (x == 1) { // 알고리즘 분류 상관 없이 가장 어려운 문제 번호 출력
                    int find = levelmap.lastEntry().getValue().last();
                    System.out.println(find);
                } else { // 가장 쉬운 문제 번호
                    int find = levelmap.firstEntry().getValue().first();
                    System.out.println(find);
                }
            } else if (command.equals("recommend3")) { // 알고리즘 분류 상관 없이
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                // 조건을 만족하는 문제가 없다면 -1 출력
                if (x == 1) { // 난이도 L보다 크거나 같은 문제 중 가장 쉬운 문제 번호 출력
                    if (levelmap.ceilingEntry(L) == null) {
                        System.out.println(-1);
                        continue;
                    }
                    int find = levelmap.ceilingEntry(L).getValue().first();
                    System.out.println(find);
                } else { // 난이도 L보다 작은 문제 중 가장 어려운 문제 번호 출력
                    if (levelmap.lowerEntry(L) == null) {
                        System.out.println(-1);
                        continue;
                    }
                    int find = levelmap.lowerEntry(L).getValue().last();
                    System.out.println(find);
                }
            } else if (command.equals("add")) { // 문제 추가
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());

                addProblem(P, L, G);
            } else { // 문제 삭제
                int P = Integer.parseInt(st.nextToken());
                int L = problems.get(P)[0];
                int G = problems.get(P)[1];

                algomap.get(G).get(L).remove(P);
                if (algomap.get(G).get(L).isEmpty())
                    algomap.get(G).remove(L);
                if (algomap.get(G).isEmpty())
                    algomap.remove(G);
                levelmap.get(L).remove(P);
                if (levelmap.get(L).isEmpty())
                    levelmap.remove(L);

                problems.remove(P);
            }
        }
    }

    static void addProblem(int p, int l, int g) {
        problems.put(p, new int[] { l, g });

        if (algomap.containsKey(g)) {
            if (algomap.get(g).containsKey(l)) {
                algomap.get(g).get(l).add(p);
            } else {
                algomap.get(g).put(l, new TreeSet<>());
                algomap.get(g).get(l).add(p);
            }
        } else {
            algomap.put(g, new TreeMap<>());
            algomap.get(g).put(l, new TreeSet<>());
            algomap.get(g).get(l).add(p);
        }

        if (levelmap.containsKey(l)) {
            levelmap.get(l).add(p);
        } else {
            levelmap.put(l, new TreeSet<>());
            levelmap.get(l).add(p);
        }
    }

}