import java.io.*;
import java.util.*;

// 최소 1개의 모음 + 최소 2개의 자음 > 조합 > 프루닝 가능
// 정렬 > bac 불가능

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int l, c;
    static char alpha[];
    static boolean select[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        alpha = new char[c];
        select = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alpha);

        dfs(0, 0, 0, 0);

        System.out.println(sb);
    }

    static int total;

    public static void dfs(int cnt, int start, int m, int j) {
        if(cnt == l){
            if(m<1 || j<2)
                return;

            for (int i = 0; i < c; i++) {
                if(select[i])
                    sb.append(alpha[i]);
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < c; i++) {
            if(select[i])
                continue;
            if(checkM(alpha[i])){
                select[i] = true;
                dfs(cnt + 1, i + 1, m + 1, j);
                select[i] = false;
            } else{
                select[i] = true;
                dfs(cnt + 1, i + 1, m, j + 1);
                select[i] = false;
            }
        }

    }

    private static boolean checkM(char c) {
        if(c=='a'||c=='i'||c=='e'||c=='o'||c=='u')
            return true;
        return false;
    }
}
