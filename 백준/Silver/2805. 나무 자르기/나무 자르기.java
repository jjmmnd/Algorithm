import java.io.*;
import java.util.*;

// n이 100만개

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 가져가려는 나무 길이
        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int highest = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if(trees[i]>highest)
                highest = trees[i];
        }

        int ans = 0;
        long left = 0;
        long right = highest;
        while (left <= right) {
            long mid = (left + right)/2;
            long sum = calc(mid, trees);
            if (sum >= m) {
                ans = (int)mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }

    public static long calc(long height, int[] trees){
        long sum = 0;
        for(int t: trees){
            if(t>height)
                sum += (t-height);
        }
        return sum;
    }
}
