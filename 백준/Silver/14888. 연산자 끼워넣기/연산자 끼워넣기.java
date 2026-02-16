import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int min, max, n, nums[], oper[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = 1_000_000_000;
        max = -1_000_000_000;
        nums = new int[n];
        oper = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int idx, int sum){
        if(idx == n){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        if(oper[0]>0){
            oper[0]--;
            dfs(idx+1, sum+nums[idx]);
            oper[0]++;
        }
        if(oper[1]>0){
            oper[1]--;
            dfs(idx+1, sum-nums[idx]);
            oper[1]++;
        }
        if(oper[2]>0){
            oper[2]--;
            dfs(idx+1, sum*nums[idx]);
            oper[2]++;
        }
        if(oper[3]>0){
            oper[3]--;
            dfs(idx+1, sum/nums[idx]);
            oper[3]++;
        }
    }
}
