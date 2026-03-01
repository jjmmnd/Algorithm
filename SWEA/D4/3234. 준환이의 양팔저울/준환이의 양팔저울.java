import java.io.*;
import java.util.*;

// n<=9
// 순열

public class Solution {
    static int n, arr[], ans;
    static boolean select[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            ans = 0;
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            select = new boolean[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 두 공간 중 한 쪽이 항상 반대보다 작아야 함
            // 고른 idx의 총합이 더 작아야 함

            dfs(0, 0, 0, n, arr, select);

            System.out.println("#"+tc+" "+ans);
        }
    }

    static void dfs(int cnt, int left, int right, int n, int[] arr, boolean[] select) {
        if(right > left)
            return;

        if(cnt == n){
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(select[i]) continue;
            select[i] = true;
            dfs(cnt + 1, left + arr[i], right, n, arr, select);
            dfs(cnt + 1, left, right + arr[i], n, arr, select);
            select[i] = false;
        }
    }
}
