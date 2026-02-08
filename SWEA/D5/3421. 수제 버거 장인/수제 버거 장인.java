import java.io.*;
import java.util.*;

// 서로 어울리지 않는 재료 궁합(2종류) 같은 버거 X
// 버거들의 재료는 조합..(순서 고려 X)

public class Solution {

    static boolean[] isSelected;
    static List<List<Integer>> graph;
    static int N, M, burgerCnt;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료의 개수
            M = Integer.parseInt(st.nextToken());

            // static 초기화
            isSelected = new boolean[N+1];
            graph = new ArrayList<>();
            for(int n=0; n<N+1; n++) {
                graph.add(new ArrayList<>());
            }
            burgerCnt = 0;

            // 노궁합 재료 레시피..
            for(int m=0; m<M; m++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            makeBurger(1, 0);

            // 버거의 최대 가짓수 출력
            System.out.println("#"+tc+" "+burgerCnt);

        }
    }

    private static void makeBurger(int cnt, int pickCnt) {
        // o o o o

        if(cnt == N+1){
            burgerCnt++;
            return;
        }

        // 현재 재료: cnt 번
        // 현재 재료 선택 O -> 지금까지 고른 재료들이 노궁합에 속하지 않을때..
        if(canInsert(cnt)){
            isSelected[cnt] = true;
            makeBurger(cnt+1, pickCnt+1);
            isSelected[cnt] = false;
        } 
        
        // 현재 재료 선택 x -> 넣을 수 있어도 안 넣는 경우까지 고려 -> else x
        makeBurger(cnt+1, pickCnt);
    }

    private static boolean canInsert(int curCnt){
        // 현재 재료의 노궁합이 이미 선택이라면 false
        for(int ing: graph.get(curCnt)){
            if(isSelected[ing]){
                return false;
            }
        }
        return true;
    }
}