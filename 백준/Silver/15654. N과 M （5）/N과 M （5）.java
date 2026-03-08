import java.io.*;
import java.util.*;

// N개의 자연수 중에서 M개를 고른 수열 (N개 자연수는 모두 다른 수)
// 사전순으로 증가하는 순서 -> 정렬
// 순열

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n,m,num[];
    static boolean select[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        select = new boolean[n];
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        List<Integer> ans = new LinkedList<>();
        dfs(0, ans);
        System.out.println(sb);
    }

    public static void dfs(int cnt, List<Integer> ans) {
        if (cnt == m) {
            for(int i: ans){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if(select[i])
                continue;
            select[i] = true;
            ans.add(num[i]);
            dfs(cnt+1, ans);
            ans.remove(ans.size()-1);
            select[i] = false;
        }
    }
}
