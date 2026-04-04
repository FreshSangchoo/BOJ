import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int t = 0; t < k; t++) {
                st = new StringTokenizer(br.readLine());

                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (str.charAt(0) == 'I') { // n 삽입
                    // System.out.println(n + " 삽입");
                    map.put(n, map.getOrDefault(n, 0) + 1); // 있으면 그 값에 +1, 없으면 0+1 삽입
                } else { // 삭제
                    // Q가 비어있으면 무시
                    if (map.isEmpty())
                        continue;
                    if (n == 1) { // 최댓값 1개 삭제
                        int maxValue = map.lastKey();
                        if (map.get(maxValue) == 1) { // 1개면 key를 없애기
                            map.remove(maxValue);
                            // System.out.println(maxValue + "가 1개라 key 삭제");
                        } else { // 여러개면 -1
                            // System.out.println(maxValue + "가 여러개라 -1");
                            map.put(maxValue, map.get(maxValue) - 1);
                        }
                    } else { // 최솟값 1개 삭제
                        int minValue = map.firstKey();
                        if (map.get(minValue) == 1) { // 1개면 key를 없애기
                            map.remove(minValue);
                            // System.out.println(minValue + "가 1개라 key 삭제");
                        } else { // 여러개면 -1
                            map.put(minValue, map.get(minValue) - 1);
                            // System.out.println(minValue + "가 여러개라 -1");
                        }
                    }
                }
            }

            if (map.isEmpty())
                System.out.println("EMPTY");
            else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }

    }

}